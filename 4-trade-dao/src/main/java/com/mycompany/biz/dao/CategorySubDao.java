/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.CategorySub;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;

/**
 * CategorySubDao
 * <pre>
 * database table: category_sub
 * database table comments: CategorySub
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface CategorySubDao {

	/**
    <pre>
    &#64;ApiParam() String mallSubId,
    &#64;ApiParam() String mallCategoryId,
    &#64;ApiParam() String mallSubName,
    &#64;ApiParam() String comments
    ,&#64;ApiParam(hidden = true) CategorySub categorySub
    
    </pre>
	 * 
	 * sql:insert into category_sub ( create_time , update_time , delete_flag , mall_sub_id , mall_category_id , mall_sub_name , comments ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?)
	 */
	public CategorySub insert(CategorySub categorySub) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("mallSubId") String mallSubId
    
    </pre>
	 * 
	 * sql:UPDATE category_sub SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and mall_sub_id = ?
	 */
	public String delete(String mallSubId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String mallCategoryId,
    &#64;ApiParam() String mallSubName,
    &#64;ApiParam() String comments,
    &#64;ApiParam() String mallSubId
    ,&#64;ApiParam(hidden = true) CategorySub categorySub
    
    </pre>
	 * 
	 * sql:UPDATE category_sub SET update_time= CURRENT_TIMESTAMP(6) , mall_category_id = ? , mall_sub_name = ? , comments = ? where delete_flag = 0 and mall_sub_id = ?
	 */
	public CategorySub update(CategorySub categorySub) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("mallSubId") String mallSubId
    
    </pre>
	 * 
	 * sql:select a.mall_sub_id, a.mall_category_id, a.mall_sub_name, a.comments, a.create_time, a.update_time, a.delete_flag from category_sub a where a.delete_flag = 0 and a.mall_sub_id = ?
	 */
	public CategorySub getCategorySubByMallSubId(String mallSubId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String mallSubId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="mallSubIds") ArrayList&lt;String&gt; mallSubIds,
    &#64;ApiParam() String mallCategoryId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="mallCategoryIds") ArrayList&lt;String&gt; mallCategoryIds,
    &#64;ApiParam() String mallSubName,
    &#64;ApiParam() String mallSubNameLike,
    &#64;ApiParam() String comments,
    &#64;ApiParam() String commentsLike,
    &#64;ApiParam() Date createTimeMin,
    &#64;ApiParam() Date createTimeMax,
    &#64;ApiParam() Date updateTimeMin,
    &#64;ApiParam() Date updateTimeMax
    ,&#64;ApiParam(hidden = true) CategorySub categorySub
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.mall_sub_id, a.mall_category_id, a.mall_sub_name, a.comments, a.create_time, a.update_time, a.delete_flag from category_sub a where a.delete_flag = 0 and a.mall_sub_id=? and a.mall_sub_id in ( ? ) and a.mall_category_id=? and a.mall_category_id in ( ? ) and a.mall_sub_name=? and a.mall_sub_name like CONCAT('%',?,'%') and a.comments=? and a.comments like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.mall_sub_id
	 */
	public PageList<CategorySub> getPageList(CategorySub categorySub, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("mallSubId")&#64;RequestParam(required =false,name="mallSubIds") ArrayList&lt;String&gt; mallSubIds
    
    </pre>
	 * 
	 * sql:select a.mall_sub_id, a.mall_category_id, a.mall_sub_name, a.comments, a.create_time, a.update_time, a.delete_flag from category_sub a where a.delete_flag = 0 and 1=0 and a.mall_sub_id in ( ? ) order by a.mall_sub_id
	 */
	public List<CategorySub> getCategorySubsByMallSubIds(java.util.List<String> mallSubIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("mallSubId")&#64;RequestParam(required =false,name="mallSubIds") ArrayList&lt;String&gt; mallSubIds
    
    </pre>
	 * 
	 * sql:UPDATE category_sub SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and mall_sub_id in ( ? )
	 */
	public java.util.List<String> deleteByMallSubIds(java.util.List<String> mallSubIds) throws DataAccessException;
	

}



