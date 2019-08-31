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

import com.mycompany.biz.dao.SlideDao;
import com.mycompany.biz.domain.Slide;
import com.mycompany.biz.service.SlideService;

/**
 * SlideServiceImpl
 * <pre>
 * database table: slide
 * database table comments: Slide
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public class SlideServiceImpl implements SlideService {

    @Resource(name = "slideDao")
    SlideDao slideDao;

    /**
     * 
     * @see com.mycompany.biz.dao.SlideDao#insert
     * @see com.mycompany.biz.service.SlideService#insert
     */
    @Override
    public Slide insert(Slide slide) {
        return slideDao.insert(slide);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.SlideDao#delete
     * @see com.mycompany.biz.service.SlideService#delete
     */
    @Override
    public String delete(String slideId) {
        return slideDao.delete(slideId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.SlideDao#update
     * @see com.mycompany.biz.service.SlideService#update
     */
    @Override
    public Slide update(Slide slide) {
        return slideDao.update(slide);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.SlideDao#getSlideBySlideId
     * @see com.mycompany.biz.service.SlideService#getSlideBySlideId
     */
    @Override
    public Slide getSlideBySlideId(String slideId) {
        return slideDao.getSlideBySlideId(slideId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.SlideDao#getSlidesBySlideIds
     * @see com.mycompany.biz.service.SlideService#getSlidesBySlideIds
     */
    @Override
    public List<Slide> getSlidesBySlideIds(java.util.List<String> slideIds) {
        return slideDao.getSlidesBySlideIds(slideIds);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.SlideDao#deleteBySlideIds
     * @see com.mycompany.biz.service.SlideService#deleteBySlideIds
     */
    @Override
    public java.util.List<String> deleteBySlideIds(java.util.List<String> slideIds) {
        return slideDao.deleteBySlideIds(slideIds);
    }

    /*** 保存slide,有id时更新，没有id时插入,并带回新的id，返回 slide*/
    @Override
    public Slide saveSlide(Slide slide) {
        if (slide != null) {
            java.lang.String slideId = slide.getSlideId();
            if (StringUtil.isBlank(slideId)) {
                insert(slide);
            } else {
                update(slide);
            }
        }
        return slide;
    }

    /*** 批量保存slides,有id时更新，没有id时插入,并带回新的id，返回 slides*/
    @Override
    public List<Slide> saveSlides(List<Slide> slides) {
        for (Slide slide : slides) {
            this.saveSlide(slide);
        }
        return slides;
    }

    /**
     * 
     * @see com.mycompany.biz.dao.SlideDao#getPageList
     * @see com.mycompany.biz.service.SlideService#getPageList
     */
    @Override
    public PageList<Slide> getPageList(Slide slide, int pageSize, int pageNum) {
        return slideDao.getPageList(slide, pageSize, pageNum);
    }

    @Override
    public <D> void assignBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod, BiConsumer<D, Slide> destSetMethod) {
        ServiceUtil.interalAssignBeanTo(dests, destGetMethod, destSetMethod, this, SlideServiceImpl::getSlidesBySlideIds, Slide::getSlideId);
    }

    @Override
    public <D, G> void assignBeansTo(Collection<D> dests, Function<? super D, G> destGetMethod, BiConsumer<D, List<Slide>> destSetMethod, BiConsumer<Slide, List<G>> resultSetQueryIdsFun, Function<? super Slide, G> resultGetGoupIdFun) {
        ServiceUtil.interalAssignBeansTo(dests, destGetMethod, destSetMethod, this, new Slide(), resultSetQueryIdsFun, resultGetGoupIdFun, 100);
    }

    @Override
    public <D> void mergeBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod) {
        ServiceUtil.interalMergeBeanTo(dests, destGetMethod, this, SlideServiceImpl::getSlidesBySlideIds, Slide::getSlideId);
    }
}
