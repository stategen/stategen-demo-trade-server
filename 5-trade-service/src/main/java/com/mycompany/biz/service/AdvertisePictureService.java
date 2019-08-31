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

import com.mycompany.biz.domain.AdvertisePicture;

/**
 * AdvertisePictureService
 * <pre>
 * database table: advertise_picture
 * database table comments: AdvertisePicture
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public interface AdvertisePictureService extends AdvertisePictureServiceTrade, AssignService<AdvertisePicture, Long>, BaseService<AdvertisePicture> {

    /**
     * 
     * @see com.mycompany.biz.dao.AdvertisePictureDao#insert
     */
    public AdvertisePicture insert(AdvertisePicture advertisePicture);

    /**
     * 
     * @see com.mycompany.biz.dao.AdvertisePictureDao#delete
     */
    public Long delete(Long advertiseId);

    /**
     * 
     * @see com.mycompany.biz.dao.AdvertisePictureDao#update
     */
    public AdvertisePicture update(AdvertisePicture advertisePicture);

    /**
     * 
     * @see com.mycompany.biz.dao.AdvertisePictureDao#getAdvertisePictureByAdvertiseId
     */
    public AdvertisePicture getAdvertisePictureByAdvertiseId(Long advertiseId);

    /**
     * 
     * @see com.mycompany.biz.dao.AdvertisePictureDao#getPageList
     */
    public PageList<AdvertisePicture> getPageList(AdvertisePicture advertisePicture, int pageSize, int pageNum);

    /**
     * 
     * @see com.mycompany.biz.dao.AdvertisePictureDao#getAdvertisePicturesByAdvertiseIds
     */
    public List<AdvertisePicture> getAdvertisePicturesByAdvertiseIds(java.util.List<Long> advertiseIds);

    /**
     * 
     * @see com.mycompany.biz.dao.AdvertisePictureDao#deleteByAdvertiseIds
     */
    public java.util.List<Long> deleteByAdvertiseIds(java.util.List<Long> advertiseIds);

    /*** 保存advertisePicture,有id时更新，没有id时插入,并带回新的id，返回 advertisePicture
     * @see com.mycompany.biz.dao.AdvertisePictureDao#insert
     */
    public AdvertisePicture saveAdvertisePicture(AdvertisePicture advertisePicture);

    /** 批量保存advertisePictures,有id时更新，没有id时插入,并带回新的id，返回 advertisePictures
     * @see com.mycompany.biz.dao.AdvertisePictureDao#insert
     */
    public List<AdvertisePicture> saveAdvertisePictures(List<AdvertisePicture> advertisePictures);
}
