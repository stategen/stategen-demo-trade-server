package com.mycompany.biz.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.GenForm;
import org.stategen.framework.annotation.State;
import org.stategen.framework.enums.DataOpt;

import com.mycompany.biz.checker.LoginCheck;
import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.enums.TopicType;

@ApiConfig
public class Topic_publishController extends TopicControllerBase {

    @Override
    @ApiRequestMappingAutoWithMethodName(method=RequestMethod.POST)
    @RequestMapping("topics")
    @LoginCheck
    @GenForm
    @State(dataOpt=DataOpt.FULL_REPLACE)
    public Topic saveTopic(String topicId, TopicType topicType, String content, String title, Date testTimestamp, Date testDatetime, Date testDate,
                            Date testTime, Topic topic) {
        return super.saveTopic(topicId, topicType, content, title, testTimestamp, testDatetime, testDate, testTime, topic);
    }

}
