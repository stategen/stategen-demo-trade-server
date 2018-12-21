package com.mycompany.biz.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestParam;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.GenForm;
import org.stategen.framework.annotation.OptionConfig;
import org.stategen.framework.annotation.State;
import org.stategen.framework.enums.DataOpt;
import org.stategen.framework.lite.AntdPageList;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.lite.Pagination;
import org.stategen.framework.util.DatetimeUtil;
import org.stategen.framework.web.cookie.CookieGroup;

import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.enums.TopicType;

import io.swagger.annotations.ApiParam;

@ApiConfig(name="论坛列表")
public class Bbs_topicController extends TopicControllerBase {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Bbs_topicController.class);

    @Resource
    private CookieGroup loginCookieGroup;

    @ApiRequestMappingAutoWithMethodName
    @State(init = true, dataOpt = DataOpt.FULL_REPLACE,genForm=true)
    public AntdPageList<Topic> getTopicPageList(
                                                @ApiParam()@RequestParam(required =false,name="topicIds") ArrayList<String> topicIds,
                                                @ApiParam()@RequestParam(required =false,name="authorIds") ArrayList<String> authorIds,
                                                @ApiParam() TopicType topicType,
                                                @ApiParam()@RequestParam(required =false,name="topicTypes") ArrayList<TopicType> topicTypes,
                                                @ApiParam() String title,
                                                @ApiParam() String titleLike,
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
                                                
                                                @OptionConfig()
                                                @ApiParam() String provinceId,
                                                
                                                @ApiParam()@RequestParam(required =false,name="cityIds") ArrayList<String> cityIds,
                                                
                                                @ApiParam()@RequestParam(required =false,name="provinceIds") ArrayList<String> provinceIds
                                                
                                                ,@ApiParam(hidden = true) Topic topic
                                                ,Pagination pagination


) {
        topic.setCreateTimeMax(DatetimeUtil.current());

        PageList<Topic> topicPageList = this.topicService.getTopicPageList(topic, pagination.getPageSize(), pagination.getPage());
        
        setTopicModels(topicPageList.getItems());
        
        return new AntdPageList<Topic>(topicPageList);
    }

    @ApiRequestMappingAutoWithMethodName
    @State(dataOpt = DataOpt.DELETE_IF_EXIST,area=Topic.class)
    public String delete(String topicId) {
        return this.topicService.delete(topicId);
    }

    @ApiRequestMappingAutoWithMethodName
    @State(dataOpt = DataOpt.DELETE_IF_EXIST,area=Topic.class)
    public List<String> deleteByTopicIds(@ApiParam("topicId") @RequestParam(required = false, name = "topicIds") ArrayList<String> topicIds) {
        return this.topicService.deleteByTopicIds(topicIds);
    }

    @ApiRequestMappingAutoWithMethodName
    @State(dataOpt = DataOpt.APPEND_OR_UPDATE)
    @GenForm
    public Topic insert(@ApiParam() String topicId,
                        @ApiParam() String authorId,
                        @ApiParam() TopicType topicType,
                        @ApiParam() String content,
                        @ApiParam() String title,
                        @ApiParam() Date lastReplyAt,
                        @ApiParam() Long good,
                        @ApiParam() Long top,
                        @ApiParam() Long visitCount,
                        @ApiParam() Date testTimestamp,
                        @ApiParam() Date testDatetime,
                        @ApiParam() Date testDate,
                        @ApiParam() Date testTime,
                        @ApiParam() String provinceId,
                        @ApiParam() String cityId
                        ,@ApiParam(hidden = true) Topic topic
) {
        topic = topicService.insert(topic);
        setTopicModels(Arrays.asList(topic));
        return topic;
    }

    @ApiRequestMappingAutoWithMethodName
    @State(dataOpt = DataOpt.APPEND_OR_UPDATE)
    @GenForm
    public Topic update(@ApiParam() String authorId,
                        @ApiParam() TopicType topicType,
                        @ApiParam() String content,
                        @ApiParam() String title,
                        @ApiParam() Date lastReplyAt,
                        @ApiParam() Long good,
                        @ApiParam() TopicType top,
                        @ApiParam() Long visitCount,
                        @ApiParam() Date testTimestamp,
                        @ApiParam() Date testDatetime,
                        @ApiParam() Date testDate,
                        @ApiParam() Date testTime,
                        @ApiParam() String provinceId,
                        @ApiParam() String cityId,
                        @ApiParam() String topicId
                        ,@ApiParam(hidden = true) Topic topic) {
        topic=topicService.update(topic);
        setTopicModels(Arrays.asList(topic));
        return topic;
    }

}
