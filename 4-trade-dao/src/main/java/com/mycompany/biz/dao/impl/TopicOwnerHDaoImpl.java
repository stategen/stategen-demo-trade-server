/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */    
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.TopicOwnerH;
import com.mycompany.biz.dao.TopicOwnerHDao;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.IdGenerateService;
/**
 * TopicOwnerHDao
 * @author StageGen.org 
 * <pre>
 * database table: demo_topic_owner_h
 * database table comments: 数据水平权限，只有直系上级有权限
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class TopicOwnerHDaoImpl  extends SqlDaoSupportBase implements TopicOwnerHDao {


	/**
	 * 
	 * sql:insert into demo_topic_owner_h ( create_time , update_time , delete_flag , id , topic_id , user_id ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?)
	 */
	public TopicOwnerH insert(TopicOwnerH topicOwnerH, IdGenerateService<Long> idGenerateService) throws DataAccessException {
		if(topicOwnerH == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        if (idGenerateService != null && topicOwnerH.getId() == null) {
            Long id = idGenerateService.generateId();
            if (id != null) {
                topicOwnerH.setId(id);
            }
        }
        super.insert("TopicOwnerH.insert", topicOwnerH);
		return topicOwnerH;
	}

	/**
	 * 
	 * sql:UPDATE demo_topic_owner_h a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.id = ?
	 */
	public Long delete(Long id) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("id",id);
        super.update("TopicOwnerH.delete", params);
        return id;
	}

	/**
	 * 
	 * sql:UPDATE demo_topic_owner_h a SET a.update_time= CURRENT_TIMESTAMP(6) , a.topic_id = ? , a.user_id = ? where a.delete_flag = 0 and a.id = ?
	 */
	public TopicOwnerH update(TopicOwnerH topicOwnerH) throws DataAccessException {
		if(topicOwnerH == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        super.update("TopicOwnerH.update", topicOwnerH);
		return topicOwnerH;
	}

	/**
	 * 
	 * sql:select a.id, a.topic_id, a.user_id, a.update_time, a.create_time, a.delete_flag from demo_topic_owner_h a where a.delete_flag = 0 and a.id = ?
	 */
	public TopicOwnerH getTopicOwnerHById(Long id) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("id",id);
		return (TopicOwnerH)super.selectOne("TopicOwnerH.getTopicOwnerHById",params);
	}

	/**
	 * 
	 * sql:select a.id, a.topic_id, a.user_id, a.update_time, a.create_time, a.delete_flag from demo_topic_owner_h a where a.delete_flag = 0 and a.id=? and a.id >=? and a.id <? and a.topic_id=? and a.topic_id in ( ? ) and a.user_id=? and a.user_id in ( ? ) and a.update_time >=? and a.update_time <? and a.create_time >=? and a.create_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<TopicOwnerH> getPageList(TopicOwnerH topicOwnerH, int pageSize, int pageNum) throws DataAccessException {
		return super.pageQuery("TopicOwnerH.getPageList",topicOwnerH,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.id, a.topic_id, a.user_id, a.update_time, a.create_time, a.delete_flag from demo_topic_owner_h a where a.delete_flag = 0 and 1=0 and a.id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<TopicOwnerH> getTopicOwnerHsByIds(java.util.List<Long> ids) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("ids",ids);
		return super.selectList("TopicOwnerH.getTopicOwnerHsByIds",params);
	}

	/**
	 * 
	 * sql:UPDATE demo_topic_owner_h a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.id in ( ? )
	 */
	public java.util.List<Long> deleteByIds(java.util.List<Long> ids) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("ids",ids);
        super.update("TopicOwnerH.deleteByIds", params);
        return ids;
	}
}

