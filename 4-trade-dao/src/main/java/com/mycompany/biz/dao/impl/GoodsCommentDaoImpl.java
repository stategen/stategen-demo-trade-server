/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.GoodsComment;
import com.mycompany.biz.dao.GoodsCommentDao;
import org.stategen.framework.ibatis.util.PageQueryUtils;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * GoodsCommentDao
 * <pre>
 * database table: goods_comment
 * database table comments: GoodsComment
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class GoodsCommentDaoImpl  extends SqlMapClientDaoSupport implements GoodsCommentDao {

	/**
	 * 
	 * sql:insert into goods_comment ( create_time , update_time , delete_flag , comments_id , goods_id , comments , user_name , discuss_time , score ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?,?)
	 */
	public GoodsComment insert(GoodsComment goodsComment) throws DataAccessException {
		if(goodsComment == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        getSqlMapClientTemplate().insert("insert.GoodsComment.trade", goodsComment);
		return goodsComment;
	}

	/**
	 * 
	 * sql:UPDATE goods_comment SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and comments_id = ?
	 */
	public String delete(String commentsId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("commentsId",commentsId);
        getSqlMapClientTemplate().update("delete.GoodsComment.trade", params);
        return commentsId;
	}

	/**
	 * 
	 * sql:UPDATE goods_comment SET update_time= CURRENT_TIMESTAMP(6) , goods_id = ? , comments = ? , user_name = ? , discuss_time = ? , score = ? where delete_flag = 0 and comments_id = ?
	 */
	public GoodsComment update(GoodsComment goodsComment) throws DataAccessException {
		if(goodsComment == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        getSqlMapClientTemplate().update("update.GoodsComment.trade", goodsComment);
		return goodsComment;
	}

	/**
	 * 
	 * sql:select a.comments_id, a.goods_id, a.comments, a.user_name, a.discuss_time, a.score, a.create_time, a.update_time, a.delete_flag from goods_comment a where a.delete_flag = 0 and a.comments_id = ?
	 */
	public GoodsComment getGoodsCommentByCommentsId(String commentsId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("commentsId",commentsId);
		return (GoodsComment)getSqlMapClientTemplate().queryForObject("getGoodsCommentByCommentsId.GoodsComment.trade",params);
	}

	/**
	 * 
	 * sql:select a.comments_id, a.goods_id, a.comments, a.user_name, a.discuss_time, a.score, a.create_time, a.update_time, a.delete_flag from goods_comment a where a.delete_flag = 0 and a.comments_id=? and a.comments_id in ( ? ) and a.goods_id=? and a.goods_id in ( ? ) and a.comments=? and a.comments like CONCAT('%',?,'%') and a.user_name=? and a.user_name like CONCAT('%',?,'%') and a.discuss_time >=? and a.discuss_time <? and a.score >=? and a.score <? and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
    @SuppressWarnings("unchecked")
	public PageList<GoodsComment> getPageList(GoodsComment goodsComment, int pageSize, int pageNum) throws DataAccessException {
		return (PageList<GoodsComment>)PageQueryUtils.pageQuery(getSqlMapClientTemplate(),"getPageList.GoodsComment.trade",goodsComment,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.comments_id, a.goods_id, a.comments, a.user_name, a.discuss_time, a.score, a.create_time, a.update_time, a.delete_flag from goods_comment a where a.delete_flag = 0 and 1=0 and a.comments_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
    @SuppressWarnings("unchecked")
	public List<GoodsComment> getGoodsCommentsByCommentsIds(java.util.List<String> commentsIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("commentsIds",commentsIds);
		return (List<GoodsComment>)getSqlMapClientTemplate().queryForList("getGoodsCommentsByCommentsIds.GoodsComment.trade",params);
	}

	/**
	 * 
	 * sql:UPDATE goods_comment SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and comments_id in ( ? )
	 */
	public java.util.List<String> deleteByCommentsIds(java.util.List<String> commentsIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("commentsIds",commentsIds);
        getSqlMapClientTemplate().update("deleteByCommentsIds.GoodsComment.trade", params);
        return commentsIds;
	}

}

