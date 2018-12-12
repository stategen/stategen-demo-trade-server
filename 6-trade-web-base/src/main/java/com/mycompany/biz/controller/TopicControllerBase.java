/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.controller;

import java.util.Date;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.stategen.framework.annotation.Wrap;
import org.stategen.framework.web.cookie.CookieGroup;

import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.enums.TopicType;
import com.mycompany.biz.service.TopicService;
import com.mycompany.biz.utils.SysConsts;

import io.swagger.annotations.ApiParam;

@RequestMapping("/api/topic")
@Wrap
public abstract class TopicControllerBase {

    @Resource
    protected TopicService topicService;

    @Resource
    private CookieGroup loginCookieGroup;

    protected Topic saveTopic(@ApiParam() String topicId, @ApiParam() TopicType topicType, @ApiParam() String content, @ApiParam() String title, @ApiParam() Date testTimestamp, @ApiParam() Date testDatetime, @ApiParam() Date testDate, @ApiParam() Date testTime, @ApiParam(hidden = true) Topic topic) {
        String userId = loginCookieGroup.getCookieValue(SysConsts.USER_ID);
        topic.setAuthorId(userId);
        topicService.saveTopic(topic);
        return topic;
    }
}
