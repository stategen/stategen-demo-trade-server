/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.stategen.framework.ibatis.util.PageQueryUtils;
import org.stategen.framework.lite.PageList;

import com.mycompany.biz.dao.CategorySubDao;
import com.mycompany.biz.domain.CategorySub;

/**
 * CategorySubDao
 * <pre>
 * database table: demo_category_sub
 * database table comments: CategorySub
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class CategorySubDaoImpl extends SqlDaoSupportBase implements CategorySubDao {

    /**
	 * 
	 * sql:insert into demo_category_sub ( create_time , update_time , delete_flag , category_sub_id , category_id , sub_name , comments ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?)
	 */
    public CategorySub insert(CategorySub categorySub) throws DataAccessException {
        if (categorySub == null) {
            throw new IllegalArgumentException("Can't insert a null data object into db.");
        }
        super.insert("CategorySub.insert", categorySub);
        return categorySub;
    }

    /**
	 * 
	 * sql:UPDATE demo_category_sub SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and category_sub_id = ?
	 */
    public String delete(String categorySubId) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("categorySubId", categorySubId);
        super.update("CategorySub.delete", params);
        return categorySubId;
    }

    /**
	 * 
	 * sql:UPDATE demo_category_sub SET update_time= CURRENT_TIMESTAMP(6) , category_id = ? , sub_name = ? , comments = ? where delete_flag = 0 and category_sub_id = ?
	 */
    public CategorySub update(CategorySub categorySub) throws DataAccessException {
        if (categorySub == null) {
            throw new IllegalArgumentException("Can't update by a null data object.");
        }
        super.update("CategorySub.update", categorySub);
        return categorySub;
    }

    /**
	 * 
	 * sql:select a.category_sub_id, a.category_id, a.sub_name, a.comments, a.create_time, a.update_time, a.delete_flag from demo_category_sub a where a.delete_flag = 0 and a.category_sub_id = ?
	 */
    public CategorySub getCategorySubByCategorySubId(String categorySubId) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("categorySubId", categorySubId);
        return (CategorySub) super.selectOne("CategorySub.getCategorySubByCategorySubId", params);
    }

    /**
	 * 
	 * sql:select a.category_sub_id, a.category_id, a.sub_name, a.comments, a.create_time, a.update_time, a.delete_flag from demo_category_sub a where a.delete_flag = 0 and a.category_sub_id=? and a.category_sub_id in ( ? ) and a.category_id=? and a.category_id in ( ? ) and a.sub_name=? and a.sub_name like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
    public PageList<CategorySub> getPageList(CategorySub categorySub, int pageSize, int pageNum) throws DataAccessException {
        return super.pageQuery("CategorySub.getPageList", categorySub, pageNum, pageSize);
    }

    /**
	 * 
	 * sql:select a.category_sub_id, a.category_id, a.sub_name, a.comments, a.create_time, a.update_time, a.delete_flag from demo_category_sub a where a.delete_flag = 0 and 1=0 and a.category_sub_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
    public List<CategorySub> getCategorySubsByCategorySubIds(java.util.List<String> categorySubIds) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("categorySubIds", categorySubIds);
        return super.selectList("CategorySub.getCategorySubsByCategorySubIds", params);
    }

    /**
	 * 
	 * sql:UPDATE demo_category_sub SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and category_sub_id in ( ? )
	 */
    public java.util.List<String> deleteByCategorySubIds(java.util.List<String> categorySubIds) throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("categorySubIds", categorySubIds);
        super.update("CategorySub.deleteByCategorySubIds", params);
        return categorySubIds;
    }
}
