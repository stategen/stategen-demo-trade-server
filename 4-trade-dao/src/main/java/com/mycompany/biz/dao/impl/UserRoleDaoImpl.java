/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.UserRole;
import com.mycompany.biz.dao.UserRoleDao;
import org.stategen.framework.ibatis.util.PageQueryUtils;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * UserRoleDao
 * <pre>
 * database table: user_role
 * database table comments: UserRole
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class UserRoleDaoImpl  extends SqlMapClientDaoSupport implements UserRoleDao {

	/**
	 * 
	 * sql:insert into user_role ( create_time , update_time , delete_flag , id , user_id , role_id , role_type ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?)
	 */
	public UserRole insert(UserRole userRole) throws DataAccessException {
		if(userRole == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        getSqlMapClientTemplate().insert("insert.UserRole.trade", userRole);
		return userRole;
	}

	/**
	 * 
	 * sql:UPDATE user_role SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and id = ?
	 */
	public Long delete(Long id) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("id",id);
        getSqlMapClientTemplate().update("delete.UserRole.trade", params);
        return id;
	}

	/**
	 * 
	 * sql:UPDATE user_role SET update_time= CURRENT_TIMESTAMP(6) , user_id = ? , role_id = ? , role_type = ? where delete_flag = 0 and id = ?
	 */
	public UserRole update(UserRole userRole) throws DataAccessException {
		if(userRole == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        getSqlMapClientTemplate().update("update.UserRole.trade", userRole);
		return userRole;
	}

	/**
	 * 
	 * sql:select a.id, a.user_id, a.role_id, a.role_type, a.create_time, a.update_time, a.delete_flag from user_role a where a.delete_flag = 0 and a.id = ?
	 */
	public UserRole getUserRoleById(Long id) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("id",id);
		return (UserRole)getSqlMapClientTemplate().queryForObject("getUserRoleById.UserRole.trade",params);
	}

	/**
	 * 
	 * sql:select a.id, a.user_id, a.role_id, a.role_type, a.create_time, a.update_time, a.delete_flag from user_role a where a.delete_flag = 0 and a.id=? and a.id in ( ? ) and a.user_id=? and a.user_id in ( ? ) and a.role_id=? and a.role_id in ( ? ) and a.role_type=? and a.role_type in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
    @SuppressWarnings("unchecked")
	public PageList<UserRole> getPageList(UserRole userRole, int pageSize, int pageNum) throws DataAccessException {
		return (PageList<UserRole>)PageQueryUtils.pageQuery(getSqlMapClientTemplate(),"getPageList.UserRole.trade",userRole,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.id, a.user_id, a.role_id, a.role_type, a.create_time, a.update_time, a.delete_flag from user_role a where a.delete_flag = 0 and 1=0 and a.id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
    @SuppressWarnings("unchecked")
	public List<UserRole> getUserRolesByIds(java.util.List<Long> ids) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("ids",ids);
		return (List<UserRole>)getSqlMapClientTemplate().queryForList("getUserRolesByIds.UserRole.trade",params);
	}

	/**
	 * 
	 * sql:UPDATE user_role SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and id in ( ? )
	 */
	public java.util.List<Long> deleteByIds(java.util.List<Long> ids) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("ids",ids);
        getSqlMapClientTemplate().update("deleteByIds.UserRole.trade", params);
        return ids;
	}

}

