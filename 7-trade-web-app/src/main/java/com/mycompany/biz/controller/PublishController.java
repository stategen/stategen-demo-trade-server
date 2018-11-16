package com.mycompany.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.Wrap;

import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.service.TopicService;

@ApiConfig
@Wrap
@RequestMapping("api")
public class PublishController {
    
    @Resource
    private TopicService topicService;
    
    @ApiRequestMappingAutoWithMethodName(method=RequestMethod.POST)
    @RequestMapping("topics")
    public Topic publish(Topic topic){
        topicService.insert(topic);
        return topic;
    }

}
