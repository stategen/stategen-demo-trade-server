/*
 * Copyright (c) 2016 - 2116 All Rights Reserved.
 * Powered By [rapid-generator]
 */
package com.mycompany.biz.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.lite.enums.MenuType;
import org.stategen.framework.util.CollectionUtil;
import org.stategen.framework.util.ServiceUtil;

import com.mycompany.biz.dao.MenuDao;
import com.mycompany.biz.domain.Menu;
import com.mycompany.biz.service.MenuService;

/**
 * MenuServiceImpl
 * <pre>
 * database table: visit
 * database table comments: IMenu
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public class MenuServiceImpl implements MenuService {

    @Value("${project.name}")
    private String projectName;

    @Resource(name = "menuDao")
    MenuDao menuDao;

    private class VisitKeyCalculator implements CollectionUtil.KeyCalculator<String, Menu> {

        @Override
        public String calculateKey(Menu menu) {
            String result = new StringBuilder().append(menu.getControllerName()).append('.').append(menu.getMethodName()).toString();
            return result;
        }
    }

    private void insertOrUpdateMenus(Long parentMenuId, List<Menu> menus, Map<String, Menu> oldMenuMap, VisitKeyCalculator visitKeyCalculator) {
        if (CollectionUtil.isNotEmpty(menus)) {
            for (Menu menu : menus) {
                menu.setMpid(parentMenuId);
                menu.setProjectName(projectName);
                menu.setDeleteFlag(0);
                String key = visitKeyCalculator.calculateKey(menu);
                Menu oldMenu = oldMenuMap.get(key);
                if (oldMenu != null) {
                    menu.setMenuId(oldMenu.getMenuId());
                    this.forceUpdateById(menu);
                } else {
                    this.insert(menu);
                }
                insertOrUpdateMenus(menu.getMenuId(), menu.getMenuChildren(), oldMenuMap, visitKeyCalculator);
            }
        }
    }

    @Override
    public List<Menu> updateMenus(List<Menu> allControllerMenus) {
        //更新visitId
        VisitKeyCalculator visitKeyCalculator = new VisitKeyCalculator();
        List<Menu> oldMenus = this.getMenusByProjectName(null);
        Map<String, Menu> oldMenuMap = CollectionUtil.toMap(new LinkedCaseInsensitiveMap<Menu>(), visitKeyCalculator, oldMenus);
        Long parentMenuId = null;
        this.insertOrUpdateMenus(parentMenuId, allControllerMenus, oldMenuMap, visitKeyCalculator);
        return allControllerMenus;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public List<Menu> getAllMenus() {
        return this.getMenusByProjectName(MenuType.MENU);
    }

    //<#--
    /**
     * 
     * @see com.mycompany.biz.dao.MenuDao#insert
     * @see com.mycompany.biz.service.MenuService#insert
     */
    @Override
    public Menu insert(Menu menu) {
        return menuDao.insert(menu);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.MenuDao#update
     * @see com.mycompany.biz.service.MenuService#update
     */
    @Override
    public Menu update(Menu menu) {
        return menuDao.update(menu);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.MenuDao#getMenuByMenuId
     * @see com.mycompany.biz.service.MenuService#getMenuByMenuId
     */
    @Override
    public Menu getMenuByMenuId(Long menuId) {
        return menuDao.getMenuByMenuId(menuId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.MenuDao#getMenusByMenuIds
     * @see com.mycompany.biz.service.MenuService#getMenusByMenuIds
     */
    @Override
    public List<Menu> getMenusByMenuIds(java.util.List<Long> menuIds) {
        return menuDao.getMenusByMenuIds(menuIds);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.MenuDao#deleteByMenuIds
     * @see com.mycompany.biz.service.MenuService#deleteByMenuIds
     */
    @Override
    public List<Long> deleteByMenuIds(java.util.List<Long> menuIds) {
        return menuDao.deleteByMenuIds(menuIds);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.MenuDao#getMenusByUserId
     * @see com.mycompany.biz.service.MenuService#getMenusByUserId
     */
    @Override
    public List<Long> getMenusByUserId(String userId, org.stategen.framework.lite.enums.MenuType menuType) {
        return menuDao.getMenusByUserId(userId, menuType);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.MenuDao#forceUpdateById
     * @see com.mycompany.biz.service.MenuService#forceUpdateById
     */
    @Override
    public Long forceUpdateById(Menu menu) {
        return menuDao.forceUpdateById(menu);
    }

    /*** 保存menu,有id时更新，没有id时插入,并带回新的id，返回 menu*/
    @Override
    public Menu saveMenu(Menu menu) {
        if (menu != null) {
            java.lang.Long menuId = menu.getMenuId();
            if (menuId != null) {
                insert(menu);
            } else {
                update(menu);
            }
        }
        return menu;
    }

    /*** 批量保存menus,有id时更新，没有id时插入,并带回新的id，返回 menus*/
    @Override
    public List<Menu> saveMenus(List<Menu> menus) {
        for (Menu menu : menus) {
            this.saveMenu(menu);
        }
        return menus;
    }

    /**
     * 
     * @see com.mycompany.biz.dao.MenuDao#delete
     * @see com.mycompany.biz.service.MenuService#delete
     */
    @Override
    public Long delete(Long menuId) {
        return menuDao.delete(menuId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.MenuDao#getMenusByProjectName
     * @see com.mycompany.biz.service.MenuService#getMenusByProjectName
     */
    @Override
    public List<Menu> getMenusByProjectName(org.stategen.framework.lite.enums.MenuType menuType) {
        return menuDao.getMenusByProjectName(menuType);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.MenuDao#getPageList
     * @see com.mycompany.biz.service.MenuService#getPageList
     */
    @Override
    public PageList<Menu> getPageList(Menu menu, int pageSize, int pageNum) {
        return menuDao.getPageList(menu, pageSize, pageNum);
    }

    @Override
    public <D> void assignBeanTo(Collection<D> dests, Function<? super D, Long> destGetMethod, BiConsumer<D, Menu> destSetMethod) {
        ServiceUtil.interalAssignBeanTo(dests, destGetMethod, destSetMethod, this, MenuServiceImpl::getMenusByMenuIds, Menu::getMenuId);
    }

    @Override
    public <D, G> void assignBeansTo(Collection<D> dests, Function<? super D, G> destGetMethod, BiConsumer<D, List<Menu>> destSetMethod, BiConsumer<Menu, List<G>> resultSetQueryIdsFun, Function<? super Menu, G> resultGetGoupIdFun) {
        ServiceUtil.interalAssignBeansTo(dests, destGetMethod, destSetMethod, this, new Menu(), resultSetQueryIdsFun, resultGetGoupIdFun, 100);
    }

    @Override
    public <D> void mergeBeanTo(Collection<D> dests, Function<? super D, Long> destGetMethod) {
        ServiceUtil.interalMergeBeanTo(dests, destGetMethod, this, MenuServiceImpl::getMenusByMenuIds, Menu::getMenuId);
    }
    //-->
    //
}
