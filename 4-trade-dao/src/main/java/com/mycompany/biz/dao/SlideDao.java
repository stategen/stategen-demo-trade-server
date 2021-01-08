/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.Slide;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.lite.IdGenerateService;

/**
 * SlideDao
 * @author StageGen.org
 * <pre>
 * database table: demo_slide
 * database table comments: Slide
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface SlideDao {

	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) String slideId,
    &#64;ApiParam() &#64;RequestParam(required = false) String goodsId,
    &#64;ApiParam() &#64;RequestParam(required = false) String image,
    &#64;ApiParam() &#64;RequestParam(required = false) Integer urlType,
    &#64;ApiParam() &#64;RequestParam(required = false) Integer orderNo
    ,&#64;ApiParam(hidden = true) Slide slide
    
    </pre>
	 * 
	 * sql:insert into demo_slide ( create_time , update_time , delete_flag , slide_id , goods_id , image , urlType , order_no ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?)
	 */
	public Slide insert(Slide slide, IdGenerateService<String> idGenerateService) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("slideId") &#64;RequestParam(required = false) String slideId    
    </pre>
	 * 
	 * sql:UPDATE demo_slide a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.slide_id = ?
	 */
	public String delete(String slideId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) String goodsId,
    &#64;ApiParam() &#64;RequestParam(required = false) String image,
    &#64;ApiParam() &#64;RequestParam(required = false) Integer urlType,
    &#64;ApiParam() &#64;RequestParam(required = false) Integer orderNo,
    &#64;ApiParam() &#64;RequestParam(required = false) String slideId
    ,&#64;ApiParam(hidden = true) Slide slide
    
    </pre>
	 * 
	 * sql:UPDATE demo_slide a SET a.update_time= CURRENT_TIMESTAMP(6) , a.goods_id = ? , a.image = ? , a.urlType = ? , a.order_no = ? where a.delete_flag = 0 and a.slide_id = ?
	 */
	public Slide update(Slide slide) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("slideId") &#64;RequestParam(required = false) String slideId    
    </pre>
	 * 
	 * sql:select a.slide_id, a.goods_id, a.image, a.urlType, a.order_no, a.create_time, a.update_time, a.delete_flag from demo_slide a where a.delete_flag = 0 and a.slide_id = ?
	 */
	public Slide getSlideBySlideId(String slideId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) String slideId,
    &#64;ApiParam() &#64;RequestParam(required = false, name="slideIds") ArrayList&lt;String&gt; slideIds,
    &#64;ApiParam() &#64;RequestParam(required = false) String goodsId,
    &#64;ApiParam() &#64;RequestParam(required = false, name="goodsIds") ArrayList&lt;String&gt; goodsIds,
    &#64;ApiParam() &#64;RequestParam(required = false) Integer urlType,
    &#64;ApiParam() &#64;RequestParam(required = false) Integer urlTypeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Integer urlTypeMax,
    &#64;ApiParam() &#64;RequestParam(required = false) Integer orderNo,
    &#64;ApiParam() &#64;RequestParam(required = false, name="orderNos") ArrayList&lt;Integer&gt; orderNos,
    &#64;ApiParam() &#64;RequestParam(required = false) Date createTimeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Date createTimeMax,
    &#64;ApiParam() &#64;RequestParam(required = false) Date updateTimeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Date updateTimeMax
    ,&#64;ApiParam(hidden = true) Slide slide
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.slide_id, a.goods_id, a.image, a.urlType, a.order_no, a.create_time, a.update_time, a.delete_flag from demo_slide a where a.delete_flag = 0 and a.slide_id=? and a.slide_id in ( ? ) and a.goods_id=? and a.goods_id in ( ? ) and a.urlType=? and a.urlType >=? and a.urlType <? and a.order_no=? and a.order_no in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<Slide> getPageList(Slide slide, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("slideId") &#64;RequestParam(required = false, name="slideIds") ArrayList&lt;String&gt; slideIds    
    </pre>
	 * 
	 * sql:select a.slide_id, a.goods_id, a.image, a.urlType, a.order_no, a.create_time, a.update_time, a.delete_flag from demo_slide a where a.delete_flag = 0 and 1=0 and a.slide_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<Slide> getSlidesBySlideIds(java.util.List<String> slideIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("slideId") &#64;RequestParam(required = false, name="slideIds") ArrayList&lt;String&gt; slideIds    
    </pre>
	 * 
	 * sql:UPDATE demo_slide a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.slide_id in ( ? )
	 */
	public java.util.List<String> deleteBySlideIds(java.util.List<String> slideIds) throws DataAccessException;
	

}



