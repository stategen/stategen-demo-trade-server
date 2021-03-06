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

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.mycompany.biz.dao.UserHoppyDao;
import com.mycompany.biz.domain.UserHoppy;
import com.mycompany.biz.service.UserHoppyService;

/**
 * UserHoppyServiceImpl
 * <pre>
 * database table: user_hoppy
 * database table comments: UserHoppy
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public class UserHoppyServiceImpl implements UserHoppyService, IdGenerateService<Long> {

    @Resource
    private IIdGenerator idGenerator;

    //<#--
    @Resource(name = "userHoppyDao")
    UserHoppyDao userHoppyDao;

    /**
     * 
     * @see com.mycompany.biz.dao.UserHoppyDao#insert
     * @see com.mycompany.biz.service.UserHoppyService#insert
     */
    @Override
    @SentinelResource
    public UserHoppy insert(UserHoppy userHoppy) {
        return userHoppyDao.insert(userHoppy, this);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.UserHoppyDao#delete
     * @see com.mycompany.biz.service.UserHoppyService#delete
     */
    @Override
    public Long delete(Long id) {
        return userHoppyDao.delete(id);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.UserHoppyDao#update
     * @see com.mycompany.biz.service.UserHoppyService#update
     */
    @Override
    public UserHoppy update(UserHoppy userHoppy) {
        return userHoppyDao.update(userHoppy);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.UserHoppyDao#getUserHoppyById
     * @see com.mycompany.biz.service.UserHoppyService#getUserHoppyById
     */
    @Override
    public UserHoppy getUserHoppyById(Long id) {
        return userHoppyDao.getUserHoppyById(id);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.UserHoppyDao#getUserHoppysByIds
     * @see com.mycompany.biz.service.UserHoppyService#getUserHoppysByIds
     */
    @Override
    public List<UserHoppy> getUserHoppysByIds(java.util.List<Long> ids) {
        return userHoppyDao.getUserHoppysByIds(ids);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.UserHoppyDao#getUserHoppysByUserIds
     * @see com.mycompany.biz.service.UserHoppyService#getUserHoppysByUserIds
     */
    @Override
    public List<UserHoppy> getUserHoppysByUserIds(java.util.List<String> userIds) {
        return userHoppyDao.getUserHoppysByUserIds(userIds);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.UserHoppyDao#deleteByIds
     * @see com.mycompany.biz.service.UserHoppyService#deleteByIds
     */
    @Override
    public java.util.List<Long> deleteByIds(java.util.List<Long> ids) {
        return userHoppyDao.deleteByIds(ids);
    }

    /*** 保存userHoppy,有id时更新，没有id时插入,并带回新的id，返回 userHoppy*/
    @Override
    public UserHoppy saveUserHoppy(UserHoppy userHoppy) {
        if (userHoppy != null) {
            java.lang.Long id = userHoppy.getId();
            if (id != null) {
                insert(userHoppy);
            } else {
                update(userHoppy);
            }
        }
        return userHoppy;
    }

    /*** 批量保存userHoppys,有id时更新，没有id时插入,并带回新的id，返回 userHoppys*/
    @Override
    public List<UserHoppy> saveUserHoppys(List<UserHoppy> userHoppys) {
        for (UserHoppy userHoppy : userHoppys) {
            this.saveUserHoppy(userHoppy);
        }
        return userHoppys;
    }

    /**
     * 
     * @see com.mycompany.biz.dao.UserHoppyDao#getPageList
     * @see com.mycompany.biz.service.UserHoppyService#getPageList
     */
    @Override
    public PageList<UserHoppy> getPageList(UserHoppy userHoppy, int pageSize, int pageNum) {
        return userHoppyDao.getPageList(userHoppy, pageSize, pageNum);
    }

    //-->
    //
    @Override
    public <D> void assignBeanTo(Collection<D> dests, Function<? super D, Long> destGetMethod, BiConsumer<D, UserHoppy> destSetMethod) {
        ServiceUtil.interalAssignBeanTo(dests, destGetMethod, destSetMethod, this, UserHoppyServiceImpl::getUserHoppysByIds, UserHoppy::getId);
    }

    @Override
    public <D, G> void assignBeansTo(Collection<D> dests, Function<? super D, G> destGetMethod, BiConsumer<D, List<UserHoppy>> destSetMethod, BiConsumer<UserHoppy, List<G>> resultSetQueryIdsFun, Function<? super UserHoppy, G> resultGetGoupIdFun) {
        ServiceUtil.interalAssignBeansTo(dests, destGetMethod, destSetMethod, this, new UserHoppy(), resultSetQueryIdsFun, resultGetGoupIdFun, 100);
    }

    @Override
    public <D> void mergeBeanTo(Collection<D> dests, Function<? super D, Long> destGetMethod) {
        ServiceUtil.interalMergeBeanTo(dests, destGetMethod, this, UserHoppyServiceImpl::getUserHoppysByIds, UserHoppy::getId);
    }

    @Override
    public <T> Long generateId() {
        return this.idGenerator.generateId(Long.class, UserHoppy.class);
    }
}
