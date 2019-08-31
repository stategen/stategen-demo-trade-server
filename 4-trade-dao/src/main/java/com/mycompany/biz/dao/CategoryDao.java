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
 * database table: category
 * database table comments: Category
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface CategoryDao {

	/**
    <pre>
    &#64;ApiParam() String mallCategoryId,
    &#64;ApiParam() String mallCategoryName,
    &#64;ApiParam() String comments,
    &#64;ApiParam() String image
    ,&#64;ApiParam(hidden = true) Category category
    
    </pre>
	 * 
	 * sql:insert into category ( create_time , update_time , delete_flag , mall_category_id , mall_category_name , comments , image ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?)
	 */
	public Category insert(Category category) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("大类目录ID") String mallCategoryId
    
    </pre>
	 * 
	 * sql:UPDATE category SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and mall_category_id = ?
	 */
	public String delete(String mallCategoryId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String mallCategoryName,
    &#64;ApiParam() String comments,
    &#64;ApiParam() String image,
    &#64;ApiParam() String mallCategoryId
    ,&#64;ApiParam(hidden = true) Category category
    
    </pre>
	 * 
	 * sql:UPDATE category SET update_time= CURRENT_TIMESTAMP(6) , mall_category_name = ? , comments = ? , image = ? where delete_flag = 0 and mall_category_id = ?
	 */
	public Category update(Category category) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("大类目录ID") String mallCategoryId
    
    </pre>
	 * 
	 * sql:select a.mall_category_id, a.mall_category_name, a.comments, a.image, a.create_time, a.update_time, a.delete_flag from category a where a.delete_flag = 0 and a.mall_category_id = ?
	 */
	public Category getCategoryByMallCategoryId(String mallCategoryId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String mallCategoryId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="mallCategoryIds") ArrayList&lt;String&gt; mallCategoryIds,
    &#64;ApiParam() String mallCategoryName,
    &#64;ApiParam() String mallCategoryNameLike,
    &#64;ApiParam() String comments,
    &#64;ApiParam() String commentsLike,
    &#64;ApiParam() Date createTimeMin,
    &#64;ApiParam() Date createTimeMax,
    &#64;ApiParam() Date updateTimeMin,
    &#64;ApiParam() Date updateTimeMax
    ,&#64;ApiParam(hidden = true) Category category
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.mall_category_id, a.mall_category_name, a.comments, a.image, a.create_time, a.update_time, a.delete_flag from category a where a.delete_flag = 0 and a.mall_category_id=? and a.mall_category_id in ( ? ) and a.mall_category_name=? and a.mall_category_name like CONCAT('%',?,'%') and a.comments=? and a.comments like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.mall_category_id
	 */
	public PageList<Category> getPageList(Category category, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("大类目录ID")&#64;RequestParam(required =false,name="mallCategoryIds") ArrayList&lt;String&gt; mallCategoryIds
    
    </pre>
	 * 
	 * sql:select a.mall_category_id, a.mall_category_name, a.comments, a.image, a.create_time, a.update_time, a.delete_flag from category a where a.delete_flag = 0 and 1=0 and a.mall_category_id in ( ? ) order by a.mall_category_id
	 */
	public List<Category> getCategorysByMallCategoryIds(java.util.List<String> mallCategoryIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("大类目录ID")&#64;RequestParam(required =false,name="mallCategoryIds") ArrayList&lt;String&gt; mallCategoryIds
    
    </pre>
	 * 
	 * sql:UPDATE category SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and mall_category_id in ( ? )
	 */
	public java.util.List<String> deleteByMallCategoryIds(java.util.List<String> mallCategoryIds) throws DataAccessException;
	

}


