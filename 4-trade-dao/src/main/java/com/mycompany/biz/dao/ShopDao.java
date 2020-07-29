/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.Shop;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.util.IIDGenerator;

/**
 * ShopDao
 * <pre>
 * database table: demo_shop
 * database table comments: Shop
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface ShopDao {

	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) String shopId,
    &#64;ApiParam() &#64;RequestParam(required = false) String leaderImage,
    &#64;ApiParam() &#64;RequestParam(required = false) String leaderPhone
    ,&#64;ApiParam(hidden = true) Shop shop
    
    </pre>
	 * 
	 * sql:insert into demo_shop ( create_time , update_time , delete_flag , shop_id , leader_image , leader_phone ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?)
	 */
	public Shop insert(Shop shop, IIDGenerator<String> idGenerator) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("shopId") &#64;RequestParam(required = false) String shopId    
    </pre>
	 * 
	 * sql:UPDATE demo_shop a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.shop_id = ?
	 */
	public String delete(String shopId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) String leaderImage,
    &#64;ApiParam() &#64;RequestParam(required = false) String leaderPhone,
    &#64;ApiParam() &#64;RequestParam(required = false) String shopId
    ,&#64;ApiParam(hidden = true) Shop shop
    
    </pre>
	 * 
	 * sql:UPDATE demo_shop a SET a.update_time= CURRENT_TIMESTAMP(6) , a.leader_image = ? , a.leader_phone = ? where a.delete_flag = 0 and a.shop_id = ?
	 */
	public Shop update(Shop shop) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("shopId") &#64;RequestParam(required = false) String shopId    
    </pre>
	 * 
	 * sql:select a.shop_id, a.leader_image, a.leader_phone, a.create_time, a.update_time, a.delete_flag from demo_shop a where a.delete_flag = 0 and a.shop_id = ?
	 */
	public Shop getShopByShopId(String shopId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) String shopId,
    &#64;ApiParam() &#64;RequestParam(required = false, name="shopIds") ArrayList&lt;String&gt; shopIds,
    &#64;ApiParam() &#64;RequestParam(required = false) String leaderPhone,
    &#64;ApiParam() &#64;RequestParam(required = false) String leaderPhoneLike,
    &#64;ApiParam() &#64;RequestParam(required = false) Date createTimeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Date createTimeMax,
    &#64;ApiParam() &#64;RequestParam(required = false) Date updateTimeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Date updateTimeMax
    ,&#64;ApiParam(hidden = true) Shop shop
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.shop_id, a.leader_image, a.leader_phone, a.create_time, a.update_time, a.delete_flag from demo_shop a where a.delete_flag = 0 and a.shop_id=? and a.shop_id in ( ? ) and a.leader_phone=? and a.leader_phone like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<Shop> getPageList(Shop shop, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("shopId") &#64;RequestParam(required = false, name="shopIds") ArrayList&lt;String&gt; shopIds    
    </pre>
	 * 
	 * sql:select a.shop_id, a.leader_image, a.leader_phone, a.create_time, a.update_time, a.delete_flag from demo_shop a where a.delete_flag = 0 and 1=0 and a.shop_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<Shop> getShopsByShopIds(java.util.List<String> shopIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("shopId") &#64;RequestParam(required = false, name="shopIds") ArrayList&lt;String&gt; shopIds    
    </pre>
	 * 
	 * sql:UPDATE demo_shop a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.shop_id in ( ? )
	 */
	public java.util.List<String> deleteByShopIds(java.util.List<String> shopIds) throws DataAccessException;
	

}



