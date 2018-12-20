/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.stategen.framework.ibatis.util.PageQueryUtils;
import org.stategen.framework.lite.PageList;

import com.mycompany.biz.dao.UserColorDao;
import com.mycompany.biz.domain.UserColor;

/**
 * UserColorDao
 * <pre>
 * database table: user_color
 * database table comments: UserColor
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class UserColorDaoImpl extends SqlMapClientDaoSupport implements UserColorDao {

    /**
	 * 
	 * sql:insert into user_color ( create_time , update_time , delete_flag , id , user_id , color_type ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?)
	 */
    public UserColor insert(UserColor userColor) throws DataAccessException {
        if (userColor == null) {
            throw new IllegalArgumentException("Can't insert a null data object into db.");
        }
        getSqlMapClientTemplate().insert("insert.UserColor.trade", userColor);
        return userColor;
    }

    /**
	 * 
	 * sql:UPDATE user_color SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and id = ?
	 */
    public Integer delete(Integer id) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("id", id);
        getSqlMapClientTemplate().update("delete.UserColor.trade", params);
        return id;
    }

    /**
	 * 
	 * sql:UPDATE user_color SET update_time= CURRENT_TIMESTAMP(6) , user_id = ? , color_type = ? where delete_flag = 0 and id = ?
	 */
    public UserColor update(UserColor userColor) throws DataAccessException {
        if (userColor == null) {
            throw new IllegalArgumentException("Can't update by a null data object.");
        }
        getSqlMapClientTemplate().update("update.UserColor.trade", userColor);
        return userColor;
    }

    /**
	 * 
	 * sql:select a.id, a.user_id, a.color_type, a.create_time, a.update_time, a.delete_flag from user_color a where a.delete_flag = 0 and a.id = ?
	 */
    public UserColor getUserColorById(Integer id) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("id", id);
        return (UserColor) getSqlMapClientTemplate().queryForObject("getUserColorById.UserColor.trade", params);
    }

    /**
	 * 
	 * sql:select a.id, a.user_id, a.color_type, a.create_time, a.update_time, a.delete_flag from user_color a where a.delete_flag = 0 and a.id=? and a.id in ( ? ) and a.user_id=? and a.user_id in ( ? ) and a.color_type=? and a.color_type in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
    @SuppressWarnings("unchecked")
    public PageList<UserColor> getUserColorPageList(UserColor userColor, int pageSize, int pageNum) throws DataAccessException {
        return (PageList<UserColor>) PageQueryUtils.pageQuery(getSqlMapClientTemplate(), "getUserColorPageList.UserColor.trade", userColor, pageNum, pageSize);
    }

    /**
	 * 
	 * sql:select a.id, a.user_id, a.color_type, a.create_time, a.update_time, a.delete_flag from user_color a where a.delete_flag = 0 and 1=0 and a.id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
    @SuppressWarnings("unchecked")
    public List<UserColor> getUserColorsByIds(java.util.List<Integer> ids) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("ids", ids);
        return (List<UserColor>) getSqlMapClientTemplate().queryForList("getUserColorsByIds.UserColor.trade", params);
    }

    /**
	 * 
	 * sql:UPDATE user_color SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and id in ( ? )
	 */
    public java.util.List<Integer> deleteByIds(java.util.List<Integer> ids) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("ids", ids);
        getSqlMapClientTemplate().update("deleteByIds.UserColor.trade", params);
        return ids;
    }
}