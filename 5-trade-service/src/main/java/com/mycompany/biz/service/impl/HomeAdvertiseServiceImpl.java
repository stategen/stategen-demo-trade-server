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
import org.stategen.framework.util.IIDGenerator;
import org.stategen.framework.util.ServiceUtil;
import org.stategen.framework.util.StringUtil;

import com.mycompany.biz.dao.HomeAdvertiseDao;
import com.mycompany.biz.domain.HomeAdvertise;
import com.mycompany.biz.service.HomeAdvertiseService;

/**
 * HomeAdvertiseServiceImpl
 * <pre>
 * database table: home_advertise
 * database table comments: HomeAdvertise
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public class HomeAdvertiseServiceImpl implements HomeAdvertiseService, IIDGenerator<String> {

    @Resource(name = "homeAdvertiseDao")
    HomeAdvertiseDao homeAdvertiseDao;

    /**
     * 
     * @see com.mycompany.biz.dao.HomeAdvertiseDao#insert
     * @see com.mycompany.biz.service.HomeAdvertiseService#insert
     */
    @Override
    public HomeAdvertise insert(HomeAdvertise homeAdvertise) {
        return homeAdvertiseDao.insert(homeAdvertise, this);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.HomeAdvertiseDao#delete
     * @see com.mycompany.biz.service.HomeAdvertiseService#delete
     */
    @Override
    public String delete(String homeAdvId) {
        return homeAdvertiseDao.delete(homeAdvId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.HomeAdvertiseDao#update
     * @see com.mycompany.biz.service.HomeAdvertiseService#update
     */
    @Override
    public HomeAdvertise update(HomeAdvertise homeAdvertise) {
        return homeAdvertiseDao.update(homeAdvertise);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.HomeAdvertiseDao#getHomeAdvertiseByHomeAdvId
     * @see com.mycompany.biz.service.HomeAdvertiseService#getHomeAdvertiseByHomeAdvId
     */
    @Override
    public HomeAdvertise getHomeAdvertiseByHomeAdvId(String homeAdvId) {
        return homeAdvertiseDao.getHomeAdvertiseByHomeAdvId(homeAdvId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.HomeAdvertiseDao#getHomeAdvertisesByHomeAdvIds
     * @see com.mycompany.biz.service.HomeAdvertiseService#getHomeAdvertisesByHomeAdvIds
     */
    @Override
    public List<HomeAdvertise> getHomeAdvertisesByHomeAdvIds(java.util.List<String> homeAdvIds) {
        return homeAdvertiseDao.getHomeAdvertisesByHomeAdvIds(homeAdvIds);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.HomeAdvertiseDao#deleteByHomeAdvIds
     * @see com.mycompany.biz.service.HomeAdvertiseService#deleteByHomeAdvIds
     */
    @Override
    public java.util.List<String> deleteByHomeAdvIds(java.util.List<String> homeAdvIds) {
        return homeAdvertiseDao.deleteByHomeAdvIds(homeAdvIds);
    }

    /*** 保存homeAdvertise,有id时更新，没有id时插入,并带回新的id，返回 homeAdvertise*/
    @Override
    public HomeAdvertise saveHomeAdvertise(HomeAdvertise homeAdvertise) {
        if (homeAdvertise != null) {
            java.lang.String homeAdvId = homeAdvertise.getHomeAdvId();
            if (StringUtil.isBlank(homeAdvId)) {
                insert(homeAdvertise);
            } else {
                update(homeAdvertise);
            }
        }
        return homeAdvertise;
    }

    /*** 批量保存homeAdvertises,有id时更新，没有id时插入,并带回新的id，返回 homeAdvertises*/
    @Override
    public List<HomeAdvertise> saveHomeAdvertises(List<HomeAdvertise> homeAdvertises) {
        for (HomeAdvertise homeAdvertise : homeAdvertises) {
            this.saveHomeAdvertise(homeAdvertise);
        }
        return homeAdvertises;
    }

    /**
     * 
     * @see com.mycompany.biz.dao.HomeAdvertiseDao#getPageList
     * @see com.mycompany.biz.service.HomeAdvertiseService#getPageList
     */
    @Override
    public PageList<HomeAdvertise> getPageList(HomeAdvertise homeAdvertise, int pageSize, int pageNum) {
        return homeAdvertiseDao.getPageList(homeAdvertise, pageSize, pageNum);
    }

    @Override
    public <D> void assignBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod, BiConsumer<D, HomeAdvertise> destSetMethod) {
        ServiceUtil.interalAssignBeanTo(dests, destGetMethod, destSetMethod, this, HomeAdvertiseServiceImpl::getHomeAdvertisesByHomeAdvIds, HomeAdvertise::getHomeAdvId);
    }

    @Override
    public <D, G> void assignBeansTo(Collection<D> dests, Function<? super D, G> destGetMethod, BiConsumer<D, List<HomeAdvertise>> destSetMethod, BiConsumer<HomeAdvertise, List<G>> resultSetQueryIdsFun, Function<? super HomeAdvertise, G> resultGetGoupIdFun) {
        ServiceUtil.interalAssignBeansTo(dests, destGetMethod, destSetMethod, this, new HomeAdvertise(), resultSetQueryIdsFun, resultGetGoupIdFun, 100);
    }

    @Override
    public <D> void mergeBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod) {
        ServiceUtil.interalMergeBeanTo(dests, destGetMethod, this, HomeAdvertiseServiceImpl::getHomeAdvertisesByHomeAdvIds, HomeAdvertise::getHomeAdvId);
    }

    @Override
    public String generateId() {
        //TODO generate id;
        return null;
    }
}
