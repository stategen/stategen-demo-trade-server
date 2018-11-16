/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.stategen.framework.ibatis.util.PageQueryUtils;
import org.stategen.framework.lite.PageList;

import com.mycompany.biz.dao.TopicDao;
import com.mycompany.biz.domain.Topic;

/**
 * TopicDao
 * <pre>
 * database table: topic
 * database table comments: Topic
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class TopicDaoImpl extends SqlMapClientDaoSupport implements TopicDao {

    /**
	 * 
	 * sql:insert into topic ( create_time , update_time , delete_flag , topic_id , author_id , tab , content , title , last_reply_at , good , top , visit_count , create_at ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?,?,?,?,?,?)
	 */
    public Topic insert(Topic topic) throws DataAccessException {
        if (topic == null) {
            throw new IllegalArgumentException("Can't insert a null data object into db.");
        }
        getSqlMapClientTemplate().insert("insert.Topic.trade", topic);
        return topic;
    }

    /**
	 * 
	 * sql:UPDATE topic SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and topic_id = ?
	 */
    public String delete(String topicId) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("topicId", topicId);
        getSqlMapClientTemplate().update("delete.Topic.trade", params);
        return topicId;
    }

    /**
	 * 
	 * sql:UPDATE topic SET update_time= CURRENT_TIMESTAMP(6) , author_id = ? , tab = ? , content = ? , title = ? , last_reply_at = ? , good = ? , top = ? , visit_count = ? , create_at = ? where delete_flag = 0 and topic_id = ?
	 */
    public Topic update(Topic topic) throws DataAccessException {
        if (topic == null) {
            throw new IllegalArgumentException("Can't update by a null data object.");
        }
        getSqlMapClientTemplate().update("update.Topic.trade", topic);
        return topic;
    }

    /**
	 * 
	 * sql:select a.topic_id, a.author_id, a.tab, a.content, a.title, a.last_reply_at, a.good, a.top, a.visit_count, a.create_at, a.create_time, a.update_time, a.delete_flag from topic a where a.delete_flag = 0 and a.topic_id = ?
	 */
    public Topic getTopicByTopicId(String topicId) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("topicId", topicId);
        return (Topic) getSqlMapClientTemplate().queryForObject("getTopicByTopicId.Topic.trade", params);
    }

    /**
	 * 
	 * sql:select a.topic_id, a.author_id, a.tab, a.content, a.title, a.last_reply_at, a.good, a.top, a.visit_count, a.create_at, a.create_time, a.update_time, a.delete_flag from topic a where a.delete_flag = 0 and a.topic_id=? and a.topic_id in ( ? ) and a.author_id=? and a.author_id in ( ? ) and a.tab=? and a.tab like CONCAT('%',?,'%') and a.content=? and a.content like CONCAT('%',?,'%') and a.title=? and a.title like CONCAT('%',?,'%') and a.last_reply_at=? and a.last_reply_at like CONCAT('%',?,'%') and a.good=? and a.good like CONCAT('%',?,'%') and a.top=? and a.top like CONCAT('%',?,'%') and a.visit_count >=? and a.visit_count <? and a.create_at=? and a.create_at like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1
	 */
    @SuppressWarnings("unchecked")
    public PageList<Topic> getTopicPageListByDefaultQuery(Topic topic, int pageSize, int pageNum) throws DataAccessException {
        return (PageList<Topic>) PageQueryUtils.pageQuery(getSqlMapClientTemplate(), "getTopicPageListByDefaultQuery.Topic.trade", topic, pageNum, pageSize);
    }

    /**
	 * 
	 * sql:select a.topic_id, a.author_id, a.tab, a.content, a.title, a.last_reply_at, a.good, a.top, a.visit_count, a.create_at, a.create_time, a.update_time, a.delete_flag from topic a where a.delete_flag = 0 and 1=0 and a.topic_id in ( ? )
	 */
    @SuppressWarnings("unchecked")
    public List<Topic> getTopicsByTopicIds(java.util.List<String> topicIds) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("topicIds", topicIds);
        return (List<Topic>) getSqlMapClientTemplate().queryForList("getTopicsByTopicIds.Topic.trade", params);
    }

    /**
	 * 
	 * sql:UPDATE topic SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and topic_id in ( ? )
	 */
    public java.util.List<String> deleteByTopicIds(java.util.List<String> topicIds) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("topicIds", topicIds);
        getSqlMapClientTemplate().update("deleteByTopicIds.Topic.trade", params);
        return topicIds;
    }
}
