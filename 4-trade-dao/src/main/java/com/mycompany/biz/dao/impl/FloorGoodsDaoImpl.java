/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.FloorGoods;
import com.mycompany.biz.dao.FloorGoodsDao;
import org.stategen.framework.ibatis.util.PageQueryUtils;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * FloorGoodsDao
 * <pre>
 * database table: floor_goods
 * database table comments: FloorGoods
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class FloorGoodsDaoImpl  extends SqlMapClientDaoSupport implements FloorGoodsDao {

	/**
	 * 
	 * sql:insert into floor_goods ( create_time , update_time , delete_flag , floor_goods_id , floor_id , goods_id , image , order_no ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?)
	 */
	public FloorGoods insert(FloorGoods floorGoods) throws DataAccessException {
		if(floorGoods == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        getSqlMapClientTemplate().insert("insert.FloorGoods.trade", floorGoods);
		return floorGoods;
	}

	/**
	 * 
	 * sql:UPDATE floor_goods SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and floor_goods_id = ?
	 */
	public String delete(String floorGoodsId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("floorGoodsId",floorGoodsId);
        getSqlMapClientTemplate().update("delete.FloorGoods.trade", params);
        return floorGoodsId;
	}

	/**
	 * 
	 * sql:UPDATE floor_goods SET update_time= CURRENT_TIMESTAMP(6) , floor_id = ? , goods_id = ? , image = ? , order_no = ? where delete_flag = 0 and floor_goods_id = ?
	 */
	public FloorGoods update(FloorGoods floorGoods) throws DataAccessException {
		if(floorGoods == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        getSqlMapClientTemplate().update("update.FloorGoods.trade", floorGoods);
		return floorGoods;
	}

	/**
	 * 
	 * sql:select a.floor_goods_id, a.floor_id, a.goods_id, a.image, a.order_no, a.create_time, a.update_time, a.delete_flag from floor_goods a where a.delete_flag = 0 and a.floor_goods_id = ?
	 */
	public FloorGoods getFloorGoodByFloorGoodsId(String floorGoodsId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("floorGoodsId",floorGoodsId);
		return (FloorGoods)getSqlMapClientTemplate().queryForObject("getFloorGoodByFloorGoodsId.FloorGoods.trade",params);
	}

	/**
	 * 
	 * sql:select a.floor_goods_id, a.floor_id, a.goods_id, a.image, a.order_no, a.create_time, a.update_time, a.delete_flag from floor_goods a where a.delete_flag = 0 and a.floor_goods_id=? and a.floor_goods_id in ( ? ) and a.floor_id=? and a.floor_id in ( ? ) and a.goods_id=? and a.goods_id in ( ? ) and a.order_no >=? and a.order_no <? and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.order_no
	 */
    @SuppressWarnings("unchecked")
	public PageList<FloorGoods> getPageList(FloorGoods floorGoods, int pageSize, int pageNum) throws DataAccessException {
		return (PageList<FloorGoods>)PageQueryUtils.pageQuery(getSqlMapClientTemplate(),"getPageList.FloorGoods.trade",floorGoods,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.floor_goods_id, a.floor_id, a.goods_id, a.image, a.order_no, a.create_time, a.update_time, a.delete_flag from floor_goods a where a.delete_flag = 0 and 1=0 and a.floor_goods_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
    @SuppressWarnings("unchecked")
	public List<FloorGoods> getFloorGoodsByFloorGoodsIds(java.util.List<String> floorGoodsIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("floorGoodsIds",floorGoodsIds);
		return (List<FloorGoods>)getSqlMapClientTemplate().queryForList("getFloorGoodsByFloorGoodsIds.FloorGoods.trade",params);
	}

	/**
	 * 
	 * sql:UPDATE floor_goods SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and floor_goods_id in ( ? )
	 */
	public java.util.List<String> deleteByFloorGoodsIds(java.util.List<String> floorGoodsIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("floorGoodsIds",floorGoodsIds);
        getSqlMapClientTemplate().update("deleteByFloorGoodsIds.FloorGoods.trade", params);
        return floorGoodsIds;
	}

}

