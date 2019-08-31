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

import com.mycompany.biz.dao.AdvertisePictureDao;
import com.mycompany.biz.domain.AdvertisePicture;
import com.mycompany.biz.service.AdvertisePictureService;

/**
 * AdvertisePictureServiceImpl
 * <pre>
 * database table: advertise_picture
 * database table comments: AdvertisePicture
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public class AdvertisePictureServiceImpl implements AdvertisePictureService {

    @Resource(name = "advertisePictureDao")
    AdvertisePictureDao advertisePictureDao;

    /**
     * 
     * @see com.mycompany.biz.dao.AdvertisePictureDao#insert
     * @see com.mycompany.biz.service.AdvertisePictureService#insert
     */
    @Override
    public AdvertisePicture insert(AdvertisePicture advertisePicture) {
        return advertisePictureDao.insert(advertisePicture);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.AdvertisePictureDao#delete
     * @see com.mycompany.biz.service.AdvertisePictureService#delete
     */
    @Override
    public Long delete(Long advertiseId) {
        return advertisePictureDao.delete(advertiseId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.AdvertisePictureDao#update
     * @see com.mycompany.biz.service.AdvertisePictureService#update
     */
    @Override
    public AdvertisePicture update(AdvertisePicture advertisePicture) {
        return advertisePictureDao.update(advertisePicture);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.AdvertisePictureDao#getAdvertisePictureByAdvertiseId
     * @see com.mycompany.biz.service.AdvertisePictureService#getAdvertisePictureByAdvertiseId
     */
    @Override
    public AdvertisePicture getAdvertisePictureByAdvertiseId(Long advertiseId) {
        return advertisePictureDao.getAdvertisePictureByAdvertiseId(advertiseId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.AdvertisePictureDao#getPageList
     * @see com.mycompany.biz.service.AdvertisePictureService#getPageList
     */
    @Override
    public PageList<AdvertisePicture> getPageList(AdvertisePicture advertisePicture, int pageSize, int pageNum) {
        return advertisePictureDao.getPageList(advertisePicture, pageSize, pageNum);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.AdvertisePictureDao#getAdvertisePicturesByAdvertiseIds
     * @see com.mycompany.biz.service.AdvertisePictureService#getAdvertisePicturesByAdvertiseIds
     */
    @Override
    public List<AdvertisePicture> getAdvertisePicturesByAdvertiseIds(java.util.List<Long> advertiseIds) {
        return advertisePictureDao.getAdvertisePicturesByAdvertiseIds(advertiseIds);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.AdvertisePictureDao#deleteByAdvertiseIds
     * @see com.mycompany.biz.service.AdvertisePictureService#deleteByAdvertiseIds
     */
    @Override
    public java.util.List<Long> deleteByAdvertiseIds(java.util.List<Long> advertiseIds) {
        return advertisePictureDao.deleteByAdvertiseIds(advertiseIds);
    }

    /*** 保存advertisePicture,有id时更新，没有id时插入,并带回新的id，返回 advertisePicture*/
    @Override
    public AdvertisePicture saveAdvertisePicture(AdvertisePicture advertisePicture) {
        if (advertisePicture != null) {
            java.lang.Long advertiseId = advertisePicture.getAdvertiseId();
            if (advertiseId != null) {
                insert(advertisePicture);
            } else {
                update(advertisePicture);
            }
        }
        return advertisePicture;
    }

    /*** 批量保存advertisePictures,有id时更新，没有id时插入,并带回新的id，返回 advertisePictures*/
    @Override
    public List<AdvertisePicture> saveAdvertisePictures(List<AdvertisePicture> advertisePictures) {
        for (AdvertisePicture advertisePicture : advertisePictures) {
            this.saveAdvertisePicture(advertisePicture);
        }
        return advertisePictures;
    }

    @Override
    public <D> void assignBeanTo(Collection<D> dests, Function<? super D, Long> destGetMethod, BiConsumer<D, AdvertisePicture> destSetMethod) {
        ServiceUtil.interalAssignBeanTo(dests, destGetMethod, destSetMethod, this, AdvertisePictureServiceImpl::getAdvertisePicturesByAdvertiseIds, AdvertisePicture::getAdvertiseId);
    }

    @Override
    public <D, G> void assignBeansTo(Collection<D> dests, Function<? super D, G> destGetMethod, BiConsumer<D, List<AdvertisePicture>> destSetMethod, BiConsumer<AdvertisePicture, List<G>> resultSetQueryIdsFun, Function<? super AdvertisePicture, G> resultGetGoupIdFun) {
        ServiceUtil.interalAssignBeansTo(dests, destGetMethod, destSetMethod, this, new AdvertisePicture(), resultSetQueryIdsFun, resultGetGoupIdFun, 100);
    }

    @Override
    public <D> void mergeBeanTo(Collection<D> dests, Function<? super D, Long> destGetMethod) {
        ServiceUtil.interalMergeBeanTo(dests, destGetMethod, this, AdvertisePictureServiceImpl::getAdvertisePicturesByAdvertiseIds, AdvertisePicture::getAdvertiseId);
    }
}
