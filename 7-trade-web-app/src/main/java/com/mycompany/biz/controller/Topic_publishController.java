package com.mycompany.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.GenForm;
import org.stategen.framework.annotation.State;
import org.stategen.framework.annotation.Wrap;
import org.stategen.framework.enums.DataOpt;
import org.stategen.framework.web.cookie.CookieGroup;

import com.mycompany.biz.checker.LoginCheck;
import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.enums.TopicType;
import com.mycompany.biz.utils.SysConsts;

import io.swagger.annotations.ApiParam;

@ApiConfig
@Wrap
public class Topic_publishController extends TopicControllerBase {
    
    @Resource
    private CookieGroup loginCookieGroup;
    
    @ApiRequestMappingAutoWithMethodName(method=RequestMethod.POST)
    @RequestMapping("topics")
    @LoginCheck
    @GenForm
    @State(dataOpt=DataOpt.FULL_REPLACE)
    public Topic publish(@ApiParam() String topicId,
                         @ApiParam() TopicType topicType,
                         @ApiParam() String content,
                         @ApiParam() String title,
                         @ApiParam(hidden = true) Topic topic){
        String userId = loginCookieGroup.getCookieValue(SysConsts.USER_ID);
        topic.setAuthorId(userId);
        topicService.saveTopic(topic);
        return topic;
    }

}
