/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.stategen.framework.annotation.Wrap;

import com.mycompany.biz.service.TopicLevelHService;

@RequestMapping("/api/topicLevelH")
@Wrap
public abstract class TopicLevelHControllerBase {

    @Resource
    protected TopicLevelHService topicLevelHService;
}
