/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.Goods;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;

/**
 * GoodsDao
 * <pre>
 * database table: goods
 * database table comments: Goods
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface GoodsDao {

	/**
    <pre>
    &#64;ApiParam() String goodsId,
    &#64;ApiParam() String goodsName,
    &#64;ApiParam() String categorySubId,
    &#64;ApiParam() Long amount,
    &#64;ApiParam() BigDecimal price,
    &#64;ApiParam() String images,
    &#64;ApiParam() Boolean isCheck,
    &#64;ApiParam() Boolean isHot,
    &#64;ApiParam() Long advertiseId,
    &#64;ApiParam() BigDecimal presentPrice,
    &#64;ApiParam() String image,
    &#64;ApiParam() String image1,
    &#64;ApiParam() String image2,
    &#64;ApiParam() String image3,
    &#64;ApiParam() String image4,
    &#64;ApiParam() String image5,
    &#64;ApiParam() String isOnLine,
    &#64;ApiParam() String goodsSerialNumber,
    &#64;ApiParam() Integer state,
    &#64;ApiParam() String shopId,
    &#64;ApiParam() String goodsDetail
    ,&#64;ApiParam(hidden = true) Goods goods
    
    </pre>
	 * 
	 * sql:insert into goods ( create_time , update_time , delete_flag , goods_id , goods_name , categorySubId , amount , price , images , is_check , is_hot , advertise_id , present_price , image , image1 , image2 , image3 , image4 , image5 , is_on_line , goods_serial_number , state , shop_id , goods_detail ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
	 */
	public Goods insert(Goods goods) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("商品ID") String goodsId
    
    </pre>
	 * 
	 * sql:UPDATE goods SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and goods_id = ?
	 */
	public String delete(String goodsId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String goodsName,
    &#64;ApiParam() String categorySubId,
    &#64;ApiParam() Long amount,
    &#64;ApiParam() BigDecimal price,
    &#64;ApiParam() String images,
    &#64;ApiParam() Boolean isCheck,
    &#64;ApiParam() Boolean isHot,
    &#64;ApiParam() Long advertiseId,
    &#64;ApiParam() BigDecimal presentPrice,
    &#64;ApiParam() String image,
    &#64;ApiParam() String image1,
    &#64;ApiParam() String image2,
    &#64;ApiParam() String image3,
    &#64;ApiParam() String image4,
    &#64;ApiParam() String image5,
    &#64;ApiParam() String isOnLine,
    &#64;ApiParam() String goodsSerialNumber,
    &#64;ApiParam() Integer state,
    &#64;ApiParam() String shopId,
    &#64;ApiParam() String goodsDetail,
    &#64;ApiParam() String goodsId
    ,&#64;ApiParam(hidden = true) Goods goods
    
    </pre>
	 * 
	 * sql:UPDATE goods SET update_time= CURRENT_TIMESTAMP(6) , goods_name = ? , categorySubId = ? , amount = ? , price = ? , images = ? , is_check = ? , is_hot = ? , advertise_id = ? , present_price = ? , image = ? , image1 = ? , image2 = ? , image3 = ? , image4 = ? , image5 = ? , is_on_line = ? , goods_serial_number = ? , state = ? , shop_id = ? , goods_detail = ? where delete_flag = 0 and goods_id = ?
	 */
	public Goods update(Goods goods) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("商品ID") String goodsId
    
    </pre>
	 * 
	 * sql:select a.goods_id, a.goods_name, a.categorySubId, a.amount, a.price, a.images, a.is_check, a.is_hot, a.advertise_id, a.present_price, a.image, a.image1, a.image2, a.image3, a.image4, a.image5, a.is_on_line, a.goods_serial_number, a.state, a.shop_id, a.goods_detail, a.create_time, a.update_time, a.delete_flag from goods a where a.delete_flag = 0 and a.goods_id = ?
	 */
	public Goods getGoodByGoodsId(String goodsId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() String goodsId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="goodsIds") ArrayList&lt;String&gt; goodsIds,
    &#64;ApiParam() String goodsName,
    &#64;ApiParam() String goodsNameLike,
    &#64;ApiParam() String categorySubId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="categorySubIds") ArrayList&lt;String&gt; categorySubIds,
    &#64;ApiParam() Long amountMin,
    &#64;ApiParam() Long amountMax,
    &#64;ApiParam() BigDecimal priceMin,
    &#64;ApiParam() BigDecimal priceMax,
    &#64;ApiParam() String images,
    &#64;ApiParam() String imagesLike,
    &#64;ApiParam() Long advertiseId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="advertiseIds") ArrayList&lt;Long&gt; advertiseIds,
    &#64;ApiParam() BigDecimal presentPriceMin,
    &#64;ApiParam() BigDecimal presentPriceMax,
    &#64;ApiParam() String image1,
    &#64;ApiParam() String image1Like,
    &#64;ApiParam() String image2,
    &#64;ApiParam() String image2Like,
    &#64;ApiParam() String image3,
    &#64;ApiParam() String image3Like,
    &#64;ApiParam() String image4,
    &#64;ApiParam() String image4Like,
    &#64;ApiParam() String image5,
    &#64;ApiParam() String image5Like,
    &#64;ApiParam() String isOnLine,
    &#64;ApiParam() String isOnLineLike,
    &#64;ApiParam() String goodsSerialNumber,
    &#64;ApiParam() String goodsSerialNumberLike,
    &#64;ApiParam() Integer stateMin,
    &#64;ApiParam() Integer stateMax,
    &#64;ApiParam() String shopId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="shopIds") ArrayList&lt;String&gt; shopIds,
    &#64;ApiParam() String goodsDetail,
    &#64;ApiParam() String goodsDetailLike,
    &#64;ApiParam() Date createTimeMin,
    &#64;ApiParam() Date createTimeMax,
    &#64;ApiParam() Date updateTimeMin,
    &#64;ApiParam() Date updateTimeMax
    ,&#64;ApiParam(hidden = true) Goods goods
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.goods_id, a.goods_name, a.categorySubId, a.amount, a.price, a.images, a.is_check, a.is_hot, a.advertise_id, a.present_price, a.image, a.image1, a.image2, a.image3, a.image4, a.image5, a.is_on_line, a.goods_serial_number, a.state, a.shop_id, a.goods_detail, a.create_time, a.update_time, a.delete_flag from goods a where a.delete_flag = 0 and a.goods_id=? and a.goods_id in ( ? ) and a.goods_name=? and a.goods_name like CONCAT('%',?,'%') and a.categorySubId=? and a.categorySubId in ( ? ) and a.amount >=? and a.amount <? and a.price >=? and a.price <? and a.images=? and a.images like CONCAT('%',?,'%') and a.advertise_id=? and a.advertise_id in ( ? ) and a.present_price >=? and a.present_price <? and a.image1=? and a.image1 like CONCAT('%',?,'%') and a.image2=? and a.image2 like CONCAT('%',?,'%') and a.image3=? and a.image3 like CONCAT('%',?,'%') and a.image4=? and a.image4 like CONCAT('%',?,'%') and a.image5=? and a.image5 like CONCAT('%',?,'%') and a.is_on_line=? and a.is_on_line like CONCAT('%',?,'%') and a.goods_serial_number=? and a.goods_serial_number like CONCAT('%',?,'%') and a.state >=? and a.state <? and a.shop_id=? and a.shop_id in ( ? ) and a.goods_detail=? and a.goods_detail like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.goods_id
	 */
	public PageList<Goods> getPageList(Goods goods, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("商品ID")&#64;RequestParam(required =false,name="goodsIds") ArrayList&lt;String&gt; goodsIds
    
    </pre>
	 * 
	 * sql:select a.goods_id, a.goods_name, a.categorySubId, a.amount, a.price, a.images, a.is_check, a.is_hot, a.advertise_id, a.present_price, a.image, a.image1, a.image2, a.image3, a.image4, a.image5, a.is_on_line, a.goods_serial_number, a.state, a.shop_id, a.goods_detail, a.create_time, a.update_time, a.delete_flag from goods a where a.delete_flag = 0 and 1=0 and a.goods_id in ( ? ) order by a.goods_id
	 */
	public List<Goods> getGoodsByGoodsIds(java.util.List<String> goodsIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("商品ID")&#64;RequestParam(required =false,name="goodsIds") ArrayList&lt;String&gt; goodsIds
    
    </pre>
	 * 
	 * sql:UPDATE goods SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and goods_id in ( ? )
	 */
	public java.util.List<String> deleteByGoodsIds(java.util.List<String> goodsIds) throws DataAccessException;
	
	/**
    <pre>
    
    </pre>
	 * 
	 * sql:select a.goods_id from goods a where a.delete_flag = 0
	 */
	public List<String> getGoodsIds() throws DataAccessException;
	

}


