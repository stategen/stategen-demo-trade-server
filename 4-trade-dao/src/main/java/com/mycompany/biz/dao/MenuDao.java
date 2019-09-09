/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.dao;

import java.util.List;

import com.mycompany.biz.domain.Menu;
import org.springframework.dao.DataAccessException;
import org.stategen.framework.lite.PageList;

/**
 * MenuDao
 * <pre>
 * database table: menu
 * database table comments: Menu
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅可以修改引用
 * </pre>
 */
public interface MenuDao {

	/**
    <pre>
    &#64;ApiParam() Long menuId,
    &#64;ApiParam() Integer morder,
    &#64;ApiParam() Long bpid,
    &#64;ApiParam() Long mpid,
    &#64;ApiParam() String projectName,
    &#64;ApiParam() String controllerName,
    &#64;ApiParam() String methodName,
    &#64;ApiParam() String url,
    &#64;ApiParam() String icon,
    &#64;ApiParam() String name,
    &#64;ApiParam() String route,
    &#64;ApiParam() MenuType menuType,
    &#64;ApiParam() VisitCheckType checkType
    ,&#64;ApiParam(hidden = true) Menu menu
    
    </pre>
	 * 
	 * sql:insert into menu ( create_time , update_time , delete_flag , menu_id , morder , bpid , mpid , project_name , controller_name , method_name , url , icon , name , route , menu_type , check_type ) VALUES (CURRENT_TIMESTAMP(6),CURRENT_TIMESTAMP(6),0,?,?,?,?,?,?,?,?,?,?,?,?,?)
	 */
	public Menu insert(Menu menu) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("menuId") Long menuId
    
    </pre>
	 * 
	 * sql:UPDATE menu SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and menu_id = ?
	 */
	public Long delete(Long menuId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() Integer morder,
    &#64;ApiParam() Long bpid,
    &#64;ApiParam() Long mpid,
    &#64;ApiParam() String projectName,
    &#64;ApiParam() String controllerName,
    &#64;ApiParam() String methodName,
    &#64;ApiParam() String url,
    &#64;ApiParam() String icon,
    &#64;ApiParam() String name,
    &#64;ApiParam() String route,
    &#64;ApiParam() MenuType menuType,
    &#64;ApiParam() VisitCheckType checkType,
    &#64;ApiParam() Long menuId
    ,&#64;ApiParam(hidden = true) Menu menu
    
    </pre>
	 * 
	 * sql:UPDATE menu SET update_time= CURRENT_TIMESTAMP(6) , morder = ? , bpid = ? , mpid = ? , project_name = ? , controller_name = ? , method_name = ? , url = ? , icon = ? , name = ? , route = ? , menu_type = ? , check_type = ? where delete_flag = 0 and menu_id = ?
	 */
	public Menu update(Menu menu) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("menuId") Long menuId
    
    </pre>
	 * 
	 * sql:select a.menu_id, a.morder, a.bpid, a.mpid, a.project_name, a.controller_name, a.method_name, a.url, a.icon, a.name, a.route, a.menu_type, a.check_type, a.create_time, a.update_time, a.delete_flag from menu a where a.delete_flag = 0 and a.menu_id = ?
	 */
	public Menu getMenuByMenuId(Long menuId) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() Long menuId,
    &#64;ApiParam()&#64;RequestParam(required =false,name="menuIds") ArrayList&lt;Long&gt; menuIds,
    &#64;ApiParam() Integer morderMin,
    &#64;ApiParam() Integer morderMax,
    &#64;ApiParam() Long bpid,
    &#64;ApiParam()&#64;RequestParam(required =false,name="bpids") ArrayList&lt;Long&gt; bpids,
    &#64;ApiParam() Long mpid,
    &#64;ApiParam()&#64;RequestParam(required =false,name="mpids") ArrayList&lt;Long&gt; mpids,
    &#64;ApiParam() String projectName,
    &#64;ApiParam() String projectNameLike,
    &#64;ApiParam() String controllerName,
    &#64;ApiParam() String controllerNameLike,
    &#64;ApiParam() String methodName,
    &#64;ApiParam() String methodNameLike,
    &#64;ApiParam() String name,
    &#64;ApiParam() String nameLike,
    &#64;ApiParam() String route,
    &#64;ApiParam() String routeLike,
    &#64;ApiParam() MenuType menuType,
    &#64;ApiParam()&#64;RequestParam(required =false,name="menuTypes") ArrayList&lt;MenuType&gt; menuTypes,
    &#64;ApiParam() VisitCheckType checkType,
    &#64;ApiParam()&#64;RequestParam(required =false,name="checkTypes") ArrayList&lt;VisitCheckType&gt; checkTypes,
    &#64;ApiParam() Date createTimeMin,
    &#64;ApiParam() Date createTimeMax,
    &#64;ApiParam() Date updateTimeMin,
    &#64;ApiParam() Date updateTimeMax
    ,&#64;ApiParam(hidden = true) Menu menu
    ,Pagination pagination
    </pre>
	 * 
	 * sql:select a.menu_id, a.morder, a.bpid, a.mpid, a.project_name, a.controller_name, a.method_name, a.url, a.icon, a.name, a.route, a.menu_type, a.check_type, a.create_time, a.update_time, a.delete_flag from menu a where a.delete_flag = 0 and a.menu_id=? and a.menu_id in ( ? ) and a.morder >=? and a.morder <? and a.bpid=? and a.bpid in ( ? ) and a.mpid=? and a.mpid in ( ? ) and a.project_name=? and a.project_name like CONCAT('%',?,'%') and a.controller_name=? and a.controller_name like CONCAT('%',?,'%') and a.method_name=? and a.method_name like CONCAT('%',?,'%') and a.name=? and a.name like CONCAT('%',?,'%') and a.route=? and a.route like CONCAT('%',?,'%') and a.menu_type=? and a.menu_type in ( ? ) and a.check_type=? and a.check_type in ( ? ) and a.create_time >=? and a.create_time <? and a.update_time >=? and a.update_time <? and 0 = 1 order by a.update_time desc, a.create_time desc
	 */
	public PageList<Menu> getPageList(Menu menu, int pageSize, int pageNum) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("menuId")&#64;RequestParam(required =false,name="menuIds") ArrayList&lt;Long&gt; menuIds
    
    </pre>
	 * 
	 * sql:select a.menu_id, a.morder, a.bpid, a.mpid, a.project_name, a.controller_name, a.method_name, a.url, a.icon, a.name, a.route, a.menu_type, a.check_type, a.create_time, a.update_time, a.delete_flag from menu a where a.delete_flag = 0 and 1=0 and a.menu_id in ( ? ) order by a.update_time desc, a.create_time desc
	 */
	public List<Menu> getMenusByMenuIds(java.util.List<Long> menuIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("menuId")&#64;RequestParam(required =false,name="menuIds") ArrayList&lt;Long&gt; menuIds
    
    </pre>
	 * 
	 * sql:UPDATE menu SET delete_flag = 1 , update_time = CURRENT_TIMESTAMP(6) where delete_flag = 0 and 1=0 and menu_id in ( ? )
	 */
	public java.util.List<Long> deleteByMenuIds(java.util.List<Long> menuIds) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("menuType") MenuType menuType
    
    </pre>
	 * 
	 * sql:select a.menu_id, a.mpid, a.bpid, a.project_name, a.controller_name, a.method_name, a.url, a.icon, a.name, a.route, a.menu_type, a.check_type, a.create_time, a.update_time, a.delete_flag from menu a where a.delete_flag = 0 and a.menu_type=? order by a.morder is null, a.morder
	 */
	public List<Menu> getMenusByProjectName(org.stategen.framework.lite.enums.MenuType menuType) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam("userId") String userId,
    &#64;ApiParam("menuType") MenuType menuType
    
    </pre>
	 * 
	 * sql:select a.menu_id from menu a left join role_menu rm on rm.menu_id=a.menu_id left JOIN role r on r.role_id=rm.role_id left JOIN user_role ur on ur.role_id =r.role_id where a.delete_flag = 0 and rm.delete_flag=0 and r.delete_flag=0 and ur.delete_flag=0 and ur.user_id=? and a.menu_type=?
	 */
	public List<Long> getMenusByUserId(String userId, org.stategen.framework.lite.enums.MenuType menuType) throws DataAccessException;
	
	/**
    <pre>
    &#64;ApiParam() Long mpid,
    &#64;ApiParam() Long bpid,
    &#64;ApiParam() String projectName,
    &#64;ApiParam() String controllerName,
    &#64;ApiParam() String methodName,
    &#64;ApiParam() String url,
    &#64;ApiParam() String icon,
    &#64;ApiParam() String name,
    &#64;ApiParam() String route,
    &#64;ApiParam() MenuType menuType,
    &#64;ApiParam() VisitCheckType checkType,
    &#64;ApiParam() Integer deleteFlag,
    &#64;ApiParam() Long menuId
    ,&#64;ApiParam(hidden = true) Menu menu
    
    </pre>
	 * 
	 * sql:UPDATE menu SET update_time= CURRENT_TIMESTAMP(6) ,mpid = ? ,bpid = ? ,project_name = ? ,controller_name = ? ,method_name = ? ,url = ? ,icon = ? ,name = ? ,route = ? ,menu_type = ? ,check_type = ? ,delete_flag = ? where menu_id = ?
	 */
	public Long forceUpdateById(Menu menu) throws DataAccessException;
	

}



