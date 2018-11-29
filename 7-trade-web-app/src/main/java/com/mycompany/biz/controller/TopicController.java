package com.mycompany.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.State;
import org.stategen.framework.annotation.Wrap;
import org.stategen.framework.enums.DataOpt;
import org.stategen.framework.lite.AntdPageList;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.lite.Pagination;
import org.stategen.framework.util.DatetimeUtil;

import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.enums.TopicType;

import io.swagger.annotations.ApiParam;

@ApiConfig
@Wrap
@RequestMapping("api")
public class TopicController extends TopicControllerBase {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TopicController.class);
    
    
    @ApiRequestMappingAutoWithMethodName
    @RequestMapping(value="topics",method=RequestMethod.GET)
    @State(init=true,dataOpt=DataOpt.APPEND_OR_UPDATE)
    public AntdPageList<Topic> getTopics(TopicType topicType,Boolean mdrender,@ApiParam(hidden=true) Topic topic, Pagination pagination){
        if (topicType==TopicType.all){
            topic.setTopicType(null);
        }
        topic.setCreateTimeMax(DatetimeUtil.current());
        
        PageList<Topic> topicPageList = this.topicService.getTopicPageListByDefaultQuery(topic, pagination.getPageSize(), pagination.getPage());
        return new AntdPageList<Topic>(topicPageList);
    }

}
