/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.HomeShop;
import com.mycompany.biz.dao.HomeShopDao;
import org.stategen.framework.ibatis.util.PageQueryUtils;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * HomeShopDao
 * <pre>
 * database table: demo_home_shop
 * database table comments: HomeShop
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class HomeShopDaoImpl  extends SqlMapClientDaoSupport implements HomeShopDao {

	/**
	 * 
	 * sql:insert into demo_home_shop ( create_time , update_time , delete_flag , home_shop_id , shop_id ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?)
	 */
	public HomeShop insert(HomeShop homeShop) throws DataAccessException {
		if(homeShop == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        getSqlMapClientTemplate().insert("insert.HomeShop.trade", homeShop);
		return homeShop;
	}

	/**
	 * 
	 * sql:UPDATE demo_home_shop SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and home_shop_id = ?
	 */
	public String delete(String homeShopId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("homeShopId",homeShopId);
        getSqlMapClientTemplate().update("delete.HomeShop.trade", params);
        return homeShopId;
	}

	/**
	 * 
	 * sql:UPDATE demo_home_shop SET update_time= CURRENT_TIMESTAMP(6) , shop_id = ? where delete_flag = 0 and home_shop_id = ?
	 */
	public HomeShop update(HomeShop homeShop) throws DataAccessException {
		if(homeShop == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        getSqlMapClientTemplate().update("update.HomeShop.trade", homeShop);
		return homeShop;
	}

	/**
	 * 
	 * sql:select a.home_shop_id, a.shop_id, a.create_time, a.update_time, a.delete_flag from demo_home_shop a where a.delete_flag = 0 and a.home_shop_id = ?
	 */
	public HomeShop getHomeShopByHomeShopId(String homeShopId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("homeShopId",homeShopId);
		return (HomeShop)getSqlMapClientTemplate().queryForObject("getHomeShopByHomeShopId.HomeShop.trade",params);
	}

	/**
	 * 
	 * sql:select a.home_shop_id, a.shop_id, a.create_time, a.update_time, a.delete_flag from demo_home_shop a where a.delete_flag = 0 and a.home_shop_id=? and a.home_shop_id in ( ? ) and a.shop_id=? and a.shop_id in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
    @SuppressWarnings("unchecked")
	public PageList<HomeShop> getPageList(HomeShop homeShop, int pageSize, int pageNum) throws DataAccessException {
		return (PageList<HomeShop>)PageQueryUtils.pageQuery(getSqlMapClientTemplate(),"getPageList.HomeShop.trade",homeShop,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.home_shop_id, a.shop_id, a.create_time, a.update_time, a.delete_flag from demo_home_shop a where a.delete_flag = 0 and 1=0 and a.home_shop_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
    @SuppressWarnings("unchecked")
	public List<HomeShop> getHomeShopsByHomeShopIds(java.util.List<String> homeShopIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("homeShopIds",homeShopIds);
		return (List<HomeShop>)getSqlMapClientTemplate().queryForList("getHomeShopsByHomeShopIds.HomeShop.trade",params);
	}

	/**
	 * 
	 * sql:UPDATE demo_home_shop SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and home_shop_id in ( ? )
	 */
	public java.util.List<String> deleteByHomeShopIds(java.util.List<String> homeShopIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("homeShopIds",homeShopIds);
        getSqlMapClientTemplate().update("deleteByHomeShopIds.HomeShop.trade", params);
        return homeShopIds;
	}

}

