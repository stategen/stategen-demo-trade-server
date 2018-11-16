package com.mycompany.biz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.Wrap;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.util.DatetimeUtil;

import com.alibaba.fastjson.JSON;
import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.domain.TopicAuthor;
import com.mycompany.biz.domain.TopicReply;
import com.mycompany.biz.service.TopicAuthorService;
import com.mycompany.biz.service.TopicReplyService;

import io.swagger.annotations.ApiParam;

@ApiConfig
@Wrap
@RequestMapping("api")
public class TopicListController extends TopicControllerBase {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TopicListController.class);
    
    @Resource
    private TopicReplyService topicReplyService;
    
    @Resource
    private TopicAuthorService topicAuthorService;
    
    
    @ApiRequestMappingAutoWithMethodName
    @RequestMapping(value="topics",method=RequestMethod.GET)
    public List<Topic> getTopics(int page,String tab,int limit,Boolean mdrender,@ApiParam(hidden=true) Topic topic){
        if ("all".equals(tab)){
            topic.setTab(null);
            topic.setCreateTimeMax(DatetimeUtil.current());
        }
        if (logger.isInfoEnabled()) {
            logger.info(new StringBuffer("输出info信息: topic:").append(JSON.toJSON(topic)).toString());
        }
        
        PageList<Topic> topicPageList = this.topicService.getTopicPageListByDefaultQuery(topic, limit, page);
        return topicPageList.getItems();
    }
    
    @ApiRequestMappingAutoWithMethodName
    @RequestMapping("reply/{replyId}")
    public TopicReply replyUp(@PathVariable("replyId") String replyId,String accesstoken ){
        TopicAuthor topicAuthor = topicAuthorService.getTopicAuthorByLoginname("niaoge");
        String authorId = topicAuthor.getAuthorId();
        TopicReply topicReply = new TopicReply();
        topicReply.setReplyId(replyId);
        topicReply.setAuthorId(authorId);
        this.topicReplyService.insert(topicReply);
        return topicReply;
    }
    
    @ApiRequestMappingAutoWithMethodName
    @RequestMapping("topic/{topicId}/replies")
    public TopicReply PostReply(@PathVariable("topicId") String topicId, TopicReply topicReply ){
        topicReply.setTopicId(topicId);
        this.topicReplyService.saveTopicReply(topicReply);
        return topicReply;
    }
    
    
    
    

}
