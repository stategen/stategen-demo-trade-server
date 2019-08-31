/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.CategorySub;
import com.mycompany.biz.dao.CategorySubDao;
import org.stategen.framework.ibatis.util.PageQueryUtils;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

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
public class CategorySubDaoImpl  extends SqlMapClientDaoSupport implements CategorySubDao {

	/**
	 * 
	 * sql:insert into category_sub ( create_time , update_time , delete_flag , mall_sub_id , mall_category_id , mall_sub_name , comments ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?)
	 */
	public CategorySub insert(CategorySub categorySub) throws DataAccessException {
		if(categorySub == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        getSqlMapClientTemplate().insert("insert.CategorySub.trade", categorySub);
		return categorySub;
	}

	/**
	 * 
	 * sql:UPDATE category_sub SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and mall_sub_id = ?
	 */
	public String delete(String mallSubId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("mallSubId",mallSubId);
        getSqlMapClientTemplate().update("delete.CategorySub.trade", params);
        return mallSubId;
	}

	/**
	 * 
	 * sql:UPDATE category_sub SET update_time= CURRENT_TIMESTAMP(6) , mall_category_id = ? , mall_sub_name = ? , comments = ? where delete_flag = 0 and mall_sub_id = ?
	 */
	public CategorySub update(CategorySub categorySub) throws DataAccessException {
		if(categorySub == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        getSqlMapClientTemplate().update("update.CategorySub.trade", categorySub);
		return categorySub;
	}

	/**
	 * 
	 * sql:select a.mall_sub_id, a.mall_category_id, a.mall_sub_name, a.comments, a.create_time, a.update_time, a.delete_flag from category_sub a where a.delete_flag = 0 and a.mall_sub_id = ?
	 */
	public CategorySub getCategorySubByMallSubId(String mallSubId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("mallSubId",mallSubId);
		return (CategorySub)getSqlMapClientTemplate().queryForObject("getCategorySubByMallSubId.CategorySub.trade",params);
	}

	/**
	 * 
	 * sql:select a.mall_sub_id, a.mall_category_id, a.mall_sub_name, a.comments, a.create_time, a.update_time, a.delete_flag from category_sub a where a.delete_flag = 0 and a.mall_sub_id=? and a.mall_sub_id in ( ? ) and a.mall_category_id=? and a.mall_category_id in ( ? ) and a.mall_sub_name=? and a.mall_sub_name like CONCAT('%',?,'%') and a.comments=? and a.comments like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.mall_sub_id
	 */
    @SuppressWarnings("unchecked")
	public PageList<CategorySub> getPageList(CategorySub categorySub, int pageSize, int pageNum) throws DataAccessException {
		return (PageList<CategorySub>)PageQueryUtils.pageQuery(getSqlMapClientTemplate(),"getPageList.CategorySub.trade",categorySub,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.mall_sub_id, a.mall_category_id, a.mall_sub_name, a.comments, a.create_time, a.update_time, a.delete_flag from category_sub a where a.delete_flag = 0 and 1=0 and a.mall_sub_id in ( ? ) order by a.mall_sub_id
	 */
    @SuppressWarnings("unchecked")
	public List<CategorySub> getCategorySubsByMallSubIds(java.util.List<String> mallSubIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("mallSubIds",mallSubIds);
		return (List<CategorySub>)getSqlMapClientTemplate().queryForList("getCategorySubsByMallSubIds.CategorySub.trade",params);
	}

	/**
	 * 
	 * sql:UPDATE category_sub SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and mall_sub_id in ( ? )
	 */
	public java.util.List<String> deleteByMallSubIds(java.util.List<String> mallSubIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("mallSubIds",mallSubIds);
        getSqlMapClientTemplate().update("deleteByMallSubIds.CategorySub.trade", params);
        return mallSubIds;
	}

}
