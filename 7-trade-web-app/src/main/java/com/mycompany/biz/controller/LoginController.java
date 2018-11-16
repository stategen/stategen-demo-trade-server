package com.mycompany.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.Wrap;

import com.mycompany.biz.domain.TopicAuthor;
import com.mycompany.biz.service.TopicAuthorService;

@ApiConfig
@Wrap
@RequestMapping("api")
public class LoginController {
    
    @Resource
    private TopicAuthorService topicAuthorService;
    
    @ApiRequestMappingAutoWithMethodName
    @RequestMapping("/accesstoken")
    public TopicAuthor getUserData(String accesstoken) {
        TopicAuthor topicAuthor = this.topicAuthorService.getTopicAuthorByLoginname("niaoge");
        return topicAuthor;
    }
}
