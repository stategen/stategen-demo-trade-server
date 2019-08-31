/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.service;

import java.util.List;

import org.stategen.framework.lite.PageList;
import org.stategen.framework.util.AssignService;
import org.stategen.framework.util.BaseService;

import com.mycompany.biz.domain.HomeGoods;

/**
 * HomeGoodsService
 * <pre>
 * database table: home_goods
 * database table comments: HomeGoods
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public interface HomeGoodsService extends HomeGoodsServiceTrade, AssignService<HomeGoods, String>, BaseService<HomeGoods> {

    /**
     * 
     * @see com.mycompany.biz.dao.HomeGoodsDao#insert
     */
    public HomeGoods insert(HomeGoods homeGoods);

    /**
     * 
     * @see com.mycompany.biz.dao.HomeGoodsDao#delete
     */
    public String delete(String recommendId);

    /**
     * 
     * @see com.mycompany.biz.dao.HomeGoodsDao#update
     */
    public HomeGoods update(HomeGoods homeGoods);

    /**
     * 
     * @see com.mycompany.biz.dao.HomeGoodsDao#getHomeGoodByRecommendId
     */
    public HomeGoods getHomeGoodByRecommendId(String recommendId);

    /**
     * 
     * @see com.mycompany.biz.dao.HomeGoodsDao#getHomeGoodsByRecommendIds
     */
    public List<HomeGoods> getHomeGoodsByRecommendIds(java.util.List<String> recommendIds);

    /**
     * 
     * @see com.mycompany.biz.dao.HomeGoodsDao#deleteByRecommendIds
     */
    public java.util.List<String> deleteByRecommendIds(java.util.List<String> recommendIds);

    /*** 保存homeGoods,有id时更新，没有id时插入,并带回新的id，返回 homeGoods
     * @see com.mycompany.biz.dao.HomeGoodsDao#insert
     */
    public HomeGoods saveHomeGoods(HomeGoods homeGoods);

    /** 批量保存homeGoodss,有id时更新，没有id时插入,并带回新的id，返回 homeGoodss
     * @see com.mycompany.biz.dao.HomeGoodsDao#insert
     */
    public List<HomeGoods> saveHomeGoodss(List<HomeGoods> homeGoodss);

    /**
     * 
     * @see com.mycompany.biz.dao.HomeGoodsDao#getPageList
     */
    public PageList<HomeGoods> getPageList(HomeGoods homeGoods, int pageSize, int pageNum);
}