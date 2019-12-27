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

import com.mycompany.biz.dao.UserHoppyDao;
import com.mycompany.biz.domain.UserHoppy;

/**
 * UserHoppyDao
 * <pre>
 * database table: demo_user_hoppy
 * database table comments: UserHoppy
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class UserHoppyDaoImpl extends SqlDaoSupportBase implements UserHoppyDao {

    /**
	 * 
	 * sql:insert into demo_user_hoppy ( create_time , update_time , delete_flag , id , user_id , hoppy_id ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?)
	 */
    public UserHoppy insert(UserHoppy userHoppy) throws DataAccessException {
        if (userHoppy == null) {
            throw new IllegalArgumentException("Can't insert a null data object into db.");
        }
        super.insert("UserHoppy.insert", userHoppy);
        return userHoppy;
    }

    /**
	 * 
	 * sql:UPDATE demo_user_hoppy SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and id = ?
	 */
    public Long delete(Long id) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("id", id);
        super.update("UserHoppy.delete", params);
        return id;
    }

    /**
	 * 
	 * sql:UPDATE demo_user_hoppy SET update_time= CURRENT_TIMESTAMP(6) , user_id = ? , hoppy_id = ? where delete_flag = 0 and id = ?
	 */
    public UserHoppy update(UserHoppy userHoppy) throws DataAccessException {
        if (userHoppy == null) {
            throw new IllegalArgumentException("Can't update by a null data object.");
        }
        super.update("UserHoppy.update", userHoppy);
        return userHoppy;
    }

    /**
	 * 
	 * sql:select a.id, a.user_id, a.hoppy_id, a.create_time, a.update_time, a.delete_flag from demo_user_hoppy a where a.delete_flag = 0 and a.id = ?
	 */
    public UserHoppy getUserHoppyById(Long id) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("id", id);
        return (UserHoppy) super.selectOne("UserHoppy.getUserHoppyById", params);
    }

    /**
	 * 
	 * sql:select a.id, a.user_id, a.hoppy_id, a.create_time, a.update_time, a.delete_flag from demo_user_hoppy a where a.delete_flag = 0 and a.id=? and a.id in ( ? ) and a.user_id=? and a.user_id in ( ? ) and a.hoppy_id=? and a.hoppy_id in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
    public PageList<UserHoppy> getPageList(UserHoppy userHoppy, int pageSize, int pageNum) throws DataAccessException {
        return super.pageQuery("UserHoppy.getPageList", userHoppy, pageNum, pageSize);
    }

    /**
	 * 
	 * sql:select a.id, a.user_id, a.hoppy_id, a.create_time, a.update_time, a.delete_flag from demo_user_hoppy a where a.delete_flag = 0 and 1=0 and a.id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
    public List<UserHoppy> getUserHoppysByIds(java.util.List<Long> ids) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("ids", ids);
        return super.selectList("UserHoppy.getUserHoppysByIds", params);
    }

    /**
	 * 
	 * sql:select a.id, a.user_id, a.hoppy_id, a.create_time, a.update_time, a.delete_flag from demo_user_hoppy a where a.delete_flag = 0 and 1=0 and a.user_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
    public List<UserHoppy> getUserHoppysByUserIds(java.util.List<String> userIds) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("userIds", userIds);
        return super.selectList("UserHoppy.getUserHoppysByUserIds", params);
    }

    /**
	 * 
	 * sql:UPDATE demo_user_hoppy SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and id in ( ? )
	 */
    public java.util.List<Long> deleteByIds(java.util.List<Long> ids) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("ids", ids);
        super.update("UserHoppy.deleteByIds", params);
        return ids;
    }
}
