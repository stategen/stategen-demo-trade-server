package com.mycompany.biz.controller;

import javax.annotation.Resource;

import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.State;
import org.stategen.framework.enums.DataOpt;
import org.stategen.framework.web.cookie.CookieGroup;

import com.mycompany.biz.checker.LoginCheck;
import com.mycompany.biz.domain.User;
import com.mycompany.biz.utils.SysConsts;

@ApiConfig
@LoginCheck
public class User_meController extends UserControllerBase {
    
    @Resource
    private CookieGroup loginCookieGroup;
    
    @ApiRequestMappingAutoWithMethodName
    @State(init=true,dataOpt=DataOpt.FULL_REPLACE)
    @LoginCheck
    public User getCurrentUser() {
        String userId = loginCookieGroup.getCookieValue(SysConsts.USER_ID);
        User topicAuthor = this.userService.getUserByUserId(userId);
        return topicAuthor;
    }
}
