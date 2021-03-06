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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Topic
 * @author StateGen.org
 * <pre>
 * database table: demo_topic
 * database table comments: 主题  -level(demo_organization) -owner(user)
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅不可以修改dalgenx生成的属生(field)类型 ,方法(Method)返回值类型和参数类型
 * 该类可自由继承、实现接口，自定义字段或方法，在下次生成时均不会丢失，可有效减少DTO的使用.
 * 同时，支持自定义修改字段大小写，一旦修改后，请再执行 gen.sh dal demo_topic -e
 * 不建议使@Data,其hashCode有问题
 * 如果表修改后 ，请执行 gen.sh table demo_topic -e ,再执行 gen.sh dal demo_topic -e
 * </pre>
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Topic implements java.io.Serializable {

    /***自定义字段，不属于别的表或类中的属性，只能添加在该类上*/
    private Long replyCount;

    /***author为属性集合，不能拆分成各个属性与再与topic中的属性组合，而是通过authorId关联*/
    private User author;

    /***不使用或自定义字段在下次生成后，会移到serialVersionUID的上面
     ** 额外查询字段，自定义方法会自动移到toString()的下面
     ** 如果字段注释中包括 ‘-inherited’, 将不生成，字段可以从父类中继承
     ** ps: 该方案既享受生成器的便利，pojo可以同时作为po dto vo使用，而不用担心字段丢失问题,
     **     同时解决领域模型(DDD)开发中，失血模式下的失忆问题
     */
    private static final long serialVersionUID = -5216457518046898601L;

    /***主题ID   db_column: topic_id VARCHAR */
    @ApiModelProperty("主题ID")
    @Id
    @Max(64)
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

    /***是否删除 (0:正常，1删除)   db_column: delete_flag BIT */
    @ApiModelProperty(value = "是否删除(0:正常，1删除)", hidden = true)
    private Boolean deleteFlag;

    /*----------------getter & setter ignore by lombok -------------------*/
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd H:m:ss.SSS");
        StringBuilder sb = new StringBuilder(1024);
        sb.append('{');
        sb.append("topicIds").append('=').append(topicIds).append('\n');
        sb.append("authorIds").append('=').append(authorIds).append('\n');
        sb.append("topicTypes").append('=').append(topicTypes).append('\n');
        sb.append("titleLike").append('=').append(titleLike).append('\n');
        sb.append("lastReplyAtMin").append('=').append(lastReplyAtMin != null ? df.format(lastReplyAtMin) : null).append('\n');
        sb.append("lastReplyAtMax").append('=').append(lastReplyAtMax != null ? df.format(lastReplyAtMax) : null).append('\n');
        sb.append("goodMin").append('=').append(goodMin).append('\n');
        sb.append("goodMax").append('=').append(goodMax).append('\n');
        sb.append("topMin").append('=').append(topMin).append('\n');
        sb.append("topMax").append('=').append(topMax).append('\n');
        sb.append("visitCountMin").append('=').append(visitCountMin).append('\n');
        sb.append("visitCountMax").append('=').append(visitCountMax).append('\n');
        sb.append("createTimeMin").append('=').append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax").append('=').append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin").append('=').append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax").append('=').append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("inclCurrOrgId").append('=').append(inclCurrOrgId).append('\n');
        sb.append("currOrgId").append('=').append(currOrgId).append('\n');
        sb.append("currUserId").append('=').append(currUserId).append('\n');
        sb.append("topicId").append('=').append(getTopicId()).append('\n');
        sb.append("authorId").append('=').append(getAuthorId()).append('\n');
        sb.append("topicType").append('=').append(getTopicType()).append('\n');
        sb.append("content").append('=').append(getContent()).append('\n');
        sb.append("title").append('=').append(getTitle()).append('\n');
        sb.append("lastReplyAt").append('=').append(getLastReplyAt() != null ? df.format(getLastReplyAt()) : null).append('\n');
        sb.append("good").append('=').append(getGood()).append('\n');
        sb.append("top").append('=').append(getTop()).append('\n');
        sb.append("visitCount").append('=').append(getVisitCount()).append('\n');
        sb.append("createTime").append('=').append(getCreateTime() != null ? df.format(getCreateTime()) : null).append('\n');
        sb.append("updateTime").append('=').append(getUpdateTime() != null ? df.format(getUpdateTime()) : null).append('\n');
        sb.append("deleteFlag").append('=').append(getDeleteFlag());
        sb.append('}');
        return sb.toString();
    }

    /***查询字段下次生成时会自动移到toString()方法下面*/
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

    /*** inclCurrOrgId in getPageList */
    @ApiModelProperty("inclCurrOrgId")
    @JSONField(serialize = false)
    private Boolean inclCurrOrgId;

    /*** 树(类似部门)主键 水平权限currOrgId in getPageList */
    @ApiModelProperty("树(类似部门)主键currOrgId")
    @JSONField(serialize = false)
    private Long currOrgId;

    /*** 所有者 水平权限currUserId in getPageList */
    @ApiModelProperty("所有者currUserId")
    @JSONField(serialize = false)
    private String currUserId;
}
