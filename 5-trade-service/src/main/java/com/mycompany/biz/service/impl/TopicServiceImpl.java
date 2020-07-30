/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.stategen.framework.cache.BaseCacheTaker;
import org.stategen.framework.lite.IIdGenerator;
import org.stategen.framework.lite.IdGenerateService;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.util.AfterInsertService;
import org.stategen.framework.util.BusinessAssert;
import org.stategen.framework.util.CollectionUtil;
import org.stategen.framework.util.ServiceUtil;
import org.stategen.framework.util.StringUtil;

import com.mycompany.biz.dao.TopicDao;
import com.mycompany.biz.domain.Topic;
import com.mycompany.biz.domain.TopicLevelH;
import com.mycompany.biz.domain.TopicOwnerH;
import com.mycompany.biz.domain.User;
import com.mycompany.biz.enums.CookieType.Login.LoginCookieNames;
import com.mycompany.biz.service.FileSummaryService;
import com.mycompany.biz.service.TopicLevelHService;
import com.mycompany.biz.service.TopicOwnerHService;
import com.mycompany.biz.service.TopicService;
import com.mycompany.biz.service.UserService;

/**
 * TopicServiceImpl
 * <pre>
 * database table: topic
 * database table comments: Topic
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public class TopicServiceImpl implements TopicService, AfterInsertService<Topic>, IdGenerateService<String> {

    @Resource
    private IIdGenerator idGenerator;

    @Resource()
    private TopicLevelHService topicLevelHService;

    @Resource()
    private TopicOwnerHService topicOwnerHService;

    @Autowired
    private BaseCacheTaker<LoginCookieNames> baseCacheTaker;

    @Resource(name = "topicDao")
    private TopicDao topicDao;

    @Resource()
    private UserService userService;

    @Resource()
    private FileSummaryService fileSummaryService;

    @Override
    public void assignTopicExtraProperties(List<Topic> topics) {
        userService.assignBeanTo(topics, Topic::getAuthorId, Topic::setAuthor);
        List<User> authors = CollectionUtil.toList(topics, Topic::getAuthor);
        fileSummaryService.assignBeanTo(authors, User::getAvatarImgId, User::setAvatarImg);
        List<String> topicIds = CollectionUtil.toList(topics, Topic::getTopicId);
        List<Topic> replyCounts = this.getReplyCounts(topicIds);
        Map<String, Topic> replyCountMap = CollectionUtil.toMap(replyCounts, Topic::getTopicId);
        CollectionUtil.setFeildToFieldByMap(topics, replyCountMap, Topic::getTopicId, Topic::setReplyCount, Topic::getReplyCount);
    }

    @Override
    public void afterInsert(Topic topic) {
        String topicId = topic.getTopicId();
        //--demo_topic_level_h
        Long currOrgId = baseCacheTaker.get(LoginCookieNames.currOrgId, Long.class);
        BusinessAssert.mustNotNull(currOrgId, "currOrgId connot be null");
        TopicLevelH topicLevelH = new TopicLevelH();
        topicLevelH.setTopicId(topicId);
        topicLevelH.setOrgId(currOrgId);
        this.topicLevelHService.insert(topicLevelH);
        //--demo_topic_owner_h
        String currUserId = baseCacheTaker.get(LoginCookieNames.currUserId, String.class);
        BusinessAssert.mustNotNull(currUserId, "currUserId connot be null");
        TopicOwnerH topicOwnerH = new TopicOwnerH();
        topicOwnerH.setTopicId(topicId);
        topicOwnerH.setUserId(currUserId);
        this.topicOwnerHService.insert(topicOwnerH);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicDao#insert
     * @see com.mycompany.biz.service.TopicService#insert
     */
    @Override
    public Topic insert(Topic topic) {
        return topicDao.insert(topic, this, this);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicDao#delete
     * @see com.mycompany.biz.service.TopicService#delete
     */
    @Override
    public String delete(String topicId, Boolean inclCurrOrgId, Long currOrgId, String currUserId) {
        return topicDao.delete(topicId, inclCurrOrgId, currOrgId, currUserId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicDao#update
     * @see com.mycompany.biz.service.TopicService#update
     */
    @Override
    public Topic update(Topic topic) {
        return topicDao.update(topic);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicDao#getTopicByTopicId
     * @see com.mycompany.biz.service.TopicService#getTopicByTopicId
     */
    @Override
    public Topic getTopicByTopicId(String topicId, Boolean inclCurrOrgId, Long currOrgId, String currUserId) {
        return topicDao.getTopicByTopicId(topicId, inclCurrOrgId, currOrgId, currUserId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicDao#getPageList
     * @see com.mycompany.biz.service.TopicService#getPageList
     */
    @Override
    public PageList<Topic> getPageList(Topic topic, int pageSize, int pageNum) {
        return topicDao.getPageList(topic, pageSize, pageNum);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicDao#getTopicsByTopicIds
     * @see com.mycompany.biz.service.TopicService#getTopicsByTopicIds
     */
    @Override
    public List<Topic> getTopicsByTopicIds(java.util.List<String> topicIds, Boolean inclCurrOrgId, Long currOrgId, String currUserId) {
        return topicDao.getTopicsByTopicIds(topicIds, inclCurrOrgId, currOrgId, currUserId);
    }

    /**
     * @see com.mycompany.biz.service.TopicService#getTopicsByTopicIds
     */
    @Override
    public List<Topic> getTopicsByTopicIdsNoLevelAuthority(java.util.List<String> topicIds) {
        return getTopicsByTopicIds(topicIds, null, null, null);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicDao#deleteByTopicIds
     * @see com.mycompany.biz.service.TopicService#deleteByTopicIds
     */
    @Override
    public java.util.List<String> deleteByTopicIds(java.util.List<String> topicIds, Boolean inclCurrOrgId, Long currOrgId, String currUserId) {
        return topicDao.deleteByTopicIds(topicIds, inclCurrOrgId, currOrgId, currUserId);
    }

    /**
     * 获取当前回复的数量
     * @see com.mycompany.biz.dao.TopicDao#getReplyCounts
     * @see com.mycompany.biz.service.TopicService#getReplyCounts
     */
    @Override
    public List<Topic> getReplyCounts(java.util.List<String> topicIds) {
        return topicDao.getReplyCounts(topicIds);
    }

    /*** 保存topic,有id时更新，没有id时插入,并带回新的id，返回 topic*/
    @Override
    public Topic saveTopic(Topic topic) {
        if (topic != null) {
            java.lang.String topicId = topic.getTopicId();
            if (StringUtil.isBlank(topicId)) {
                insert(topic);
            } else {
                update(topic);
            }
        }
        return topic;
    }

    /*** 批量保存topics,有id时更新，没有id时插入,并带回新的id，返回 topics*/
    @Override
    public List<Topic> saveTopics(List<Topic> topics) {
        for (Topic topic : topics) {
            this.saveTopic(topic);
        }
        return topics;
    }

    @Override
    public <D> void assignBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod, BiConsumer<D, Topic> destSetMethod) {
        ServiceUtil.interalAssignBeanTo(dests, destGetMethod, destSetMethod, this, TopicServiceImpl::getTopicsByTopicIdsNoLevelAuthority, Topic::getTopicId);
    }

    @Override
    public <D, G> void assignBeansTo(Collection<D> dests, Function<? super D, G> destGetMethod, BiConsumer<D, List<Topic>> destSetMethod, BiConsumer<Topic, List<G>> resultSetQueryIdsFun, Function<? super Topic, G> resultGetGoupIdFun) {
        ServiceUtil.interalAssignBeansTo(dests, destGetMethod, destSetMethod, this, new Topic(), resultSetQueryIdsFun, resultGetGoupIdFun, 100);
    }

    @Override
    public <D> void mergeBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod) {
        ServiceUtil.interalMergeBeanTo(dests, destGetMethod, this, TopicServiceImpl::getTopicsByTopicIdsNoLevelAuthority, Topic::getTopicId);
    }

    @Override
    public <T> String generateId(Class<T> bizTagClz) {
        return this.idGenerator.generateId(String.class, bizTagClz);
    }
}
