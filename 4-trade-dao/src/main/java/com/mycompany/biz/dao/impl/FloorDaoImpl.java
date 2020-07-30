/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */    
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.Floor;
import com.mycompany.biz.dao.FloorDao;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.IdGenerateService;
/**
 * FloorDao
 * <pre>
 * database table: demo_floor
 * database table comments: Floor
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class FloorDaoImpl  extends SqlDaoSupportBase implements FloorDao {


	/**
	 * 
	 * sql:insert into demo_floor ( create_time , update_time , delete_flag , floor_id , advertise_id , order_no , floor_name ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?)
	 */
	public Floor insert(Floor floor, IdGenerateService<String> idGenerateService) throws DataAccessException {
		if(floor == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        if (idGenerateService != null) {
            String floorId = idGenerateService.generateId(Floor.class);
            if (floorId != null) {
                floor.setFloorId(floorId);
            }
        }
        super.insert("Floor.insert", floor);
		return floor;
	}

	/**
	 * 
	 * sql:UPDATE demo_floor a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.floor_id = ?
	 */
	public String delete(String floorId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("floorId",floorId);
        super.update("Floor.delete", params);
        return floorId;
	}

	/**
	 * 
	 * sql:UPDATE demo_floor a SET a.update_time= CURRENT_TIMESTAMP(6) , a.advertise_id = ? , a.order_no = ? , a.floor_name = ? where a.delete_flag = 0 and a.floor_id = ?
	 */
	public Floor update(Floor floor) throws DataAccessException {
		if(floor == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        super.update("Floor.update", floor);
		return floor;
	}

	/**
	 * 
	 * sql:select a.floor_id, a.advertise_id, a.order_no, a.floor_name, a.create_time, a.update_time, a.delete_flag from demo_floor a where a.delete_flag = 0 and a.floor_id = ?
	 */
	public Floor getFloorByFloorId(String floorId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("floorId",floorId);
		return (Floor)super.selectOne("Floor.getFloorByFloorId",params);
	}

	/**
	 * 
	 * sql:select a.floor_id, a.advertise_id, a.order_no, a.floor_name, a.create_time, a.update_time, a.delete_flag from demo_floor a where a.delete_flag = 0 and a.floor_id=? and a.floor_id in ( ? ) and a.advertise_id=? and a.advertise_id in ( ? ) and a.order_no=? and a.order_no in ( ? ) and a.floor_name=? and a.floor_name like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<Floor> getPageList(Floor floor, int pageSize, int pageNum) throws DataAccessException {
		return super.pageQuery("Floor.getPageList",floor,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.floor_id, a.advertise_id, a.order_no, a.floor_name, a.create_time, a.update_time, a.delete_flag from demo_floor a where a.delete_flag = 0 and 1=0 and a.floor_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<Floor> getFloorsByFloorIds(java.util.List<String> floorIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("floorIds",floorIds);
		return super.selectList("Floor.getFloorsByFloorIds",params);
	}

	/**
	 * 
	 * sql:UPDATE demo_floor a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.floor_id in ( ? )
	 */
	public java.util.List<String> deleteByFloorIds(java.util.List<String> floorIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("floorIds",floorIds);
        super.update("Floor.deleteByFloorIds", params);
        return floorIds;
	}
}

