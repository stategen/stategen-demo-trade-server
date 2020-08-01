/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.stategen.framework.annotation.Wrap;

import com.mycompany.biz.service.OrganizationService;

@RequestMapping("/api/organization")
@Wrap
public abstract class OrganizationControllerBase {

    @Resource
    protected OrganizationService organizationService;
}
