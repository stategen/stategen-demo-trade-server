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

import com.mycompany.biz.domain.Topic;

/**
 * TopicService
 * <pre>
 * database table: topic
 * database table comments: Topic
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public interface TopicService extends AssignService<Topic, String>, TopicServiceTrade, BaseService<Topic> {

    void assignTopicExtraProperties(List<Topic> topics);

    /**
     ** 
     * @see com.mycompany.biz.dao.TopicDao#insert
     */
    public Topic insert(Topic topic);

    /**
     ** 
     * @see com.mycompany.biz.dao.TopicDao#delete
     */
    public String delete(String topicId, Long currentOrgId, String currentUserId);

    /**
     ** 
     * @see com.mycompany.biz.dao.TopicDao#update
     */
    public Topic update(Topic topic);

    /**
     ** 
     * @see com.mycompany.biz.dao.TopicDao#getTopicByTopicId
     */
    public Topic getTopicByTopicId(String topicId, Long currentOrgId, String currentUserId);

    /**
     ** 
     * @see com.mycompany.biz.dao.TopicDao#getPageList
     */
    public PageList<Topic> getPageList(Topic topic, int pageSize, int pageNum);

    /**
     ** 
     * @see com.mycompany.biz.dao.TopicDao#getTopicsByTopicIds
     */
    public List<Topic> getTopicsByTopicIds(java.util.List<String> topicIds, Long currentOrgId, String currentUserId);

    /**
     * @see com.mycompany.biz.service.TopicService#getTopicsByTopicIds
     */
    public List<Topic> getTopicsByTopicIdsNoLevelAuthority(java.util.List<String> topicIds);

    /**
     ** 
     * @see com.mycompany.biz.dao.TopicDao#deleteByTopicIds
     */
    public java.util.List<String> deleteByTopicIds(java.util.List<String> topicIds, Long currentOrgId, String currentUserId);

    /**
     ** 获取当前回复的数量
     * @see com.mycompany.biz.dao.TopicDao#getReplyCounts
     */
    public List<Topic> getReplyCounts(java.util.List<String> topicIds);

    /*** 保存topic,有id时更新，没有id时插入,并带回新的id，返回 topic
     * @see com.mycompany.biz.dao.TopicDao#insert
     */
    public Topic saveTopic(Topic topic);

    /** 批量保存topics,有id时更新，没有id时插入,并带回新的id，返回 topics
     * @see com.mycompany.biz.dao.TopicDao#insert
     */
    public List<Topic> saveTopics(List<Topic> topics);
}
