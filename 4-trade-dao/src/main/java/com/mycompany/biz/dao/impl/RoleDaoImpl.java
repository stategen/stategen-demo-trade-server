/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.Role;
import com.mycompany.biz.dao.RoleDao;
import org.stategen.framework.ibatis.util.PageQueryUtils;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * RoleDao
 * <pre>
 * database table: role
 * database table comments: Role
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class RoleDaoImpl  extends SqlMapClientDaoSupport implements RoleDao {

	/**
	 * 
	 * sql:insert into role ( create_time , update_time , delete_flag , role_id , role_name , description , role_type ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?)
	 */
	public Role insert(Role role) throws DataAccessException {
		if(role == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        getSqlMapClientTemplate().insert("insert.Role.trade", role);
		return role;
	}

	/**
	 * 
	 * sql:UPDATE role SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and role_id = ?
	 */
	public String delete(String roleId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("roleId",roleId);
        getSqlMapClientTemplate().update("delete.Role.trade", params);
        return roleId;
	}

	/**
	 * 
	 * sql:UPDATE role SET update_time= CURRENT_TIMESTAMP(6) , role_name = ? , description = ? , role_type = ? where delete_flag = 0 and role_id = ?
	 */
	public Role update(Role role) throws DataAccessException {
		if(role == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        getSqlMapClientTemplate().update("update.Role.trade", role);
		return role;
	}

	/**
	 * 
	 * sql:select a.role_id, a.role_name, a.description, a.create_time, a.update_time, a.delete_flag, a.role_type from role a where a.delete_flag = 0 and a.role_id = ?
	 */
	public Role getRoleByRoleId(String roleId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("roleId",roleId);
		return (Role)getSqlMapClientTemplate().queryForObject("getRoleByRoleId.Role.trade",params);
	}

	/**
	 * 
	 * sql:select a.role_id, a.role_name, a.description, a.create_time, a.update_time, a.delete_flag, a.role_type from role a where a.delete_flag = 0 and a.role_id=? and a.role_id in ( ? ) and a.role_name=? and a.role_name like CONCAT('%',?,'%') and a.description=? and a.description like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and a.role_type=? and a.role_type in ( ? ) and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
    @SuppressWarnings("unchecked")
	public PageList<Role> getPageList(Role role, int pageSize, int pageNum) throws DataAccessException {
		return (PageList<Role>)PageQueryUtils.pageQuery(getSqlMapClientTemplate(),"getPageList.Role.trade",role,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.role_id, a.role_name, a.description, a.create_time, a.update_time, a.delete_flag, a.role_type from role a where a.delete_flag = 0 and 1=0 and a.role_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
    @SuppressWarnings("unchecked")
	public List<Role> getRolesByRoleIds(java.util.List<String> roleIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("roleIds",roleIds);
		return (List<Role>)getSqlMapClientTemplate().queryForList("getRolesByRoleIds.Role.trade",params);
	}

	/**
	 * 
	 * sql:UPDATE role SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and role_id in ( ? )
	 */
	public java.util.List<String> deleteByRoleIds(java.util.List<String> roleIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("roleIds",roleIds);
        getSqlMapClientTemplate().update("deleteByRoleIds.Role.trade", params);
        return roleIds;
	}

}

