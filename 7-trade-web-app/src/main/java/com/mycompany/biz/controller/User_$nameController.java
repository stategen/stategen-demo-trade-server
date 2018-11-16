package com.mycompany.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.Wrap;

import com.mycompany.biz.domain.TopicAuthor;
import com.mycompany.biz.service.TopicAuthorService;

@ApiConfig
@Wrap
@RequestMapping("api/user")
public class User_$nameController {

    @Resource
    private TopicAuthorService topicAuthorService;

    @ApiRequestMappingAutoWithMethodName
    @RequestMapping("/{loginname}")
    public TopicAuthor getUserData(@PathVariable("loginname") String loginname) {
        TopicAuthor topicAuthor = this.topicAuthorService.getTopicAuthorByLoginname(loginname);
        return topicAuthor;
    }
}
