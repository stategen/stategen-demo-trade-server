package com.mycompany.biz.controller;

import java.util.Arrays;
import java.util.Date;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@ApiConfig
@Api
public class TopicController extends TopicControllerBase {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TopicController.class);
    
    @Resource
    private CookieGroup<LoginCookieNames> loginCookieGroup;
    
    
    @ApiRequestMappingAutoWithMethodName
    @State(init=true,dataOpt=DataOpt.APPEND_OR_UPDATE)
    @GenRefresh
    public AntdPageList<Topic> getTopicPageList(TopicType topicType,Boolean mdrender,@ApiParam(hidden=true) Topic topic, Pagination pagination){
        topic.setCreateTimeMax(DatetimeUtil.current());
        PageList<Topic> topicPageList = this.topicService.getPageList(topic, pagination.getPageSize(), pagination.getPage());
        topicService.assignTopicExtraProperties(topicPageList.getItems());
        return new AntdPageList<Topic>(topicPageList);
    }


    
    @ApiRequestMappingAutoWithMethodName
    @State
    public Topic update(@RequestParam(required=false) @ApiParam() String authorId,
                        @RequestParam(required=false) @ApiParam() String topicType,
                        @RequestParam(required=false) @ApiParam() String content,
                        @RequestParam(required=false) @ApiParam() String title,
                        @RequestParam(required=false) @ApiParam() String lastReplyAt,
                        @RequestParam(required=false) @ApiParam() String good,
                        @RequestParam(required=false) @ApiParam() String top,
                        @RequestParam(required=false) @ApiParam() Long visitCount,
                        @RequestParam(required=false) @ApiParam() String createAt,
                        @RequestParam(required=false) @ApiParam() Date testTimestamp,
                        @RequestParam(required=false) @ApiParam() Date testDatetime,
                        @RequestParam(required=false) @ApiParam() Date testDate,
                        @RequestParam(required=false) @ApiParam() Date testTime,
                        @RequestParam(required=false) @ApiParam() String topicId,                     
                        @ApiParam(hidden = true) Topic topic) {
        topic = this.topicService.update(topic);
        //forceUseLevelAuthorForWrite ，必须提供 至少invokerOrgId,invokerUserId之一
        topicService.assignTopicExtraProperties(Arrays.asList(topic));
        return topic;
    }
    
    
    @ApiRequestMappingAutoWithMethodName
    @State(area=Topic.class, dataOpt =DataOpt.DELETE_IF_EXIST)
    public String delete(String topicId ) {
        //forceUseLevelAuthorForWrite ，必须提供 至少invokerOrgId,invokerUserId之一
        //this.topicService.delete(topicId, inclInvokerOrgId, invokerOrgId, invokerUserId);
        return topicId;
    }
    @ApiRequestMappingAutoWithMethodName
    @State(area=Topic.class, dataOpt =DataOpt.DELETE_IF_EXIST)
    public String[] deleteBatch(String[] topicIds ) {
      //forceUseLevelAuthorForWrite ，必须提供 至少invokerOrgId,invokerUserId之一
        return topicIds;
    }
    

}
