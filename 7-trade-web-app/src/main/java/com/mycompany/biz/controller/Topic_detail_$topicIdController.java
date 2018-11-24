package com.mycompany.biz.controller;

import java.util.Arrays;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.State;
import org.stategen.framework.annotation.Wrap;
import org.stategen.framework.enums.StateOperation;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.lite.Pagination;
import org.stategen.framework.web.cookie.CookieGroup;

import com.mycompany.biz.checker.LoginCheck;
import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.domain.TopicReply;
import com.mycompany.biz.service.TopicReplyService;
import com.mycompany.biz.service.TopicUpService;
import com.mycompany.biz.service.UserService;
import com.mycompany.biz.utils.SysConsts;

import io.swagger.annotations.ApiParam;

@ApiConfig
@Wrap
@RequestMapping("api/topic")
public class Topic_detail_$topicIdController extends TopicControllerBase {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Topic_detail_$topicIdController.class);

    @Resource
    private TopicReplyService topicReplyService;
    @Resource
    private CookieGroup loginCookieGroup;

    @Resource
    private UserService userService;

    @Resource
    private TopicUpService topicUpService;

    @ApiRequestMappingAutoWithMethodName
    @RequestMapping("/{topicId}")
    @State(init = true, operation = StateOperation.FULL_REPLACE)
    public Topic getTopicDetail(@PathVariable("topicId") String topicId) {
        Topic topic = this.topicService.getTopicByTopicId(topicId);
        return topic;
    }

    @ApiRequestMappingAutoWithMethodName
    @RequestMapping("/{topicId}/getReplies")
    @State(init = true, operation = StateOperation.APPEND_OR_UPDATE_CURRENT)
    public PageList<TopicReply> getTopicReplies(@PathVariable("topicId") String topicId, @ApiParam(hidden = true) TopicReply topicReply,
                                                Pagination pagination) {

        String userId = loginCookieGroup.getCookieValue(SysConsts.USER_ID);
        PageList<TopicReply> topicReplyPageList = topicReplyService.getTopicReplyPageListByDefaultQuery(topicReply, userId, pagination.getPageSize(),
            pagination.getPage());
        return topicReplyPageList;
    }

    @ApiRequestMappingAutoWithMethodName
    @RequestMapping("reply/{replyId}")
    @LoginCheck
    public TopicReply replyUp(@PathVariable("replyId") String replyId) {
        String userId = this.loginCookieGroup.getCookieValue(SysConsts.USER_ID);
        return this.topicReplyService.replyUp(replyId, userId);
    }

    @ApiRequestMappingAutoWithMethodName
    @RequestMapping("/{topicId}/postReply")
    @LoginCheck
    public TopicReply PostReply(@PathVariable("topicId") String topicId, TopicReply topicReply) {
        topicReply.setTopicId(topicId);
        String userId = loginCookieGroup.getCookieValue(SysConsts.USER_ID);
        topicReply.setAuthorId(userId);
        this.topicReplyService.saveTopicReply(topicReply);
        if (logger.isInfoEnabled()) {
            logger.info(new StringBuffer("输出info信息: topicReply:").append(topicReply).toString());
        }
        topicReplyService.assignRepliesExtraProperties(userId, Arrays.asList(topicReply));
        return topicReply;
    }
}
