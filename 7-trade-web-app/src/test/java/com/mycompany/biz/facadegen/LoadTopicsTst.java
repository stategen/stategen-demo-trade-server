package com.mycompany.biz.facadegen;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.stategen.framework.spring.util.HttpsUtil;
import org.stategen.framework.util.StringUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.domain.TopicAuthor;
import com.mycompany.biz.domain.TopicReply;
import com.mycompany.biz.domain.TopicUp;
import com.mycompany.biz.service.TopicAuthorService;
import com.mycompany.biz.service.TopicReplyService;
import com.mycompany.biz.service.TopicService;
import com.mycompany.biz.service.TopicUpService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class LoadTopicsTst {
    @Resource
    TopicService topicService;

    @Resource
    TopicReplyService topicReplyService;

    @Resource
    TopicAuthorService topicAuthorService;
    
    @Resource
    TopicUpService topicUpService;

    @Test
    @Transactional
    public void loadTopics() throws IOException, GeneralSecurityException, InterruptedException {
        String topicsPath = Thread.currentThread().getContextClassLoader().getResource("topics.json").getPath();
        String readFileToString = FileUtils.readFileToString(new File(topicsPath), StringUtil.UTF_8);
        List<Topic> topics = JSON.parseArray(readFileToString, Topic.class);
        Map<String, TopicAuthor> topicAuthorMap = new HashMap<String, TopicAuthor>();

        for (Topic topic : topics) {
            TopicAuthor topicAuthor = topic.getAuthor();
            topicAuthor.setAuthorId(topic.getAuthorId());
            System.out.println(topic.getContent());
            
            if (!topicAuthorMap.containsKey(topicAuthor.getLoginname())) {
                topicAuthorMap.put(topicAuthor.getLoginname(), topicAuthor);
                this.topicAuthorService.insert(topicAuthor);
            }
            this.topicService.insert(topic);
        }

        for (Topic topic : topics) {
            String getTopicUrl = "https://cnodejs.org/api/v1/topic/" + topic.getTopicId()
                                 + "?m1jbbtllrr&mdrender=true&accesstoken="+"your accesstoken";
            String reponseHttp = HttpsUtil.doGet(getTopicUrl);
            JSONObject parseObject = JSON.parseObject(reponseHttp);
            String theTopicString = parseObject.getString("data");
            Topic theTopic = JSON.parseObject(theTopicString, Topic.class);

            List<TopicReply> replies = theTopic.getReplies();
            for (TopicReply topicReply : replies) {
                topicReply.setTopicId(topic.getTopicId());
                TopicAuthor replyAuthor = topicReply.getAuthor();
                TopicAuthor existAuthor = topicAuthorMap.get(replyAuthor.getLoginname());
                if (existAuthor == null) {
                    topicAuthorMap.put(replyAuthor.getLoginname(), replyAuthor);
                    this.topicAuthorService.insert(replyAuthor);
                } else {
                    replyAuthor = existAuthor;
                }
                topicReply.setAuthorId(replyAuthor.getAuthorId());
                this.topicReplyService.insert(topicReply);
                List<String> ups = topicReply.getUps();
                for (String upAuthorId : ups) {
                    TopicUp topicUp =new TopicUp();
                    topicUp.setAuthorId(upAuthorId);
                    topicUp.setTopicOrReplyId(topicReply.getTopicReplyId());
                    topicUpService.insert(topicUp);
                }
            }

            Thread.sleep(1000L);
        }
        
    }

}
