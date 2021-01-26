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

package com.mycompany.biz.stream;

import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

/**
 * @author niaoge
 * @version $Id: ProviderController.java, v 0.1 2021年1月26日 下午11:48:36 XiaZhengsheng Exp $
 */
@Configuration
@Slf4j
public class Sender {
    
    private static final String destination_key = "spring.cloud.stream.sendto.destination";
    
    private static final EmitterProcessor<Message<?>> processor = EmitterProcessor.create();
    
    @Bean
    public Supplier<Flux<Message<?>>> supplier() {
        if (log.isInfoEnabled()) {
            log.info(new StringBuilder("输出info信息: Sender创建 supplier:").append("<<<<<<<<<<<<<<<<<<<<").toString());
        }
        return () -> processor;
    }    
    
    public static <T> void sendMessage( String destination, T payload) {
        Message<?> message = MessageBuilder.withPayload(payload)
                .setHeader(destination_key, destination).build();
        processor.onNext(message);
    }   
    
    public static <T> void sendMessage(Class<? extends Receiver<T>> receiverClz, T payload) {
        sendMessage(StringUtils.uncapitalize(receiverClz.getSimpleName()),payload);
    }


}
