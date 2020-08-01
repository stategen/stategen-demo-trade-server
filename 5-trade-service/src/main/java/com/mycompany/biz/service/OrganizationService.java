/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.service;

import java.util.List;

import org.stategen.framework.lite.PageList;
import org.stategen.framework.util.AssignService;
import org.stategen.framework.util.BaseService;

import com.mycompany.biz.domain.Organization;

/**
 * OrganizationService
 * <pre>
 * database table: demo_organization
 * database table comments: 组织架构表 ，用于水平权限  --tree
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public interface OrganizationService extends OrganizationServiceTrade, AssignService<Organization, Long>, BaseService<Organization> {

    /**
     * 
     * @see com.mycompany.biz.dao.OrganizationDao#insert
     */
    public Organization insert(Organization organization);

    /**
     * 
     * @see com.mycompany.biz.dao.OrganizationDao#delete
     */
    public Long delete(Long orgId);

    /**
     * 
     * @see com.mycompany.biz.dao.OrganizationDao#update
     */
    public Organization update(Organization organization);

    /**
     * 
     * @see com.mycompany.biz.dao.OrganizationDao#getOrganizationByOrgId
     */
    public Organization getOrganizationByOrgId(Long orgId);

    /**
     * 
     * @see com.mycompany.biz.dao.OrganizationDao#getPageList
     */
    public PageList<Organization> getPageList(Organization organization, int pageSize, int pageNum);

    /**
     * 
     * @see com.mycompany.biz.dao.OrganizationDao#getOrganizationsByOrgIds
     */
    public List<Organization> getOrganizationsByOrgIds(java.util.List<Long> orgIds);

    /**
     * 
     * @see com.mycompany.biz.dao.OrganizationDao#deleteByOrgIds
     */
    public java.util.List<Long> deleteByOrgIds(java.util.List<Long> orgIds);

    /*** 保存organization,有id时更新，没有id时插入,并带回新的id，返回 organization
     * @see com.mycompany.biz.dao.OrganizationDao#insert
     */
    public Organization saveOrganization(Organization organization);

    /** 批量保存organizations,有id时更新，没有id时插入,并带回新的id，返回 organizations
     * @see com.mycompany.biz.dao.OrganizationDao#insert
     */
    public List<Organization> saveOrganizations(List<Organization> organizations);
}