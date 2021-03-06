/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */    
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.Shop;
import com.mycompany.biz.dao.ShopDao;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.IdGenerateService;
/**
 * ShopDao
 * @author StageGen.org 
 * <pre>
 * database table: demo_shop
 * database table comments: Shop
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class ShopDaoImpl  extends SqlDaoSupportBase implements ShopDao {


	/**
	 * 
	 * sql:insert into demo_shop ( create_time , update_time , delete_flag , shop_id , leader_image , leader_phone ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?)
	 */
	public Shop insert(Shop shop, IdGenerateService<String> idGenerateService) throws DataAccessException {
		if(shop == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        if (idGenerateService != null && shop.getShopId() == null) {
            String shopId = idGenerateService.generateId();
            if (shopId != null) {
                shop.setShopId(shopId);
            }
        }
        super.insert("Shop.insert", shop);
		return shop;
	}

	/**
	 * 
	 * sql:UPDATE demo_shop a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.shop_id = ?
	 */
	public String delete(String shopId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("shopId",shopId);
        super.update("Shop.delete", params);
        return shopId;
	}

	/**
	 * 
	 * sql:UPDATE demo_shop a SET a.update_time= CURRENT_TIMESTAMP(6) , a.leader_image = ? , a.leader_phone = ? where a.delete_flag = 0 and a.shop_id = ?
	 */
	public Shop update(Shop shop) throws DataAccessException {
		if(shop == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        super.update("Shop.update", shop);
		return shop;
	}

	/**
	 * 
	 * sql:select a.shop_id, a.leader_image, a.leader_phone, a.create_time, a.update_time, a.delete_flag from demo_shop a where a.delete_flag = 0 and a.shop_id = ?
	 */
	public Shop getShopByShopId(String shopId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("shopId",shopId);
		return (Shop)super.selectOne("Shop.getShopByShopId",params);
	}

	/**
	 * 
	 * sql:select a.shop_id, a.leader_image, a.leader_phone, a.create_time, a.update_time, a.delete_flag from demo_shop a where a.delete_flag = 0 and a.shop_id=? and a.shop_id in ( ? ) and a.leader_phone=? and a.leader_phone like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<Shop> getPageList(Shop shop, int pageSize, int pageNum) throws DataAccessException {
		return super.pageQuery("Shop.getPageList",shop,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.shop_id, a.leader_image, a.leader_phone, a.create_time, a.update_time, a.delete_flag from demo_shop a where a.delete_flag = 0 and 1=0 and a.shop_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<Shop> getShopsByShopIds(java.util.List<String> shopIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("shopIds",shopIds);
		return super.selectList("Shop.getShopsByShopIds",params);
	}

	/**
	 * 
	 * sql:UPDATE demo_shop a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.shop_id in ( ? )
	 */
	public java.util.List<String> deleteByShopIds(java.util.List<String> shopIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("shopIds",shopIds);
        super.update("Shop.deleteByShopIds", params);
        return shopIds;
	}
}

