/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.City;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.lite.IdGenerateService;

/**
 * CityDao
 * @author StageGen.org
 * <pre>
 * database table: demo_city
 * database table comments: City
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface CityDao {

	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) String cityId,
    &#64;ApiParam() &#64;RequestParam(required = false) String name,
    &#64;ApiParam() &#64;RequestParam(required = false) String pycode,
    &#64;ApiParam() &#64;RequestParam(required = false) String provinceId,
    &#64;ApiParam() &#64;RequestParam(required = false) String postcode,
    &#64;ApiParam() &#64;RequestParam(required = false) String areacode
    ,&#64;ApiParam(hidden = true) City city
    
    </pre>
	 * 
	 * sql:insert into demo_city ( create_time , update_time , delete_flag , city_id , name , pycode , province_id , postcode , areacode ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?,?)
	 */
	public City insert(City city, IdGenerateService<String> idGenerateService) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("cityId") &#64;RequestParam(required = false) String cityId    
    </pre>
	 * 
	 * sql:UPDATE demo_city a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.city_id = ?
	 */
	public String delete(String cityId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) String name,
    &#64;ApiParam() &#64;RequestParam(required = false) String pycode,
    &#64;ApiParam() &#64;RequestParam(required = false) String provinceId,
    &#64;ApiParam() &#64;RequestParam(required = false) String postcode,
    &#64;ApiParam() &#64;RequestParam(required = false) String areacode,
    &#64;ApiParam() &#64;RequestParam(required = false) String cityId
    ,&#64;ApiParam(hidden = true) City city
    
    </pre>
	 * 
	 * sql:UPDATE demo_city a SET a.update_time= CURRENT_TIMESTAMP(6) , a.name = ? , a.pycode = ? , a.province_id = ? , a.postcode = ? , a.areacode = ? where a.delete_flag = 0 and a.city_id = ?
	 */
	public City update(City city) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("cityId") &#64;RequestParam(required = false) String cityId    
    </pre>
	 * 
	 * sql:select a.city_id, a.name, a.pycode, a.province_id, a.postcode, a.areacode, a.create_time, a.update_time, a.delete_flag from demo_city a where a.delete_flag = 0 and a.city_id = ?
	 */
	public City getCityByCityId(String cityId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() &#64;RequestParam(required = false) String cityId,
    &#64;ApiParam() &#64;RequestParam(required = false, name="cityIds") ArrayList&lt;String&gt; cityIds,
    &#64;ApiParam() &#64;RequestParam(required = false) String name,
    &#64;ApiParam() &#64;RequestParam(required = false) String nameLike,
    &#64;ApiParam() &#64;RequestParam(required = false) String pycode,
    &#64;ApiParam() &#64;RequestParam(required = false) String pycodeLike,
    &#64;ApiParam() &#64;RequestParam(required = false) String provinceId,
    &#64;ApiParam() &#64;RequestParam(required = false, name="provinceIds") ArrayList&lt;String&gt; provinceIds,
    &#64;ApiParam() &#64;RequestParam(required = false) String postcode,
    &#64;ApiParam() &#64;RequestParam(required = false) String postcodeLike,
    &#64;ApiParam() &#64;RequestParam(required = false) String areacode,
    &#64;ApiParam() &#64;RequestParam(required = false) String areacodeLike,
    &#64;ApiParam() &#64;RequestParam(required = false) Date createTimeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Date createTimeMax,
    &#64;ApiParam() &#64;RequestParam(required = false) Date updateTimeMin,
    &#64;ApiParam() &#64;RequestParam(required = false) Date updateTimeMax
    ,&#64;ApiParam(hidden = true) City city
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.city_id, a.name, a.pycode, a.province_id, a.postcode, a.areacode, a.create_time, a.update_time, a.delete_flag from demo_city a where a.delete_flag = 0 and a.city_id=? and a.city_id in ( ? ) and a.name=? and a.name like CONCAT('%',?,'%') and a.pycode=? and a.pycode like CONCAT('%',?,'%') and a.province_id=? and a.province_id in ( ? ) and a.postcode=? and a.postcode like CONCAT('%',?,'%') and a.areacode=? and a.areacode like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<City> getPageList(City city, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("cityId") &#64;RequestParam(required = false, name="cityIds") ArrayList&lt;String&gt; cityIds    
    </pre>
	 * 
	 * sql:select a.city_id, a.name, a.pycode, a.province_id, a.postcode, a.areacode, a.create_time, a.update_time, a.delete_flag from demo_city a where a.delete_flag = 0 and 1=0 and a.city_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<City> getCitysByCityIds(java.util.List<String> cityIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("cityId") &#64;RequestParam(required = false, name="cityIds") ArrayList&lt;String&gt; cityIds    
    </pre>
	 * 
	 * sql:UPDATE demo_city a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.city_id in ( ? )
	 */
	public java.util.List<String> deleteByCityIds(java.util.List<String> cityIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("provinceId") &#64;RequestParam(required = false) String provinceId    
    </pre>
	 * 
	 * sql:select a.city_id, a.name, a.province_id from demo_city a where a.delete_flag = 0 and a.province_id = ?
	 */
	public List<City> getCityOptions(String provinceId) throws DataAccessException;
	

}



