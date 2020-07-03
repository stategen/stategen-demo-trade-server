/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.HomeShop;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;

/**
 * HomeShopDao
 * <pre>
 * database table: demo_home_shop
 * database table comments: HomeShop
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface HomeShopDao {

	/**
    <pre>
    &#64;ApiParam() String homeShopId,
    &#64;ApiParam() String shopId
    ,&#64;ApiParam(hidden = true) HomeShop homeShop
    
    </pre>
	 * 
	 * sql:insert into demo_home_shop ( create_time , update_time , delete_flag , home_shop_id , shop_id ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?)
	 */
	public HomeShop insert(HomeShop homeShop) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("homeShopId") String homeShopId
    
    </pre>
	 * 
	 * sql:UPDATE demo_home_shop SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and home_shop_id = ?
	 */
	public String delete(String homeShopId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String shopId,
    &#64;ApiParam() String homeShopId
    ,&#64;ApiParam(hidden = true) HomeShop homeShop
    
    </pre>
	 * 
	 * sql:UPDATE demo_home_shop SET update_time= CURRENT_TIMESTAMP(6) , shop_id = ? where delete_flag = 0 and home_shop_id = ?
	 */
	public HomeShop update(HomeShop homeShop) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("homeShopId") String homeShopId
    
    </pre>
	 * 
	 * sql:select a.home_shop_id, a.shop_id, a.create_time, a.update_time, a.delete_flag from demo_home_shop a where a.delete_flag = 0 and a.home_shop_id = ?
	 */
	public HomeShop getHomeShopByHomeShopId(String homeShopId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String homeShopId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="homeShopIds") ArrayList&lt;String&gt; homeShopIds,
    &#64;ApiParam() String shopId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="shopIds") ArrayList&lt;String&gt; shopIds,
    &#64;ApiParam() Date createTimeMin,
    &#64;ApiParam() Date createTimeMax,
    &#64;ApiParam() Date updateTimeMin,
    &#64;ApiParam() Date updateTimeMax
    ,&#64;ApiParam(hidden = true) HomeShop homeShop
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.home_shop_id, a.shop_id, a.create_time, a.update_time, a.delete_flag from demo_home_shop a where a.delete_flag = 0 and a.home_shop_id=? and a.home_shop_id in ( ? ) and a.shop_id=? and a.shop_id in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<HomeShop> getPageList(HomeShop homeShop, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("homeShopId")&#64;RequestParam(required =false,name="homeShopIds") ArrayList&lt;String&gt; homeShopIds
    
    </pre>
	 * 
	 * sql:select a.home_shop_id, a.shop_id, a.create_time, a.update_time, a.delete_flag from demo_home_shop a where a.delete_flag = 0 and 1=0 and a.home_shop_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<HomeShop> getHomeShopsByHomeShopIds(java.util.List<String> homeShopIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("homeShopId")&#64;RequestParam(required =false,name="homeShopIds") ArrayList&lt;String&gt; homeShopIds
    
    </pre>
	 * 
	 * sql:UPDATE demo_home_shop SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and home_shop_id in ( ? )
	 */
	public java.util.List<String> deleteByHomeShopIds(java.util.List<String> homeShopIds) throws DataAccessException;
	

}



