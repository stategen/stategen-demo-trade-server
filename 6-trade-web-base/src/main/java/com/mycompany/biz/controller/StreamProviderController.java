/**
 * Copyright (C) 2021  niaoge<78493244@qq.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mycompany.biz.controller;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.biz.stream.ReceiveTrade;
import com.mycompany.biz.stream.SenderTrade;

/**
 * @author niaoge
 * @version $Id: StreamProviderController.java, v 0.1 2021年1月27日 上午1:02:09 XiaZhengsheng Exp $
 */
@RequestMapping("api/streamProvider")
@Controller
@Configuration
public class StreamProviderController {
    @Autowired
    private ObjectMapper jsonMapper;
    
    @PostConstruct
    public void mixin_to_specify_creator() throws Exception {
        jsonMapper.addMixIn(MimeType.class, MimeTypeMixin.class);
    }
    
    public static abstract class MimeTypeMixin {
        
        @JsonCreator
        public MimeTypeMixin(@JsonProperty("type") String type) {
        }
    }
    
    /*** curl -H "Content-Type: application/json" -X POST -d "{\"id\":\"receive1\",\"bill-pay\":\"150\"}" http://localhost:8080/tradeApp/api/streamProvider/handleMq */
    
    @SuppressWarnings("unchecked")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiRequestMappingAutoWithMethodName
    public String handleMq(@RequestBody String body, @RequestHeader(HttpHeaders.CONTENT_TYPE) Object contentType) throws Exception {
        Map<String, String> payload         = jsonMapper.readValue(body, Map.class);
        
        String              destinationName = payload.get("id");
        SenderTrade.sendMessage(destinationName, payload);
        return "Ok";
    }
    
    
    
    
    //Following sink is used as test consumer. It logs the data received through the consumer.
    
    static class TestSink {
        final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(StreamProviderController.TestSink.class);
        
        @Bean
        public ReceiveTrade receiveTrade() {
            return new ReceiveTrade() {
                @Override
                public void accept(String data) {
                    log.info("Data received from receiveTrade-dest..." + data);
                }
            };
            //return data -> log.info("Data received from receiveTrade-dest.." + data);
        }


    }

}
