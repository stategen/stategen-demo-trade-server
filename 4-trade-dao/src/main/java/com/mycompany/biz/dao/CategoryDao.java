/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.Category;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;

/**
 * CategoryDao
 * <pre>
 * database table: demo_category
 * database table comments: Category
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface CategoryDao {

	/**
    <pre>
    &#64;ApiParam() String categoryId,
    &#64;ApiParam() String categoryName,
    &#64;ApiParam() String comments,
    &#64;ApiParam() String image
    ,&#64;ApiParam(hidden = true) Category category
    
    </pre>
	 * 
	 * sql:insert into demo_category ( create_time , update_time , delete_flag , category_id , category_name , comments , image ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?)
	 */
	public Category insert(Category category) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("大类目录ID") String categoryId
    
    </pre>
	 * 
	 * sql:UPDATE demo_category SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and category_id = ?
	 */
	public String delete(String categoryId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String categoryName,
    &#64;ApiParam() String comments,
    &#64;ApiParam() String image,
    &#64;ApiParam() String categoryId
    ,&#64;ApiParam(hidden = true) Category category
    
    </pre>
	 * 
	 * sql:UPDATE demo_category SET update_time= CURRENT_TIMESTAMP(6) , category_name = ? , comments = ? , image = ? where delete_flag = 0 and category_id = ?
	 */
	public Category update(Category category) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("大类目录ID") String categoryId
    
    </pre>
	 * 
	 * sql:select a.category_id, a.category_name, a.comments, a.image, a.create_time, a.update_time, a.delete_flag from demo_category a where a.delete_flag = 0 and a.category_id = ?
	 */
	public Category getCategoryByCategoryId(String categoryId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String categoryId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="categoryIds") ArrayList&lt;String&gt; categoryIds,
    &#64;ApiParam() String categoryName,
    &#64;ApiParam() String categoryNameLike,
    &#64;ApiParam() Date createTimeMin,
    &#64;ApiParam() Date createTimeMax,
    &#64;ApiParam() Date updateTimeMin,
    &#64;ApiParam() Date updateTimeMax
    ,&#64;ApiParam(hidden = true) Category category
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.category_id, a.category_name, a.comments, a.image, a.create_time, a.update_time, a.delete_flag from demo_category a where a.delete_flag = 0 and a.category_id=? and a.category_id in ( ? ) and a.category_name=? and a.category_name like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<Category> getPageList(Category category, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("大类目录ID")&#64;RequestParam(required =false,name="categoryIds") ArrayList&lt;String&gt; categoryIds
    
    </pre>
	 * 
	 * sql:select a.category_id, a.category_name, a.comments, a.image, a.create_time, a.update_time, a.delete_flag from demo_category a where a.delete_flag = 0 and 1=0 and a.category_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<Category> getCategorysByCategoryIds(java.util.List<String> categoryIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("大类目录ID")&#64;RequestParam(required =false,name="categoryIds") ArrayList&lt;String&gt; categoryIds
    
    </pre>
	 * 
	 * sql:UPDATE demo_category SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and category_id in ( ? )
	 */
	public java.util.List<String> deleteByCategoryIds(java.util.List<String> categoryIds) throws DataAccessException;
	

}



