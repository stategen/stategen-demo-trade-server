package com.mycompany.biz.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
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
import org.stategen.framework.util.CollectionUtil;
import org.stategen.framework.util.CopyUtil;
import org.stategen.framework.util.DatetimeUtil;
import org.stategen.framework.web.cookie.CookieGroup;

import com.mycompany.biz.annotion.ExcludeBeanNotNull;
import com.mycompany.biz.domain.User;
import com.mycompany.biz.domain.UserHoppy;
import com.mycompany.biz.enums.StatusEnum;
import com.mycompany.biz.service.CityService;
import com.mycompany.biz.service.ProvinceService;
import com.mycompany.biz.service.UserHoppyService;

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

    @Resource
    private UserHoppyService userHoppyService;

    @ApiRequestMappingAutoWithMethodName(name = "用户列表")
    @VisitCheck
    @State(init = true, dataOpt = DataOpt.FULL_REPLACE,genForm=true)
    @ExcludeBeanNotNull
    public AntdPageList<User> getUserPageList(
                                              @ApiParam() String userId,
                                              @OptionConfig @ApiParam() @RequestParam(required = false, name = "userIds") ArrayList<String> userIds,
                                              @ApiParam() String usernameLike,
                                              @ApiParam() @RequestParam(required = false, name = "roleTypes") ArrayList<String> roleTypes,
                                              @ApiParam() Integer ageMin, @ApiParam() Integer ageMax, @ApiParam() Date valiDatetimeMin,
                                              @ApiParam() Date birthdayDateMin, @ApiParam() Date workTimeMin, @ApiParam() String provinceId,
                                              @ApiParam() @RequestParam(required = false, name = "cityIds") ArrayList<String> cityIds,
                                              @ApiParam() @RequestParam(required = false, name = "statuss") ArrayList<StatusEnum> statuss,
                                              @ApiParam() Long gradeMin, @ApiParam() String postAddressId,
                                              @ApiParam() @RequestParam(required = false, name = "postAddressIds") ArrayList<String> postAddressIds,
                                              @ApiParam(hidden = true) User user, Pagination pagination

    ) {
        user.setCreateTimeMax(DatetimeUtil.current());
        //技巧，api参数 .在dao中已自动化生成,从以下getUserPageList 帮助文件中 点开See also直接复制过来，
        PageList<User> userList = this.userService.getUserPageList(user, pagination.getPageSize(), pagination.getPage());
        assignBeans(userList.getItems());
        setUsersHoppyIds(userList.getItems());
        return new AntdPageList<User>(userList);
    }

    private void assignBeans(List<User> users) {
        provinceService.assignBeanTo(users, User::getProvinceId, User::setProvince);
        cityService.assignBeanTo(users, User::getCityId, User::setCity);
    }

    @ApiRequestMappingAutoWithMethodName(name = "批量删除用户")
    @VisitCheck
    @State(dataOpt = DataOpt.DELETE_IF_EXIST, area = User.class)
    public List<String> deleteByUserIds(@RequestParam(name = "userIds", required = false) ArrayList<String> userIds, HttpServletResponse response) {
        return this.userService.deleteByUserIds(userIds);
    }

    @ApiRequestMappingAutoWithMethodName(name = "创建用户")
    @VisitCheck
    @State
    @GenForm
    public User insert(@ApiParam()@RequestParam(required =false,name="hoppyIds") ArrayList<Long> hoppyIds,
                       @ApiParam() String username,
                       @ApiParam() String password,
                       @ApiParam() String roleType,
                       @ApiParam() String name,
                       @ApiParam() String nickName,
                       @ApiParam() Integer age,
                       @ApiParam() String address,
                       @ApiParam() String avatarImg,
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
                       ,@ApiParam(hidden = true) User user) {
        user.setCreateTime(DatetimeUtil.current());
        user.setAvatarImg("http://dummyimage.com/100x100/79e6f2/757575.png&text=" + user.getNickName().substring(0, 1));
        this.userService.insert(user);
        saveUserHoppys(hoppyIds, userId, user);
        List<User> users = Arrays.asList(user);
        assignBeans(users);
        setUsersHoppyIds(users);
        return user;
    }

    @ApiRequestMappingAutoWithMethodName(name = "删除用户")
    @VisitCheck
    @State(area = User.class, dataOpt = DataOpt.DELETE_IF_EXIST)
    public String delete(@PathVariable String userId) {
        return userService.delete(userId);
    }

    @ApiRequestMappingAutoWithMethodName(name = "修改用户")
    @VisitCheck
    @GenForm
    @State()
    public User update(
                       @ApiParam()@RequestParam(required =false,name="hoppyIds") ArrayList<Long> hoppyIds,
                       @ApiParam() String username,
                       @ApiParam() String password,
                       @ApiParam() String roleType,
                       @ApiParam() String name,
                       @ApiParam() String nickName,
                       @ApiParam() Integer age,
                       @ApiParam() String address,
                       @ApiParam() String avatarImg,
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
        
        saveUserHoppys(hoppyIds, userId, orgUser);
        List<User> users = Arrays.asList(orgUser);
        setUsersHoppyIds(users);
        
        assignBeans(Arrays.asList(orgUser));
        return orgUser;
    }

    private void saveUserHoppys(ArrayList<Long> hoppyIds, String userId, User user) {
        List<UserHoppy> userHoppys = userHoppyService.getUserHoppysByUserIds(Arrays.asList(user.getUserId()));
        Map<Long, UserHoppy> hoppyIdUserHoppyMap = CollectionUtil.toMap(UserHoppy::getHoppyId, userHoppys);
        for (Long hoppyId : hoppyIds) {
            UserHoppy userHoppy = hoppyIdUserHoppyMap.get(hoppyId);
            if (userHoppy==null){
                userHoppy =new UserHoppy();
                userHoppy.setUserId(userId);
                userHoppy.setHoppyId(hoppyId);
                userHoppyService.insert(userHoppy);
            } else {
                hoppyIdUserHoppyMap.remove(hoppyId);
            }
        }
        
        for (UserHoppy userHoppy : hoppyIdUserHoppyMap.values()) {
            userHoppyService.delete(userHoppy.getId());
        }
    }

    private void setUsersHoppyIds(List<User> users) {
        List<UserHoppy> userHoppys = userHoppyService.getUserHoppysByUserIds(CollectionUtil.toList(users, User::getUserId));
        CollectionUtil.setListByList(users, userHoppys, User::getUserId, User::setHoppyIds, UserHoppy::getUserId, UserHoppy::getHoppyId);
    }

}
