/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */    
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.TopicLevelH;
import com.mycompany.biz.dao.TopicLevelHDao;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.IdGenerateService;
/**
 * TopicLevelHDao
 * <pre>
 * database table: demo_topic_level_h
 * database table comments: 数据水平权限，只有直系上级有权限
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class TopicLevelHDaoImpl  extends SqlDaoSupportBase implements TopicLevelHDao {


	/**
	 * 
	 * sql:insert into demo_topic_level_h ( create_time , update_time , delete_flag , topic_id , org_id ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?)
	 */
	public TopicLevelH insert(TopicLevelH topicLevelH, IdGenerateService<String> idGenerateService) throws DataAccessException {
		if(topicLevelH == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        if (idGenerateService != null && topicLevelH.getTopicId() == null) {
            String topicId = idGenerateService.generateId(TopicLevelH.class);
            if (topicId != null) {
                topicLevelH.setTopicId(topicId);
            }
        }
        super.insert("TopicLevelH.insert", topicLevelH);
		return topicLevelH;
	}

	/**
	 * 
	 * sql:UPDATE demo_topic_level_h a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.topic_id = ?
	 */
	public String delete(String topicId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("topicId",topicId);
        super.update("TopicLevelH.delete", params);
        return topicId;
	}

	/**
	 * 
	 * sql:UPDATE demo_topic_level_h a SET a.update_time= CURRENT_TIMESTAMP(6) , a.org_id = ? where a.delete_flag = 0 and a.topic_id = ?
	 */
	public TopicLevelH update(TopicLevelH topicLevelH) throws DataAccessException {
		if(topicLevelH == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        super.update("TopicLevelH.update", topicLevelH);
		return topicLevelH;
	}

	/**
	 * 
	 * sql:select a.topic_id, a.org_id, a.update_time, a.create_time, a.delete_flag from demo_topic_level_h a where a.delete_flag = 0 and a.topic_id = ?
	 */
	public TopicLevelH getTopicLevelHByTopicId(String topicId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("topicId",topicId);
		return (TopicLevelH)super.selectOne("TopicLevelH.getTopicLevelHByTopicId",params);
	}

	/**
	 * 
	 * sql:select a.topic_id, a.org_id, a.update_time, a.create_time, a.delete_flag from demo_topic_level_h a where a.delete_flag = 0 and a.topic_id=? and a.topic_id in ( ? ) and a.org_id=? and a.org_id in ( ? ) and a.update_time >=? and a.update_time <? and a.create_time >=? and a.create_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<TopicLevelH> getPageList(TopicLevelH topicLevelH, int pageSize, int pageNum) throws DataAccessException {
		return super.pageQuery("TopicLevelH.getPageList",topicLevelH,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.topic_id, a.org_id, a.update_time, a.create_time, a.delete_flag from demo_topic_level_h a where a.delete_flag = 0 and 1=0 and a.topic_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<TopicLevelH> getTopicLevelHsByTopicIds(java.util.List<String> topicIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("topicIds",topicIds);
		return super.selectList("TopicLevelH.getTopicLevelHsByTopicIds",params);
	}

	/**
	 * 
	 * sql:UPDATE demo_topic_level_h a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.topic_id in ( ? )
	 */
	public java.util.List<String> deleteByTopicIds(java.util.List<String> topicIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("topicIds",topicIds);
        super.update("TopicLevelH.deleteByTopicIds", params);
        return topicIds;
	}
}
