/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.domain;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.stategen.framework.annotation.FieldNameConst;
import org.stategen.framework.lite.IMenu;
import org.stategen.framework.lite.TreeNode;
import org.stategen.framework.lite.enums.MenuType;
import org.stategen.framework.lite.enums.VisitCheckType;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Menu
 * <pre>
 * database table: menu
 * database table comments: Menu
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅不可以修改dalgenx生成的属生(field)类型 ,方法(Method)返回值类型和参数类型
 * 该类可自由继承、实现接口，自定义字段或方法，在下次生成时均不会丢失，可有效减少DTO的使用.
 * 同时，支持自定义修改字段大小写，一旦修改后，请再执行 gen.sh dal menu -e
 * 不建议使@Data,其hashCode有问题
 * 如果表修改后 ，请执行 gen.sh table menu -e ,再执行 gen.sh dal menu -e
 * </pre>
 */
@Getter
@Setter()
@Builder()
@NoArgsConstructor
@AllArgsConstructor
public class Menu extends TreeNode<Menu> implements java.io.Serializable, IMenu<Menu> {

    private String roleId;

    private Boolean checked;

    /*** menuId与bpid组成树图s in getPageList */
    @ApiModelProperty("menuId与bpid组成树图 s")
    @JSONField(serialize = false)
    private java.util.List<Long> bpids;

    /*** 大部分情况下与bpid相同，当为动态目录时，mpid=-1s in getPageList */
    @ApiModelProperty("大部分情况下与bpid相同 s")
    @JSONField(serialize = false)
    private java.util.List<Long> mpids;

    /***不使用或自定义字段在下次生成后，会移到serialVersionUID的上面
     ** 额外查询字段，自定义方法会自动移到toString()的下面
     ** 如果字段注释中包括 ‘-inherited’, 将不生成，字段可以从父类中继承
     ** ps: 该方案既享受生成器的便利，pojo可以同时作为po dto vo使用，而不用担心字段丢失问题,
     **     同时解决领域模型(DDD)开发中，失血模式下的失忆问题
     */
    private static final long serialVersionUID = -5216457518046898601L;

    /***menuId   db_column: menu_id BIGINT */
    @ApiModelProperty("menuId")
    @Id
    private Long menuId;

    /***morder   db_column: morder INTEGER */
    @ApiModelProperty("morder")
    @Column
    private Integer morder;

    /***menuId与bpid组成树图   db_column: bpid BIGINT */
    @ApiModelProperty("menuId与bpid组成树图")
    private Long bpid;

    /***大部分情况下与bpid相同，当为动态目录时，mpid=-1   db_column: mpid BIGINT */
    @ApiModelProperty("大部分情况下与bpid相同，当为动态目录时，mpid=-1")
    private Long mpid;

    /***对应的项目id   db_column: project_name VARCHAR */
    @ApiModelProperty("对应的项目id")
    @Max(64)
    private String projectName;

    /***对应后台系统controlle名称   db_column: controller_name VARCHAR */
    @ApiModelProperty("对应后台系统controlle名称")
    @Max(64)
    private String controllerName;

    /***对应后台系统method名称   db_column: method_name VARCHAR */
    @ApiModelProperty("对应后台系统method名称")
    @Max(64)
    private String methodName;

    /***对应的api路径   db_column: url VARCHAR */
    @ApiModelProperty("对应的api路径")
    @Max(64)
    private String url;

    /***icon   db_column: icon VARCHAR */
    @ApiModelProperty("icon")
    @Max(64)
    private String icon;

    /***name   db_column: name VARCHAR */
    @ApiModelProperty("name")
    @Max(64)
    private String name;

    /***route   db_column: route VARCHAR */
    @ApiModelProperty("route")
    @FieldNameConst
    @NotNull
    @Max(64)
    private String route;

    /***menuType   db_column: menu_type VARCHAR */
    @ApiModelProperty("menuType")
    private MenuType menuType;

    /***checkType   db_column: check_type VARCHAR */
    @ApiModelProperty("checkType")
    private VisitCheckType checkType;

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
        sb.append("menuIds").append('=').append(menuIds).append('\n');
        sb.append("morderMin").append('=').append(morderMin).append('\n');
        sb.append("morderMax").append('=').append(morderMax).append('\n');
        sb.append("bpidMin").append('=').append(bpidMin).append('\n');
        sb.append("bpidMax").append('=').append(bpidMax).append('\n');
        sb.append("mpidMin").append('=').append(mpidMin).append('\n');
        sb.append("mpidMax").append('=').append(mpidMax).append('\n');
        sb.append("projectNameLike").append('=').append(projectNameLike).append('\n');
        sb.append("controllerNameLike").append('=').append(controllerNameLike).append('\n');
        sb.append("methodNameLike").append('=').append(methodNameLike).append('\n');
        sb.append("nameLike").append('=').append(nameLike).append('\n');
        sb.append("routeLike").append('=').append(routeLike).append('\n');
        sb.append("menuTypes").append('=').append(menuTypes).append('\n');
        sb.append("checkTypes").append('=').append(checkTypes).append('\n');
        sb.append("createTimeMin").append('=').append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax").append('=').append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin").append('=').append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax").append('=').append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("menuId").append('=').append(getMenuId()).append('\n');
        sb.append("morder").append('=').append(getMorder()).append('\n');
        sb.append("bpid").append('=').append(getBpid()).append('\n');
        sb.append("mpid").append('=').append(getMpid()).append('\n');
        sb.append("projectName").append('=').append(getProjectName()).append('\n');
        sb.append("controllerName").append('=').append(getControllerName()).append('\n');
        sb.append("methodName").append('=').append(getMethodName()).append('\n');
        sb.append("url").append('=').append(getUrl()).append('\n');
        sb.append("icon").append('=').append(getIcon()).append('\n');
        sb.append("name").append('=').append(getName()).append('\n');
        sb.append("route").append('=').append(getRoute()).append('\n');
        sb.append("menuType").append('=').append(getMenuType()).append('\n');
        sb.append("checkType").append('=').append(getCheckType()).append('\n');
        sb.append("createTime").append('=').append(getCreateTime() != null ? df.format(getCreateTime()) : null).append('\n');
        sb.append("updateTime").append('=').append(getUpdateTime() != null ? df.format(getUpdateTime()) : null).append('\n');
        sb.append("deleteFlag").append('=').append(getDeleteFlag());
        sb.append('}');
        return sb.toString();
    }

    /***查询字段下次生成时会自动移到toString()方法下面*/
    /*** menuIds in getPageList */
    @ApiModelProperty("menuId s")
    @JSONField(serialize = false)
    private java.util.List<Long> menuIds;

    /*** morderMin in getPageList */
    @ApiModelProperty("morderMin")
    @JSONField(serialize = false)
    private Integer morderMin;

    /*** morderMax in getPageList */
    @ApiModelProperty("morderMax")
    @JSONField(serialize = false)
    private Integer morderMax;

    /*** menuId与bpid组成树图Min in getPageList */
    @ApiModelProperty("menuId与bpid组成树图Min")
    @JSONField(serialize = false)
    private Long bpidMin;

    /*** menuId与bpid组成树图Max in getPageList */
    @ApiModelProperty("menuId与bpid组成树图Max")
    @JSONField(serialize = false)
    private Long bpidMax;

    /*** 大部分情况下与bpid相同，当为动态目录时，mpid=-1Min in getPageList */
    @ApiModelProperty("大部分情况下与bpid相同Min")
    @JSONField(serialize = false)
    private Long mpidMin;

    /*** 大部分情况下与bpid相同，当为动态目录时，mpid=-1Max in getPageList */
    @ApiModelProperty("大部分情况下与bpid相同Max")
    @JSONField(serialize = false)
    private Long mpidMax;

    /*** 对应的项目idLike in getPageList */
    @ApiModelProperty("对应的项目idLike")
    @JSONField(serialize = false)
    private String projectNameLike;

    /*** 对应后台系统controlle名称Like in getPageList */
    @ApiModelProperty("对应后台系统controlle名称Like")
    @JSONField(serialize = false)
    private String controllerNameLike;

    /*** 对应后台系统method名称Like in getPageList */
    @ApiModelProperty("对应后台系统method名称Like")
    @JSONField(serialize = false)
    private String methodNameLike;

    /*** 对应的项目idnameLike in getPageList */
    @ApiModelProperty("对应的项目idnameLike")
    @JSONField(serialize = false)
    private String nameLike;

    /*** routeLike in getPageList */
    @ApiModelProperty("routeLike")
    @JSONField(serialize = false)
    private String routeLike;

    /*** menuTypes in getPageList */
    @ApiModelProperty("menuType s")
    @JSONField(serialize = false)
    private java.util.List<org.stategen.framework.lite.enums.MenuType> menuTypes;

    /*** checkTypes in getPageList */
    @ApiModelProperty("checkType s")
    @JSONField(serialize = false)
    private java.util.List<org.stategen.framework.lite.enums.VisitCheckType> checkTypes;

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

    /**
     * Getter method for property <tt>id id</tt>.
     * @return property value of id id
     */
    @ApiModelProperty("id,和MenuId相同，为了生成树")
    public Long getId() {
        return getMenuId();
    }

    public List<Menu> getMenuChildren() {
        return super.getChildren();
    }

    @ApiModelProperty(value = "打开顺序，前端model存储用", hidden = true)
    public Integer getOpendOrder() {
        return null;
    }
}
