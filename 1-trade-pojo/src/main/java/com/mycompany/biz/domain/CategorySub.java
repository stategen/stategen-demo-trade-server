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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CategorySub
 * <pre>
 * database table: demo_category_sub
 * database table comments: CategorySub
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅不可以修改dalgenx生成的属生(field)类型 ,方法(Method)返回值类型和参数类型
 * 该类可自由继承、实现接口，自定义字段或方法，在下次生成时均不会丢失，可有效减少DTO的使用.
 * 同时，支持自定义修改字段大小写，一旦修改后，请再执行 gen.sh dal demo_category_sub -e
 * 不建议使@Data,其hashCode有问题
 * 如果表修改后 ，请执行 gen.sh table demo_category_sub -e ,再执行 gen.sh dal demo_category_sub -e
 * </pre>
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategorySub implements java.io.Serializable {

    /*** commentsLike in getPageList */
    @ApiModelProperty("commentsLike")
    @JSONField(serialize = false)
    private String commentsLike;

    /***不使用或自定义字段在下次生成后，会移到serialVersionUID的上面*/
    /* 如果字段注释中包括 -inherited 将不生成 */
    private static final long serialVersionUID = -5216457518046898601L;

    /***categorySubId   db_column: category_sub_id VARCHAR */
    @ApiModelProperty("categorySubId")
    @Id
    @Max(64)
    private String categorySubId;

    /***categoryId   db_column: category_id VARCHAR */
    @ApiModelProperty("categoryId")
    @Max(64)
    private String categoryId;

    /***subName   db_column: sub_name VARCHAR */
    @ApiModelProperty("subName")
    @Max(255)
    private String subName;

    /***comments   db_column: comments LONGVARCHAR */
    @ApiModelProperty("comments")
    @Max(65535)
    @Editor(EditorType.Textarea.class)
    private String comments;

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
        sb.append("categorySubIds").append('=').append(categorySubIds).append('\n');
        sb.append("categoryIds").append('=').append(categoryIds).append('\n');
        sb.append("subNameLike").append('=').append(subNameLike).append('\n');
        sb.append("createTimeMin").append('=').append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax").append('=').append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin").append('=').append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax").append('=').append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("categorySubId").append('=').append(getCategorySubId()).append('\n');
        sb.append("categoryId").append('=').append(getCategoryId()).append('\n');
        sb.append("subName").append('=').append(getSubName()).append('\n');
        sb.append("comments").append('=').append(getComments()).append('\n');
        sb.append("createTime").append('=').append(getCreateTime() != null ? df.format(getCreateTime()) : null).append('\n');
        sb.append("updateTime").append('=').append(getUpdateTime() != null ? df.format(getUpdateTime()) : null).append('\n');
        sb.append("deleteFlag").append('=').append(getDeleteFlag());
        sb.append('}');
        return sb.toString();
    }

    /***查询字段下次生成时会自动移到toString()方法下面*/
    /*** categorySubIds in getPageList */
    @ApiModelProperty("categorySubId s")
    @JSONField(serialize = false)
    private java.util.List<String> categorySubIds;

    /*** categoryIds in getPageList */
    @ApiModelProperty("categoryId s")
    @JSONField(serialize = false)
    private java.util.List<String> categoryIds;

    /*** subNameLike in getPageList */
    @ApiModelProperty("subNameLike")
    @JSONField(serialize = false)
    private String subNameLike;

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
