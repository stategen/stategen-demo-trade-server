/*
 * Do not remove this unless you get business authorization.
 * Copyright (c) 2016 - 2018 All Rights Reserved.
 * Powered By [stategen.dalgen]
 */
package com.mycompany.biz.domain;

import java.math.BigDecimal;
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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Goods
 * <pre>
 * database table: demo_goods
 * database table comments: Goods
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅不可以修改dalgenx生成的属生(field)类型 ,方法(Method)返回值类型和参数类型
 * 该类可自由继承、实现接口，自定义字段或方法，在下次生成时均不会丢失，可有效减少DTO的使用.
 * 同时，支持自定义修改字段大小写，一旦修改后，请再执行 gen.sh dal demo_goods -e
 * 不建议使@Data,其hashCode有问题
 * 如果表修改后 ，请执行 gen.sh table demo_goods -e ,再执行 gen.sh dal demo_goods -e
 * </pre>
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Goods implements java.io.Serializable {

    List<GoodsComment> goodComments;

    /*** goodsDetailLike in getPageList */
    @ApiModelProperty("goodsDetailLike")
    @JSONField(serialize = false)
    private String goodsDetailLike;

    /***不使用或自定义字段在下次生成后，会移到serialVersionUID的上面*/
    private static final long serialVersionUID = -5216457518046898601L;

    /***商品ID   db_column: goods_id VARCHAR */
    @ApiModelProperty("商品ID")
    @Id
    @Max(64)
    private String goodsId;

    /***商品名称   db_column: goods_name VARCHAR */
    @ApiModelProperty("商品名称")
    @Max(64)
    private String goodsName;

    /***categorySubId   db_column: categorySubId VARCHAR */
    @ApiModelProperty("categorySubId")
    @Max(64)
    private String categorySubId;

    /***数量 代替count   db_column: amount BIGINT */
    @ApiModelProperty("数量 代替count")
    private Long amount;

    /***价格   db_column: price DECIMAL */
    @ApiModelProperty("价格")
    private BigDecimal price;

    /***图片地址   db_column: images VARCHAR */
    @ApiModelProperty("图片地址")
    @Max(255)
    private String images;

    /***是否选择   db_column: is_check BIT */
    @ApiModelProperty("是否选择")
    private Boolean isCheck;

    /***isHot   db_column: is_hot BIT */
    @ApiModelProperty("isHot")
    private Boolean isHot;

    /***advertiseId   db_column: advertise_id BIGINT */
    @ApiModelProperty("advertiseId")
    private Long advertiseId;

    /***presentPrice   db_column: present_price DECIMAL */
    @ApiModelProperty("presentPrice")
    private BigDecimal presentPrice;

    /***image   db_column: image VARCHAR */
    @ApiModelProperty("image")
    @Max(255)
    private String image;

    /***image1   db_column: image1 VARCHAR */
    @ApiModelProperty("image1")
    @Max(255)
    private String image1;

    /***image2   db_column: image2 VARCHAR */
    @ApiModelProperty("image2")
    @Max(255)
    private String image2;

    /***image3   db_column: image3 VARCHAR */
    @ApiModelProperty("image3")
    @Max(255)
    private String image3;

    /***image4   db_column: image4 VARCHAR */
    @ApiModelProperty("image4")
    @Max(255)
    private String image4;

    /***image5   db_column: image5 VARCHAR */
    @ApiModelProperty("image5")
    @Max(255)
    private String image5;

    /***isOnLine   db_column: is_on_line VARCHAR */
    @ApiModelProperty("isOnLine")
    @Max(8)
    private String isOnLine;

    /***goodsSerialNumber   db_column: goods_serial_number VARCHAR */
    @ApiModelProperty("goodsSerialNumber")
    @Max(64)
    private String goodsSerialNumber;

    /***state   db_column: state INTEGER */
    @ApiModelProperty("state")
    private Integer state;

    /***shopId   db_column: shop_id VARCHAR */
    @ApiModelProperty("shopId")
    @Max(64)
    private String shopId;

    /***goodsDetail   db_column: goods_detail LONGVARCHAR */
    @ApiModelProperty("goodsDetail")
    @Max(65535)
    @Editor(EditorType.Textarea.class)
    private String goodsDetail;

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
        sb.append("goodsIds").append('=').append(goodsIds).append('\n');
        sb.append("goodsNameLike").append('=').append(goodsNameLike).append('\n');
        sb.append("categorySubIds").append('=').append(categorySubIds).append('\n');
        sb.append("amountMin").append('=').append(amountMin).append('\n');
        sb.append("amountMax").append('=').append(amountMax).append('\n');
        sb.append("priceMin").append('=').append(priceMin).append('\n');
        sb.append("priceMax").append('=').append(priceMax).append('\n');
        sb.append("imagesLike").append('=').append(imagesLike).append('\n');
        sb.append("advertiseIds").append('=').append(advertiseIds).append('\n');
        sb.append("presentPriceMin").append('=').append(presentPriceMin).append('\n');
        sb.append("presentPriceMax").append('=').append(presentPriceMax).append('\n');
        sb.append("image1Like").append('=').append(image1Like).append('\n');
        sb.append("image2Like").append('=').append(image2Like).append('\n');
        sb.append("image3Like").append('=').append(image3Like).append('\n');
        sb.append("image4Like").append('=').append(image4Like).append('\n');
        sb.append("image5Like").append('=').append(image5Like).append('\n');
        sb.append("isOnLineLike").append('=').append(isOnLineLike).append('\n');
        sb.append("goodsSerialNumberLike").append('=').append(goodsSerialNumberLike).append('\n');
        sb.append("stateMin").append('=').append(stateMin).append('\n');
        sb.append("stateMax").append('=').append(stateMax).append('\n');
        sb.append("shopIds").append('=').append(shopIds).append('\n');
        sb.append("createTimeMin").append('=').append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax").append('=').append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin").append('=').append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax").append('=').append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("goodsId").append('=').append(getGoodsId()).append('\n');
        sb.append("goodsName").append('=').append(getGoodsName()).append('\n');
        sb.append("categorySubId").append('=').append(getCategorySubId()).append('\n');
        sb.append("amount").append('=').append(getAmount()).append('\n');
        sb.append("price").append('=').append(getPrice()).append('\n');
        sb.append("images").append('=').append(getImages()).append('\n');
        sb.append("isCheck").append('=').append(getIsCheck()).append('\n');
        sb.append("isHot").append('=').append(getIsHot()).append('\n');
        sb.append("advertiseId").append('=').append(getAdvertiseId()).append('\n');
        sb.append("presentPrice").append('=').append(getPresentPrice()).append('\n');
        sb.append("image").append('=').append(getImage()).append('\n');
        sb.append("image1").append('=').append(getImage1()).append('\n');
        sb.append("image2").append('=').append(getImage2()).append('\n');
        sb.append("image3").append('=').append(getImage3()).append('\n');
        sb.append("image4").append('=').append(getImage4()).append('\n');
        sb.append("image5").append('=').append(getImage5()).append('\n');
        sb.append("isOnLine").append('=').append(getIsOnLine()).append('\n');
        sb.append("goodsSerialNumber").append('=').append(getGoodsSerialNumber()).append('\n');
        sb.append("state").append('=').append(getState()).append('\n');
        sb.append("shopId").append('=').append(getShopId()).append('\n');
        sb.append("goodsDetail").append('=').append(getGoodsDetail()).append('\n');
        sb.append("createTime").append('=').append(getCreateTime() != null ? df.format(getCreateTime()) : null).append('\n');
        sb.append("updateTime").append('=').append(getUpdateTime() != null ? df.format(getUpdateTime()) : null).append('\n');
        sb.append("deleteFlag").append('=').append(getDeleteFlag());
        sb.append('}');
        return sb.toString();
    }

    /***查询字段下次生成时会自动移到toString()方法下面*/
    /*** 商品IDs in getPageList */
    @ApiModelProperty("商品ID s")
    @JSONField(serialize = false)
    private java.util.List<String> goodsIds;

    /*** 商品名称Like in getPageList */
    @ApiModelProperty("商品名称Like")
    @JSONField(serialize = false)
    private String goodsNameLike;

    /*** categorySubIds in getPageList */
    @ApiModelProperty("categorySubId s")
    @JSONField(serialize = false)
    private java.util.List<String> categorySubIds;

    /*** 数量 代替countMin in getPageList */
    @ApiModelProperty("数量Min")
    @JSONField(serialize = false)
    private Long amountMin;

    /*** 数量 代替countMax in getPageList */
    @ApiModelProperty("数量Max")
    @JSONField(serialize = false)
    private Long amountMax;

    /*** 价格Min in getPageList */
    @ApiModelProperty("价格Min")
    @JSONField(serialize = false)
    private java.math.BigDecimal priceMin;

    /*** 价格Max in getPageList */
    @ApiModelProperty("价格Max")
    @JSONField(serialize = false)
    private java.math.BigDecimal priceMax;

    /*** 图片地址Like in getPageList */
    @ApiModelProperty("图片地址Like")
    @JSONField(serialize = false)
    private String imagesLike;

    /*** advertiseIds in getPageList */
    @ApiModelProperty("advertiseId s")
    @JSONField(serialize = false)
    private java.util.List<Long> advertiseIds;

    /*** presentPriceMin in getPageList */
    @ApiModelProperty("presentPriceMin")
    @JSONField(serialize = false)
    private java.math.BigDecimal presentPriceMin;

    /*** presentPriceMax in getPageList */
    @ApiModelProperty("presentPriceMax")
    @JSONField(serialize = false)
    private java.math.BigDecimal presentPriceMax;

    /*** image1Like in getPageList */
    @ApiModelProperty("image1Like")
    @JSONField(serialize = false)
    private String image1Like;

    /*** image2Like in getPageList */
    @ApiModelProperty("image2Like")
    @JSONField(serialize = false)
    private String image2Like;

    /*** image3Like in getPageList */
    @ApiModelProperty("image3Like")
    @JSONField(serialize = false)
    private String image3Like;

    /*** image4Like in getPageList */
    @ApiModelProperty("image4Like")
    @JSONField(serialize = false)
    private String image4Like;

    /*** image5Like in getPageList */
    @ApiModelProperty("image5Like")
    @JSONField(serialize = false)
    private String image5Like;

    /*** isOnLineLike in getPageList */
    @ApiModelProperty("isOnLineLike")
    @JSONField(serialize = false)
    private String isOnLineLike;

    /*** goodsSerialNumberLike in getPageList */
    @ApiModelProperty("goodsSerialNumberLike")
    @JSONField(serialize = false)
    private String goodsSerialNumberLike;

    /*** stateMin in getPageList */
    @ApiModelProperty("stateMin")
    @JSONField(serialize = false)
    private Integer stateMin;

    /*** stateMax in getPageList */
    @ApiModelProperty("stateMax")
    @JSONField(serialize = false)
    private Integer stateMax;

    /*** shopIds in getPageList */
    @ApiModelProperty("shopId s")
    @JSONField(serialize = false)
    private java.util.List<String> shopIds;

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

    public String getName() {
        return goodsName;
    }

    public void setName(String name) {
        this.goodsName = name;
    }

    public BigDecimal getOriPrice() {
        return this.price;
    }

    public void setOriPrice(BigDecimal oriPrice) {
        this.price = oriPrice;
    }

    public BigDecimal getMallPrice() {
        return this.presentPrice;
    }

    public void setMallPrice(BigDecimal mallPrice) {
        this.presentPrice = mallPrice;
    }

    public Long getCount() {
        return amount;
    }

    public void setCount(Long count) {
        this.amount = count;
    }

    public String getComPic() {
        return this.image;
    }

    public void setComPic(String comPic) {
        this.image = comPic;
    }
}
