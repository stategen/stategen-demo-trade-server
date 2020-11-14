/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */    
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.Province;
import com.mycompany.biz.dao.ProvinceDao;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.IdGenerateService;
/**
 * ProvinceDao
 * <pre>
 * database table: demo_province
 * database table comments: Province
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class ProvinceDaoImpl  extends SqlDaoSupportBase implements ProvinceDao {


	/**
	 * 
	 * sql:insert into demo_province ( create_time , update_time , delete_flag , province_id , name , pycode ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?)
	 */
	public Province insert(Province province, IdGenerateService<String> idGenerateService) throws DataAccessException {
		if(province == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        if (idGenerateService != null && province.getProvinceId() == null) {
            String provinceId = idGenerateService.generateId();
            if (provinceId != null) {
                province.setProvinceId(provinceId);
            }
        }
        super.insert("Province.insert", province);
		return province;
	}

	/**
	 * 
	 * sql:UPDATE demo_province a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and a.province_id = ?
	 */
	public String delete(String provinceId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("provinceId",provinceId);
        super.update("Province.delete", params);
        return provinceId;
	}

	/**
	 * 
	 * sql:UPDATE demo_province a SET a.update_time= CURRENT_TIMESTAMP(6) , a.name = ? , a.pycode = ? where a.delete_flag = 0 and a.province_id = ?
	 */
	public Province update(Province province) throws DataAccessException {
		if(province == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        super.update("Province.update", province);
		return province;
	}

	/**
	 * 
	 * sql:select a.province_id, a.name, a.pycode, a.create_time, a.update_time, a.delete_flag from demo_province a where a.delete_flag = 0 and a.province_id = ?
	 */
	public Province getProvinceByProvinceId(String provinceId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("provinceId",provinceId);
		return (Province)super.selectOne("Province.getProvinceByProvinceId",params);
	}

	/**
	 * 
	 * sql:select a.province_id, a.name, a.pycode, a.create_time, a.update_time, a.delete_flag from demo_province a where a.delete_flag = 0 and a.province_id=? and a.province_id in ( ? ) and a.name=? and a.name like CONCAT('%',?,'%') and a.pycode=? and a.pycode like CONCAT('%',?,'%') and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<Province> getPageList(Province province, int pageSize, int pageNum) throws DataAccessException {
		return super.pageQuery("Province.getPageList",province,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.province_id, a.name, a.pycode, a.create_time, a.update_time, a.delete_flag from demo_province a where a.delete_flag = 0 and 1=0 and a.province_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<Province> getProvincesByProvinceIds(java.util.List<String> provinceIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("provinceIds",provinceIds);
		return super.selectList("Province.getProvincesByProvinceIds",params);
	}

	/**
	 * 
	 * sql:UPDATE demo_province a SET a.delete_flag = 1 , a.update_time = CURRENT_TIMESTAMP(6) where a.delete_flag = 0 and 1=0 and a.province_id in ( ? )
	 */
	public java.util.List<String> deleteByProvinceIds(java.util.List<String> provinceIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("provinceIds",provinceIds);
        super.update("Province.deleteByProvinceIds", params);
        return provinceIds;
	}

	/**
	 * 
	 * sql:select a.province_id, a.name from demo_province a where a.delete_flag = 0
	 */
	public List<Province> getProvinceOptions() throws DataAccessException {
		return super.selectList("Province.getProvinceOptions",null);
	}
}

