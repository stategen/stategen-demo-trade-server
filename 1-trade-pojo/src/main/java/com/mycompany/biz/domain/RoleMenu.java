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
 * RoleMenu
 * <pre>
 * database table: role_menu
 * database table comments: RoleMenu
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅不可以修改dalgen生成的属生(field)类型 ,方法(Method)返回值类型和参数类型
 * 不建议使@Data,其hashCode有问题
 * </pre>
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleMenu implements java.io.Serializable {

    private static final long serialVersionUID = -5216457518046898601L;

    /***id   db_column: id BIGINT */
    @ApiModelProperty("id")
    @Id
    private Long id;

    /***roleId   db_column: role_id VARCHAR */
    @ApiModelProperty("roleId")
    @Max(32)
    private String roleId;

    /***menuId   db_column: menu_id BIGINT */
    @ApiModelProperty("menuId")
    private Long menuId;

    /***数据创建时间   db_column: create_time TIMESTAMP */
    @ApiModelProperty(value = "数据创建时间", hidden = true)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createTime;

    /***数据更新时间   db_column: update_time TIMESTAMP */
    @ApiModelProperty(value = "数据更新时间", hidden = true)
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
        sb.append("ids=").append(ids).append('\n');
        sb.append("roleIds=").append(roleIds).append('\n');
        sb.append("menuIds=").append(menuIds).append('\n');
        sb.append("createTimeMin=").append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax=").append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin=").append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax=").append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("id=").append(id).append('\n');
        sb.append("roleId=").append(roleId).append('\n');
        sb.append("menuId=").append(menuId).append('\n');
        sb.append("createTime=").append(createTime != null ? df.format(createTime) : null).append('\n');
        sb.append("updateTime=").append(updateTime != null ? df.format(updateTime) : null).append('\n');
        sb.append("deleteFlag=").append(deleteFlag);
        sb.append('}');
        return sb.toString();
    }

    /*** ids in getPageList */
    @ApiModelProperty("id s")
    @JSONField(serialize = false)
    private java.util.List<Long> ids;

    /*** roleIds in getPageList */
    @ApiModelProperty("roleId s")
    @JSONField(serialize = false)
    private java.util.List<String> roleIds;

    /*** menuIds in getPageList */
    @ApiModelProperty("menuId s")
    @JSONField(serialize = false)
    private java.util.List<Long> menuIds;

    /*** 数据创建时间Min in getPageList */
    @ApiModelProperty("数据创建时间Min")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date createTimeMin;

    /*** 数据创建时间Max in getPageList */
    @ApiModelProperty("数据创建时间Max")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date createTimeMax;

    /*** 数据更新时间Min in getPageList */
    @ApiModelProperty("数据更新时间Min")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date updateTimeMin;

    /*** 数据更新时间Max in getPageList */
    @ApiModelProperty("数据更新时间Max")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date updateTimeMax;
}
