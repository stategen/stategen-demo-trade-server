/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.TopicReply;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;

/**
 * TopicReplyDao
 * <pre>
 * database table: demo_topic_reply
 * database table comments: TopicReply
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface TopicReplyDao {

	/**
    <pre>
    &#64;ApiParam() String replyId,
    &#64;ApiParam() String topicId,
    &#64;ApiParam() String authorId,
    &#64;ApiParam() String content,
    &#64;ApiParam() String parentReplyId
    ,&#64;ApiParam(hidden = true) TopicReply topicReply
    
    </pre>
	 * 
	 * sql:insert into demo_topic_reply ( create_time , update_time , delete_flag , reply_id , topic_id , author_id , content , parent_reply_id ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?)
	 */
	public TopicReply insert(TopicReply topicReply) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("replyId") String replyId
    
    </pre>
	 * 
	 * sql:UPDATE demo_topic_reply a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.reply_id = ?
	 */
	public String delete(String replyId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String topicId,
    &#64;ApiParam() String authorId,
    &#64;ApiParam() String content,
    &#64;ApiParam() String parentReplyId,
    &#64;ApiParam() String replyId
    ,&#64;ApiParam(hidden = true) TopicReply topicReply
    
    </pre>
	 * 
	 * sql:UPDATE demo_topic_reply a SET a.update_time= CURRENT_TIMESTAMP(6) , a.topic_id = ? , a.author_id = ? , a.content = ? , a.parent_reply_id = ? where a.delete_flag = 0 and a.reply_id = ?
	 */
	public TopicReply update(TopicReply topicReply) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("replyId") String replyId
    
    </pre>
	 * 
	 * sql:select a.reply_id, a.topic_id, a.author_id, a.content, a.parent_reply_id, a.create_time, a.update_time, a.delete_flag from demo_topic_reply a where a.delete_flag = 0 and a.reply_id = ?
	 */
	public TopicReply getTopicReplyByReplyId(String replyId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String replyId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="replyIds") ArrayList&lt;String&gt; replyIds,
    &#64;ApiParam() String topicId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="topicIds") ArrayList&lt;String&gt; topicIds,
    &#64;ApiParam() String authorId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="authorIds") ArrayList&lt;String&gt; authorIds,
    &#64;ApiParam() String parentReplyId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="parentReplyIds") ArrayList&lt;String&gt; parentReplyIds,
    &#64;ApiParam() Date createTimeMin,
    &#64;ApiParam() Date createTimeMax,
    &#64;ApiParam() Date updateTimeMin,
    &#64;ApiParam() Date updateTimeMax
    ,&#64;ApiParam(hidden = true) TopicReply topicReply
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.reply_id, a.topic_id, a.author_id, a.content, a.parent_reply_id, a.create_time, a.update_time, a.delete_flag from demo_topic_reply a where a.delete_flag = 0 and a.reply_id=? and a.reply_id in ( ? ) and a.topic_id=? and a.topic_id in ( ? ) and a.author_id=? and a.author_id in ( ? ) and a.parent_reply_id=? and a.parent_reply_id in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<TopicReply> getPageList(TopicReply topicReply, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("replyId")&#64;RequestParam(required =false,name="replyIds") ArrayList&lt;String&gt; replyIds
    
    </pre>
	 * 
	 * sql:select a.reply_id, a.topic_id, a.author_id, a.content, a.parent_reply_id, a.create_time, a.update_time, a.delete_flag from demo_topic_reply a where a.delete_flag = 0 and 1=0 and a.reply_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<TopicReply> getTopicReplysByReplyIds(java.util.List<String> replyIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("replyId")&#64;RequestParam(required =false,name="replyIds") ArrayList&lt;String&gt; replyIds
    
    </pre>
	 * 
	 * sql:UPDATE demo_topic_reply a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.reply_id in ( ? )
	 */
	public java.util.List<String> deleteByReplyIds(java.util.List<String> replyIds) throws DataAccessException;
	

}



