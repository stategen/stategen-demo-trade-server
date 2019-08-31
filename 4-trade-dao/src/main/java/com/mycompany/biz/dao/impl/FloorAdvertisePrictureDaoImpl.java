/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.FloorAdvertisePricture;
import com.mycompany.biz.dao.FloorAdvertisePrictureDao;
import org.stategen.framework.ibatis.util.PageQueryUtils;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * FloorAdvertisePrictureDao
 * <pre>
 * database table: floor_advertise_pricture
 * database table comments: FloorAdvertisePricture
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class FloorAdvertisePrictureDaoImpl  extends SqlMapClientDaoSupport implements FloorAdvertisePrictureDao {

	/**
	 * 
	 * sql:insert into floor_advertise_pricture ( create_time , update_time , delete_flag , floor_id , advertise_id , order_no , floor_name ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?)
	 */
	public FloorAdvertisePricture insert(FloorAdvertisePricture floorAdvertisePricture) throws DataAccessException {
		if(floorAdvertisePricture == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        getSqlMapClientTemplate().insert("insert.FloorAdvertisePricture.trade", floorAdvertisePricture);
		return floorAdvertisePricture;
	}

	/**
	 * 
	 * sql:UPDATE floor_advertise_pricture SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and floor_id = ?
	 */
	public String delete(String floorId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("floorId",floorId);
        getSqlMapClientTemplate().update("delete.FloorAdvertisePricture.trade", params);
        return floorId;
	}

	/**
	 * 
	 * sql:UPDATE floor_advertise_pricture SET update_time= CURRENT_TIMESTAMP(6) , advertise_id = ? , order_no = ? , floor_name = ? where delete_flag = 0 and floor_id = ?
	 */
	public FloorAdvertisePricture update(FloorAdvertisePricture floorAdvertisePricture) throws DataAccessException {
		if(floorAdvertisePricture == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        getSqlMapClientTemplate().update("update.FloorAdvertisePricture.trade", floorAdvertisePricture);
		return floorAdvertisePricture;
	}

	/**
	 * 
	 * sql:select a.floor_id, a.advertise_id, a.order_no, a.floor_name, a.create_time, a.update_time, a.delete_flag from floor_advertise_pricture a where a.delete_flag = 0 and a.floor_id = ?
	 */
	public FloorAdvertisePricture getFloorAdvertisePrictureByFloorId(String floorId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("floorId",floorId);
		return (FloorAdvertisePricture)getSqlMapClientTemplate().queryForObject("getFloorAdvertisePrictureByFloorId.FloorAdvertisePricture.trade",params);
	}

	/**
	 * 
	 * sql:select a.floor_id, a.advertise_id, a.order_no, a.floor_name, a.create_time, a.update_time, a.delete_flag from floor_advertise_pricture a where a.delete_flag = 0 and a.floor_id=? and a.floor_id in ( ? ) and a.advertise_id=? and a.advertise_id in ( ? ) and a.order_no >=? and a.order_no <? and a.floor_name=? and a.floor_name like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
    @SuppressWarnings("unchecked")
	public PageList<FloorAdvertisePricture> getPageList(FloorAdvertisePricture floorAdvertisePricture, int pageSize, int pageNum) throws DataAccessException {
		return (PageList<FloorAdvertisePricture>)PageQueryUtils.pageQuery(getSqlMapClientTemplate(),"getPageList.FloorAdvertisePricture.trade",floorAdvertisePricture,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.floor_id, a.advertise_id, a.order_no, a.floor_name, a.create_time, a.update_time, a.delete_flag from floor_advertise_pricture a where a.delete_flag = 0 and 1=0 and a.floor_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
    @SuppressWarnings("unchecked")
	public List<FloorAdvertisePricture> getFloorAdvertisePricturesByFloorIds(java.util.List<String> floorIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("floorIds",floorIds);
		return (List<FloorAdvertisePricture>)getSqlMapClientTemplate().queryForList("getFloorAdvertisePricturesByFloorIds.FloorAdvertisePricture.trade",params);
	}

	/**
	 * 
	 * sql:UPDATE floor_advertise_pricture SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and floor_id in ( ? )
	 */
	public java.util.List<String> deleteByFloorIds(java.util.List<String> floorIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("floorIds",floorIds);
        getSqlMapClientTemplate().update("deleteByFloorIds.FloorAdvertisePricture.trade", params);
        return floorIds;
	}

}
