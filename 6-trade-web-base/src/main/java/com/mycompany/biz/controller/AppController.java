package com.mycompany.biz.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.State;
import org.stategen.framework.annotation.Wrap;
import org.stategen.framework.enums.DataOpt;
import org.stategen.framework.lite.SimpleResponse;
import org.stategen.framework.lite.enums.MenuType;
import org.stategen.framework.util.BusinessAssert;
import org.stategen.framework.util.CollectionUtil;
//import org.stategen.framework.util.MockUtil;
import org.stategen.framework.util.StringUtil;
import org.stategen.framework.web.cookie.CookieGroup;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baidu.fsg.uid.impl.CachedUidGenerator;
import com.mycompany.biz.domain.City;
import com.mycompany.biz.domain.Hoppy;
import com.mycompany.biz.domain.Menu;
import com.mycompany.biz.domain.Province;
import com.mycompany.biz.domain.Region;
import com.mycompany.biz.domain.User;
import com.mycompany.biz.enums.CookieType.Login.LoginCookieNames;
import com.mycompany.biz.service.CityService;
import com.mycompany.biz.service.HoppyService;
import com.mycompany.biz.service.MenuService;
import com.mycompany.biz.service.ProvinceService;
import com.mycompany.biz.service.RegionService;
import com.mycompany.biz.service.UserService;

import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.ApiParam;

@ApiConfig(menu = false)
@RequestMapping("/api/app")
@Wrap
public class AppController {
    
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AppController.class);
    
    @Resource
    private CookieGroup<LoginCookieNames> loginCookieGroup;
    
    @Resource
    private CachedUidGenerator cachedUidGenerator;
    
    @Resource
    private ProvinceService provinceService;
    
    @Resource
    private CityService cityService;
    
    @Resource
    private HoppyService hoppyService;
    
    @Resource
    private RegionService regionService;
    
    @Resource(name = "userService")
    private UserService userService;
    
    @Resource
    private MenuService menuService;
    
    /**
    @Getter
    @Setter
    @AllArgsConstructor
    public class User implements java.io.Serializable {
        String username;
        String password;
    }
    */
    
    @ApiRequestMappingAutoWithMethodName(method = RequestMethod.GET)
    @SentinelResource
    @Wrap(false)
    public String testPlain() {
        //MockUtil只能用于测试，不能打包，执行 mvn package 由 插件 forbiddenapis 检测
//        MockUtil.slow(1000L);
        return "test张三中文";
    }
    
    /***测试seata分布式事务*/
    @ApiRequestMappingAutoWithMethodName(method = RequestMethod.GET)
    @GlobalTransactional
    public User testSeata() {
        User user = this.userService.appendUserAge("2");
        return user;
    }
    
    /***测试限流降级分布式事务*/
    @ApiRequestMappingAutoWithMethodName(method = RequestMethod.GET)
    @SentinelResource(/* blockHandler = "orderBlockHandler",fallback = "orderFallback", */ )
    public User testSentinel(@ApiParam(value = "用户ID", defaultValue = "1") @RequestParam() String userId) {
        //MockUtil只能用于测试，不能打包，执行 mvn package 由 插件 forbiddenapis 检测
        //        MockUtil.throwRandomException(2);
        User user = this.userService.getUserByUserId(userId);
        return user;
    }
    
    /***测试百度分步式id*/
    @ApiRequestMappingAutoWithMethodName(method = RequestMethod.GET)
    public String testUid() {
        long uid = this.cachedUidGenerator.getUID();
        if (logger.isInfoEnabled()) {
            logger.info(new StringBuilder("输出info信息: uid:").append(uid).toString());
        }
        String parseUID = cachedUidGenerator.parseUID(uid);
        return parseUID;
    }

    @ApiRequestMappingAutoWithMethodName(name = "")
    @State(area = User.class)
    public SimpleResponse logout(HttpServletResponse response) {
        loginCookieGroup.expireAllCookies();
        return new SimpleResponse(true, "退出成功");
    }
    
    @ApiRequestMappingAutoWithMethodName(name = "")
    @State(init = true, initCheck = false, dataOpt = DataOpt.FULL_REPLACE)
    public User getCookieUser() {
        String userId = this.loginCookieGroup.getCookieValue(LoginCookieNames.userId);
        if (StringUtil.isEmpty(userId)) {
            return null;
        }
        
        User user = this.userService.getUserByUserId(userId);
        if (user == null) {
            return null;
        }
        
        List<Long> visitsIds = this.menuService.getMenusByUserId(user.getUserId(), MenuType.MENU);
        user.setVisitsIds(visitsIds);
        return user;
    }
    
    @ApiRequestMappingAutoWithMethodName(name = "", method = RequestMethod.POST)
    public SimpleResponse login(
            @ApiParam("用户名") @RequestParam() String username,
            @ApiParam("密码") @RequestParam() String password,
            @ApiParam(hidden = true) User user) {
        BusinessAssert.mustNotNull(user, "用户数据不能为空");
        User loginUser = this.userService.getUserByUsername(username);
        if (loginUser != null) {
            String userPassword = loginUser.getPassword();
            BusinessAssert.mustEqual(String.class, userPassword, password, "密码不正确");
            loginCookieGroup.addCookie(LoginCookieNames.userId, loginUser.getUserId());
            return new SimpleResponse(true, "登录成功");
        }
        return new SimpleResponse(false, "用户不存在");
    }
    
    @ApiRequestMappingAutoWithMethodName(name = "获所所有菜单", method = RequestMethod.GET)
    @State(init = true, initCheck = false, dataOpt = DataOpt.FULL_REPLACE)
    public List<Menu> getAllMenus() {
        return this.menuService.getAllMenus();
    }
    
    @ApiRequestMappingAutoWithMethodName(name = "获取用户")
    public List<User> getUserOptions(@RequestParam(required = false, name = "userIds") ArrayList<String> userIds) {
        return null;
    }
    
    @ApiRequestMappingAutoWithMethodName(name = "省份")
    public List<Province> getProvinceOptions() {
        List<Province> provinceOptions = this.provinceService.getProvinceOptions();
        return provinceOptions;
    }
    
    @ApiRequestMappingAutoWithMethodName(name = "城市")
    public List<City> getCityOptions(@ApiParam("provinceId") String provinceId) {
        return this.cityService.getCityOptions(provinceId);
    }
    
    @ApiRequestMappingAutoWithMethodName(name = "爱好", method = RequestMethod.GET)
    public List<Hoppy> getHoppyOptions() {
        return this.hoppyService.getHoppyOptions();
    }
    
    @ApiRequestMappingAutoWithMethodName(name = "获取地区")
    public List<Region> getRegionOptions(
            @ApiParam("父ID") @RequestParam(required = false, name = "parentRegionIds") ArrayList<Long> parentRegionIds) {
        if (CollectionUtil.isNotEmpty(parentRegionIds)) {
            //客户端不必知道根值或处理根值的问题，直接传null上来
            if (parentRegionIds.get(0) == null) {
                parentRegionIds.set(0, 0L);
            }
        }
        
        List<Region>            regionOptions      = this.regionService.getRegionOptions(parentRegionIds);
        Map<Long, List<Region>> regionMap          = CollectionUtil.toGroup(regionOptions, Region::getParentRegionId);
        Long                    lastParentRegionId = CollectionUtil.getLast(parentRegionIds);
        if (lastParentRegionId != null) {
            List<Region> children = regionMap.get(lastParentRegionId);
            while (CollectionUtil.isNotEmpty(children)) {
                Region first = CollectionUtil.getFirst(children);
                if (first != null && !first.getIsLeaf()) {
                    children = this.regionService.getRegionOptions(Arrays.asList(first.getRegionId()));
                    regionOptions.addAll(children);
                } else {
                    children = null;
                }
                
            }
        }
        return regionOptions;
    }
    
}
