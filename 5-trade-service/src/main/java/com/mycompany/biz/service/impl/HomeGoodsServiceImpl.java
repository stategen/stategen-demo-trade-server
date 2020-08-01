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

import org.stategen.framework.lite.IIdGenerator;
import org.stategen.framework.lite.IdGenerateService;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.util.ServiceUtil;
import org.stategen.framework.util.StringUtil;

import com.mycompany.biz.dao.HomeGoodsDao;
import com.mycompany.biz.domain.HomeGoods;
import com.mycompany.biz.service.HomeGoodsService;

/**
 * HomeGoodsServiceImpl
 * <pre>
 * database table: home_goods
 * database table comments: HomeGoods
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public class HomeGoodsServiceImpl implements HomeGoodsService, IdGenerateService<String> {

    @Resource
    private IIdGenerator idGenerator;

    @Resource(name = "homeGoodsDao")
    HomeGoodsDao homeGoodsDao;

    /**
     * 
     * @see com.mycompany.biz.dao.HomeGoodsDao#insert
     * @see com.mycompany.biz.service.HomeGoodsService#insert
     */
    @Override
    public HomeGoods insert(HomeGoods homeGoods) {
        return homeGoodsDao.insert(homeGoods, this);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.HomeGoodsDao#delete
     * @see com.mycompany.biz.service.HomeGoodsService#delete
     */
    @Override
    public String delete(String recommendId) {
        return homeGoodsDao.delete(recommendId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.HomeGoodsDao#update
     * @see com.mycompany.biz.service.HomeGoodsService#update
     */
    @Override
    public HomeGoods update(HomeGoods homeGoods) {
        return homeGoodsDao.update(homeGoods);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.HomeGoodsDao#getHomeGoodsByRecommendId
     * @see com.mycompany.biz.service.HomeGoodsService#getHomeGoodsByRecommendId
     */
    @Override
    public HomeGoods getHomeGoodsByRecommendId(String recommendId) {
        return homeGoodsDao.getHomeGoodsByRecommendId(recommendId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.HomeGoodsDao#getPageList
     * @see com.mycompany.biz.service.HomeGoodsService#getPageList
     */
    @Override
    public PageList<HomeGoods> getPageList(HomeGoods homeGoods, int pageSize, int pageNum) {
        return homeGoodsDao.getPageList(homeGoods, pageSize, pageNum);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.HomeGoodsDao#getHomeGoodssByRecommendIds
     * @see com.mycompany.biz.service.HomeGoodsService#getHomeGoodssByRecommendIds
     */
    @Override
    public List<HomeGoods> getHomeGoodssByRecommendIds(java.util.List<String> recommendIds) {
        return homeGoodsDao.getHomeGoodssByRecommendIds(recommendIds);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.HomeGoodsDao#deleteByRecommendIds
     * @see com.mycompany.biz.service.HomeGoodsService#deleteByRecommendIds
     */
    @Override
    public java.util.List<String> deleteByRecommendIds(java.util.List<String> recommendIds) {
        return homeGoodsDao.deleteByRecommendIds(recommendIds);
    }

    /*** 保存homeGoods,有id时更新，没有id时插入,并带回新的id，返回 homeGoods*/
    @Override
    public HomeGoods saveHomeGoods(HomeGoods homeGoods) {
        if (homeGoods != null) {
            java.lang.String recommendId = homeGoods.getRecommendId();
            if (StringUtil.isBlank(recommendId)) {
                insert(homeGoods);
            } else {
                update(homeGoods);
            }
        }
        return homeGoods;
    }

    /*** 批量保存homeGoodss,有id时更新，没有id时插入,并带回新的id，返回 homeGoodss*/
    @Override
    public List<HomeGoods> saveHomeGoodss(List<HomeGoods> homeGoodss) {
        for (HomeGoods homeGoods : homeGoodss) {
            this.saveHomeGoods(homeGoods);
        }
        return homeGoodss;
    }

    @Override
    public <D> void assignBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod, BiConsumer<D, HomeGoods> destSetMethod) {
        ServiceUtil.interalAssignBeanTo(dests, destGetMethod, destSetMethod, this, HomeGoodsServiceImpl::getHomeGoodssByRecommendIds, HomeGoods::getRecommendId);
    }

    @Override
    public <D, G> void assignBeansTo(Collection<D> dests, Function<? super D, G> destGetMethod, BiConsumer<D, List<HomeGoods>> destSetMethod, BiConsumer<HomeGoods, List<G>> resultSetQueryIdsFun, Function<? super HomeGoods, G> resultGetGoupIdFun) {
        ServiceUtil.interalAssignBeansTo(dests, destGetMethod, destSetMethod, this, new HomeGoods(), resultSetQueryIdsFun, resultGetGoupIdFun, 100);
    }

    @Override
    public <D> void mergeBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod) {
        ServiceUtil.interalMergeBeanTo(dests, destGetMethod, this, HomeGoodsServiceImpl::getHomeGoodssByRecommendIds, HomeGoods::getRecommendId);
    }

    @Override
    public <T> String generateId(Class<T> bizTagClz) {
        return this.idGenerator.generateId(String.class, bizTagClz);
    }
}
