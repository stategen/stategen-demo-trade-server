package com.mycompany.biz.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestParam;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.GenRefresh;
import org.stategen.framework.annotation.State;
import org.stategen.framework.enums.DataOpt;
import org.stategen.framework.lite.AntdPageList;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.lite.Pagination;
import org.stategen.framework.util.DatetimeUtil;
import org.stategen.framework.web.cookie.CookieGroup;

import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.enums.CookieType.Login.LoginCookieNames;
import com.mycompany.biz.enums.TopicType;

import io.swagger.annotations.ApiParam;

@ApiConfig
public class TopicController extends TopicControllerBase {
    
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TopicController.class);
    
    @Resource
    private CookieGroup<LoginCookieNames> loginCookieGroup;
    
    @ApiRequestMappingAutoWithMethodName
    @State(init = true, dataOpt = DataOpt.APPEND_OR_UPDATE)
    @GenRefresh
    public AntdPageList<Topic> getTopicPageList(
            TopicType topicType,
            Boolean mdrender,
            @ApiParam(hidden = true) Topic topic,
            Pagination pagination) {
        topic.setCreateTimeMax(DatetimeUtil.current());
        PageList<Topic> topicPageList = this.topicService.getPageList(topic, pagination.getPageSize(), pagination.getPage());
        topicService.assignTopicExtraProperties(topicPageList.getItems());
        return new AntdPageList<Topic>(topicPageList);
    }
    
    @ApiRequestMappingAutoWithMethodName
    @State
    public Topic update(
            @ApiParam() @RequestParam(required = false) String authorId,
            @ApiParam() @RequestParam(required = false) TopicType topicType,
            @ApiParam() @RequestParam(required = false) String content,
            @ApiParam() @RequestParam(required = false) String title,
            @ApiParam() @RequestParam(required = false) Date lastReplyAt,
            @ApiParam() @RequestParam(required = false) Long good,
            @ApiParam() @RequestParam(required = false) TopicType top,
            @ApiParam() @RequestParam(required = false) Long visitCount,
            @ApiParam() @RequestParam(required = false) String topicId,
            @ApiParam(hidden = true) Topic topic
    
    ) {
        topic = this.topicService.update(topic);
        //forceUseLevelAuthorForWrite ，必须提供 至少invokerOrgId,invokerUserId之一
        topicService.assignTopicExtraProperties(Arrays.asList(topic));
        return topic;
    }
    
    @ApiRequestMappingAutoWithMethodName
    @State(area = Topic.class, dataOpt = DataOpt.DELETE_IF_EXIST)
    public String delete(String topicId) {
        //gen_config.xml中 forceUseLevelAuthorForWrite ，必须提供 至少invokerOrgId,invokerUserId之一
        //this.topicService.delete(topicId, null, null, null);
        return topicId;
    }
    
    @ApiRequestMappingAutoWithMethodName
    @State(area = Topic.class, dataOpt = DataOpt.DELETE_IF_EXIST)
    public List<String>  deleteBatch(
            @ApiParam("主题ID") @RequestParam(required = false, name="topicIds") ArrayList<String> topicIds ) {
        //gen_config.xml中 forceUseLevelAuthorForWrite ，必须提供 至少invokerOrgId,invokerUserId之一
        //this.topicService.deleteByTopicIds(topicIds, null, null, null);
        return topicIds;
    }
    
}
