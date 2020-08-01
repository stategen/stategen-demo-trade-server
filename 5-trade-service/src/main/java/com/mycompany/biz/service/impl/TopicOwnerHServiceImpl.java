/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.stategen.framework.lite.IIdGenerator;
import org.stategen.framework.lite.IdGenerateService;
import org.stategen.framework.lite.PageList;

import com.mycompany.biz.dao.TopicOwnerHDao;
import com.mycompany.biz.domain.TopicOwnerH;
import com.mycompany.biz.service.TopicOwnerHService;

/**
 * TopicOwnerHServiceImpl
 * <pre>
 * database table: demo_topic_owner_h
 * database table comments: 数据水平权限，只有直系上级有权限
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public class TopicOwnerHServiceImpl implements TopicOwnerHService, IdGenerateService<Long> {

    @Resource
    private IIdGenerator idGenerator;

    @Resource(name = "topicOwnerHDao")
    TopicOwnerHDao topicOwnerHDao;

    /**
     * 
     * @see com.mycompany.biz.dao.TopicOwnerHDao#insert
     * @see com.mycompany.biz.service.TopicOwnerHService#insert
     */
    @Override
    public TopicOwnerH insert(TopicOwnerH topicOwnerH) {
        return topicOwnerHDao.insert(topicOwnerH, this);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicOwnerHDao#delete
     * @see com.mycompany.biz.service.TopicOwnerHService#delete
     */
    @Override
    public Long delete(Long id) {
        return topicOwnerHDao.delete(id);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicOwnerHDao#update
     * @see com.mycompany.biz.service.TopicOwnerHService#update
     */
    @Override
    public TopicOwnerH update(TopicOwnerH topicOwnerH) {
        return topicOwnerHDao.update(topicOwnerH);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicOwnerHDao#getTopicOwnerHById
     * @see com.mycompany.biz.service.TopicOwnerHService#getTopicOwnerHById
     */
    @Override
    public TopicOwnerH getTopicOwnerHById(Long id) {
        return topicOwnerHDao.getTopicOwnerHById(id);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicOwnerHDao#getPageList
     * @see com.mycompany.biz.service.TopicOwnerHService#getPageList
     */
    @Override
    public PageList<TopicOwnerH> getPageList(TopicOwnerH topicOwnerH, int pageSize, int pageNum) {
        return topicOwnerHDao.getPageList(topicOwnerH, pageSize, pageNum);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicOwnerHDao#getTopicOwnerHsByIds
     * @see com.mycompany.biz.service.TopicOwnerHService#getTopicOwnerHsByIds
     */
    @Override
    public List<TopicOwnerH> getTopicOwnerHsByIds(java.util.List<Long> ids) {
        return topicOwnerHDao.getTopicOwnerHsByIds(ids);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicOwnerHDao#deleteByIds
     * @see com.mycompany.biz.service.TopicOwnerHService#deleteByIds
     */
    @Override
    public java.util.List<Long> deleteByIds(java.util.List<Long> ids) {
        return topicOwnerHDao.deleteByIds(ids);
    }

    /*** 保存topicOwnerH,有id时更新，没有id时插入,并带回新的id，返回 topicOwnerH*/
    @Override
    public TopicOwnerH saveTopicOwnerH(TopicOwnerH topicOwnerH) {
        if (topicOwnerH != null) {
            java.lang.Long id = topicOwnerH.getId();
            if (id != null) {
                insert(topicOwnerH);
            } else {
                update(topicOwnerH);
            }
        }
        return topicOwnerH;
    }

    /*** 批量保存topicOwnerHs,有id时更新，没有id时插入,并带回新的id，返回 topicOwnerHs*/
    @Override
    public List<TopicOwnerH> saveTopicOwnerHs(List<TopicOwnerH> topicOwnerHs) {
        for (TopicOwnerH topicOwnerH : topicOwnerHs) {
            this.saveTopicOwnerH(topicOwnerH);
        }
        return topicOwnerHs;
    }

    @Override
    public <T> Long generateId(Class<T> bizTagClz) {
        return this.idGenerator.generateId(Long.class, bizTagClz);
    }
}