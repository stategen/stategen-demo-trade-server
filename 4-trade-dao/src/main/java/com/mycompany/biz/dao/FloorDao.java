/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.Floor;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;

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
public interface FloorDao {

	/**
    <pre>
    &#64;ApiParam() String floorId,
    &#64;ApiParam() Long advertiseId,
    &#64;ApiParam() Integer orderNo,
    &#64;ApiParam() String floorName
    ,&#64;ApiParam(hidden = true) Floor floor
    
    </pre>
	 * 
	 * sql:insert into demo_floor ( create_time , update_time , delete_flag , floor_id , advertise_id , order_no , floor_name ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?)
	 */
	public Floor insert(Floor floor) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("floorId") String floorId
    
    </pre>
	 * 
	 * sql:UPDATE demo_floor a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.floor_id = ?
	 */
	public String delete(String floorId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() Long advertiseId,
    &#64;ApiParam() Integer orderNo,
    &#64;ApiParam() String floorName,
    &#64;ApiParam() String floorId
    ,&#64;ApiParam(hidden = true) Floor floor
    
    </pre>
	 * 
	 * sql:UPDATE demo_floor a SET a.update_time= CURRENT_TIMESTAMP(6) , a.advertise_id = ? , a.order_no = ? , a.floor_name = ? where a.delete_flag = 0 and a.floor_id = ?
	 */
	public Floor update(Floor floor) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("floorId") String floorId
    
    </pre>
	 * 
	 * sql:select a.floor_id, a.advertise_id, a.order_no, a.floor_name, a.create_time, a.update_time, a.delete_flag from demo_floor a where a.delete_flag = 0 and a.floor_id = ?
	 */
	public Floor getFloorByFloorId(String floorId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String floorId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="floorIds") ArrayList&lt;String&gt; floorIds,
    &#64;ApiParam() Long advertiseId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="advertiseIds") ArrayList&lt;Long&gt; advertiseIds,
    &#64;ApiParam() Integer orderNo,
    &#64;ApiParam()&#64;RequestParam(required =false,name="orderNos") ArrayList&lt;Integer&gt; orderNos,
    &#64;ApiParam() String floorName,
    &#64;ApiParam() String floorNameLike,
    &#64;ApiParam() Date createTimeMin,
    &#64;ApiParam() Date createTimeMax,
    &#64;ApiParam() Date updateTimeMin,
    &#64;ApiParam() Date updateTimeMax
    ,&#64;ApiParam(hidden = true) Floor floor
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.floor_id, a.advertise_id, a.order_no, a.floor_name, a.create_time, a.update_time, a.delete_flag from demo_floor a where a.delete_flag = 0 and a.floor_id=? and a.floor_id in ( ? ) and a.advertise_id=? and a.advertise_id in ( ? ) and a.order_no=? and a.order_no in ( ? ) and a.floor_name=? and a.floor_name like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<Floor> getPageList(Floor floor, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("floorId")&#64;RequestParam(required =false,name="floorIds") ArrayList&lt;String&gt; floorIds
    
    </pre>
	 * 
	 * sql:select a.floor_id, a.advertise_id, a.order_no, a.floor_name, a.create_time, a.update_time, a.delete_flag from demo_floor a where a.delete_flag = 0 and 1=0 and a.floor_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<Floor> getFloorsByFloorIds(java.util.List<String> floorIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("floorId")&#64;RequestParam(required =false,name="floorIds") ArrayList&lt;String&gt; floorIds
    
    </pre>
	 * 
	 * sql:UPDATE demo_floor a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.floor_id in ( ? )
	 */
	public java.util.List<String> deleteByFloorIds(java.util.List<String> floorIds) throws DataAccessException;
	

}



