package com.mycompany.biz.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.GenForm;
import org.stategen.framework.annotation.OptionConfig;
import org.stategen.framework.annotation.State;
import org.stategen.framework.annotation.VisitCheck;
import org.stategen.framework.enums.DataOpt;
import org.stategen.framework.lite.AntdPageList;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.lite.Pagination;
import org.stategen.framework.util.BusinessAssert;
import org.stategen.framework.util.CopyUtil;
import org.stategen.framework.util.DatetimeUtil;
import org.stategen.framework.web.cookie.CookieGroup;

import com.mycompany.biz.domain.User;
import com.mycompany.biz.enums.StatusEnum;
import com.mycompany.biz.service.CityService;
import com.mycompany.biz.service.ProvinceService;

import io.swagger.annotations.ApiParam;

@ApiConfig(name = "用户")
@VisitCheck
public class UserController extends UserControllerBase {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserController.class);

    @Resource
    private CookieGroup baseCookieGroup;
    
    @Resource
    private ProvinceService provinceService;
    
    @Resource
    private CityService cityService;

    @ApiRequestMappingAutoWithMethodName(name = "用户列表")
    @VisitCheck
    @State(init = true,dataOpt=DataOpt.FULL_REPLACE)
    @GenForm
    public AntdPageList<User> getUserPageList(
                                              @OptionConfig
                                              @ApiParam()@RequestParam(required =false,name="userIds") ArrayList<String> userIds,
                                              @ApiParam() String usernameLike,
                                              @ApiParam()@RequestParam(required =false,name="roleTypes") ArrayList<String> roleTypes,
                                              @ApiParam() Integer ageMin,
                                              @ApiParam() Integer ageMax,
                                              @ApiParam() Date valiDatetimeMin,
                                              @ApiParam() Date birthdayDateMin,
                                              @ApiParam() Date workTimeMin,
                                              @ApiParam() String provinceId,
                                              @ApiParam()@RequestParam(required =false,name="cityIds") ArrayList<String> cityIds,
                                              @ApiParam()@RequestParam(required =false,name="statuss") ArrayList<StatusEnum> statuss,
                                              @ApiParam() Long gradeMin,
                                              @ApiParam() String postAddressId,
                                              @ApiParam()@RequestParam(required =false,name="postAddressIds") ArrayList<String> postAddressIds
                                              ,@ApiParam(hidden = true) User user
                                              ,Pagination pagination



    ) {
            user.setCreateTimeMax(DatetimeUtil.current());
        //技巧，api参数 .在dao中已自动化生成,从以下getUserPageList 帮助文件中 点开See also直接复制过来，
        PageList<User> userList = this.userService.getUserPageList(user, pagination.getPageSize(), pagination.getPage());
        assignBeans(userList.getItems());
        return new AntdPageList<User>(userList);
    }

    private void assignBeans(List<User> users) {
        provinceService.assignBeanTo(users, User::getProvinceId, User::setProvince);
        cityService.assignBeanTo(users, User::getCityId, User::setCity);
    }

    @ApiRequestMappingAutoWithMethodName(name = "批量删除用户", method = RequestMethod.DELETE)
    @VisitCheck
    @State(dataOpt = DataOpt.DELETE_IF_EXIST, area = User.class)
    public List<String> deleteByUserIds(@RequestParam(name = "userIds", required = false) ArrayList<String> userIds, HttpServletResponse response) {
        return this.userService.deleteByUserIds(userIds);
    }

    @ApiRequestMappingAutoWithMethodName(name = "创建用户", method = RequestMethod.POST)
    @VisitCheck
    @GenForm
    public User insert(@ApiParam() String userId,
                       @ApiParam() String username,
                       @ApiParam() String password,
                       @ApiParam() String roleType,
                       @ApiParam() String name,
                       @ApiParam() String nickName,
                       @ApiParam() Integer age,
                       @ApiParam() String address,
                       @ApiParam() String avatarUrl,
                       @ApiParam() String email,
                       @ApiParam() Date valiDatetime,
                       @ApiParam() Date birthdayDate,
                       @ApiParam() Date workTime,
                       @ApiParam() String provinceId,
                       @ApiParam() String cityId,
                       @ApiParam() StatusEnum status,
                       @ApiParam() Long grade,
                       @ApiParam() Boolean sex,
                       @ApiParam() String postAddressId
                       ,@ApiParam(hidden = true) User user
) {
        user.setCreateTime(DatetimeUtil.current());
        user.setAvatarUrl("http://dummyimage.com/100x100/79e6f2/757575.png&text=" + user.getNickName().substring(0, 1));
        this.userService.insert(user);
        if (logger.isInfoEnabled()) {
            logger.info(new StringBuffer("输出info信息: user:").append(user).toString());
        }
        assignBeans(Arrays.asList(user));
        return user;
    }

    @ApiRequestMappingAutoWithMethodName(name = "删除用户", method = RequestMethod.DELETE)
    @VisitCheck
    @State(area = User.class, dataOpt = DataOpt.DELETE_IF_EXIST)
    public String delete(@PathVariable String userId) {
        return userService.delete(userId);
    }

    @ApiRequestMappingAutoWithMethodName(name = "修改用户", method = RequestMethod.PATCH)
    @VisitCheck
    @GenForm
    public User update(@ApiParam() String username,
                       @ApiParam() String password,
                       @ApiParam() String roleType,
                       @ApiParam() String name,
                       @ApiParam() String nickName,
                       @ApiParam() Integer age,
                       @ApiParam() String address,
                       @ApiParam() String avatarUrl,
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
        if (logger.isInfoEnabled()) {
            logger.info(new StringBuffer("输出info信息: orgUser:").append(orgUser).toString());
        }
        assignBeans(Arrays.asList(orgUser));
        return orgUser;
    }

}
