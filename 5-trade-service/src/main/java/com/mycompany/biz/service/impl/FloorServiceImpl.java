/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.service.impl;

import java.util.List;

import java.util.List;
import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Function;

import javax.annotation.Resource;



import org.stategen.framework.lite.PageList;

import org.stategen.framework.util.ServiceUtil;
import org.stategen.framework.util.StringUtil;

import com.mycompany.biz.domain.Floor;
import com.mycompany.biz.service.FloorService;
import com.mycompany.biz.dao.FloorDao;

/**
 * FloorServiceImpl
 * <pre>
 * database table: floor
 * database table comments: Floor
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public class FloorServiceImpl  implements FloorService {

    @Resource(name="floorDao")
    FloorDao floorDao;

    /**
     * 
     * @see com.mycompany.biz.dao.FloorDao#insert
     * @see com.mycompany.biz.service.FloorService#insert
     */
    @Override
    public Floor insert(Floor floor) {
        return floorDao.insert(floor);
    }
    
    /**
     * 
     * @see com.mycompany.biz.dao.FloorDao#delete
     * @see com.mycompany.biz.service.FloorService#delete
     */
    @Override
    public String delete(String floorId) {
        return floorDao.delete(floorId);
    }
    
    /**
     * 
     * @see com.mycompany.biz.dao.FloorDao#update
     * @see com.mycompany.biz.service.FloorService#update
     */
    @Override
    public Floor update(Floor floor) {
        return floorDao.update(floor);
    }
    
    /**
     * 
     * @see com.mycompany.biz.dao.FloorDao#getFloorByFloorId
     * @see com.mycompany.biz.service.FloorService#getFloorByFloorId
     */
    @Override
    public Floor getFloorByFloorId(String floorId) {
        return floorDao.getFloorByFloorId(floorId);
    }
    
    /**
     * 
     * @see com.mycompany.biz.dao.FloorDao#getPageList
     * @see com.mycompany.biz.service.FloorService#getPageList
     */
    @Override
    public PageList<Floor> getPageList(Floor floor, int pageSize, int pageNum) {
        return floorDao.getPageList(floor, pageSize, pageNum);
    }
    
    /**
     * 
     * @see com.mycompany.biz.dao.FloorDao#getFloorsByFloorIds
     * @see com.mycompany.biz.service.FloorService#getFloorsByFloorIds
     */
    @Override
    public List<Floor> getFloorsByFloorIds(java.util.List<String> floorIds) {
        return floorDao.getFloorsByFloorIds(floorIds);
    }
    
    /**
     * 
     * @see com.mycompany.biz.dao.FloorDao#deleteByFloorIds
     * @see com.mycompany.biz.service.FloorService#deleteByFloorIds
     */
    @Override
    public java.util.List<String> deleteByFloorIds(java.util.List<String> floorIds) {
        return floorDao.deleteByFloorIds(floorIds);
    }
    

    /*** 保存floor,有id时更新，没有id时插入,并带回新的id，返回 floor*/
    @Override
    public Floor saveFloor(Floor floor){
        if (floor != null) {
            java.lang.String floorId = floor.getFloorId();
            if (StringUtil.isBlank(floorId)) {
                insert(floor);
            } else {
                update(floor);
            }
        }
        return floor;
    }

    /*** 批量保存floors,有id时更新，没有id时插入,并带回新的id，返回 floors*/
    @Override
    public List<Floor> saveFloors(List<Floor> floors) {
        for (Floor floor : floors) {
            this.saveFloor(floor);
        }
        return floors;
    }

    @Override
    public <D> void assignBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod, BiConsumer<D, Floor> destSetMethod) {
        ServiceUtil.interalAssignBeanTo(dests, destGetMethod, destSetMethod, this, FloorServiceImpl::getFloorsByFloorIds, Floor::getFloorId);
    }

    @Override
    public <D, G> void assignBeansTo(Collection<D> dests,Function<? super D, G> destGetMethod,BiConsumer<D, List<Floor>> destSetMethod, BiConsumer<Floor,List<G>> resultSetQueryIdsFun, Function<? super Floor, G> resultGetGoupIdFun) {
        ServiceUtil.interalAssignBeansTo(dests, destGetMethod, destSetMethod, this, new Floor(), resultSetQueryIdsFun, resultGetGoupIdFun, 100);
    }

    @Override
    public <D> void mergeBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod) {
        ServiceUtil.interalMergeBeanTo(dests, destGetMethod, this, FloorServiceImpl::getFloorsByFloorIds, Floor::getFloorId);
    }

}