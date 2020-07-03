/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.HomeGoods;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;

/**
 * HomeGoodsDao
 * <pre>
 * database table: demo_home_goods
 * database table comments: HomeGoods
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface HomeGoodsDao {

	/**
    <pre>
    &#64;ApiParam() String recommendId,
    &#64;ApiParam() String goodsId,
    &#64;ApiParam() Integer orderNo
    ,&#64;ApiParam(hidden = true) HomeGoods homeGoods
    
    </pre>
	 * 
	 * sql:insert into demo_home_goods ( create_time , update_time , delete_flag , recommend_id , goods_id , order_no ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?)
	 */
	public HomeGoods insert(HomeGoods homeGoods) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("recommendId") String recommendId
    
    </pre>
	 * 
	 * sql:UPDATE demo_home_goods SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and recommend_id = ?
	 */
	public String delete(String recommendId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String goodsId,
    &#64;ApiParam() Integer orderNo,
    &#64;ApiParam() String recommendId
    ,&#64;ApiParam(hidden = true) HomeGoods homeGoods
    
    </pre>
	 * 
	 * sql:UPDATE demo_home_goods SET update_time= CURRENT_TIMESTAMP(6) , goods_id = ? , order_no = ? where delete_flag = 0 and recommend_id = ?
	 */
	public HomeGoods update(HomeGoods homeGoods) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("recommendId") String recommendId
    
    </pre>
	 * 
	 * sql:select a.recommend_id, a.goods_id, a.order_no, a.create_time, a.update_time, a.delete_flag from demo_home_goods a where a.delete_flag = 0 and a.recommend_id = ?
	 */
	public HomeGoods getHomeGoodByRecommendId(String recommendId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String recommendId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="recommendIds") ArrayList&lt;String&gt; recommendIds,
    &#64;ApiParam() String goodsId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="goodsIds") ArrayList&lt;String&gt; goodsIds,
    &#64;ApiParam() Integer orderNo,
    &#64;ApiParam() Integer orderNoMin,
    &#64;ApiParam() Integer orderNoMax,
    &#64;ApiParam() Date createTimeMin,
    &#64;ApiParam() Date createTimeMax,
    &#64;ApiParam() Date updateTimeMin,
    &#64;ApiParam() Date updateTimeMax
    ,&#64;ApiParam(hidden = true) HomeGoods homeGoods
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.recommend_id, a.goods_id, a.order_no, a.create_time, a.update_time, a.delete_flag from demo_home_goods a where a.delete_flag = 0 and a.recommend_id=? and a.recommend_id in ( ? ) and a.goods_id=? and a.goods_id in ( ? ) and a.order_no=? and a.order_no >=? and a.order_no <? and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<HomeGoods> getPageList(HomeGoods homeGoods, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("recommendId")&#64;RequestParam(required =false,name="recommendIds") ArrayList&lt;String&gt; recommendIds
    
    </pre>
	 * 
	 * sql:select a.recommend_id, a.goods_id, a.order_no, a.create_time, a.update_time, a.delete_flag from demo_home_goods a where a.delete_flag = 0 and 1=0 and a.recommend_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<HomeGoods> getHomeGoodsByRecommendIds(java.util.List<String> recommendIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("recommendId")&#64;RequestParam(required =false,name="recommendIds") ArrayList&lt;String&gt; recommendIds
    
    </pre>
	 * 
	 * sql:UPDATE demo_home_goods SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and recommend_id in ( ? )
	 */
	public java.util.List<String> deleteByRecommendIds(java.util.List<String> recommendIds) throws DataAccessException;
	

}



