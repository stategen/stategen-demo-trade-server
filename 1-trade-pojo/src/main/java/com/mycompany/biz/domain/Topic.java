/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.domain;

import java.text.SimpleDateFormat;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;

import org.stategen.framework.annotation.Editor;
import org.stategen.framework.lite.enums.EditorType;

import com.alibaba.fastjson.annotation.JSONField;
import com.mycompany.biz.enums.TopicType;
import io.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * Topic
 * <pre>
 * database table: topic
 * database table comments: Topic
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅不可以修改dalgen生成的属生(field)类型 ,方法(Method)返回值类型和参数类型
 * 不建议使@Data,其hashCode有问题
 * </pre>
 */
@Getter
@Setter
public class Topic implements java.io.Serializable {

    private User author;

    private Long replyCount;

    private static final long serialVersionUID = -5216457518046898601L;

    /***主题ID   db_column: topic_id VARCHAR */
    @ApiModelProperty("主题ID")
    @Id
    @Max(64)
    @Editor(EditorType.Hidden.class)
    private String topicId;

    /***作者ID   db_column: author_id VARCHAR */
    @ApiModelProperty("作者ID")
    @Max(64)
    private String authorId;

    /***主题类型   db_column: topic_type VARCHAR */
    @ApiModelProperty("主题类型")
    private TopicType topicType;

    /***内容   db_column: content LONGVARCHAR */
    @ApiModelProperty("内容")
    @Max(65535)
    @Editor(EditorType.Textarea.class)
    private String content;

    /***标题   db_column: title VARCHAR */
    @ApiModelProperty("标题")
    @Max(64)
    private String title;

    /***最后回复   db_column: last_reply_at TIMESTAMP */
    @ApiModelProperty("最后回复")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date lastReplyAt;

    /***精华   db_column: good BIGINT */
    @ApiModelProperty("精华")
    private Long good;

    /***置顶   db_column: top BIGINT */
    @ApiModelProperty("置顶")
    private Long top;

    /***浏览次数   db_column: visit_count BIGINT */
    @ApiModelProperty("浏览次数")
    private Long visitCount;

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
        sb.append("topicIds=").append(topicIds).append('\n');
        sb.append("authorIds=").append(authorIds).append('\n');
        sb.append("topicTypes=").append(topicTypes).append('\n');
        sb.append("contentLike=").append(contentLike).append('\n');
        sb.append("titleLike=").append(titleLike).append('\n');
        sb.append("lastReplyAtMin=").append(lastReplyAtMin != null ? df.format(lastReplyAtMin) : null).append('\n');
        sb.append("lastReplyAtMax=").append(lastReplyAtMax != null ? df.format(lastReplyAtMax) : null).append('\n');
        sb.append("goodMin=").append(goodMin).append('\n');
        sb.append("goodMax=").append(goodMax).append('\n');
        sb.append("topMin=").append(topMin).append('\n');
        sb.append("topMax=").append(topMax).append('\n');
        sb.append("visitCountMin=").append(visitCountMin).append('\n');
        sb.append("visitCountMax=").append(visitCountMax).append('\n');
        sb.append("createTimeMin=").append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax=").append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin=").append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax=").append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("topicId=").append(topicId).append('\n');
        sb.append("authorId=").append(authorId).append('\n');
        sb.append("topicType=").append(topicType).append('\n');
        sb.append("content=").append(content).append('\n');
        sb.append("title=").append(title).append('\n');
        sb.append("lastReplyAt=").append(lastReplyAt != null ? df.format(lastReplyAt) : null).append('\n');
        sb.append("good=").append(good).append('\n');
        sb.append("top=").append(top).append('\n');
        sb.append("visitCount=").append(visitCount).append('\n');
        sb.append("createTime=").append(createTime != null ? df.format(createTime) : null).append('\n');
        sb.append("updateTime=").append(updateTime != null ? df.format(updateTime) : null).append('\n');
        sb.append("deleteFlag=").append(deleteFlag);
        sb.append('}');
        return sb.toString();
    }

    /*** 主题IDs in getPageList */
    @ApiModelProperty("主题ID s")
    @JSONField(serialize = false)
    private java.util.List<String> topicIds;

    /*** 作者IDs in getPageList */
    @ApiModelProperty("作者ID s")
    @JSONField(serialize = false)
    private java.util.List<String> authorIds;

    /*** 主题类型s in getPageList */
    @ApiModelProperty("主题类型 s")
    @JSONField(serialize = false)
    private java.util.List<com.mycompany.biz.enums.TopicType> topicTypes;

    /*** 内容Like in getPageList */
    @ApiModelProperty("内容Like")
    @JSONField(serialize = false)
    private String contentLike;

    /*** 标题Like in getPageList */
    @ApiModelProperty("标题Like")
    @JSONField(serialize = false)
    private String titleLike;

    /*** 最后回复Min in getPageList */
    @ApiModelProperty("最后回复Min")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date lastReplyAtMin;

    /*** 最后回复Max in getPageList */
    @ApiModelProperty("最后回复Max")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date lastReplyAtMax;

    /*** 精华Min in getPageList */
    @ApiModelProperty("精华Min")
    @JSONField(serialize = false)
    private Long goodMin;

    /*** 精华Max in getPageList */
    @ApiModelProperty("精华Max")
    @JSONField(serialize = false)
    private Long goodMax;

    /*** 置顶Min in getPageList */
    @ApiModelProperty("置顶Min")
    @JSONField(serialize = false)
    private Long topMin;

    /*** 置顶Max in getPageList */
    @ApiModelProperty("置顶Max")
    @JSONField(serialize = false)
    private Long topMax;

    /*** 浏览次数Min in getPageList */
    @ApiModelProperty("浏览次数Min")
    @JSONField(serialize = false)
    private Long visitCountMin;

    /*** 浏览次数Max in getPageList */
    @ApiModelProperty("浏览次数Max")
    @JSONField(serialize = false)
    private Long visitCountMax;

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
}
