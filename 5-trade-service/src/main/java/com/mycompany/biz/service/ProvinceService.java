/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.service;

import java.util.List;

import org.stategen.framework.lite.PageList;
import org.stategen.framework.util.AssignService;

import com.mycompany.biz.domain.Province;

/**
 * ProvinceService
 * <pre>
 * database table: province
 * database table comments: Province
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public interface ProvinceService extends AssignService<Province, String>, ProvinceServiceTrade {

    //<#--
    /**
     * 
     * @see com.mycompany.biz.dao.ProvinceDao#insert
     */
    public Province insert(Province province);

    /**
     * 
     * @see com.mycompany.biz.dao.ProvinceDao#delete
     */
    public String delete(String provinceId);

    /**
     * 
     * @see com.mycompany.biz.dao.ProvinceDao#update
     */
    public Province update(Province province);

    /**
     * 
     * @see com.mycompany.biz.dao.ProvinceDao#getProvinceByProvinceId
     */
    public Province getProvinceByProvinceId(String provinceId);

    /**
     * 
     * @see com.mycompany.biz.dao.ProvinceDao#getProvincePageList
     */
    public PageList<Province> getProvincePageList(Province province, int pageSize, int pageNum);

    /**
     * 
     * @see com.mycompany.biz.dao.ProvinceDao#getProvincesByProvinceIds
     */
    public List<Province> getProvincesByProvinceIds(java.util.List<String> provinceIds);

    /**
     * 
     * @see com.mycompany.biz.dao.ProvinceDao#deleteByProvinceIds
     */
    public java.util.List<String> deleteByProvinceIds(java.util.List<String> provinceIds);

    /*** 保存province,有id时更新，没有id时插入,并带回新的id，返回 province
     * @see com.mycompany.biz.dao.ProvinceDao#insert
     */
    public Province saveProvince(Province province);

    /** 批量保存provinces,有id时更新，没有id时插入,并带回新的id，返回 provinces
     * @see com.mycompany.biz.dao.ProvinceDao#insert
     */
    public List<Province> saveProvinces(List<Province> provinces);

    /**
     * 
     * @see com.mycompany.biz.dao.ProvinceDao#getProvinceOptions
     */
    public List<Province> getProvinceOptions();
    //-->
    //
}
