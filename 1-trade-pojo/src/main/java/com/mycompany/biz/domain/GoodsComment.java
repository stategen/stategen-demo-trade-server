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
import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * GoodsComment
 * <pre>
 * database table: demo_goods_comment
 * database table comments: GoodsComment
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅不可以修改dalgen生成的属生(field)类型 ,方法(Method)返回值类型和参数类型
 * 不建议使@Data,其hashCode有问题
 * </pre>
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
public class GoodsComment implements java.io.Serializable {

    /*** commentsLike in getPageList */
    @ApiModelProperty("commentsLike")
    @JSONField(serialize = false)
    private String commentsLike;

    private static final long serialVersionUID = -5216457518046898601L;

    /***commentsId   db_column: comments_id VARCHAR */
    @ApiModelProperty("commentsId")
    @Id
    @Max(64)
    private String commentsId;

    /***goodsId   db_column: goods_id VARCHAR */
    @ApiModelProperty("goodsId")
    @Max(64)
    private String goodsId;

    /***comments   db_column: comments LONGVARCHAR */
    @ApiModelProperty("comments")
    @Max(65535)
    @Editor(EditorType.Textarea.class)
    private String comments;

    /***userName   db_column: user_name VARCHAR */
    @ApiModelProperty("userName")
    @Max(32)
    private String userName;

    /***discussTime   db_column: discuss_time TIMESTAMP */
    @ApiModelProperty("discussTime")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date discussTime;

    /***score   db_column: score INTEGER */
    @ApiModelProperty("score")
    private Integer score;

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
        sb.append("commentsIds=").append(commentsIds).append('\n');
        sb.append("goodsIds=").append(goodsIds).append('\n');
        sb.append("userNameLike=").append(userNameLike).append('\n');
        sb.append("discussTimeMin=").append(discussTimeMin != null ? df.format(discussTimeMin) : null).append('\n');
        sb.append("discussTimeMax=").append(discussTimeMax != null ? df.format(discussTimeMax) : null).append('\n');
        sb.append("scoreMin=").append(scoreMin).append('\n');
        sb.append("scoreMax=").append(scoreMax).append('\n');
        sb.append("createTimeMin=").append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax=").append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin=").append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax=").append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("commentsId=").append(commentsId).append('\n');
        sb.append("goodsId=").append(goodsId).append('\n');
        sb.append("comments=").append(comments).append('\n');
        sb.append("userName=").append(userName).append('\n');
        sb.append("discussTime=").append(discussTime != null ? df.format(discussTime) : null).append('\n');
        sb.append("score=").append(score).append('\n');
        sb.append("createTime=").append(createTime != null ? df.format(createTime) : null).append('\n');
        sb.append("updateTime=").append(updateTime != null ? df.format(updateTime) : null).append('\n');
        sb.append("deleteFlag=").append(deleteFlag);
        sb.append('}');
        return sb.toString();
    }

    /*** commentsIds in getPageList */
    @ApiModelProperty("commentsId s")
    @JSONField(serialize = false)
    private java.util.List<String> commentsIds;

    /*** goodsIds in getPageList */
    @ApiModelProperty("goodsId s")
    @JSONField(serialize = false)
    private java.util.List<String> goodsIds;

    /*** userNameLike in getPageList */
    @ApiModelProperty("userNameLike")
    @JSONField(serialize = false)
    private String userNameLike;

    /*** discussTimeMin in getPageList */
    @ApiModelProperty("discussTimeMin")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date discussTimeMin;

    /*** discussTimeMax in getPageList */
    @ApiModelProperty("discussTimeMax")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date discussTimeMax;

    /*** scoreMin in getPageList */
    @ApiModelProperty("scoreMin")
    @JSONField(serialize = false)
    private Integer scoreMin;

    /*** scoreMax in getPageList */
    @ApiModelProperty("scoreMax")
    @JSONField(serialize = false)
    private Integer scoreMax;

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

    public Integer getSCORE() {
        return score;
    }

    public void setSCORE(Integer sCORE) {
        score = sCORE;
    }
}
