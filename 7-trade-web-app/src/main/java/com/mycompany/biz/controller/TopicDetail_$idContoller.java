package com.mycompany.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.Wrap;

import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.service.TopicService;

@ApiConfig
@Wrap
@RequestMapping("api/topic")
public class TopicDetail_$idContoller {
    
    @Resource
    private TopicService topicService;

    @ApiRequestMappingAutoWithMethodName
    @RequestMapping("/{topicId}")
    public Topic getTopicDetail(@PathVariable("topicId") String topicId){
        Topic topic = this.topicService.getTopicByTopicId(topicId);
        return topic;
    }
}
