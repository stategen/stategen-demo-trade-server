package com.mycompany.biz.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestParam;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.State;
import org.stategen.framework.enums.DataOpt;
import org.stategen.framework.lite.AntdPageList;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.lite.Pagination;
import org.stategen.framework.util.DatetimeUtil;
import org.stategen.framework.web.cookie.CookieGroup;

import com.mycompany.biz.domain.Topic;

import io.swagger.annotations.ApiParam;

@ApiConfig(name="论坛列表")
public class Bbs_topicController extends TopicControllerBase {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Bbs_topicController.class);

    @Resource
    private CookieGroup loginCookieGroup;

    @ApiRequestMappingAutoWithMethodName
    @State(init = true, dataOpt = DataOpt.FULL_REPLACE,genForm=true)
    public AntdPageList<Topic> getTopicPageList(@ApiParam() String topicId,
                                                @ApiParam()@RequestParam(required =false,name="topicIds") ArrayList<String> topicIds,
                                                @ApiParam() String authorId,
                                                @ApiParam()@RequestParam(required =false,name="authorIds") ArrayList<String> authorIds,
                                                @ApiParam() String topicType,
                                                @ApiParam()@RequestParam(required =false,name="topicTypes") ArrayList<String> topicTypes,
                                                @ApiParam() String content,
                                                @ApiParam() String contentLike,
                                                @ApiParam() String title,
                                                @ApiParam() String titleLike,
                                                @ApiParam() Date lastReplyAtMin,
                                                @ApiParam() Date lastReplyAtMax,
                                                @ApiParam() Long goodMin,
                                                @ApiParam() Long goodMax,
                                                @ApiParam() Long topMin,
                                                @ApiParam() Long topMax,
                                                @ApiParam() Long visitCountMin,
                                                @ApiParam() Long visitCountMax,
                                                @ApiParam() Date testTimestampMin,
                                                @ApiParam() Date testTimestampMax,
                                                @ApiParam() Date testDatetimeMin,
                                                @ApiParam() Date testDatetimeMax,
                                                @ApiParam() Date testDateMin,
                                                @ApiParam() Date testDateMax,
                                                @ApiParam() Date testTimeMin,
                                                @ApiParam() Date testTimeMax,
                                                @ApiParam() Date createTimeMin,
                                                @ApiParam() Date createTimeMax,
                                                @ApiParam() Date updateTimeMin,
                                                @ApiParam() Date updateTimeMax
                                                ,@ApiParam(hidden = true) Topic topic
                                                ,Pagination pagination


) {
        topic.setCreateTimeMax(DatetimeUtil.current());

        PageList<Topic> topicPageList = this.topicService.getTopicPageList(topic, pagination.getPageSize(), pagination.getPage());
        return new AntdPageList<Topic>(topicPageList);
    }

    @ApiRequestMappingAutoWithMethodName
    @State(dataOpt = DataOpt.DELETE_IF_EXIST)
    public String delete(String topicId) {
        return this.topicService.delete(topicId);
    }

    @ApiRequestMappingAutoWithMethodName
    @State(dataOpt = DataOpt.DELETE_IF_EXIST)
    public List<String> deleteByTopicIds(@ApiParam("topicId") @RequestParam(required = false, name = "topicIds") ArrayList<String> topicIds) {
        return this.topicService.deleteByTopicIds(topicIds);
    }

    @ApiRequestMappingAutoWithMethodName
    @State(dataOpt = DataOpt.APPEND_OR_UPDATE)
    public Topic insert(@ApiParam() String topicId, @ApiParam() String authorId, @ApiParam() String topicType, @ApiParam() String content,
                        @ApiParam() String title, @ApiParam() String lastReplyAt, @ApiParam() String good, @ApiParam() String top,
                        @ApiParam() Long visitCount, @ApiParam() String createAt, @ApiParam() Date testTimestamp, @ApiParam() Date testDatetime,
                        @ApiParam() Date testDate, @ApiParam() Date testTime, @ApiParam(hidden = true) Topic topic) {
        return this.topicService.insert(topic);
    }

    @ApiRequestMappingAutoWithMethodName
    @State(dataOpt = DataOpt.APPEND_OR_UPDATE)
    public Topic update(@ApiParam() String authorId, @ApiParam() String topicType, @ApiParam() String content, @ApiParam() String title,
                        @ApiParam() String lastReplyAt, @ApiParam() String good, @ApiParam() String top, @ApiParam() Long visitCount,
                        @ApiParam() String createAt, @ApiParam() Date testTimestamp, @ApiParam() Date testDatetime, @ApiParam() Date testDate,
                        @ApiParam() Date testTime, @ApiParam() String topicId, @ApiParam(hidden = true) Topic topic) {
        return this.topicService.update(topic);
    }

}