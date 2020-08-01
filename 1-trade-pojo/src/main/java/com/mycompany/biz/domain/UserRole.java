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

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * UserRole
 * <pre>
 * database table: user_role
 * database table comments: UserRole
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅不可以修改dalgenx生成的属生(field)类型 ,方法(Method)返回值类型和参数类型
 * 该类可自由继承、实现接口，自定义字段或方法，在下次生成时均不会丢失，可有效减少DTO的使用.
 * 同时，支持自定义修改字段大小写，一旦修改后，请再执行 gen.sh dal user_role -e
 * 不建议使@Data,其hashCode有问题
 * 如果表修改后 ，请执行 gen.sh table user_role -e ,再执行 gen.sh dal user_role -e
 * </pre>
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements java.io.Serializable {

    /*** ids in getPageList */
    @ApiModelProperty("id s")
    @JSONField(serialize = false)
    private java.util.List<Long> ids;

    /***不使用或自定义字段在下次生成后，会移到serialVersionUID的上面*/
    /* 如果字段注释中包括 -inherited 将不生成 */
    private static final long serialVersionUID = -5216457518046898601L;

    /***id   db_column: id BIGINT */
    @ApiModelProperty("id")
    @Id
    private Long id;

    /***userId   db_column: user_id VARCHAR */
    @ApiModelProperty("userId")
    @Max(64)
    private String userId;

    /***roleId   db_column: role_id VARCHAR */
    @ApiModelProperty("roleId")
    @Max(64)
    private String roleId;

    /***roleType   db_column: role_type VARCHAR */
    @ApiModelProperty("roleType")
    @Max(64)
    private String roleType;

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
        sb.append("idMin").append('=').append(idMin).append('\n');
        sb.append("idMax").append('=').append(idMax).append('\n');
        sb.append("userIds").append('=').append(userIds).append('\n');
        sb.append("roleIds").append('=').append(roleIds).append('\n');
        sb.append("roleTypes").append('=').append(roleTypes).append('\n');
        sb.append("createTimeMin").append('=').append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax").append('=').append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin").append('=').append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax").append('=').append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("id").append('=').append(getId()).append('\n');
        sb.append("userId").append('=').append(getUserId()).append('\n');
        sb.append("roleId").append('=').append(getRoleId()).append('\n');
        sb.append("roleType").append('=').append(getRoleType()).append('\n');
        sb.append("createTime").append('=').append(getCreateTime() != null ? df.format(getCreateTime()) : null).append('\n');
        sb.append("updateTime").append('=').append(getUpdateTime() != null ? df.format(getUpdateTime()) : null).append('\n');
        sb.append("deleteFlag").append('=').append(getDeleteFlag());
        sb.append('}');
        return sb.toString();
    }

    /***查询字段下次生成时会自动移到toString()方法下面*/
    /*** idMin in getPageList */
    @ApiModelProperty("idMin")
    @JSONField(serialize = false)
    private Long idMin;

    /*** idMax in getPageList */
    @ApiModelProperty("idMax")
    @JSONField(serialize = false)
    private Long idMax;

    /*** userIds in getPageList */
    @ApiModelProperty("userId s")
    @JSONField(serialize = false)
    private java.util.List<String> userIds;

    /*** roleIds in getPageList */
    @ApiModelProperty("roleId s")
    @JSONField(serialize = false)
    private java.util.List<String> roleIds;

    /*** roleTypes in getPageList */
    @ApiModelProperty("roleType s")
    @JSONField(serialize = false)
    private java.util.List<String> roleTypes;

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
