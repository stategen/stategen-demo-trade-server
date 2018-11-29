package com.mycompany.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.State;
import org.stategen.framework.enums.DataOpt;

import com.mycompany.biz.checker.LoginCheck;
import com.mycompany.biz.domain.User;
import com.mycompany.biz.service.UserService;

@ApiConfig
@LoginCheck
public class UserController extends UserControllerBase {
    @Resource
    private UserService userService;

    @ApiRequestMappingAutoWithMethodName
    @RequestMapping("/{username}")
    @State(init=true,dataOpt=DataOpt.FULL_REPLACE)
    public User getUserData(@PathVariable("username") String username) {
        User topicAuthor = this.userService.getUserByUsername(username);
        return topicAuthor;
    }
}
