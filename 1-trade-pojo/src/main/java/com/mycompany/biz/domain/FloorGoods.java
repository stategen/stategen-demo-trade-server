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
 * FloorGoods
 * @author StateGen.org
 * <pre>
 * database table: demo_floor_goods
 * database table comments: FloorGoods
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅不可以修改dalgenx生成的属生(field)类型 ,方法(Method)返回值类型和参数类型
 * 该类可自由继承、实现接口，自定义字段或方法，在下次生成时均不会丢失，可有效减少DTO的使用.
 * 同时，支持自定义修改字段大小写，一旦修改后，请再执行 gen.sh dal demo_floor_goods -e
 * 不建议使@Data,其hashCode有问题
 * 如果表修改后 ，请执行 gen.sh table demo_floor_goods -e ,再执行 gen.sh dal demo_floor_goods -e
 * </pre>
 */
@Getter
@Setter
@Builder(builderMethodName = "blder")
@NoArgsConstructor
@AllArgsConstructor
public class FloorGoods extends Goods implements java.io.Serializable {

    /*** orderNoMin in getPageList */
    @ApiModelProperty("orderNoMin")
    @JSONField(serialize = false)
    private Integer orderNoMin;

    /*** orderNoMax in getPageList */
    @ApiModelProperty("orderNoMax")
    @JSONField(serialize = false)
    private Integer orderNoMax;

    /***不使用或自定义字段在下次生成后，会移到serialVersionUID的上面
     ** 额外查询字段，自定义方法会自动移到toString()的下面
     ** 如果字段注释中包括 ‘-inherited’, 将不生成，字段可以从父类中继承
     ** ps: 该方案既享受生成器的便利，pojo可以同时作为po dto vo使用，而不用担心字段丢失问题,
     **     同时解决领域模型(DDD)开发中，失血模式下的失忆问题
     */
    private static final long serialVersionUID = -5216457518046898601L;

    /***floorGoodsId   db_column: floor_goods_id VARCHAR */
    @ApiModelProperty("floorGoodsId")
    @Id
    @Max(64)
    private String floorGoodsId;

    /***floorId   db_column: floor_id VARCHAR */
    @ApiModelProperty("floorId")
    @Max(64)
    private String floorId;

    /***goodsId   db_column: goods_id VARCHAR */
    @ApiModelProperty("goodsId")
    @Max(255)
    private String goodsId;

    /***image   db_column: image VARCHAR */
    @ApiModelProperty("image")
    @Max(255)
    private String image;

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
        StringBuilder sb = new StringBuilder(1024);
        sb.append('{');
        sb.append("floorGoodsIds").append('=').append(floorGoodsIds).append('\n');
        sb.append("floorIds").append('=').append(floorIds).append('\n');
        sb.append("goodsIds").append('=').append(goodsIds).append('\n');
        sb.append("orderNos").append('=').append(orderNos).append('\n');
        sb.append("createTimeMin").append('=').append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax").append('=').append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin").append('=').append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax").append('=').append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("floorGoodsId").append('=').append(getFloorGoodsId()).append('\n');
        sb.append("floorId").append('=').append(getFloorId()).append('\n');
        sb.append("goodsId").append('=').append(getGoodsId()).append('\n');
        sb.append("image").append('=').append(getImage()).append('\n');
        sb.append("orderNo").append('=').append(getOrderNo()).append('\n');
        sb.append("createTime").append('=').append(getCreateTime() != null ? df.format(getCreateTime()) : null).append('\n');
        sb.append("updateTime").append('=').append(getUpdateTime() != null ? df.format(getUpdateTime()) : null).append('\n');
        sb.append("deleteFlag").append('=').append(getDeleteFlag());
        sb.append('}');
        return sb.toString();
    }

    /***查询字段下次生成时会自动移到toString()方法下面*/
    /*** floorGoodsIds in getPageList */
    @ApiModelProperty("floorGoodsId s")
    @JSONField(serialize = false)
    private java.util.List<String> floorGoodsIds;

    /*** floorIds in getPageList */
    @ApiModelProperty("floorId s")
    @JSONField(serialize = false)
    private java.util.List<String> floorIds;

    /*** goodsIds in getPageList */
    @ApiModelProperty("goodsId s")
    @JSONField(serialize = false)
    private java.util.List<String> goodsIds;

    /*** orderNos in getPageList */
    @ApiModelProperty("orderNo s")
    @JSONField(serialize = false)
    private java.util.List<Integer> orderNos;

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
