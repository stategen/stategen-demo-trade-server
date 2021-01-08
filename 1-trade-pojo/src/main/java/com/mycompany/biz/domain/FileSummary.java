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

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * FileSummary
 * @author StateGen.org
 * <pre>
 * database table: file_summary
 * database table comments: FileSummary
 * This file is generated by <tt>dalgenx</tt>, a DAL (Data Access Layer)
 *
 * 该类仅不可以修改dalgenx生成的属生(field)类型 ,方法(Method)返回值类型和参数类型
 * 该类可自由继承、实现接口，自定义字段或方法，在下次生成时均不会丢失，可有效减少DTO的使用.
 * 同时，支持自定义修改字段大小写，一旦修改后，请再执行 gen.sh dal file_summary -e
 * 不建议使@Data,其hashCode有问题
 * 如果表修改后 ，请执行 gen.sh table file_summary -e ,再执行 gen.sh dal file_summary -e
 * </pre>
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@OptionConvertor(value = "fileId")
public class FileSummary implements java.io.Serializable {

    /*** types in getPageList */
    @ApiModelProperty("type s")
    @JSONField(serialize = false)
    private java.util.List<String> types;

    /***不使用或自定义字段在下次生成后，会移到serialVersionUID的上面
     ** 额外查询字段，自定义方法会自动移到toString()的下面
     ** 如果字段注释中包括 ‘-inherited’, 将不生成，字段可以从父类中继承
     ** ps: 该方案既享受生成器的便利，pojo可以同时作为po dto vo使用，而不用担心字段丢失问题,
     **     同时解决领域模型(DDD)开发中，失血模式下的失忆问题
     */
    private static final long serialVersionUID = -5216457518046898601L;

    /***fileId   db_column: file_id VARCHAR */
    @ApiModelProperty("fileId")
    @Id
    @Max(64)
    private String fileId;

    /***url   db_column: url VARCHAR */
    @ApiModelProperty("url")
    @Max(255)
    private String url;

    /***size   db_column: size BIGINT */
    @ApiModelProperty("size")
    private Long size;

    /***name   db_column: name VARCHAR */
    @ApiModelProperty("name")
    @Max(128)
    private String name;

    /***type   db_column: type VARCHAR */
    @ApiModelProperty("type")
    @Max(64)
    private String type;

    /***userId   db_column: user_id VARCHAR */
    @ApiModelProperty("userId")
    @Max(64)
    private String userId;

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
        StringBuilder sb = new StringBuilder(1024);
        sb.append('{');
        sb.append("fileIds").append('=').append(fileIds).append('\n');
        sb.append("sizeMin").append('=').append(sizeMin).append('\n');
        sb.append("sizeMax").append('=').append(sizeMax).append('\n');
        sb.append("nameLike").append('=').append(nameLike).append('\n');
        sb.append("typeLike").append('=').append(typeLike).append('\n');
        sb.append("userIds").append('=').append(userIds).append('\n');
        sb.append("createTimeMin").append('=').append(createTimeMin != null ? df.format(createTimeMin) : null).append('\n');
        sb.append("createTimeMax").append('=').append(createTimeMax != null ? df.format(createTimeMax) : null).append('\n');
        sb.append("updateTimeMin").append('=').append(updateTimeMin != null ? df.format(updateTimeMin) : null).append('\n');
        sb.append("updateTimeMax").append('=').append(updateTimeMax != null ? df.format(updateTimeMax) : null).append('\n');
        sb.append("fileId").append('=').append(getFileId()).append('\n');
        sb.append("url").append('=').append(getUrl()).append('\n');
        sb.append("size").append('=').append(getSize()).append('\n');
        sb.append("name").append('=').append(getName()).append('\n');
        sb.append("type").append('=').append(getType()).append('\n');
        sb.append("userId").append('=').append(getUserId()).append('\n');
        sb.append("createTime").append('=').append(getCreateTime() != null ? df.format(getCreateTime()) : null).append('\n');
        sb.append("updateTime").append('=').append(getUpdateTime() != null ? df.format(getUpdateTime()) : null).append('\n');
        sb.append("deleteFlag").append('=').append(getDeleteFlag());
        sb.append('}');
        return sb.toString();
    }

    /***查询字段下次生成时会自动移到toString()方法下面*/
    /*** fileIds in getPageList */
    @ApiModelProperty("fileId s")
    @JSONField(serialize = false)
    private java.util.List<String> fileIds;

    /*** sizeMin in getPageList */
    @ApiModelProperty("sizeMin")
    @JSONField(serialize = false)
    private Long sizeMin;

    /*** sizeMax in getPageList */
    @ApiModelProperty("sizeMax")
    @JSONField(serialize = false)
    private Long sizeMax;

    /*** nameLike in getPageList */
    @ApiModelProperty("nameLike")
    @JSONField(serialize = false)
    private String nameLike;

    /*** typeLike in getPageList */
    @ApiModelProperty("typeLike")
    @JSONField(serialize = false)
    private String typeLike;

    /*** userIds in getPageList */
    @ApiModelProperty("userId s")
    @JSONField(serialize = false)
    private java.util.List<String> userIds;

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

    public String getUid() {
        return this.getFileId();
    }

    public void setUid(String uid) {
        this.setFileId(uid);
    }
}
