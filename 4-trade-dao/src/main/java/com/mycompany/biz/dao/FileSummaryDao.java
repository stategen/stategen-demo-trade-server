/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.FileSummary;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.lite.IdGenerateService;

/**
 * FileSummaryDao
 * <pre>
 * database table: file_summary
 * database table comments: FileSummary
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface FileSummaryDao {

	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) String fileId,
    &#64;ApiParam() &#64;RequestParam(required = false) String url,
    &#64;ApiParam() &#64;RequestParam(required = false) Long size,
    &#64;ApiParam() &#64;RequestParam(required = false) String name,
    &#64;ApiParam() &#64;RequestParam(required = false) String type,
    &#64;ApiParam() &#64;RequestParam(required = false) String userId
    ,&#64;ApiParam(hidden = true) FileSummary fileSummary
    
    </pre>
	 * 
	 * sql:insert into file_summary ( create_time , update_time , delete_flag , file_id , url , size , name , type , user_id ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?,?)
	 */
	public FileSummary insert(FileSummary fileSummary, IdGenerateService<String> idGenerateService) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("fileId") &#64;RequestParam(required = false) String fileId    
    </pre>
	 * 
	 * sql:UPDATE file_summary a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.file_id = ?
	 */
	public String delete(String fileId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) String url,
    &#64;ApiParam() &#64;RequestParam(required = false) Long size,
    &#64;ApiParam() &#64;RequestParam(required = false) String name,
    &#64;ApiParam() &#64;RequestParam(required = false) String type,
    &#64;ApiParam() &#64;RequestParam(required = false) String userId,
    &#64;ApiParam() &#64;RequestParam(required = false) String fileId
    ,&#64;ApiParam(hidden = true) FileSummary fileSummary
    
    </pre>
	 * 
	 * sql:UPDATE file_summary a SET a.update_time= CURRENT_TIMESTAMP(6) , a.url = ? , a.size = ? , a.name = ? , a.type = ? , a.user_id = ? where a.delete_flag = 0 and a.file_id = ?
	 */
	public FileSummary update(FileSummary fileSummary) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("fileId") &#64;RequestParam(required = false) String fileId    
    </pre>
	 * 
	 * sql:select a.file_id, a.url, a.size, a.name, a.type, a.user_id, a.create_time, a.update_time, a.delete_flag from file_summary a where a.delete_flag = 0 and a.file_id = ?
	 */
	public FileSummary getFileSummaryByFileId(String fileId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) String fileId,
    &#64;ApiParam() &#64;RequestParam(required = false, name="fileIds") ArrayList&lt;String&gt; fileIds,
    &#64;ApiParam() &#64;RequestParam(required = false) Long size,
    &#64;ApiParam() &#64;RequestParam(required = false) Long sizeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Long sizeMax,
    &#64;ApiParam() &#64;RequestParam(required = false) String name,
    &#64;ApiParam() &#64;RequestParam(required = false) String nameLike,
    &#64;ApiParam() &#64;RequestParam(required = false) String type,
    &#64;ApiParam() &#64;RequestParam(required = false) String typeLike,
    &#64;ApiParam() &#64;RequestParam(required = false) String userId,
    &#64;ApiParam() &#64;RequestParam(required = false, name="userIds") ArrayList&lt;String&gt; userIds,
    &#64;ApiParam() &#64;RequestParam(required = false) Date createTimeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Date createTimeMax,
    &#64;ApiParam() &#64;RequestParam(required = false) Date updateTimeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Date updateTimeMax
    ,&#64;ApiParam(hidden = true) FileSummary fileSummary
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.file_id, a.url, a.size, a.name, a.type, a.user_id, a.create_time, a.update_time, a.delete_flag from file_summary a where a.delete_flag = 0 and a.file_id=? and a.file_id in ( ? ) and a.size=? and a.size >=? and a.size <? and a.name=? and a.name like CONCAT('%',?,'%') and a.type=? and a.type like CONCAT('%',?,'%') and a.user_id=? and a.user_id in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<FileSummary> getPageList(FileSummary fileSummary, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("fileId") &#64;RequestParam(required = false, name="fileIds") ArrayList&lt;String&gt; fileIds    
    </pre>
	 * 
	 * sql:select a.file_id, a.url, a.size, a.name, a.type, a.user_id, a.create_time, a.update_time, a.delete_flag from file_summary a where a.delete_flag = 0 and 1=0 and a.file_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<FileSummary> getFileSummarysByFileIds(java.util.List<String> fileIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("fileId") &#64;RequestParam(required = false, name="fileIds") ArrayList&lt;String&gt; fileIds    
    </pre>
	 * 
	 * sql:UPDATE file_summary a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.file_id in ( ? )
	 */
	public java.util.List<String> deleteByFileIds(java.util.List<String> fileIds) throws DataAccessException;
	

}



