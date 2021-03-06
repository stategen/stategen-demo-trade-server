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

import org.stategen.framework.lite.IIdGenerator;
import org.stategen.framework.lite.IdGenerateService;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.util.CollectionUtil;
import org.stategen.framework.util.ServiceUtil;
import org.stategen.framework.util.StringUtil;

import com.mycompany.biz.dao.TopicReplyDao;
import com.mycompany.biz.domain.TopicReply;
import com.mycompany.biz.domain.TopicUp;
import com.mycompany.biz.domain.User;
import com.mycompany.biz.service.FileSummaryService;
import com.mycompany.biz.service.TopicReplyService;
import com.mycompany.biz.service.TopicUpService;
import com.mycompany.biz.service.UserService;

/**
 * TopicReplyServiceImpl
 * <pre>
 * database table: topic_reply
 * database table comments: TopicReply
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 新生成的类中的方法，只有在不同名的情况下才会被追加到该类下，
 * 因此该类可以修改任何部分
 * </pre>
 */
public class TopicReplyServiceImpl implements TopicReplyService, IdGenerateService<String> {

    @Resource
    private IIdGenerator idGenerator;

    @Resource
    TopicUpService topicUpService;

    @Resource
    UserService userService;

    @Resource
    FileSummaryService fileSummaryService;

    @Override
    public void assignRepliesExtraProperties(String authorId, List<TopicReply> replies) {
        userService.assignBeanTo(replies, TopicReply::getAuthorId, TopicReply::setAuthor);
        List<User> authors = CollectionUtil.toList(replies, TopicReply::getAuthor);
        fileSummaryService.assignBeanTo(authors, User::getAvatarImgId, User::setAvatarImg);
        List<String> replyIds = CollectionUtil.toList(replies, TopicReply::getReplyId);
        List<TopicUp> topicUpCounts = this.topicUpService.getTopicUpsGroupCountByTopicIds(replyIds, null);
        Map<String, TopicUp> upCountMap = CollectionUtil.toMap(topicUpCounts, TopicUp::getObjectId);
        CollectionUtil.setFeildToFieldByMap(replies, upCountMap, TopicReply::getReplyId, TopicReply::setUpCount, TopicUp::getUpCount);
        if (StringUtil.isNotEmpty(authorId)) {
            topicUpCounts = this.topicUpService.getTopicUpsGroupCountByTopicIds(replyIds, authorId);
            upCountMap = CollectionUtil.toMap(topicUpCounts, TopicUp::getObjectId);
            for (TopicReply tr : replies) {
                tr.setIsUped(upCountMap.containsKey(tr.getReplyId()));
            }
        }
    }

    @Override
    public TopicReply replyUp(String replyId, String authorId) {
        List<TopicUp> topicUps = this.topicUpService.getTopicUpByObjectIdAndAuthorId(replyId, authorId);
        if (CollectionUtil.isNotEmpty(topicUps)) {
            topicUpService.deleteByUpIds(CollectionUtil.toList(topicUps, TopicUp::getUpId));
        } else {
            TopicUp topicUp = new TopicUp();
            topicUp.setObjectId(replyId);
            topicUp.setAuthorId(authorId);
            this.topicUpService.insert(topicUp);
        }
        TopicReply topicReply = this.getTopicReplyByReplyId(replyId);
        return topicReply;
    }

    //<#--
    @Resource(name = "topicReplyDao")
    TopicReplyDao topicReplyDao;

    /**
     * 
     * @see com.mycompany.biz.dao.TopicReplyDao#insert
     * @see com.mycompany.biz.service.TopicReplyService#insert
     */
    @Override
    public TopicReply insert(TopicReply topicReply) {
        return topicReplyDao.insert(topicReply, this);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicReplyDao#delete
     * @see com.mycompany.biz.service.TopicReplyService#delete
     */
    @Override
    public String delete(String replyId) {
        return topicReplyDao.delete(replyId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicReplyDao#update
     * @see com.mycompany.biz.service.TopicReplyService#update
     */
    @Override
    public TopicReply update(TopicReply topicReply) {
        return topicReplyDao.update(topicReply);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicReplyDao#getTopicReplyByReplyId
     * @see com.mycompany.biz.service.TopicReplyService#getTopicReplyByReplyId
     */
    @Override
    public TopicReply getTopicReplyByReplyId(String replyId) {
        return topicReplyDao.getTopicReplyByReplyId(replyId);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicReplyDao#getTopicReplysByReplyIds
     * @see com.mycompany.biz.service.TopicReplyService#getTopicReplysByReplyIds
     */
    @Override
    public List<TopicReply> getTopicReplysByReplyIds(java.util.List<String> replyIds) {
        return topicReplyDao.getTopicReplysByReplyIds(replyIds);
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicReplyDao#deleteByReplyIds
     * @see com.mycompany.biz.service.TopicReplyService#deleteByReplyIds
     */
    @Override
    public java.util.List<String> deleteByReplyIds(java.util.List<String> replyIds) {
        return topicReplyDao.deleteByReplyIds(replyIds);
    }

    /*** 保存topicReply,有id时更新，没有id时插入,并带回新的id，返回 topicReply*/
    @Override
    public TopicReply saveTopicReply(TopicReply topicReply) {
        if (topicReply != null) {
            java.lang.String replyId = topicReply.getReplyId();
            if (StringUtil.isBlank(replyId)) {
                insert(topicReply);
            } else {
                update(topicReply);
            }
        }
        return topicReply;
    }

    /*** 批量保存topicReplys,有id时更新，没有id时插入,并带回新的id，返回 topicReplys*/
    @Override
    public List<TopicReply> saveTopicReplys(List<TopicReply> topicReplys) {
        for (TopicReply topicReply : topicReplys) {
            this.saveTopicReply(topicReply);
        }
        return topicReplys;
    }

    /**
     * 
     * @see com.mycompany.biz.dao.TopicReplyDao#getPageList
     * @see com.mycompany.biz.service.TopicReplyService#getPageList
     */
    @Override
    public PageList<TopicReply> getPageList(TopicReply topicReply, int pageSize, int pageNum) {
        return topicReplyDao.getPageList(topicReply, pageSize, pageNum);
    }

    @Override
    public <D> void assignBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod, BiConsumer<D, TopicReply> destSetMethod) {
        ServiceUtil.interalAssignBeanTo(dests, destGetMethod, destSetMethod, this, TopicReplyServiceImpl::getTopicReplysByReplyIds, TopicReply::getReplyId);
    }

    @Override
    public <D, G> void assignBeansTo(Collection<D> dests, Function<? super D, G> destGetMethod, BiConsumer<D, List<TopicReply>> destSetMethod, BiConsumer<TopicReply, List<G>> resultSetQueryIdsFun, Function<? super TopicReply, G> resultGetGoupIdFun) {
        ServiceUtil.interalAssignBeansTo(dests, destGetMethod, destSetMethod, this, new TopicReply(), resultSetQueryIdsFun, resultGetGoupIdFun, 100);
    }

    @Override
    public <D> void mergeBeanTo(Collection<D> dests, Function<? super D, String> destGetMethod) {
        ServiceUtil.interalMergeBeanTo(dests, destGetMethod, this, TopicReplyServiceImpl::getTopicReplysByReplyIds, TopicReply::getReplyId);
    }

    @Override
    public <T> String generateId() {
        return this.idGenerator.generateId(String.class, TopicReply.class);
    }
}
