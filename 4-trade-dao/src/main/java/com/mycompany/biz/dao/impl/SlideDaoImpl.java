/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */    
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.Slide;
import com.mycompany.biz.dao.SlideDao;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.IdGenerateService;
/**
 * SlideDao
 * <pre>
 * database table: demo_slide
 * database table comments: Slide
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class SlideDaoImpl  extends SqlDaoSupportBase implements SlideDao {


	/**
	 * 
	 * sql:insert into demo_slide ( create_time , update_time , delete_flag , slide_id , goods_id , image , urlType , order_no ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?)
	 */
	public Slide insert(Slide slide, IdGenerateService<String> idGenerateService) throws DataAccessException {
		if(slide == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        if (idGenerateService != null && slide.getSlideId() == null) {
            String slideId = idGenerateService.generateId();
            if (slideId != null) {
                slide.setSlideId(slideId);
            }
        }
        super.insert("Slide.insert", slide);
		return slide;
	}

	/**
	 * 
	 * sql:UPDATE demo_slide a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.slide_id = ?
	 */
	public String delete(String slideId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("slideId",slideId);
        super.update("Slide.delete", params);
        return slideId;
	}

	/**
	 * 
	 * sql:UPDATE demo_slide a SET a.update_time= CURRENT_TIMESTAMP(6) , a.goods_id = ? , a.image = ? , a.urlType = ? , a.order_no = ? where a.delete_flag = 0 and a.slide_id = ?
	 */
	public Slide update(Slide slide) throws DataAccessException {
		if(slide == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        super.update("Slide.update", slide);
		return slide;
	}

	/**
	 * 
	 * sql:select a.slide_id, a.goods_id, a.image, a.urlType, a.order_no, a.create_time, a.update_time, a.delete_flag from demo_slide a where a.delete_flag = 0 and a.slide_id = ?
	 */
	public Slide getSlideBySlideId(String slideId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("slideId",slideId);
		return (Slide)super.selectOne("Slide.getSlideBySlideId",params);
	}

	/**
	 * 
	 * sql:select a.slide_id, a.goods_id, a.image, a.urlType, a.order_no, a.create_time, a.update_time, a.delete_flag from demo_slide a where a.delete_flag = 0 and a.slide_id=? and a.slide_id in ( ? ) and a.goods_id=? and a.goods_id in ( ? ) and a.urlType=? and a.urlType >=? and a.urlType <? and a.order_no=? and a.order_no in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<Slide> getPageList(Slide slide, int pageSize, int pageNum) throws DataAccessException {
		return super.pageQuery("Slide.getPageList",slide,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.slide_id, a.goods_id, a.image, a.urlType, a.order_no, a.create_time, a.update_time, a.delete_flag from demo_slide a where a.delete_flag = 0 and 1=0 and a.slide_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<Slide> getSlidesBySlideIds(java.util.List<String> slideIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("slideIds",slideIds);
		return super.selectList("Slide.getSlidesBySlideIds",params);
	}

	/**
	 * 
	 * sql:UPDATE demo_slide a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.slide_id in ( ? )
	 */
	public java.util.List<String> deleteBySlideIds(java.util.List<String> slideIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("slideIds",slideIds);
        super.update("Slide.deleteBySlideIds", params);
        return slideIds;
	}
}

