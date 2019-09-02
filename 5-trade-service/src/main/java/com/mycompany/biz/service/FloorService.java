/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */package com.mycompany.biz.service;

import java.util.List;

import com.mycompany.biz.domain.Floor;

import org.stategen.framework.lite.PageList;
import org.stategen.framework.util.AssignService;
import org.stategen.framework.util.BaseService;

/**
 * FloorService
 * <pre>
 * database table: floor
 * database table comments: Floor
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public interface FloorService extends FloorServiceTrade, AssignService<Floor, String>, BaseService<Floor> {

    /**
     * 
     * @see com.mycompany.biz.dao.FloorDao#insert
     */
    public Floor insert(Floor floor);

    /**
     * 
     * @see com.mycompany.biz.dao.FloorDao#delete
     */
    public String delete(String floorId);

    /**
     * 
     * @see com.mycompany.biz.dao.FloorDao#update
     */
    public Floor update(Floor floor);

    /**
     * 
     * @see com.mycompany.biz.dao.FloorDao#getFloorByFloorId
     */
    public Floor getFloorByFloorId(String floorId);

    /**
     * 
     * @see com.mycompany.biz.dao.FloorDao#getPageList
     */
    public PageList<Floor> getPageList(Floor floor, int pageSize, int pageNum);

    /**
     * 
     * @see com.mycompany.biz.dao.FloorDao#getFloorsByFloorIds
     */
    public List<Floor> getFloorsByFloorIds(java.util.List<String> floorIds);

    /**
     * 
     * @see com.mycompany.biz.dao.FloorDao#deleteByFloorIds
     */
    public java.util.List<String> deleteByFloorIds(java.util.List<String> floorIds);


    /*** 保存floor,有id时更新，没有id时插入,并带回新的id，返回 floor
     * @see com.mycompany.biz.dao.FloorDao#insert
     */
    public Floor saveFloor(Floor floor);

    /** 批量保存floors,有id时更新，没有id时插入,并带回新的id，返回 floors
     * @see com.mycompany.biz.dao.FloorDao#insert
     */
    public List<Floor> saveFloors(List<Floor> floors);
}



