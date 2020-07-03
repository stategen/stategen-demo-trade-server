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

import com.mycompany.biz.dao.HomeAdvertiseDao;
import com.mycompany.biz.domain.HomeAdvertise;

/**
 * HomeAdvertiseDao
 * <pre>
 * database table: demo_home_advertise
 * database table comments: HomeAdvertise
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class HomeAdvertiseDaoImpl extends SqlDaoSupportBase implements HomeAdvertiseDao {

    /**
	 * 
	 * sql:insert into demo_home_advertise ( create_time , update_time , delete_flag , home_adv_id , advertise_id ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?)
	 */
    public HomeAdvertise insert(HomeAdvertise homeAdvertise) throws DataAccessException {
        if (homeAdvertise == null) {
            throw new IllegalArgumentException("Can't insert a null data object into db.");
        }
        super.insert("HomeAdvertise.insert", homeAdvertise);
        return homeAdvertise;
    }

    /**
	 * 
	 * sql:UPDATE demo_home_advertise SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and home_adv_id = ?
	 */
    public String delete(String homeAdvId) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("homeAdvId", homeAdvId);
        super.update("HomeAdvertise.delete", params);
        return homeAdvId;
    }

    /**
	 * 
	 * sql:UPDATE demo_home_advertise SET update_time= CURRENT_TIMESTAMP(6) , advertise_id = ? where delete_flag = 0 and home_adv_id = ?
	 */
    public HomeAdvertise update(HomeAdvertise homeAdvertise) throws DataAccessException {
        if (homeAdvertise == null) {
            throw new IllegalArgumentException("Can't update by a null data object.");
        }
        super.update("HomeAdvertise.update", homeAdvertise);
        return homeAdvertise;
    }

    /**
	 * 
	 * sql:select a.home_adv_id, a.advertise_id, a.create_time, a.update_time, a.delete_flag from demo_home_advertise a where a.delete_flag = 0 and a.home_adv_id = ?
	 */
    public HomeAdvertise getHomeAdvertiseByHomeAdvId(String homeAdvId) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("homeAdvId", homeAdvId);
        return (HomeAdvertise) super.selectOne("HomeAdvertise.getHomeAdvertiseByHomeAdvId", params);
    }

    /**
	 * 
	 * sql:select a.home_adv_id, a.advertise_id, a.create_time, a.update_time, a.delete_flag from demo_home_advertise a where a.delete_flag = 0 and a.home_adv_id=? and a.home_adv_id in ( ? ) and a.advertise_id=? and a.advertise_id in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
    public PageList<HomeAdvertise> getPageList(HomeAdvertise homeAdvertise, int pageSize, int pageNum) throws DataAccessException {
        return super.pageQuery("HomeAdvertise.getPageList", homeAdvertise, pageNum, pageSize);
    }

    /**
	 * 
	 * sql:select a.home_adv_id, a.advertise_id, a.create_time, a.update_time, a.delete_flag from demo_home_advertise a where a.delete_flag = 0 and 1=0 and a.home_adv_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
    public List<HomeAdvertise> getHomeAdvertisesByHomeAdvIds(java.util.List<String> homeAdvIds) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("homeAdvIds", homeAdvIds);
        return super.selectList("HomeAdvertise.getHomeAdvertisesByHomeAdvIds", params);
    }

    /**
	 * 
	 * sql:UPDATE demo_home_advertise SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and home_adv_id in ( ? )
	 */
    public java.util.List<String> deleteByHomeAdvIds(java.util.List<String> homeAdvIds) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("homeAdvIds", homeAdvIds);
        super.update("HomeAdvertise.deleteByHomeAdvIds", params);
        return homeAdvIds;
    }
}
