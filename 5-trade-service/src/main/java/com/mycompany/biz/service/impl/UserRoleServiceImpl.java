/*
 * Copyright (c) 2016 - 2116 All Rights Reserved.
 * Powered By [rapid-generator]
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

import com.mycompany.biz.dao.UserRoleDao;
import com.mycompany.biz.domain.UserRole;
import com.mycompany.biz.service.UserRoleService;

/**
 * UserRoleServiceImpl
 * <pre>
 * database table: user_role
 * database table comments: UserRole
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public class UserRoleServiceImpl implements UserRoleService, IdGenerateService<Long> {

    @Resource
    private IIdGenerator idGenerator;

    //<#--
    @Resource(name = "userRoleDao")
    UserRoleDao userRoleDao;

    /**
     * 
     * @see com.mycompany.biz.dao.UserRoleDao#insert
     * @see com.mycompany.biz.service.UserRoleService#insert
     */
    @Override
    public UserRole insert(UserRole userRole) {
        return userRoleDao.insert(userRole, this);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.UserRoleDao#update
     * @see com.mycompany.biz.service.UserRoleService#update
     */
    @Override
    public UserRole update(UserRole userRole) {
        return userRoleDao.update(userRole);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.UserRoleDao#getUserRoleById
     * @see com.mycompany.biz.service.UserRoleService#getUserRoleById
     */
    @Override
    public UserRole getUserRoleById(Long id) {
        return userRoleDao.getUserRoleById(id);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.UserRoleDao#getUserRolesByIds
     * @see com.mycompany.biz.service.UserRoleService#getUserRolesByIds
     */
    @Override
    public List<UserRole> getUserRolesByIds(java.util.List<Long> ids) {
        return userRoleDao.getUserRolesByIds(ids);
    }

    /*** 保存userRole,有id时更新，没有id时插入,并带回新的id，返回 userRole*/
    @Override
    public UserRole saveUserRole(UserRole userRole) {
        if (userRole != null) {
            java.lang.Long id = userRole.getId();
            if (id != null) {
                insert(userRole);
            } else {
                update(userRole);
            }
        }
        return userRole;
    }

    /*** 批量保存userRoles,有id时更新，没有id时插入,并带回新的id，返回 userRoles*/
    @Override
    public List<UserRole> saveUserRoles(List<UserRole> userRoles) {
        for (UserRole userRole : userRoles) {
            this.saveUserRole(userRole);
        }
        return userRoles;
    }

    /**
     * 
     * @see com.mycompany.biz.dao.UserRoleDao#delete
     * @see com.mycompany.biz.service.UserRoleService#delete
     */
    @Override
    public Long delete(Long id) {
        return userRoleDao.delete(id);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.UserRoleDao#deleteByIds
     * @see com.mycompany.biz.service.UserRoleService#deleteByIds
     */
    @Override
    public List<Long> deleteByIds(java.util.List<Long> ids) {
        return userRoleDao.deleteByIds(ids);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.UserRoleDao#getPageList
     * @see com.mycompany.biz.service.UserRoleService#getPageList
     */
    @Override
    public PageList<UserRole> getPageList(UserRole userRole, int pageSize, int pageNum) {
        return userRoleDao.getPageList(userRole, pageSize, pageNum);
    }

    //-->
    //
    @Override
    public <D> void assignBeanTo(Collection<D> dests, Function<? super D, Long> destGetMethod, BiConsumer<D, UserRole> destSetMethod) {
        ServiceUtil.interalAssignBeanTo(dests, destGetMethod, destSetMethod, this, UserRoleServiceImpl::getUserRolesByIds, UserRole::getId);
    }

    @Override
    public <D, G> void assignBeansTo(Collection<D> dests, Function<? super D, G> destGetMethod, BiConsumer<D, List<UserRole>> destSetMethod, BiConsumer<UserRole, List<G>> resultSetQueryIdsFun, Function<? super UserRole, G> resultGetGoupIdFun) {
        ServiceUtil.interalAssignBeansTo(dests, destGetMethod, destSetMethod, this, new UserRole(), resultSetQueryIdsFun, resultGetGoupIdFun, 100);
    }

    @Override
    public <D> void mergeBeanTo(Collection<D> dests, Function<? super D, Long> destGetMethod) {
        ServiceUtil.interalMergeBeanTo(dests, destGetMethod, this, UserRoleServiceImpl::getUserRolesByIds, UserRole::getId);
    }

    @Override
    public <T> Long generateId() {
        return this.idGenerator.generateId(Long.class, UserRole.class);
    }
}
