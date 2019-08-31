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

import com.mycompany.biz.domain.Goods;

/**
 * GoodsService
 * <pre>
 * database table: goods
 * database table comments: Goods
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public interface GoodsService extends GoodsServiceTrade, AssignService<Goods, String>, BaseService<Goods> {

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#insert
     */
    public Goods insert(Goods goods);

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#delete
     */
    public String delete(String goodsId);

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#update
     */
    public Goods update(Goods goods);

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#getGoodByGoodsId
     */
    public Goods getGoodByGoodsId(String goodsId);

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#getGoodsByGoodsIds
     */
    public List<Goods> getGoodsByGoodsIds(java.util.List<String> goodsIds);

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#deleteByGoodsIds
     */
    public java.util.List<String> deleteByGoodsIds(java.util.List<String> goodsIds);

    /*** 保存goods,有id时更新，没有id时插入,并带回新的id，返回 goods
     * @see com.mycompany.biz.dao.GoodsDao#insert
     */
    public Goods saveGoods(Goods goods);

    /** 批量保存goodss,有id时更新，没有id时插入,并带回新的id，返回 goodss
     * @see com.mycompany.biz.dao.GoodsDao#insert
     */
    public List<Goods> saveGoodss(List<Goods> goodss);

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#getGoodsIds
     */
    public List<String> getGoodsIds();

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#getPageList
     */
    public PageList<Goods> getPageList(Goods goods, int pageSize, int pageNum);
}