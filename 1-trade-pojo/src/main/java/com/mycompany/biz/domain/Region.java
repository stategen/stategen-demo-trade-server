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

import org.stategen.framework.annotation.OptionConvertor;
import org.stategen.framework.lite.IOption;

import com.alibaba.fastjson.annotation.JSONField;
import com.mycompany.biz.enums.RegionType;
import io.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * Region
 * <pre>
 * database table: region
 * database table comments: Region
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 *
 * 该类仅不可以修改dalgen生成的属生(field)类型 ,方法(Method)返回值类型和参数类型
 * 不建议使@Data,其hashCode有问题
 * </pre>
 */
@Getter
@Setter
@OptionConvertor(parentId = "parentRegionId", label = "name")
public class Region implements java.io.Serializable, IOption {

    private Boolean isLeaf;

    private static final long serialVersionUID = -5216457518046898601L;

    /***主键   db_column: region_id BIGINT */
    @ApiModelProperty("主键")
    @Id
    private Long regionId;

    /***父ID   db_column: parent_region_id BIGINT */
    @ApiModelProperty("父ID")
    private Long parentRegionId;

    /***路径   db_column: path VARCHAR */
    @ApiModelProperty("路径")
    @Max(255)
    private String path;

    /***层级   db_column: level INTEGER */
    @ApiModelProperty("层级")
    private Integer level;

    /***regionType   db_column: region_type VARCHAR */
    @ApiModelProperty("regionType")
    private RegionType regionType;

    /***中文名称   db_column: name VARCHAR */
    @ApiModelProperty("中文名称")
    @Max(255)
    private String name;

    /***英文名称   db_column: name_en VARCHAR */
    @ApiModelProperty("英文名称")
    @Max(255)
    private String nameEn;

    /***中文拼音   db_column: name_pinyin VARCHAR */
    @ApiModelProperty("中文拼音")
    @Max(255)
    private String namePinyin;

    /***代码   db_column: code VARCHAR */
    @ApiModelProperty("代码")
    @Max(50)
    private String code;

    /***创建时间   db_column: create_time TIMESTAMP */
    @ApiModelProperty(value = "创建时间", hidden = true)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createTime;

    /***更新时间   db_column: update_time TIMESTAMP */
    @ApiModelProperty(value = "更新时间", hidden = true)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updateTime;

    /***是否删除 (0:正常，1删除)   db_column: delete_flag INTEGER */
    @ApiModelProperty(value = "是否删除 (0:正常，1删除)", hidden = true)
    private Integer deleteFlag;

    /*----------------getter & setter ignore by lombok -------------------*/
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd H:m:ss.SSS");
        StringBuffer sb = new StringBuffer(1024);
        sb.append('{');
        sb.append("regionIds=").append(regionIds).append('\n');
        sb.append("parentRegionIds=").append(parentRegionIds).append('\n');
        sb.append("pathLike=").append(pathLike).append('\n');
        sb.append("levelMin=").append(levelMin).append('\n');
        sb.append("levelMax=").append(levelMax).append('\n');
        sb.append("regionTypes=").append(regionTypes).append('\n');
        sb.append("nameLike=").append(nameLike).append('\n');
        sb.append("nameEnLike=").append(nameEnLike).append('\n');
        sb.append("namePinyinLike=").append(namePinyinLike).append('\n');
        sb.append("codeLike=").append(codeLike).append('\n');
        sb.append("createTimeMin=").append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax=").append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin=").append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax=").append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("regionId=").append(regionId).append('\n');
        sb.append("parentRegionId=").append(parentRegionId).append('\n');
        sb.append("path=").append(path).append('\n');
        sb.append("level=").append(level).append('\n');
        sb.append("regionType=").append(regionType).append('\n');
        sb.append("name=").append(name).append('\n');
        sb.append("nameEn=").append(nameEn).append('\n');
        sb.append("namePinyin=").append(namePinyin).append('\n');
        sb.append("code=").append(code).append('\n');
        sb.append("createTime=").append(createTime != null ? df.format(createTime) : null).append('\n');
        sb.append("updateTime=").append(updateTime != null ? df.format(updateTime) : null).append('\n');
        sb.append("deleteFlag=").append(deleteFlag);
        sb.append('}');
        return sb.toString();
    }

    /*** 主键s in getRegionPageList */
    @ApiModelProperty("主键s")
    @JSONField(serialize = false)
    private java.util.List<Long> regionIds;

    /*** 父IDs in getRegionPageList */
    @ApiModelProperty("父IDs")
    @JSONField(serialize = false)
    private java.util.List<Long> parentRegionIds;

    /*** 路径Like in getRegionPageList */
    @ApiModelProperty("路径Like")
    @JSONField(serialize = false)
    private String pathLike;

    /*** 层级Min in getRegionPageList */
    @ApiModelProperty("层级Min")
    @JSONField(serialize = false)
    private Integer levelMin;

    /*** 层级Max in getRegionPageList */
    @ApiModelProperty("层级Max")
    @JSONField(serialize = false)
    private Integer levelMax;

    /*** regionTypes in getRegionPageList */
    @ApiModelProperty("regionTypes")
    @JSONField(serialize = false)
    private java.util.List<com.mycompany.biz.enums.RegionType> regionTypes;

    /*** 中文名称Like in getRegionPageList */
    @ApiModelProperty("中文名称Like")
    @JSONField(serialize = false)
    private String nameLike;

    /*** 英文名称Like in getRegionPageList */
    @ApiModelProperty("英文名称Like")
    @JSONField(serialize = false)
    private String nameEnLike;

    /*** 中文拼音Like in getRegionPageList */
    @ApiModelProperty("中文拼音Like")
    @JSONField(serialize = false)
    private String namePinyinLike;

    /*** 代码Like in getRegionPageList */
    @ApiModelProperty("代码Like")
    @JSONField(serialize = false)
    private String codeLike;

    /*** 创建时间Min in getRegionPageList */
    @ApiModelProperty("创建时间Min")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date createTimeMin;

    /*** 创建时间Max in getRegionPageList */
    @ApiModelProperty("创建时间Max")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date createTimeMax;

    /*** 更新时间Min in getRegionPageList */
    @ApiModelProperty("更新时间Min")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date updateTimeMin;

    /*** 更新时间Max in getRegionPageList */
    @ApiModelProperty("更新时间Max")
    @Temporal(TemporalType.TIMESTAMP)
    @JSONField(serialize = false)
    private java.util.Date updateTimeMax;

    @Override
    public String getTitle() {
        return getName();
    }

    @Override
    public String getValue() {
        if (regionId == null) {
            return null;
        }
        return regionId.toString();
    }
}
