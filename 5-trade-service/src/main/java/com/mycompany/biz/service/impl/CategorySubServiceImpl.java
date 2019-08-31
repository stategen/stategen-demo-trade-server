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

import com.mycompany.biz.dao.CategorySubDao;
import com.mycompany.biz.domain.CategorySub;
import com.mycompany.biz.service.CategorySubService;

/**
 * CategorySubServiceImpl
 * <pre>
 * database table: category_sub
 * database table comments: CategorySub
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public class CategorySubServiceImpl implements CategorySubService {

    @Resource(name = "categorySubDao")
    CategorySubDao categorySubDao;

    /**
     * 
     * @see com.mycompany.biz.dao.CategorySubDao#insert
     * @see com.mycompany.biz.service.CategorySubService#insert
     */
    @Override
    public CategorySub insert(CategorySub categorySub) {
        return categorySubDao.insert(categorySub);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.CategorySubDao#delete
     * @see com.mycompany.biz.service.CategorySubService#delete
     */
    @Override
    public String delete(String mallSubId) {
        return categorySubDao.delete(mallSubId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.CategorySubDao#update
     * @see com.mycompany.biz.service.CategorySubService#update
     */
    @Override
    public CategorySub update(CategorySub categorySub) {
        return categorySubDao.update(categorySub);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.CategorySubDao#getCategorySubByMallSubId
     * @see com.mycompany.biz.service.CategorySubService#getCategorySubByMallSubId
     */
    @Override
    public CategorySub getCategorySubByMallSubId(String mallSubId) {
        return categorySubDao.getCategorySubByMallSubId(mallSubId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.CategorySubDao#getCategorySubsByMallSubIds
     * @see com.mycompany.biz.service.CategorySubService#getCategorySubsByMallSubIds
     */
    @Override
    public List<CategorySub> getCategorySubsByMallSubIds(java.util.List<String> mallSubIds) {
        return categorySubDao.getCategorySubsByMallSubIds(mallSubIds);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.CategorySubDao#deleteByMallSubIds
     * @see com.mycompany.biz.service.CategorySubService#deleteByMallSubIds
     */
    @Override
    public java.util.List<String> deleteByMallSubIds(java.util.List<String> mallSubIds) {
        return categorySubDao.deleteByMallSubIds(mallSubIds);
    }

    /*** 保存categorySub,有id时更新，没有id时插入,并带回新的id，返回 categorySub*/
    @Override
    public CategorySub saveCategorySub(CategorySub categorySub) {
        if (categorySub != null) {
            java.lang.String mallSubId = categorySub.getMallSubId();
            if (StringUtil.isBlank(mallSubId)) {
                insert(categorySub);
            } else {
                update(categorySub);
            }
        }
        return categorySub;
    }

    /*** 批量保存categorySubs,有id时更新，没有id时插入,并带回新的id，返回 categorySubs*/
    @Override
    public List<CategorySub> saveCategorySubs(List<CategorySub> categorySubs) {
        for (CategorySub categorySub : categorySubs) {
            this.saveCategorySub(categorySub);
        }
        return categorySubs;
    }

    /**
     * 
     * @see com.mycompany.biz.dao.CategorySubDao#getPageList
     * @see com.mycompany.biz.service.CategorySubService#getPageList
     */
    @Override
    public PageList<CategorySub> getPageList(CategorySub categorySub, int pageSize, int pageNum) {
        return categorySubDao.getPageList(categorySub, pageSize, pageNum);
    }

    @Override
    public <D> void assignBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod, BiConsumer<D, CategorySub> destSetMethod) {
        ServiceUtil.interalAssignBeanTo(dests, destGetMethod, destSetMethod, this, CategorySubServiceImpl::getCategorySubsByMallSubIds, CategorySub::getMallSubId);
    }

    @Override
    public <D, G> void assignBeansTo(Collection<D> dests, Function<? super D, G> destGetMethod, BiConsumer<D, List<CategorySub>> destSetMethod, BiConsumer<CategorySub, List<G>> resultSetQueryIdsFun, Function<? super CategorySub, G> resultGetGoupIdFun) {
        ServiceUtil.interalAssignBeansTo(dests, destGetMethod, destSetMethod, this, new CategorySub(), resultSetQueryIdsFun, resultGetGoupIdFun, 100);
    }

    @Override
    public <D> void mergeBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod) {
        ServiceUtil.interalMergeBeanTo(dests, destGetMethod, this, CategorySubServiceImpl::getCategorySubsByMallSubIds, CategorySub::getMallSubId);
    }
}