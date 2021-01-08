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

import org.stategen.framework.annotation.Editor;
import org.stategen.framework.annotation.ReferConfig;
import org.stategen.framework.lite.enums.EditorType;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TopicReply
 * @author StateGen.org
 * <pre>
 * database table: demo_topic_reply
 * database table comments: TopicReply
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅不可以修改dalgenx生成的属生(field)类型 ,方法(Method)返回值类型和参数类型
 * 该类可自由继承、实现接口，自定义字段或方法，在下次生成时均不会丢失，可有效减少DTO的使用.
 * 同时，支持自定义修改字段大小写，一旦修改后，请再执行 gen.sh dal demo_topic_reply -e
 * 不建议使@Data,其hashCode有问题
 * 如果表修改后 ，请执行 gen.sh table demo_topic_reply -e ,再执行 gen.sh dal demo_topic_reply -e
 * </pre>
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicReply implements java.io.Serializable {

    private User author;

    private List<String> ups;

    private Boolean isUped;

    private Long upCount;

    /*** contentLike in getPageList */
    @ApiModelProperty("contentLike")
    @JSONField(serialize = false)
    private String contentLike;

    /***不使用或自定义字段在下次生成后，会移到serialVersionUID的上面
     ** 额外查询字段，自定义方法会自动移到toString()的下面
     ** 如果字段注释中包括 ‘-inherited’, 将不生成，字段可以从父类中继承
     ** ps: 该方案既享受生成器的便利，pojo可以同时作为po dto vo使用，而不用担心字段丢失问题,
     **     同时解决领域模型(DDD)开发中，失血模式下的失忆问题
     */
    private static final long serialVersionUID = -5216457518046898601L;

    /***replyId   db_column: reply_id VARCHAR */
    @ApiModelProperty("replyId")
    @Id
    @Max(64)
    private String replyId;

    /***topicId   db_column: topic_id VARCHAR */
    @ApiModelProperty("topicId")
    @Max(64)
    private String topicId;

    /***authorId   db_column: author_id VARCHAR */
    @ApiModelProperty("authorId")
    @Max(64)
    @ReferConfig
    private String authorId;

    /***content   db_column: content LONGVARCHAR */
    @ApiModelProperty("content")
    @Max(65535)
    @Editor(EditorType.Textarea.class)
    private String content;

    /***parentReplyId   db_column: parent_reply_id VARCHAR */
    @ApiModelProperty("parentReplyId")
    @Max(64)
    private String parentReplyId;

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
        StringBuilder sb = new StringBuilder(1024);
        sb.append('{');
        sb.append("replyIds").append('=').append(replyIds).append('\n');
        sb.append("topicIds").append('=').append(topicIds).append('\n');
        sb.append("authorIds").append('=').append(authorIds).append('\n');
        sb.append("parentReplyIds").append('=').append(parentReplyIds).append('\n');
        sb.append("createTimeMin").append('=').append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax").append('=').append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin").append('=').append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax").append('=').append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("replyId").append('=').append(getReplyId()).append('\n');
        sb.append("topicId").append('=').append(getTopicId()).append('\n');
        sb.append("authorId").append('=').append(getAuthorId()).append('\n');
        sb.append("content").append('=').append(getContent()).append('\n');
        sb.append("parentReplyId").append('=').append(getParentReplyId()).append('\n');
        sb.append("createTime").append('=').append(getCreateTime() != null ? df.format(getCreateTime()) : null).append('\n');
        sb.append("updateTime").append('=').append(getUpdateTime() != null ? df.format(getUpdateTime()) : null).append('\n');
        sb.append("deleteFlag").append('=').append(getDeleteFlag());
        sb.append('}');
        return sb.toString();
    }

    /***查询字段下次生成时会自动移到toString()方法下面*/
    /*** replyIds in getPageList */
    @ApiModelProperty("replyId s")
    @JSONField(serialize = false)
    private java.util.List<String> replyIds;

    /*** topicIds in getPageList */
    @ApiModelProperty("topicId s")
    @JSONField(serialize = false)
    private java.util.List<String> topicIds;

    /*** authorIds in getPageList */
    @ApiModelProperty("authorId s")
    @JSONField(serialize = false)
    private java.util.List<String> authorIds;

    /*** parentReplyIds in getPageList */
    @ApiModelProperty("parentReplyId s")
    @JSONField(serialize = false)
    private java.util.List<String> parentReplyIds;

    /*** 创建时间Min in getPageList */
    @ApiModelProperty("创建时间Min")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date createTimeMin;

    /*** 创建时间Max in getPageList */
    @ApiModelProperty("创建时间Max")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date createTimeMax;

    /*** 更新时间Min in getPageList */
    @ApiModelProperty("更新时间Min")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date updateTimeMin;

    /*** 更新时间Max in getPageList */
    @ApiModelProperty("更新时间Max")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date updateTimeMax;

    public String getId() {
        return replyId;
    }

    public void setId(String id) {
        this.replyId = id;
    }
}
