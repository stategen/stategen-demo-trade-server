/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.Topic;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;

/**
 * TopicDao
 * <pre>
 * database table: demo_topic
 * database table comments: Topic
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface TopicDao {

	/**
    <pre>
    &#64;ApiParam() String topicId,
    &#64;ApiParam() String authorId,
    &#64;ApiParam() TopicType topicType,
    &#64;ApiParam() String content,
    &#64;ApiParam() String title,
    &#64;ApiParam() Date lastReplyAt,
    &#64;ApiParam() Long good,
    &#64;ApiParam() Long top,
    &#64;ApiParam() Long visitCount
    ,&#64;ApiParam(hidden = true) Topic topic
    
    </pre>
	 * 
	 * sql:insert into demo_topic ( create_time , update_time , delete_flag , topic_id , author_id , topic_type , content , title , last_reply_at , good , top , visit_count ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?,?,?,?,?)
	 */
	public Topic insert(Topic topic) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("主题ID") String topicId
    
    </pre>
	 * 
	 * sql:UPDATE demo_topic SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and topic_id = ?
	 */
	public String delete(String topicId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String authorId,
    &#64;ApiParam() TopicType topicType,
    &#64;ApiParam() String content,
    &#64;ApiParam() String title,
    &#64;ApiParam() Date lastReplyAt,
    &#64;ApiParam() Long good,
    &#64;ApiParam() TopicType top,
    &#64;ApiParam() Long visitCount,
    &#64;ApiParam() String topicId
    ,&#64;ApiParam(hidden = true) Topic topic
    
    </pre>
	 * 
	 * sql:UPDATE demo_topic SET update_time= CURRENT_TIMESTAMP(6) , author_id = ? , topic_type = ? , content = ? , title = ? , last_reply_at = ? , good = ? , top = ? , visit_count = ? where delete_flag = 0 and topic_id = ?
	 */
	public Topic update(Topic topic) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("主题ID") String topicId
    
    </pre>
	 * 
	 * sql:select a.topic_id, a.author_id, a.topic_type, a.content, a.title, a.last_reply_at, a.good, a.top, a.visit_count, a.create_time, a.update_time, a.delete_flag from demo_topic a where a.delete_flag = 0 and a.topic_id = ?
	 */
	public Topic getTopicByTopicId(String topicId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String topicId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="topicIds") ArrayList&lt;String&gt; topicIds,
    &#64;ApiParam() String authorId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="authorIds") ArrayList&lt;String&gt; authorIds,
    &#64;ApiParam() TopicType topicType,
    &#64;ApiParam()&#64;RequestParam(required =false,name="topicTypes") ArrayList&lt;TopicType&gt; topicTypes,
    &#64;ApiParam() String title,
    &#64;ApiParam() String titleLike,
    &#64;ApiParam() Date lastReplyAtMin,
    &#64;ApiParam() Date lastReplyAtMax,
    &#64;ApiParam() Long good,
    &#64;ApiParam() Long goodMin,
    &#64;ApiParam() Long goodMax,
    &#64;ApiParam() String top,
    &#64;ApiParam() Long topMin,
    &#64;ApiParam() Long topMax,
    &#64;ApiParam() Long visitCount,
    &#64;ApiParam() Long visitCountMin,
    &#64;ApiParam() Long visitCountMax,
    &#64;ApiParam() Date createTimeMin,
    &#64;ApiParam() Date createTimeMax,
    &#64;ApiParam() Date updateTimeMin,
    &#64;ApiParam() Date updateTimeMax
    ,&#64;ApiParam(hidden = true) Topic topic
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.topic_id, a.author_id, a.topic_type, a.content, a.title, a.last_reply_at, a.good, a.top, a.visit_count, a.create_time, a.update_time, a.delete_flag from demo_topic a where a.delete_flag = 0 and a.topic_id=? and a.topic_id in ( ? ) and a.author_id=? and a.author_id in ( ? ) and a.topic_type=? and a.topic_type in ( ? ) and a.title=? and a.title like CONCAT('%',?,'%') and a.last_reply_at >=? and a.last_reply_at <? and a.good=? and a.good >=? and a.good <? and a.top=? and a.top >=? and a.top <? and a.visit_count=? and a.visit_count >=? and a.visit_count <? and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<Topic> getPageList(Topic topic, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("主题ID")&#64;RequestParam(required =false,name="topicIds") ArrayList&lt;String&gt; topicIds
    
    </pre>
	 * 
	 * sql:select a.topic_id, a.author_id, a.topic_type, a.content, a.title, a.last_reply_at, a.good, a.top, a.visit_count, a.create_time, a.update_time, a.delete_flag from demo_topic a where a.delete_flag = 0 and 1=0 and a.topic_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<Topic> getTopicsByTopicIds(java.util.List<String> topicIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("主题ID")&#64;RequestParam(required =false,name="topicIds") ArrayList&lt;String&gt; topicIds
    
    </pre>
	 * 
	 * sql:UPDATE demo_topic SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and topic_id in ( ? )
	 */
	public java.util.List<String> deleteByTopicIds(java.util.List<String> topicIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("topicId")&#64;RequestParam(required =false,name="topicIds") ArrayList&lt;String&gt; topicIds
    
    </pre>
	 * 获取当前回复的数量
	 * sql:SELECT b.topic_id, COUNT(b.reply_id) as replyCount FROM demo_topic_reply b WHERE b.delete_flag = 0 and b.topic_id in ( ? ) and 1=0 GROUP BY b.topic_id
	 */
	public List<Topic> getReplyCounts(java.util.List<String> topicIds) throws DataAccessException;
	

}



