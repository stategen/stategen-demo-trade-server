/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.stategen.framework.annotation.Wrap;
import org.stategen.framework.util.CollectionUtil;
import org.stategen.framework.web.cookie.CookieGroup;

import com.mycompany.biz.domain.City;
import com.mycompany.biz.domain.Province;
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
        Set<String> provinceIds = CollectionUtil.toSet(topics, Topic::getProvinceId);
        List<Province> provinces = this.provinceService.getProvincesByProvinceIds(new ArrayList<String>( provinceIds));
        CollectionUtil.setModelByList(topics, provinces, Topic::getProvinceId, Topic::setProvince, Province::getProvinceId);
        
        Set<String> cityIds = CollectionUtil.toSet(topics, Topic::getCityId);
        List<City> citys = this.cityService.getCitysByCityIds(new ArrayList<String>(cityIds));
        CollectionUtil.setModelByList(topics, citys, Topic::getCityId, Topic::setCity, City::getCityId);
    }
    
}
