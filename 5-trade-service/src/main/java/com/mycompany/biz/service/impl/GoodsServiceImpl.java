/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import javax.annotation.Resource;

import org.stategen.framework.lite.PageList;
import org.stategen.framework.util.ServiceUtil;
import org.stategen.framework.util.StringUtil;

import com.mycompany.biz.dao.GoodsDao;
import com.mycompany.biz.domain.Goods;
import com.mycompany.biz.service.GoodsService;

/**
 * GoodsServiceImpl
 * <pre>
 * database table: goods
 * database table comments: Goods
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public class GoodsServiceImpl implements GoodsService {

    @Resource(name = "goodsDao")
    GoodsDao goodsDao;

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#insert
     * @see com.mycompany.biz.service.GoodsService#insert
     */
    @Override
    public Goods insert(Goods goods) {
        return goodsDao.insert(goods);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#delete
     * @see com.mycompany.biz.service.GoodsService#delete
     */
    @Override
    public String delete(String goodsId) {
        return goodsDao.delete(goodsId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#update
     * @see com.mycompany.biz.service.GoodsService#update
     */
    @Override
    public Goods update(Goods goods) {
        return goodsDao.update(goods);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#getGoodByGoodsId
     * @see com.mycompany.biz.service.GoodsService#getGoodByGoodsId
     */
    @Override
    public Goods getGoodByGoodsId(String goodsId) {
        return goodsDao.getGoodByGoodsId(goodsId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#getGoodsByGoodsIds
     * @see com.mycompany.biz.service.GoodsService#getGoodsByGoodsIds
     */
    @Override
    public List<Goods> getGoodsByGoodsIds(java.util.List<String> goodsIds) {
        return goodsDao.getGoodsByGoodsIds(goodsIds);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#deleteByGoodsIds
     * @see com.mycompany.biz.service.GoodsService#deleteByGoodsIds
     */
    @Override
    public java.util.List<String> deleteByGoodsIds(java.util.List<String> goodsIds) {
        return goodsDao.deleteByGoodsIds(goodsIds);
    }

    /*** 保存goods,有id时更新，没有id时插入,并带回新的id，返回 goods*/
    @Override
    public Goods saveGoods(Goods goods) {
        if (goods != null) {
            java.lang.String goodsId = goods.getGoodsId();
            if (StringUtil.isBlank(goodsId)) {
                insert(goods);
            } else {
                update(goods);
            }
        }
        return goods;
    }

    /*** 批量保存goodss,有id时更新，没有id时插入,并带回新的id，返回 goodss*/
    @Override
    public List<Goods> saveGoodss(List<Goods> goodss) {
        for (Goods goods : goodss) {
            this.saveGoods(goods);
        }
        return goodss;
    }

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#getGoodsIds
     * @see com.mycompany.biz.service.GoodsService#getGoodsIds
     */
    @Override
    public List<String> getGoodsIds() {
        return goodsDao.getGoodsIds();
    }

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#getPageList
     * @see com.mycompany.biz.service.GoodsService#getPageList
     */
    @Override
    public PageList<Goods> getPageList(Goods goods, int pageSize, int pageNum) {
        return goodsDao.getPageList(goods, pageSize, pageNum);
    }

    @Override
    public <D> void assignBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod, BiConsumer<D, Goods> destSetMethod) {
        ServiceUtil.interalAssignBeanTo(dests, destGetMethod, destSetMethod, this, GoodsServiceImpl::getGoodsByGoodsIds, Goods::getGoodsId);
    }

    @Override
    public <D, G> void assignBeansTo(Collection<D> dests, Function<? super D, G> destGetMethod, BiConsumer<D, List<Goods>> destSetMethod, BiConsumer<Goods, List<G>> resultSetQueryIdsFun, Function<? super Goods, G> resultGetGoupIdFun) {
        ServiceUtil.interalAssignBeansTo(dests, destGetMethod, destSetMethod, this, new Goods(), resultSetQueryIdsFun, resultGetGoupIdFun, 100);
    }

    @Override
    public <D> void mergeBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod) {
        ServiceUtil.interalMergeBeanTo(dests, destGetMethod, this, GoodsServiceImpl::getGoodsByGoodsIds, Goods::getGoodsId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#getGoodsByGoodsId
     * @see com.mycompany.biz.service.GoodsService#getGoodsByGoodsId
     */
    @Override
    public Goods getGoodsByGoodsId(String goodsId) {
        return goodsDao.getGoodsByGoodsId(goodsId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.GoodsDao#getGoodssByGoodsIds
     * @see com.mycompany.biz.service.GoodsService#getGoodssByGoodsIds
     */
    @Override
    public List<Goods> getGoodssByGoodsIds(java.util.List<String> goodsIds) {
        return goodsDao.getGoodssByGoodsIds(goodsIds);
    }
}
