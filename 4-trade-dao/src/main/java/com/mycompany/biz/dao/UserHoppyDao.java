/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.UserHoppy;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;

/**
 * UserHoppyDao
 * <pre>
 * database table: demo_user_hoppy
 * database table comments: UserHoppy
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface UserHoppyDao {

	/**
    <pre>
    &#64;ApiParam() Long id,
    &#64;ApiParam() String userId,
    &#64;ApiParam() Long hoppyId
    ,&#64;ApiParam(hidden = true) UserHoppy userHoppy
    
    </pre>
	 * 
	 * sql:insert into demo_user_hoppy ( create_time , update_time , delete_flag , id , user_id , hoppy_id ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?)
	 */
	public UserHoppy insert(UserHoppy userHoppy) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("id") Long id
    
    </pre>
	 * 
	 * sql:UPDATE demo_user_hoppy SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and id = ?
	 */
	public Long delete(Long id) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String userId,
    &#64;ApiParam() Long hoppyId,
    &#64;ApiParam() Long id
    ,&#64;ApiParam(hidden = true) UserHoppy userHoppy
    
    </pre>
	 * 
	 * sql:UPDATE demo_user_hoppy SET update_time= CURRENT_TIMESTAMP(6) , user_id = ? , hoppy_id = ? where delete_flag = 0 and id = ?
	 */
	public UserHoppy update(UserHoppy userHoppy) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("id") Long id
    
    </pre>
	 * 
	 * sql:select a.id, a.user_id, a.hoppy_id, a.create_time, a.update_time, a.delete_flag from demo_user_hoppy a where a.delete_flag = 0 and a.id = ?
	 */
	public UserHoppy getUserHoppyById(Long id) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() Long id,
    &#64;ApiParam()&#64;RequestParam(required =false,name="ids") ArrayList&lt;Long&gt; ids,
    &#64;ApiParam() String userId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="userIds") ArrayList&lt;String&gt; userIds,
    &#64;ApiParam() Long hoppyId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="hoppyIds") ArrayList&lt;Long&gt; hoppyIds,
    &#64;ApiParam() Date createTimeMin,
    &#64;ApiParam() Date createTimeMax,
    &#64;ApiParam() Date updateTimeMin,
    &#64;ApiParam() Date updateTimeMax
    ,&#64;ApiParam(hidden = true) UserHoppy userHoppy
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.id, a.user_id, a.hoppy_id, a.create_time, a.update_time, a.delete_flag from demo_user_hoppy a where a.delete_flag = 0 and a.id=? and a.id in ( ? ) and a.user_id=? and a.user_id in ( ? ) and a.hoppy_id=? and a.hoppy_id in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<UserHoppy> getPageList(UserHoppy userHoppy, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("id")&#64;RequestParam(required =false,name="ids") ArrayList&lt;Long&gt; ids
    
    </pre>
	 * 
	 * sql:select a.id, a.user_id, a.hoppy_id, a.create_time, a.update_time, a.delete_flag from demo_user_hoppy a where a.delete_flag = 0 and 1=0 and a.id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<UserHoppy> getUserHoppysByIds(java.util.List<Long> ids) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("用户ID")&#64;RequestParam(required =false,name="userIds") ArrayList&lt;String&gt; userIds
    
    </pre>
	 * 
	 * sql:select a.id, a.user_id, a.hoppy_id, a.create_time, a.update_time, a.delete_flag from demo_user_hoppy a where a.delete_flag = 0 and 1=0 and a.user_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<UserHoppy> getUserHoppysByUserIds(java.util.List<String> userIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("id")&#64;RequestParam(required =false,name="ids") ArrayList&lt;Long&gt; ids
    
    </pre>
	 * 
	 * sql:UPDATE demo_user_hoppy SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and id in ( ? )
	 */
	public java.util.List<Long> deleteByIds(java.util.List<Long> ids) throws DataAccessException;
	

}



