/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.stategen.framework.ibatis.util.PageQueryUtils;
import org.stategen.framework.lite.PageList;

import com.mycompany.biz.dao.HomeGoodsDao;
import com.mycompany.biz.domain.HomeGoods;

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
public class HomeGoodsDaoImpl extends SqlDaoSupportBase implements HomeGoodsDao {

    /**
	 * 
	 * sql:insert into demo_home_goods ( create_time , update_time , delete_flag , recommend_id , goods_id , order_no ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?)
	 */
    public HomeGoods insert(HomeGoods homeGoods) throws DataAccessException {
        if (homeGoods == null) {
            throw new IllegalArgumentException("Can't insert a null data object into db.");
        }
        super.insert("HomeGoods.insert", homeGoods);
        return homeGoods;
    }

    /**
	 * 
	 * sql:UPDATE demo_home_goods SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and recommend_id = ?
	 */
    public String delete(String recommendId) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("recommendId", recommendId);
        super.update("HomeGoods.delete", params);
        return recommendId;
    }

    /**
	 * 
	 * sql:UPDATE demo_home_goods SET update_time= CURRENT_TIMESTAMP(6) , goods_id = ? , order_no = ? where delete_flag = 0 and recommend_id = ?
	 */
    public HomeGoods update(HomeGoods homeGoods) throws DataAccessException {
        if (homeGoods == null) {
            throw new IllegalArgumentException("Can't update by a null data object.");
        }
        super.update("HomeGoods.update", homeGoods);
        return homeGoods;
    }

    /**
	 * 
	 * sql:select a.recommend_id, a.goods_id, a.order_no, a.create_time, a.update_time, a.delete_flag from demo_home_goods a where a.delete_flag = 0 and a.recommend_id = ?
	 */
    public HomeGoods getHomeGoodByRecommendId(String recommendId) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("recommendId", recommendId);
        return (HomeGoods) super.selectOne("HomeGoods.getHomeGoodByRecommendId", params);
    }

    /**
	 * 
	 * sql:select a.recommend_id, a.goods_id, a.order_no, a.create_time, a.update_time, a.delete_flag from demo_home_goods a where a.delete_flag = 0 and a.recommend_id=? and a.recommend_id in ( ? ) and a.goods_id=? and a.goods_id in ( ? ) and a.order_no=? and a.order_no >=? and a.order_no <? and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
    public PageList<HomeGoods> getPageList(HomeGoods homeGoods, int pageSize, int pageNum) throws DataAccessException {
        return super.pageQuery("HomeGoods.getPageList", homeGoods, pageNum, pageSize);
    }

    /**
	 * 
	 * sql:select a.recommend_id, a.goods_id, a.order_no, a.create_time, a.update_time, a.delete_flag from demo_home_goods a where a.delete_flag = 0 and 1=0 and a.recommend_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
    public List<HomeGoods> getHomeGoodsByRecommendIds(java.util.List<String> recommendIds) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("recommendIds", recommendIds);
        return super.selectList("HomeGoods.getHomeGoodsByRecommendIds", params);
    }

    /**
	 * 
	 * sql:UPDATE demo_home_goods SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and recommend_id in ( ? )
	 */
    public java.util.List<String> deleteByRecommendIds(java.util.List<String> recommendIds) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("recommendIds", recommendIds);
        super.update("HomeGoods.deleteByRecommendIds", params);
        return recommendIds;
    }
}
