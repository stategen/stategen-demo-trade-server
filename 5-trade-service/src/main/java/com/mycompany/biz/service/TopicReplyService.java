/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.service;

import java.util.List;
import org.stategen.framework.lite.PageList;

import com.mycompany.biz.domain.TopicReply;

/**
 * TopicReplyService
 * <pre>
 * database table: topic_reply
 * database table comments: TopicReply
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public interface TopicReplyService extends TopicReplyServiceFacade {

    /**
     * 
     * @see com.mycompany.biz.dao.TopicReplyDao#insert
     */
    public TopicReply insert(TopicReply topicReply);

    /**
     * 
     * @see com.mycompany.biz.dao.TopicReplyDao#delete
     */
    public String delete(String topicReplyId);

    /**
     * 
     * @see com.mycompany.biz.dao.TopicReplyDao#update
     */
    public TopicReply update(TopicReply topicReply);

    /**
     * 
     * @see com.mycompany.biz.dao.TopicReplyDao#getTopicReplyByTopicReplyId
     */
    public TopicReply getTopicReplyByTopicReplyId(String topicReplyId);

    /**
     * 
     * @see com.mycompany.biz.dao.TopicReplyDao#getTopicReplyPageListByDefaultQuery
     */
    public PageList<TopicReply> getTopicReplyPageListByDefaultQuery(TopicReply topicReply, int pageSize, int pageNum);

    /**
     * 
     * @see com.mycompany.biz.dao.TopicReplyDao#getTopicReplysByTopicReplyIds
     */
    public List<TopicReply> getTopicReplysByTopicReplyIds(java.util.List<String> topicReplyIds);

    /**
     * 
     * @see com.mycompany.biz.dao.TopicReplyDao#deleteByTopicReplyIds
     */
    public java.util.List<String> deleteByTopicReplyIds(java.util.List<String> topicReplyIds);

    /*** 保存topicReply,有id时更新，没有id时插入,并带回新的id，返回 topicReply*/
    public TopicReply saveTopicReply(TopicReply topicReply);

    /*** 批量保存topicReplys,有id时更新，没有id时插入,并带回新的id，返回 topicReplys*/
    public List<TopicReply> saveTopicReplys(List<TopicReply> topicReplys);
}
