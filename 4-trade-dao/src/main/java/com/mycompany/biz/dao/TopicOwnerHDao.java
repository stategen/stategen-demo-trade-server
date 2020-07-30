/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.TopicOwnerH;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.lite.IdGenerateService;

/**
 * TopicOwnerHDao
 * <pre>
 * database table: demo_topic_owner_h
 * database table comments: 数据水平权限，只有直系上级有权限
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface TopicOwnerHDao {

	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) Long id,
    &#64;ApiParam() &#64;RequestParam(required = false) String topicId,
    &#64;ApiParam() &#64;RequestParam(required = false) String userId
    ,&#64;ApiParam(hidden = true) TopicOwnerH topicOwnerH
    
    </pre>
	 * 
	 * sql:insert into demo_topic_owner_h ( create_time , update_time , delete_flag , id , topic_id , user_id ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?)
	 */
	public TopicOwnerH insert(TopicOwnerH topicOwnerH, IdGenerateService<Long> idGenerateService) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("id") &#64;RequestParam(required = false) Long id    
    </pre>
	 * 
	 * sql:UPDATE demo_topic_owner_h a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.id = ?
	 */
	public Long delete(Long id) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) String topicId,
    &#64;ApiParam() &#64;RequestParam(required = false) String userId,
    &#64;ApiParam() &#64;RequestParam(required = false) Long id
    ,&#64;ApiParam(hidden = true) TopicOwnerH topicOwnerH
    
    </pre>
	 * 
	 * sql:UPDATE demo_topic_owner_h a SET a.update_time= CURRENT_TIMESTAMP(6) , a.topic_id = ? , a.user_id = ? where a.delete_flag = 0 and a.id = ?
	 */
	public TopicOwnerH update(TopicOwnerH topicOwnerH) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("id") &#64;RequestParam(required = false) Long id    
    </pre>
	 * 
	 * sql:select a.id, a.topic_id, a.user_id, a.update_time, a.create_time, a.delete_flag from demo_topic_owner_h a where a.delete_flag = 0 and a.id = ?
	 */
	public TopicOwnerH getTopicOwnerHById(Long id) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) Long id,
    &#64;ApiParam() &#64;RequestParam(required = false) Long idMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Long idMax,
    &#64;ApiParam() &#64;RequestParam(required = false) String topicId,
    &#64;ApiParam() &#64;RequestParam(required = false, name="topicIds") ArrayList&lt;String&gt; topicIds,
    &#64;ApiParam() &#64;RequestParam(required = false) String userId,
    &#64;ApiParam() &#64;RequestParam(required = false, name="userIds") ArrayList&lt;String&gt; userIds,
    &#64;ApiParam() &#64;RequestParam(required = false) Date updateTimeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Date updateTimeMax,
    &#64;ApiParam() &#64;RequestParam(required = false) Date createTimeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Date createTimeMax
    ,&#64;ApiParam(hidden = true) TopicOwnerH topicOwnerH
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.id, a.topic_id, a.user_id, a.update_time, a.create_time, a.delete_flag from demo_topic_owner_h a where a.delete_flag = 0 and a.id=? and a.id >=? and a.id <? and a.topic_id=? and a.topic_id in ( ? ) and a.user_id=? and a.user_id in ( ? ) and a.update_time >=? and a.update_time <? and a.create_time >=? and a.create_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<TopicOwnerH> getPageList(TopicOwnerH topicOwnerH, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("id") &#64;RequestParam(required = false, name="ids") ArrayList&lt;Long&gt; ids    
    </pre>
	 * 
	 * sql:select a.id, a.topic_id, a.user_id, a.update_time, a.create_time, a.delete_flag from demo_topic_owner_h a where a.delete_flag = 0 and 1=0 and a.id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<TopicOwnerH> getTopicOwnerHsByIds(java.util.List<Long> ids) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("id") &#64;RequestParam(required = false, name="ids") ArrayList&lt;Long&gt; ids    
    </pre>
	 * 
	 * sql:UPDATE demo_topic_owner_h a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.id in ( ? )
	 */
	public java.util.List<Long> deleteByIds(java.util.List<Long> ids) throws DataAccessException;
	

}



