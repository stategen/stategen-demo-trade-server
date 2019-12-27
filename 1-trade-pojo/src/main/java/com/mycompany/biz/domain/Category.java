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
import org.stategen.framework.lite.enums.EditorType;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Category
 * <pre>
 * database table: demo_category
 * database table comments: Category
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
public class Category implements java.io.Serializable {

    List<CategorySub> categorySubs;

    /*** 描述Like in getPageList */
    @ApiModelProperty("描述Like")
    @JSONField(serialize = false)
    private String commentsLike;

    private static final long serialVersionUID = -5216457518046898601L;

    /***大类目录ID   db_column: category_id VARCHAR */
    @ApiModelProperty("大类目录ID")
    @Id
    @Max(64)
    private String categoryId;

    /***大类目录名称   db_column: category_name VARCHAR */
    @ApiModelProperty("大类目录名称")
    @Max(64)
    private String categoryName;

    /***描述   db_column: comments LONGVARCHAR */
    @ApiModelProperty("描述")
    @Max(65535)
    @Editor(EditorType.Textarea.class)
    private String comments;

    /***图片地址   db_column: image VARCHAR */
    @ApiModelProperty("图片地址")
    @Max(255)
    private String image;

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
        sb.append("categoryIds=").append(categoryIds).append('\n');
        sb.append("categoryNameLike=").append(categoryNameLike).append('\n');
        sb.append("createTimeMin=").append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax=").append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin=").append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax=").append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("categoryId=").append(categoryId).append('\n');
        sb.append("categoryName=").append(categoryName).append('\n');
        sb.append("comments=").append(comments).append('\n');
        sb.append("image=").append(image).append('\n');
        sb.append("createTime=").append(createTime != null ? df.format(createTime) : null).append('\n');
        sb.append("updateTime=").append(updateTime != null ? df.format(updateTime) : null).append('\n');
        sb.append("deleteFlag=").append(deleteFlag);
        sb.append('}');
        return sb.toString();
    }

    /*** 大类目录IDs in getPageList */
    @ApiModelProperty("大类目录ID s")
    @JSONField(serialize = false)
    private java.util.List<String> categoryIds;

    /*** 大类目录名称Like in getPageList */
    @ApiModelProperty("大类目录名称Like")
    @JSONField(serialize = false)
    private String categoryNameLike;

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
