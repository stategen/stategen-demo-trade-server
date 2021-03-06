package com.mycompany.biz.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.GenForm;
import org.stategen.framework.annotation.State;
import org.stategen.framework.annotation.VisitCheck;
import org.stategen.framework.enums.DataOpt;
import org.stategen.framework.util.BusinessAssert;
import org.stategen.framework.util.CopyUtil;

import com.mycompany.biz.checker.LoginCheck;
import com.mycompany.biz.domain.User;
import com.mycompany.biz.enums.CookieType.Login.LoginCookieNames;
import com.mycompany.biz.enums.RoleType;
import com.mycompany.biz.enums.StatusEnum;

import io.swagger.annotations.ApiParam;

@ApiConfig
public class User_meController extends UserControllerBase {
    

    
    @ApiRequestMappingAutoWithMethodName
    @State(init=true,dataOpt=DataOpt.FULL_REPLACE)
    @LoginCheck
    public User getCurrentUser() {
        String userId = loginCookieGroup.getCookieValue(LoginCookieNames.userId);
        User topicAuthor = this.userService.getUserByUserId(userId);
        assignBeans(Arrays.asList(topicAuthor));
        return topicAuthor;
    }
    
    @ApiRequestMappingAutoWithMethodName
    @State(init=true,dataOpt=DataOpt.FULL_REPLACE)
    public User getTheUser() {
        User topicAuthor = this.userService.getUserByUserId("2018111306343099304690546571");
        if (logger.isInfoEnabled()) {
            logger.info(new StringBuilder("输出info信息: topicAuthor:").append(topicAuthor).toString());
        }
        assignBeans(Arrays.asList(topicAuthor));
        return topicAuthor;
    }
    

    @ApiRequestMappingAutoWithMethodName(name = "修改用户")
    @VisitCheck
    @GenForm
    @State()
    public User update(
                       @ApiParam()@RequestParam(required =false,name="hoppyIds") ArrayList<Long> hoppyIds,
                       @ApiParam() @RequestParam(required = false, name = "cascaderPostAddressIds") ArrayList<Long> cascaderPostAddressIds,
                       @ApiParam() String username,
                       @ApiParam() String password,
                       @ApiParam() RoleType roleType,
                       @ApiParam() String name,
                       @ApiParam() String nickName,
                       @ApiParam() Integer age,
                       @ApiParam() String address,
                       @ApiParam() String avatarImgId,
                       @ApiParam() String email,
                       @ApiParam() Date valiDatetime,
                       @ApiParam() Date birthdayDate,
                       @ApiParam() Date workTime,
                       @ApiParam() String provinceId,
                       @ApiParam() String cityId,
                       @ApiParam() StatusEnum status,
                       @ApiParam() Long grade,
                       @ApiParam() Boolean sex,
                       @ApiParam() String postAddressId,
                       @ApiParam() String userId
                       ,@ApiParam(hidden = true) User user

    ) {
        User orgUser = this.userService.getUserByUserId(userId);
        BusinessAssert.mustNotNull(orgUser, "用户不存在");
        user = CopyUtil.merge(orgUser, user);
        this.userService.update(orgUser);
        saveUserHoppys(hoppyIds, userId, orgUser);
        List<User> users = Arrays.asList(orgUser);
        assignBeans(users);
        return orgUser;
    }
}
