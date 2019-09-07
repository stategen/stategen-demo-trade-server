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

import lombok.Getter;
import lombok.Setter;

/**
 * HomeGoods
 * <pre>
 * database table: demo_home_goods
 * database table comments: HomeGoods
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅不可以修改dalgen生成的属生(field)类型 ,方法(Method)返回值类型和参数类型
 * 不建议使@Data,其hashCode有问题
 * </pre>
 */
@Getter
@Setter
public class HomeGoods extends Goods implements java.io.Serializable {

    private static final long serialVersionUID = -5216457518046898601L;

    /***recommendId   db_column: recommend_id VARCHAR */
    @ApiModelProperty("recommendId")
    @Id
    @Max(64)
    private String recommendId;

    /***goodsId   db_column: goods_id VARCHAR */
    @ApiModelProperty("goodsId")
    @Max(255)
    private String goodsId;

    /***orderNo   db_column: order_no INTEGER */
    @ApiModelProperty("orderNo")
    private Integer orderNo;

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
        sb.append("recommendIds=").append(recommendIds).append('\n');
        sb.append("goodsIds=").append(goodsIds).append('\n');
        sb.append("orderNoMin=").append(orderNoMin).append('\n');
        sb.append("orderNoMax=").append(orderNoMax).append('\n');
        sb.append("createTimeMin=").append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax=").append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin=").append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax=").append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("recommendId=").append(recommendId).append('\n');
        sb.append("goodsId=").append(goodsId).append('\n');
        sb.append("orderNo=").append(orderNo).append('\n');
        sb.append("createTime=").append(createTime != null ? df.format(createTime) : null).append('\n');
        sb.append("updateTime=").append(updateTime != null ? df.format(updateTime) : null).append('\n');
        sb.append("deleteFlag=").append(deleteFlag);
        sb.append('}');
        return sb.toString();
    }

    /*** recommendIds in getPageList */
    @ApiModelProperty("recommendId s")
    @JSONField(serialize = false)
    private java.util.List<String> recommendIds;

    /*** goodsIds in getPageList */
    @ApiModelProperty("goodsId s")
    @JSONField(serialize = false)
    private java.util.List<String> goodsIds;

    /*** orderNoMin in getPageList */
    @ApiModelProperty("orderNoMin")
    @JSONField(serialize = false)
    private Integer orderNoMin;

    /*** orderNoMax in getPageList */
    @ApiModelProperty("orderNoMax")
    @JSONField(serialize = false)
    private Integer orderNoMax;

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
