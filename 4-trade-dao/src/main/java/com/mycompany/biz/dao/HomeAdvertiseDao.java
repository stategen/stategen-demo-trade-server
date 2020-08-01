/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.HomeAdvertise;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.lite.IdGenerateService;

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
public interface HomeAdvertiseDao {

	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) String homeAdvId,
    &#64;ApiParam() &#64;RequestParam(required = false) Long advertiseId
    ,&#64;ApiParam(hidden = true) HomeAdvertise homeAdvertise
    
    </pre>
	 * 
	 * sql:insert into demo_home_advertise ( create_time , update_time , delete_flag , home_adv_id , advertise_id ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?)
	 */
	public HomeAdvertise insert(HomeAdvertise homeAdvertise, IdGenerateService<String> idGenerateService) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("homeAdvId") &#64;RequestParam(required = false) String homeAdvId    
    </pre>
	 * 
	 * sql:UPDATE demo_home_advertise a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.home_adv_id = ?
	 */
	public String delete(String homeAdvId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) Long advertiseId,
    &#64;ApiParam() &#64;RequestParam(required = false) String homeAdvId
    ,&#64;ApiParam(hidden = true) HomeAdvertise homeAdvertise
    
    </pre>
	 * 
	 * sql:UPDATE demo_home_advertise a SET a.update_time= CURRENT_TIMESTAMP(6) , a.advertise_id = ? where a.delete_flag = 0 and a.home_adv_id = ?
	 */
	public HomeAdvertise update(HomeAdvertise homeAdvertise) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("homeAdvId") &#64;RequestParam(required = false) String homeAdvId    
    </pre>
	 * 
	 * sql:select a.home_adv_id, a.advertise_id, a.create_time, a.update_time, a.delete_flag from demo_home_advertise a where a.delete_flag = 0 and a.home_adv_id = ?
	 */
	public HomeAdvertise getHomeAdvertiseByHomeAdvId(String homeAdvId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) String homeAdvId,
    &#64;ApiParam() &#64;RequestParam(required = false, name="homeAdvIds") ArrayList&lt;String&gt; homeAdvIds,
    &#64;ApiParam() &#64;RequestParam(required = false) Long advertiseId,
    &#64;ApiParam() &#64;RequestParam(required = false, name="advertiseIds") ArrayList&lt;Long&gt; advertiseIds,
    &#64;ApiParam() &#64;RequestParam(required = false) Date createTimeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Date createTimeMax,
    &#64;ApiParam() &#64;RequestParam(required = false) Date updateTimeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Date updateTimeMax
    ,&#64;ApiParam(hidden = true) HomeAdvertise homeAdvertise
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.home_adv_id, a.advertise_id, a.create_time, a.update_time, a.delete_flag from demo_home_advertise a where a.delete_flag = 0 and a.home_adv_id=? and a.home_adv_id in ( ? ) and a.advertise_id=? and a.advertise_id in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<HomeAdvertise> getPageList(HomeAdvertise homeAdvertise, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("homeAdvId") &#64;RequestParam(required = false, name="homeAdvIds") ArrayList&lt;String&gt; homeAdvIds    
    </pre>
	 * 
	 * sql:select a.home_adv_id, a.advertise_id, a.create_time, a.update_time, a.delete_flag from demo_home_advertise a where a.delete_flag = 0 and 1=0 and a.home_adv_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<HomeAdvertise> getHomeAdvertisesByHomeAdvIds(java.util.List<String> homeAdvIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("homeAdvId") &#64;RequestParam(required = false, name="homeAdvIds") ArrayList&lt;String&gt; homeAdvIds    
    </pre>
	 * 
	 * sql:UPDATE demo_home_advertise a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.home_adv_id in ( ? )
	 */
	public java.util.List<String> deleteByHomeAdvIds(java.util.List<String> homeAdvIds) throws DataAccessException;
	

}



