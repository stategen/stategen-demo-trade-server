package com.mycompany.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.State;
import org.stategen.framework.annotation.Wrap;
import org.stategen.framework.enums.StateOperation;
import org.stategen.framework.web.cookie.CookieGroup;

import com.mycompany.biz.checker.LoginCheck;
import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.domain.TopicReply;
import com.mycompany.biz.domain.User;
import com.mycompany.biz.service.TopicReplyService;
import com.mycompany.biz.service.UserService;
import com.mycompany.biz.utils.SysConsts;

@ApiConfig
@Wrap
@RequestMapping("api/topic")
@LoginCheck
public class Topic_$idController extends TopicControllerBase {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Topic_$idController.class);

    @Resource
    private TopicReplyService topicReplyService;
    @Resource
    private CookieGroup loginCookieGroup;

    @Resource
    private UserService userService;

    @ApiRequestMappingAutoWithMethodName
    @RequestMapping("/{topicId}")
    @State(init=true,operation=StateOperation.FULL_REPLACE)
    public Topic getTopicDetail(@PathVariable("topicId") String topicId) {
        Topic topic = this.topicService.getTopicByTopicId(topicId);
        return topic;
    }

    @ApiRequestMappingAutoWithMethodName
    @RequestMapping("reply/{replyId}")
    @LoginCheck
    public TopicReply replyUp(@PathVariable("replyId") String replyId) {
        String userId = this.loginCookieGroup.getCookieValue(SysConsts.USER_ID);
        User topicAuthor = userService.getUserByUserId(userId);
        String authorId = topicAuthor.getUserId();
        TopicReply topicReply = new TopicReply();
        topicReply.setReplyId(replyId);
        topicReply.setAuthorId(authorId);
        this.topicReplyService.insert(topicReply);
        return topicReply;
    }

    @ApiRequestMappingAutoWithMethodName
    @RequestMapping("topic/{topicId}/replies")
    @LoginCheck
    public TopicReply PostReply(@PathVariable("topicId") String topicId, TopicReply topicReply) {
        topicReply.setTopicId(topicId);
        this.topicReplyService.saveTopicReply(topicReply);
        return topicReply;
    }
}
