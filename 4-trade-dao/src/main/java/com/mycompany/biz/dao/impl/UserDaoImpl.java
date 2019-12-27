/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.biz.domain.User;
import com.mycompany.biz.dao.UserDao;
import org.stategen.framework.lite.PageList;

import org.springframework.dao.DataAccessException;

/**
 * UserDao
 * <pre>
 * database table: user
 * database table comments: User
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public class UserDaoImpl  extends SqlDaoSupportBase implements UserDao {

	/**
	 * 
	 * sql:insert into user ( create_time , update_time , delete_flag , user_id , username , password , role_type , name , nickName , inter_code , mobile , age , address , avatar_img_id , email , vali_datetime , birthday_date , work_time , province_id , city_id , status , grade , sex , post_address_id , remark ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
	 */
	public User insert(User user) throws DataAccessException {
		if(user == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
        super.insert("User.insert", user);
		return user;
	}

	/**
	 * 
	 * sql:UPDATE user SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and user_id = ?
	 */
	public String delete(String userId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("userId",userId);
        super.update("User.delete", params);
        return userId;
	}

	/**
	 * 
	 * sql:UPDATE user SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and username = ?
	 */
	public Long deleteByUsername(String username) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("username",username);
		return (long)super.update("User.deleteByUsername", params);
	}

	/**
	 * 
	 * sql:UPDATE user SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and email = ?
	 */
	public Long deleteByEmail(String email) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("email",email);
		return (long)super.update("User.deleteByEmail", params);
	}

	/**
	 * 
	 * sql:UPDATE user SET update_time= CURRENT_TIMESTAMP(6) , username = ? , password = ? , role_type = ? , name = ? , nickName = ? , inter_code = ? , mobile = ? , age = ? , address = ? , avatar_img_id = ? , email = ? , vali_datetime = ? , birthday_date = ? , work_time = ? , province_id = ? , city_id = ? , status = ? , grade = ? , sex = ? , post_address_id = ? , remark = ? where delete_flag = 0 and user_id = ?
	 */
	public User update(User user) throws DataAccessException {
		if(user == null) {
			throw new IllegalArgumentException("Can't update by a null data object.");
		}
        super.update("User.update", user);
		return user;
	}

	/**
	 * 
	 * sql:select a.user_id, a.username, a.password, a.role_type, a.name, a.nickName, a.inter_code, a.mobile, a.age, a.address, a.avatar_img_id, a.email, a.vali_datetime, a.birthday_date, a.work_time, a.province_id, a.city_id, a.status, a.grade, a.sex, a.post_address_id, a.remark, a.create_time, a.update_time, a.delete_flag from user a where a.delete_flag = 0 and a.user_id = ?
	 */
	public User getUserByUserId(String userId) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("userId",userId);
		return (User)super.selectOne("User.getUserByUserId",params);
	}

	/**
	 * 
	 * sql:select a.user_id, a.username, a.password, a.role_type, a.name, a.nickName, a.inter_code, a.mobile, a.age, a.address, a.avatar_img_id, a.email, a.vali_datetime, a.birthday_date, a.work_time, a.province_id, a.city_id, a.status, a.grade, a.sex, a.post_address_id, a.remark, a.create_time, a.update_time, a.delete_flag from user a where a.delete_flag = 0 and a.username = ?
	 */
	public User getUserByUsername(String username) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("username",username);
		return (User)super.selectOne("User.getUserByUsername",params);
	}

	/**
	 * 
	 * sql:select a.user_id, a.username, a.password, a.role_type, a.name, a.nickName, a.inter_code, a.mobile, a.age, a.address, a.avatar_img_id, a.email, a.vali_datetime, a.birthday_date, a.work_time, a.province_id, a.city_id, a.status, a.grade, a.sex, a.post_address_id, a.remark, a.create_time, a.update_time, a.delete_flag from user a where a.delete_flag = 0 and a.email = ?
	 */
	public User getUserByEmail(String email) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("email",email);
		return (User)super.selectOne("User.getUserByEmail",params);
	}

	/**
	 * 
	 * sql:select a.user_id, a.username, a.password, a.role_type, a.name, a.nickName, a.inter_code, a.mobile, a.age, a.address, a.avatar_img_id, a.email, a.vali_datetime, a.birthday_date, a.work_time, a.province_id, a.city_id, a.status, a.grade, a.sex, a.post_address_id, a.remark, a.create_time, a.update_time, a.delete_flag from user a where a.delete_flag = 0 and a.user_id=? and a.user_id in ( ? ) and a.username=? and a.username like CONCAT('%',?,'%') and a.password=? and a.password like CONCAT('%',?,'%') and a.role_type=? and a.role_type in ( ? ) and a.name=? and a.name like CONCAT('%',?,'%') and a.nickName=? and a.nickName like CONCAT('%',?,'%') and a.inter_code=? and a.inter_code like CONCAT('%',?,'%') and a.mobile=? and a.mobile like CONCAT('%',?,'%') and a.age=? and a.age >=? and a.age <? and a.address=? and a.address like CONCAT('%',?,'%') and a.avatar_img_id=? and a.avatar_img_id in ( ? ) and a.email=? and a.email like CONCAT('%',?,'%') and a.vali_datetime >=? and a.vali_datetime <? and a.birthday_date >=? and a.birthday_date <? and a.work_time >=? and a.work_time <? and a.province_id=? and a.province_id in ( ? ) and a.city_id=? and a.city_id in ( ? ) and a.status=? and a.status in ( ? ) and a.grade=? and a.grade >=? and a.grade <? and a.post_address_id=? and a.post_address_id in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<User> getPageList(User user, int pageSize, int pageNum) throws DataAccessException {
		return super.pageQuery("User.getPageList",user,pageNum,pageSize);
	}

	/**
	 * 
	 * sql:select a.user_id, a.username, a.password, a.role_type, a.name, a.nickName, a.inter_code, a.mobile, a.age, a.address, a.avatar_img_id, a.email, a.vali_datetime, a.birthday_date, a.work_time, a.province_id, a.city_id, a.status, a.grade, a.sex, a.post_address_id, a.remark, a.create_time, a.update_time, a.delete_flag from user a where a.delete_flag = 0 and 1=0 and a.user_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<User> getUsersByUserIds(java.util.List<String> userIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("userIds",userIds);
		return super.selectList("User.getUsersByUserIds",params);
	}

	/**
	 * 
	 * sql:select a.user_id, a.username, a.password, a.role_type, a.name, a.nickName, a.inter_code, a.mobile, a.age, a.address, a.avatar_img_id, a.email, a.vali_datetime, a.birthday_date, a.work_time, a.province_id, a.city_id, a.status, a.grade, a.sex, a.post_address_id, a.remark, a.create_time, a.update_time, a.delete_flag from user a where a.delete_flag = 0 and 1=0 and a.username in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<User> getUsersByUsernames(java.util.List<String> usernames) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("usernames",usernames);
		return super.selectList("User.getUsersByUsernames",params);
	}

	/**
	 * 
	 * sql:select a.user_id, a.username, a.password, a.role_type, a.name, a.nickName, a.inter_code, a.mobile, a.age, a.address, a.avatar_img_id, a.email, a.vali_datetime, a.birthday_date, a.work_time, a.province_id, a.city_id, a.status, a.grade, a.sex, a.post_address_id, a.remark, a.create_time, a.update_time, a.delete_flag from user a where a.delete_flag = 0 and 1=0 and a.email in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<User> getUsersByEmails(java.util.List<String> emails) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("emails",emails);
		return super.selectList("User.getUsersByEmails",params);
	}

	/**
	 * 
	 * sql:UPDATE user SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and user_id in ( ? )
	 */
	public java.util.List<String> deleteByUserIds(java.util.List<String> userIds) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("userIds",userIds);
        super.update("User.deleteByUserIds", params);
        return userIds;
	}

	/**
	 * 
	 * sql:UPDATE user SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and username in ( ? )
	 */
	public Long deleteByUsernames(java.util.List<String> usernames) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("usernames",usernames);
		return (long)super.update("User.deleteByUsernames", params);
	}

	/**
	 * 
	 * sql:UPDATE user SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and email in ( ? )
	 */
	public Long deleteByEmails(java.util.List<String> emails) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(1);
		params.put("emails",emails);
		return (long)super.update("User.deleteByEmails", params);
	}

	/**
	 * 
	 * sql:select a.user_id, a.username, a.password, a.role_type, a.name, a.nickName, a.inter_code, a.mobile, a.age, a.address, a.avatar_img_id, a.email, a.vali_datetime, a.birthday_date, a.work_time, a.province_id, a.city_id, a.status, a.grade, a.sex, a.post_address_id, a.remark, a.create_time, a.update_time, a.delete_flag from user a where a.delete_flag = 0 and a.inter_code = ? and a.mobile = ?
	 */
	public User getUserByMobile(String interCode, String mobile) throws DataAccessException {
		Map<String,Object> params = new HashMap<String,Object>(2);
		params.put("interCode",interCode);
		params.put("mobile",mobile);
		return (User)super.selectOne("User.getUserByMobile",params);
	}

}

