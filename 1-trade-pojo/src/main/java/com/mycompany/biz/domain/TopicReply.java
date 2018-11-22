/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.domain;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * TopicReply
 * <pre>
 * database table: topic_reply
 * database table comments: TopicReply
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅不可以修改dalgen生成的属生(field)类型 ,方法(Method)返回值类型和参数类型
 * 不建议使@Data,其hashCode有问题
 * </pre>
 */
@Getter
@Setter
public class TopicReply implements java.io.Serializable {

    private User author;

    private List<String> ups;

    private Boolean isUped;

    /*** isUpedLike in getTopicReplyPageListByDefaultQuery */
    @ApiModelProperty("isUpedLike")
    private transient String isUpedLike;

    private static final long serialVersionUID = -5216457518046898601L;

    /***topicReplyId   db_column: topic_reply_id VARCHAR */
    @ApiModelProperty("topicReplyId")
    @Id
    @Max(64)
    private String topicReplyId;

    /***topicId   db_column: topic_id VARCHAR */
    @ApiModelProperty("topicId")
    @Max(64)
    private String topicId;

    /***authorId   db_column: author_id VARCHAR */
    @ApiModelProperty("authorId")
    @Max(64)
    private String authorId;

    /***content   db_column: content LONGVARCHAR */
    @ApiModelProperty("content")
    @Max(255)
    private String content;

    /***createAt   db_column: create_at VARCHAR */
    @ApiModelProperty("createAt")
    @Max(255)
    private String createAt;

    /***replyId   db_column: reply_id VARCHAR */
    @ApiModelProperty("replyId")
    @Max(64)
    private String replyId;

    /***创建时间   db_column: create_time TIMESTAMP */
    @ApiModelProperty(value = "创建时间", hidden = true)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createTime;

    /***更新时间   db_column: update_time TIMESTAMP */
    @ApiModelProperty(value = "更新时间", hidden = true)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updateTime;

    /***是否删除(0:正常，1删除)   db_column: delete_flag INTEGER */
    @ApiModelProperty(value = "是否删除(0:正常，1删除)", hidden = true)
    private Integer deleteFlag;

    /*----------------getter & setter ignore by lombok -------------------*/
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd H:m:ss.SSS");
        StringBuffer sb = new StringBuffer(1024);
        sb.append('{');
        sb.append("topicReplyIds=").append(topicReplyIds).append('\n');
        sb.append("topicIds=").append(topicIds).append('\n');
        sb.append("authorIds=").append(authorIds).append('\n');
        sb.append("contentLike=").append(contentLike).append('\n');
        sb.append("createAtLike=").append(createAtLike).append('\n');
        sb.append("replyIds=").append(replyIds).append('\n');
        sb.append("createTimeMin=").append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax=").append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin=").append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax=").append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("topicReplyId=").append(topicReplyId).append('\n');
        sb.append("topicId=").append(topicId).append('\n');
        sb.append("authorId=").append(authorId).append('\n');
        sb.append("content=").append(content).append('\n');
        sb.append("createAt=").append(createAt).append('\n');
        sb.append("replyId=").append(replyId).append('\n');
        sb.append("createTime=").append(createTime != null ? df.format(createTime) : null).append('\n');
        sb.append("updateTime=").append(updateTime != null ? df.format(updateTime) : null).append('\n');
        sb.append("deleteFlag=").append(deleteFlag);
        sb.append('}');
        return sb.toString();
    }

    /*** topicReplyIds in getTopicReplyPageListByDefaultQuery */
    @ApiModelProperty("topicReplyIds")
    private transient java.util.List<String> topicReplyIds;

    /*** topicIds in getTopicReplyPageListByDefaultQuery */
    @ApiModelProperty("topicIds")
    private transient java.util.List<String> topicIds;

    /*** authorIds in getTopicReplyPageListByDefaultQuery */
    @ApiModelProperty("authorIds")
    private transient java.util.List<String> authorIds;

    /*** contentLike in getTopicReplyPageListByDefaultQuery */
    @ApiModelProperty("contentLike")
    private transient String contentLike;

    /*** createAtLike in getTopicReplyPageListByDefaultQuery */
    @ApiModelProperty("createAtLike")
    private transient String createAtLike;

    /*** replyIds in getTopicReplyPageListByDefaultQuery */
    @ApiModelProperty("replyIds")
    private transient java.util.List<String> replyIds;

    /*** 创建时间Min in getTopicReplyPageListByDefaultQuery */
    @ApiModelProperty("创建时间Min")
    @Temporal(TemporalType.TIMESTAMP)
    private transient java.util.Date createTimeMin;

    /*** 创建时间Max in getTopicReplyPageListByDefaultQuery */
    @ApiModelProperty("创建时间Max")
    @Temporal(TemporalType.TIMESTAMP)
    private transient java.util.Date createTimeMax;

    /*** 更新时间Min in getTopicReplyPageListByDefaultQuery */
    @ApiModelProperty("更新时间Min")
    @Temporal(TemporalType.TIMESTAMP)
    private transient java.util.Date updateTimeMin;

    /*** 更新时间Max in getTopicReplyPageListByDefaultQuery */
    @ApiModelProperty("更新时间Max")
    @Temporal(TemporalType.TIMESTAMP)
    private transient java.util.Date updateTimeMax;

    public String getReply_id() {
        return replyId;
    }

    public void setReply_id(String id) {
        this.replyId = id;
    }

    public String getId() {
        return topicReplyId;
    }

    public void setId(String id) {
        this.topicReplyId = id;
    }
}
