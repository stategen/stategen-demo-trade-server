/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.Organization;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.util.IIDGenerator;

/**
 * OrganizationDao
 * <pre>
 * database table: demo_organization
 * database table comments: 组织架构表 ，用于水平权限  --tree
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface OrganizationDao {

	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) Long orgId,
    &#64;ApiParam() &#64;RequestParam(required = false) Long parentId,
    &#64;ApiParam() &#64;RequestParam(required = false) String name,
    &#64;ApiParam() &#64;RequestParam(required = false) String orgType
    ,&#64;ApiParam(hidden = true) Organization organization
    
    </pre>
	 * 
	 * sql:insert into demo_organization ( create_time , update_time , delete_flag , org_id , parent_id , name , org_type ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?)
	 */
	public Organization insert(Organization organization, IIDGenerator<Long> idGenerator) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("orgId") &#64;RequestParam(required = false) Long orgId    
    </pre>
	 * 
	 * sql:UPDATE demo_organization a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.org_id = ?
	 */
	public Long delete(Long orgId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) Long parentId,
    &#64;ApiParam() &#64;RequestParam(required = false) String name,
    &#64;ApiParam() &#64;RequestParam(required = false) String orgType,
    &#64;ApiParam() &#64;RequestParam(required = false) Long orgId
    ,&#64;ApiParam(hidden = true) Organization organization
    
    </pre>
	 * 
	 * sql:UPDATE demo_organization a SET a.update_time= CURRENT_TIMESTAMP(6) , a.parent_id = ? , a.name = ? , a.org_type = ? where a.delete_flag = 0 and a.org_id = ?
	 */
	public Organization update(Organization organization) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("orgId") &#64;RequestParam(required = false) Long orgId    
    </pre>
	 * 
	 * sql:select a.org_id, a.parent_id, a.name, a.org_type, a.update_time, a.create_time, a.delete_flag from demo_organization a where a.delete_flag = 0 and a.org_id = ?
	 */
	public Organization getOrganizationByOrgId(Long orgId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) Long orgId,
    &#64;ApiParam() &#64;RequestParam(required = false, name="orgIds") ArrayList&lt;Long&gt; orgIds,
    &#64;ApiParam() &#64;RequestParam(required = false) Long parentId,
    &#64;ApiParam() &#64;RequestParam(required = false, name="parentIds") ArrayList&lt;Long&gt; parentIds,
    &#64;ApiParam() &#64;RequestParam(required = false) String name,
    &#64;ApiParam() &#64;RequestParam(required = false) String nameLike,
    &#64;ApiParam() &#64;RequestParam(required = false) String orgType,
    &#64;ApiParam() &#64;RequestParam(required = false, name="orgTypes") ArrayList&lt;String&gt; orgTypes,
    &#64;ApiParam() &#64;RequestParam(required = false) Date updateTimeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Date updateTimeMax,
    &#64;ApiParam() &#64;RequestParam(required = false) Date createTimeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Date createTimeMax
    ,&#64;ApiParam(hidden = true) Organization organization
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.org_id, a.parent_id, a.name, a.org_type, a.update_time, a.create_time, a.delete_flag from demo_organization a where a.delete_flag = 0 and a.org_id=? and a.org_id in ( ? ) and a.parent_id=? and a.parent_id in ( ? ) and a.name=? and a.name like CONCAT('%',?,'%') and a.org_type=? and a.org_type in ( ? ) and a.update_time >=? and a.update_time <? and a.create_time >=? and a.create_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<Organization> getPageList(Organization organization, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("orgId") &#64;RequestParam(required = false, name="orgIds") ArrayList&lt;Long&gt; orgIds    
    </pre>
	 * 
	 * sql:select a.org_id, a.parent_id, a.name, a.org_type, a.update_time, a.create_time, a.delete_flag from demo_organization a where a.delete_flag = 0 and 1=0 and a.org_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<Organization> getOrganizationsByOrgIds(java.util.List<Long> orgIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("orgId") &#64;RequestParam(required = false, name="orgIds") ArrayList&lt;Long&gt; orgIds    
    </pre>
	 * 
	 * sql:UPDATE demo_organization a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.org_id in ( ? )
	 */
	public java.util.List<Long> deleteByOrgIds(java.util.List<Long> orgIds) throws DataAccessException;
	

}



