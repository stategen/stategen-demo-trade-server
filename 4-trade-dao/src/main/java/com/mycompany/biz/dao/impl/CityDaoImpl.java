/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */    
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.City;
import com.mycompany.biz.dao.CityDao;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;
import org.stategen.framework.util.IIDGenerator;
/**
 * CityDao
 * <pre>
 * database table: demo_city
 * database table comments: City
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class CityDaoImpl  extends SqlDaoSupportBase implements CityDao {


	/**
	 * 
	 * sql:insert into demo_city ( create_time , update_time , delete_flag , city_id , name , pycode , province_id , postcode , areacode ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?,?)
	 */
	public City insert(City city, IIDGenerator<String> idGenerator) throws DataAccessException {
		if(city == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        if (idGenerator != null) {
            String cityId = idGenerator.generateId();
            city.setCityId(cityId);
        }
        super.insert("City.insert", city);
		return city;
	}

	/**
	 * 
	 * sql:UPDATE demo_city a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.city_id = ?
	 */
	public String delete(String cityId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("cityId",cityId);
        super.update("City.delete", params);
        return cityId;
	}

	/**
	 * 
	 * sql:UPDATE demo_city a SET a.update_time= CURRENT_TIMESTAMP(6) , a.name = ? , a.pycode = ? , a.province_id = ? , a.postcode = ? , a.areacode = ? where a.delete_flag = 0 and a.city_id = ?
	 */
	public City update(City city) throws DataAccessException {
		if(city == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        super.update("City.update", city);
		return city;
	}

	/**
	 * 
	 * sql:select a.city_id, a.name, a.pycode, a.province_id, a.postcode, a.areacode, a.create_time, a.update_time, a.delete_flag from demo_city a where a.delete_flag = 0 and a.city_id = ?
	 */
	public City getCityByCityId(String cityId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("cityId",cityId);
		return (City)super.selectOne("City.getCityByCityId",params);
	}

	/**
	 * 
	 * sql:select a.city_id, a.name, a.pycode, a.province_id, a.postcode, a.areacode, a.create_time, a.update_time, a.delete_flag from demo_city a where a.delete_flag = 0 and a.city_id=? and a.city_id in ( ? ) and a.name=? and a.name like CONCAT('%',?,'%') and a.pycode=? and a.pycode like CONCAT('%',?,'%') and a.province_id=? and a.province_id in ( ? ) and a.postcode=? and a.postcode like CONCAT('%',?,'%') and a.areacode=? and a.areacode like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<City> getPageList(City city, int pageSize, int pageNum) throws DataAccessException {
		return super.pageQuery("City.getPageList",city,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.city_id, a.name, a.pycode, a.province_id, a.postcode, a.areacode, a.create_time, a.update_time, a.delete_flag from demo_city a where a.delete_flag = 0 and 1=0 and a.city_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<City> getCitysByCityIds(java.util.List<String> cityIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("cityIds",cityIds);
		return super.selectList("City.getCitysByCityIds",params);
	}

	/**
	 * 
	 * sql:UPDATE demo_city a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.city_id in ( ? )
	 */
	public java.util.List<String> deleteByCityIds(java.util.List<String> cityIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("cityIds",cityIds);
        super.update("City.deleteByCityIds", params);
        return cityIds;
	}

	/**
	 * 
	 * sql:select a.city_id, a.name, a.province_id from demo_city a where a.delete_flag = 0 and a.province_id = ?
	 */
	public List<City> getCityOptions(String provinceId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("provinceId",provinceId);
		return super.selectList("City.getCityOptions",params);
	}
}

