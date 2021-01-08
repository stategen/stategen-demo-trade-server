/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */    
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.TopicReply;
import com.mycompany.biz.dao.TopicReplyDao;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.IdGenerateService;
/**
 * TopicReplyDao
 * @author StageGen.org 
 * <pre>
 * database table: demo_topic_reply
 * database table comments: TopicReply
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class TopicReplyDaoImpl  extends SqlDaoSupportBase implements TopicReplyDao {


	/**
	 * 
	 * sql:insert into demo_topic_reply ( create_time , update_time , delete_flag , reply_id , topic_id , author_id , content , parent_reply_id ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?)
	 */
	public TopicReply insert(TopicReply topicReply, IdGenerateService<String> idGenerateService) throws DataAccessException {
		if(topicReply == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        if (idGenerateService != null && topicReply.getReplyId() == null) {
            String replyId = idGenerateService.generateId();
            if (replyId != null) {
                topicReply.setReplyId(replyId);
            }
        }
        super.insert("TopicReply.insert", topicReply);
		return topicReply;
	}

	/**
	 * 
	 * sql:UPDATE demo_topic_reply a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.reply_id = ?
	 */
	public String delete(String replyId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("replyId",replyId);
        super.update("TopicReply.delete", params);
        return replyId;
	}

	/**
	 * 
	 * sql:UPDATE demo_topic_reply a SET a.update_time= CURRENT_TIMESTAMP(6) , a.topic_id = ? , a.author_id = ? , a.content = ? , a.parent_reply_id = ? where a.delete_flag = 0 and a.reply_id = ?
	 */
	public TopicReply update(TopicReply topicReply) throws DataAccessException {
		if(topicReply == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        super.update("TopicReply.update", topicReply);
		return topicReply;
	}

	/**
	 * 
	 * sql:select a.reply_id, a.topic_id, a.author_id, a.content, a.parent_reply_id, a.create_time, a.update_time, a.delete_flag from demo_topic_reply a where a.delete_flag = 0 and a.reply_id = ?
	 */
	public TopicReply getTopicReplyByReplyId(String replyId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("replyId",replyId);
		return (TopicReply)super.selectOne("TopicReply.getTopicReplyByReplyId",params);
	}

	/**
	 * 
	 * sql:select a.reply_id, a.topic_id, a.author_id, a.content, a.parent_reply_id, a.create_time, a.update_time, a.delete_flag from demo_topic_reply a where a.delete_flag = 0 and a.reply_id=? and a.reply_id in ( ? ) and a.topic_id=? and a.topic_id in ( ? ) and a.author_id=? and a.author_id in ( ? ) and a.parent_reply_id=? and a.parent_reply_id in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<TopicReply> getPageList(TopicReply topicReply, int pageSize, int pageNum) throws DataAccessException {
		return super.pageQuery("TopicReply.getPageList",topicReply,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.reply_id, a.topic_id, a.author_id, a.content, a.parent_reply_id, a.create_time, a.update_time, a.delete_flag from demo_topic_reply a where a.delete_flag = 0 and 1=0 and a.reply_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<TopicReply> getTopicReplysByReplyIds(java.util.List<String> replyIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("replyIds",replyIds);
		return super.selectList("TopicReply.getTopicReplysByReplyIds",params);
	}

	/**
	 * 
	 * sql:UPDATE demo_topic_reply a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.reply_id in ( ? )
	 */
	public java.util.List<String> deleteByReplyIds(java.util.List<String> replyIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("replyIds",replyIds);
        super.update("TopicReply.deleteByReplyIds", params);
        return replyIds;
	}
}

