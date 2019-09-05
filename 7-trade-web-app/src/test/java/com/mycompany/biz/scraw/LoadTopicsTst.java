package com.mycompany.biz.scraw;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class LoadTopicsTst {
//    @Resource
//    TopicService topicService;
//
//    @Resource
//    TopicReplyService topicReplyService;
//
//    @Resource
//    UserService topicAuthorService;
//    
//    @Resource
//    TopicUpService topicUpService;
//
//    @Test
//    @Transactional
//    public void loadTopics() throws IOException, GeneralSecurityException, InterruptedException {
//        String topicsPath = Thread.currentThread().getContextClassLoader().getResource("topics.json").getPath();
//        String readFileToString = FileUtils.readFileToString(new File(topicsPath), StringUtil.UTF_8);
//        List<Topic> topics = JSON.parseArray(readFileToString, Topic.class);
//        Map<String, User> topicAuthorMap = new HashMap<String, User>();
//
//        for (Topic topic : topics) {
//            User topicAuthor = topic.getAuthor();
//            topicAuthor.setUserId(topic.getAuthorId());
//            System.out.println(topic.getContent());
//            
//            if (!topicAuthorMap.containsKey(topicAuthor.getUsername())) {
//                topicAuthorMap.put(topicAuthor.getUsername(), topicAuthor);
//                this.topicAuthorService.insert(topicAuthor);
//            }
//            this.topicService.insert(topic);
//        }
//
//        for (Topic topic : topics) {
//            String getTopicUrl = "https://cnodejs.org/api/v1/topic/" + topic.getTopicId()
//                                 + "?m1jbbtllrr&mdrender=true&accesstoken="+"your accesstoken";
//            String reponseHttp = HttpsUtil.doGet(getTopicUrl);
//            JSONObject parseObject = JSON.parseObject(reponseHttp);
//            String theTopicString = parseObject.getString("data");
//            Topic theTopic = JSON.parseObject(theTopicString, Topic.class);
//
//            List<TopicReply> replies = theTopic.getReplies();
//            for (TopicReply topicReply : replies) {
//                topicReply.setTopicId(topic.getTopicId());
//                User replyAuthor = topicReply.getAuthor();
//                User existAuthor = topicAuthorMap.get(replyAuthor.getUsername());
//                if (existAuthor == null) {
//                    topicAuthorMap.put(replyAuthor.getUsername(), replyAuthor);
//                    this.topicAuthorService.insert(replyAuthor);
//                } else {
//                    replyAuthor = existAuthor;
//                }
//                topicReply.setAuthorId(replyAuthor.getUserId());
//                this.topicReplyService.insert(topicReply);
//                List<String> ups = topicReply.getUps();
//                for (String upAuthorId : ups) {
//                    TopicUp topicUp =new TopicUp();
//                    topicUp.setAuthorId(upAuthorId);
//                    topicUp.setTopicOrReplyId(topicReply.getTopicReplyId());
//                    topicUpService.insert(topicUp);
//                }
//            }
//
//            Thread.sleep(1000L);
//        }
//        
//    }

}
