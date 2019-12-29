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

import com.mycompany.biz.dao.HoppyDao;
import com.mycompany.biz.domain.Hoppy;

/**
 * HoppyDao
 * <pre>
 * database table: demo_hoppy
 * database table comments: Hoppy
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class HoppyDaoImpl extends SqlDaoSupportBase implements HoppyDao {

    /**
	 * 
	 * sql:insert into demo_hoppy ( create_time , update_time , delete_flag , hoppy_id , hoppy_name ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?)
	 */
    public Hoppy insert(Hoppy hoppy) throws DataAccessException {
        if (hoppy == null) {
            throw new IllegalArgumentException("Can't insert a null data object into db.");
        }
        super.insert("Hoppy.insert", hoppy);
        return hoppy;
    }

    /**
	 * 
	 * sql:UPDATE demo_hoppy SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and hoppy_id = ?
	 */
    public Long delete(Long hoppyId) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("hoppyId", hoppyId);
        super.update("Hoppy.delete", params);
        return hoppyId;
    }

    /**
	 * 
	 * sql:UPDATE demo_hoppy SET update_time= CURRENT_TIMESTAMP(6) , hoppy_name = ? where delete_flag = 0 and hoppy_id = ?
	 */
    public Hoppy update(Hoppy hoppy) throws DataAccessException {
        if (hoppy == null) {
            throw new IllegalArgumentException("Can't update by a null data object.");
        }
        super.update("Hoppy.update", hoppy);
        return hoppy;
    }

    /**
	 * 
	 * sql:select a.hoppy_id, a.hoppy_name, a.create_time, a.update_time, a.delete_flag from demo_hoppy a where a.delete_flag = 0 and a.hoppy_id = ?
	 */
    public Hoppy getHoppyByHoppyId(Long hoppyId) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("hoppyId", hoppyId);
        return (Hoppy) super.selectOne("Hoppy.getHoppyByHoppyId", params);
    }

    /**
	 * 
	 * sql:select a.hoppy_id, a.hoppy_name, a.create_time, a.update_time, a.delete_flag from demo_hoppy a where a.delete_flag = 0 and a.hoppy_id=? and a.hoppy_id in ( ? ) and a.hoppy_name=? and a.hoppy_name like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
    public PageList<Hoppy> getPageList(Hoppy hoppy, int pageSize, int pageNum) throws DataAccessException {
        return super.pageQuery("Hoppy.getPageList", hoppy, pageNum, pageSize);
    }

    /**
	 * 
	 * sql:select a.hoppy_id, a.hoppy_name, a.create_time, a.update_time, a.delete_flag from demo_hoppy a where a.delete_flag = 0 and 1=0 and a.hoppy_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
    public List<Hoppy> getHoppysByHoppyIds(java.util.List<Long> hoppyIds) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("hoppyIds", hoppyIds);
        return super.selectList("Hoppy.getHoppysByHoppyIds", params);
    }

    /**
	 * 
	 * sql:UPDATE demo_hoppy SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and hoppy_id in ( ? )
	 */
    public java.util.List<Long> deleteByHoppyIds(java.util.List<Long> hoppyIds) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("hoppyIds", hoppyIds);
        super.update("Hoppy.deleteByHoppyIds", params);
        return hoppyIds;
    }

    /**
	 * 
	 * sql:select a.hoppy_id, a.hoppy_name from demo_hoppy a where a.delete_flag = 0
	 */
    public List<Hoppy> getHoppyOptions() throws DataAccessException {
        return super.selectList("Hoppy.getHoppyOptions", null);
    }
}
