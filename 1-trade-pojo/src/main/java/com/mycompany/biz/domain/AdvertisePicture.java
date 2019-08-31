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
 * AdvertisePicture
 * <pre>
 * database table: advertise_picture
 * database table comments: AdvertisePicture
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅不可以修改dalgen生成的属生(field)类型 ,方法(Method)返回值类型和参数类型
 * 不建议使@Data,其hashCode有问题
 * </pre>
 */
@Getter
@Setter
public class AdvertisePicture implements java.io.Serializable {

    private static final long serialVersionUID = -5216457518046898601L;

    /***advertiseId   db_column: advertise_id BIGINT */
    @ApiModelProperty("advertiseId")
    @Id
    private Long advertiseId;

    /***pictureAddress   db_column: PICTURE_ADDRESS VARCHAR */
    @ApiModelProperty("pictureAddress")
    @Max(255)
    private String pictureAddress;
    
    public String getPICTURE_ADDRESS() {
        return pictureAddress;
    }
    public void setPICTURE_ADDRESS(String pICTURE_ADDRESS) {
        pictureAddress = pICTURE_ADDRESS;
    }

    /***toPlace   db_column: TO_PLACE VARCHAR */
    @ApiModelProperty("toPlace")
    @Max(8)
    private String toPlace;
    public String getTO_PLACE() {
        return toPlace;
    }
    public void setTO_PLACE(String tO_PLACE) {
        toPlace = tO_PLACE;
    }

    /***urlType   db_column: url_type INTEGER */
    @ApiModelProperty("urlType")
    private Integer urlType;

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
        sb.append("advertiseIds=").append(advertiseIds).append('\n');
        sb.append("pictureAddressLike=").append(pictureAddressLike).append('\n');
        sb.append("toPlaceLike=").append(toPlaceLike).append('\n');
        sb.append("urlTypes=").append(urlTypes).append('\n');
        sb.append("createTimeMin=").append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax=").append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin=").append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax=").append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("advertiseId=").append(advertiseId).append('\n');
        sb.append("pictureAddress=").append(pictureAddress).append('\n');
        sb.append("toPlace=").append(toPlace).append('\n');
        sb.append("urlType=").append(urlType).append('\n');
        sb.append("createTime=").append(createTime != null ? df.format(createTime) : null).append('\n');
        sb.append("updateTime=").append(updateTime != null ? df.format(updateTime) : null).append('\n');
        sb.append("deleteFlag=").append(deleteFlag);
        sb.append('}');
        return sb.toString();
    }

    /*** advertiseIds in getPageList */
    @ApiModelProperty("advertiseId s")
    @JSONField(serialize = false)
    private java.util.List<Long> advertiseIds;

    /*** pictureAddressLike in getPageList */
    @ApiModelProperty("pictureAddressLike")
    @JSONField(serialize = false)
    private String pictureAddressLike;

    /*** toPlaceLike in getPageList */
    @ApiModelProperty("toPlaceLike")
    @JSONField(serialize = false)
    private String toPlaceLike;

    /*** urlTypes in getPageList */
    @ApiModelProperty("urlType s")
    @JSONField(serialize = false)
    private java.util.List<Integer> urlTypes;

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