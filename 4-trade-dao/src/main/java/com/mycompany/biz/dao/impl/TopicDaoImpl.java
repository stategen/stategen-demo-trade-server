/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */    
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.dao.TopicDao;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.util.AfterInsertService;

import org.springframework.dao.DataAccessException;
import org.stategen.framework.util.IIDGenerator;
/**
 * TopicDao
 * <pre>
 * database table: demo_topic
 * database table comments: 主题  -level(demo_organization) -owner(user)
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class TopicDaoImpl  extends SqlDaoSupportBase implements TopicDao {


	/**
	 * 
	 * sql:insert into demo_topic ( create_time , update_time , delete_flag , topic_id , author_id , topic_type , content , title , last_reply_at , good , top , visit_count ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?,?,?,?,?)
	 */
	public Topic insert(Topic topic, IIDGenerator<String> idGenerator, AfterInsertService<Topic> afterInsertService) throws DataAccessException {
		if(topic == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        if (idGenerator != null) {
            String topicId = idGenerator.generateId();
            topic.setTopicId(topicId);
        }
        super.insert("Topic.insert", topic);
        if (afterInsertService != null) {
            afterInsertService.afterInsert(topic);
        }
		return topic;
	}

	/**
	 * 
	 * sql:UPDATE demo_topic a left join demo_topic_level_h h on ( a.topic_id = h.topic_id ) left join demo_topic_owner_h o on ( a.topic_id = o.topic_id ) left join user u on ( u.user_id = o.user_id ) SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.topic_id = ? and ( 1=0 ) and ( ( ( 1=? and h.org_id = ? ) or exists ( select null from demo_organization_flat_h where org_id = h.org_id and parent_id = ? and delete_flag = 0 ) ) ) and ( o.user_id = ? and u.delete_flag = 0 ) and ( ( o.user_id = ? and u.delete_flag = 0 ) or ( ( 1=? and h.org_id = ? ) or exists ( select null from demo_organization_flat_h where org_id = h.org_id and parent_id = ? and delete_flag = 0 ) ) )
	 */
	public String delete(String topicId, Boolean inclCurrOrgId, Long currOrgId, String currUserId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(4);
		params.put("topicId",topicId);
		params.put("inclCurrOrgId",inclCurrOrgId);
		params.put("currOrgId",currOrgId);
		params.put("currUserId",currUserId);
        super.update("Topic.delete", params);
        return topicId;
	}

	/**
	 * 
	 * sql:UPDATE demo_topic a left join demo_topic_level_h h on ( a.topic_id = h.topic_id ) left join demo_topic_owner_h o on ( a.topic_id = o.topic_id ) left join user u on ( u.user_id = o.user_id ) SET a.update_time= CURRENT_TIMESTAMP(6) , a.author_id = ? , a.topic_type = ? , a.content = ? , a.title = ? , a.last_reply_at = ? , a.good = ? , a.top = ? , a.visit_count = ? where a.delete_flag = 0 and a.topic_id = ? and ( 1=0 ) and ( ( ( 1=? and h.org_id = ? ) or exists ( select null from demo_organization_flat_h where org_id = h.org_id and parent_id = ? and delete_flag = 0 ) ) ) and ( o.user_id = ? and u.delete_flag = 0 ) and ( ( o.user_id = ? and u.delete_flag = 0 ) or ( ( 1=? and h.org_id = ? ) or exists ( select null from demo_organization_flat_h where org_id = h.org_id and parent_id = ? and delete_flag = 0 ) ) )
	 */
	public Topic update(Topic topic) throws DataAccessException {
		if(topic == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        super.update("Topic.update", topic);
		return topic;
	}

	/**
	 * 
	 * sql:select a.topic_id, a.author_id, a.topic_type, a.content, a.title, a.last_reply_at, a.good, a.top, a.visit_count, a.create_time, a.update_time, a.delete_flag from demo_topic a left join demo_topic_level_h h on ( a.topic_id = h.topic_id ) left join demo_topic_owner_h o on ( a.topic_id = o.topic_id ) left join user u on ( u.user_id = o.user_id ) where a.delete_flag = 0 and a.topic_id = ? and ( ( ( 1=? and h.org_id = ? ) or exists ( select null from demo_organization_flat_h where org_id = h.org_id and parent_id = ? and delete_flag = 0 ) ) ) and ( o.user_id = ? and u.delete_flag = 0 ) and ( ( o.user_id = ? and u.delete_flag = 0 ) or ( ( 1=? and h.org_id = ? ) or exists ( select null from demo_organization_flat_h where org_id = h.org_id and parent_id = ? and delete_flag = 0 ) ) )
	 */
	public Topic getTopicByTopicId(String topicId, Boolean inclCurrOrgId, Long currOrgId, String currUserId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(4);
		params.put("topicId",topicId);
		params.put("inclCurrOrgId",inclCurrOrgId);
		params.put("currOrgId",currOrgId);
		params.put("currUserId",currUserId);
		return (Topic)super.selectOne("Topic.getTopicByTopicId",params);
	}

	/**
	 * 
	 * sql:select a.topic_id, a.author_id, a.topic_type, a.content, a.title, a.last_reply_at, a.good, a.top, a.visit_count, a.create_time, a.update_time, a.delete_flag from demo_topic a left join demo_topic_level_h h on ( a.topic_id = h.topic_id ) left join demo_topic_owner_h o on ( a.topic_id = o.topic_id ) left join user u on ( u.user_id = o.user_id ) where a.delete_flag = 0 and a.topic_id=? and a.topic_id in ( ? ) and a.author_id=? and a.author_id in ( ? ) and a.topic_type=? and a.topic_type in ( ? ) and a.title=? and a.title like CONCAT('%',?,'%') and a.last_reply_at >=? and a.last_reply_at <? and a.good=? and a.good >=? and a.good <? and a.top=? and a.top >=? and a.top <? and a.visit_count=? and a.visit_count >=? and a.visit_count <? and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and ( ( ( 1=? and h.org_id = ? ) or h.org_id in ( select org_id from demo_organization_flat_h where parent_id = ? and delete_flag = 0 ) ) ) and ( o.user_id = ? and u.delete_flag = 0 ) and ( ( o.user_id = ? and u.delete_flag = 0 ) or ( ( 1=? and h.org_id = ? ) or h.org_id in ( select org_id from demo_organization_flat_h where parent_id = ? and delete_flag = 0 ) ) ) and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<Topic> getPageList(Topic topic, int pageSize, int pageNum) throws DataAccessException {
		return super.pageQuery("Topic.getPageList",topic,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.topic_id, a.author_id, a.topic_type, a.content, a.title, a.last_reply_at, a.good, a.top, a.visit_count, a.create_time, a.update_time, a.delete_flag from demo_topic a left join demo_topic_level_h h on ( a.topic_id = h.topic_id ) left join demo_topic_owner_h o on ( a.topic_id = o.topic_id ) left join user u on ( u.user_id = o.user_id ) where a.delete_flag = 0 and 1=0 and a.topic_id in ( ? ) and ( ( ( 1=? and h.org_id = ? ) or h.org_id in ( select org_id from demo_organization_flat_h where parent_id = ? and delete_flag = 0 ) ) ) and ( o.user_id = ? and u.delete_flag = 0 ) and ( ( o.user_id = ? and u.delete_flag = 0 ) or ( ( 1=? and h.org_id = ? ) or h.org_id in ( select org_id from demo_organization_flat_h where parent_id = ? and delete_flag = 0 ) ) ) order by a.update_time desc, a.create_time desc
	 */
	public List<Topic> getTopicsByTopicIds(java.util.List<String> topicIds, Boolean inclCurrOrgId, Long currOrgId, String currUserId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(4);
		params.put("topicIds",topicIds);
		params.put("inclCurrOrgId",inclCurrOrgId);
		params.put("currOrgId",currOrgId);
		params.put("currUserId",currUserId);
		return super.selectList("Topic.getTopicsByTopicIds",params);
	}

	/**
	 * 
	 * sql:UPDATE demo_topic a left join demo_topic_level_h h on ( a.topic_id = h.topic_id ) left join demo_topic_owner_h o on ( a.topic_id = o.topic_id ) left join user u on ( u.user_id = o.user_id ) SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and ( 1=0 ) and a.topic_id in ( ? ) and ( ( ( 1=? and h.org_id = ? ) or h.org_id in ( select org_id from demo_organization_flat_h where parent_id = ? and delete_flag = 0 ) ) ) and ( o.user_id = ? and u.delete_flag = 0 ) and ( ( o.user_id = ? and u.delete_flag = 0 ) or ( ( 1=? and h.org_id = ? ) or h.org_id in ( select org_id from demo_organization_flat_h where parent_id = ? and delete_flag = 0 ) ) )
	 */
	public java.util.List<String> deleteByTopicIds(java.util.List<String> topicIds, Boolean inclCurrOrgId, Long currOrgId, String currUserId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(4);
		params.put("topicIds",topicIds);
		params.put("inclCurrOrgId",inclCurrOrgId);
		params.put("currOrgId",currOrgId);
		params.put("currUserId",currUserId);
        super.update("Topic.deleteByTopicIds", params);
        return topicIds;
	}

	/**
	 * 获取当前回复的数量
	 * sql:SELECT b.topic_id, COUNT(b.reply_id) as replyCount FROM demo_topic_reply b WHERE b.delete_flag = 0 and b.topic_id in ( ? ) and 1=0 GROUP BY b.topic_id
	 */
	public List<Topic> getReplyCounts(java.util.List<String> topicIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("topicIds",topicIds);
		return super.selectList("Topic.getReplyCounts",params);
	}
}

