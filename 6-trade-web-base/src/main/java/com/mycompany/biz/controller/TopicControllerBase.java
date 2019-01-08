/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.controller;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.stategen.framework.annotation.Wrap;
import org.stategen.framework.web.cookie.CookieGroup;

import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.service.CityService;
import com.mycompany.biz.service.ProvinceService;
import com.mycompany.biz.service.TopicService;

@RequestMapping("/api/topic")
@Wrap
public abstract class TopicControllerBase {

    @Resource
    protected TopicService topicService;

    @Resource
    protected CookieGroup loginCookieGroup;

    @Resource
    private ProvinceService provinceService;

    @Resource
    private CityService cityService;

    protected void setTopicModels(List<Topic> topics) {
        provinceService.assignBeanTo(topics, Topic::getProvinceId, Topic::setProvince);
        cityService.assignBeanTo(topics, Topic::getCityId, Topic::setCity);
    }
}
