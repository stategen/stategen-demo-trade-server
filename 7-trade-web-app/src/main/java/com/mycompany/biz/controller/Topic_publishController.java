package com.mycompany.biz.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.GenForm;
import org.stategen.framework.annotation.State;
import org.stategen.framework.enums.DataOpt;

import com.mycompany.biz.checker.LoginCheck;
import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.enums.CookieType.Login.LoginCookieNames;
import com.mycompany.biz.enums.TopicType;

import io.swagger.annotations.ApiParam;

@ApiConfig
public class Topic_publishController extends TopicControllerBase {

    @ApiRequestMappingAutoWithMethodName(method = RequestMethod.POST)
    @LoginCheck
    @GenForm
    @State(dataOpt = DataOpt.FULL_REPLACE)
    public Topic saveTopic(
                           @ApiParam() String topicId, 
                           @ApiParam() TopicType topicType,
                           @ApiParam() String content,
                           @ApiParam() String title, 
                           @ApiParam(hidden = true) Topic topic) {
        String userId = loginCookieGroup.getCookieValue(LoginCookieNames.userId);
        topic.setAuthorId(userId);
        topicService.saveTopic(topic);
        return topic;
    }
}
