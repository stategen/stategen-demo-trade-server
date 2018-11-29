package com.mycompany.biz.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.State;
import org.stategen.framework.enums.DataOpt;
import org.stategen.framework.lite.SimpleResponse;
import org.stategen.framework.lite.enums.VisitType;
import org.stategen.framework.util.StringUtil;
import org.stategen.framework.web.cookie.CookieGroup;

import com.mycompany.biz.domain.Menu;
import com.mycompany.biz.domain.User;
import com.mycompany.biz.service.MenuService;
import com.mycompany.biz.service.UserService;
import com.mycompany.biz.utils.SysConsts;

@ApiConfig(menu = false)
@RequestMapping("/api/app")
public class AppController {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AppController.class);
    

    @Resource
    private CookieGroup loginCookieGroup;

    @Resource(name = "userService")
    private UserService userService;

    @Resource
    private MenuService menuService;

    @ApiRequestMappingAutoWithMethodName(name = "", method = RequestMethod.GET)
    @State(area=User.class)
    public SimpleResponse logout(HttpServletResponse response) {
        loginCookieGroup.expireAllCookies();
        return new SimpleResponse(true, "退出成功");
    }

    @ApiRequestMappingAutoWithMethodName(name = "", method = RequestMethod.GET)
    @State(init = true, initCheck = false, dataOpt = DataOpt.FULL_REPLACE)
    public User getCookieUser() {
        String userId = this.loginCookieGroup.getCookieValue(SysConsts.USER_ID);
        if (StringUtil.isEmpty(userId)) {
            return null;
        }

        User user = this.userService.getUserByUserId(userId);
        if (user == null) {
            return null;
        }

        List<Long> visitsIds = this.menuService.getMenusByUserId(user.getUserId(), VisitType.MENU);
        user.setVisitsIds(visitsIds);
        return user;
    }

    @ApiRequestMappingAutoWithMethodName(method = RequestMethod.GET, name = "获所所有菜单")
    @State(init = true, initCheck = false, dataOpt = DataOpt.FULL_REPLACE)
    public List<Menu> getAllMenus() {
        return this.menuService.getAllMenus();
    }

}
