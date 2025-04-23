package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 病床使用
 *
 * @author 
 * @email
 */
@TableName("bingchuang_shiyong")
public class BingchuangShiyongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BingchuangShiyongEntity() {

	}

	public BingchuangShiyongEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 患者
     */
    @TableField(value = "huanzhe_id")

    private Integer huanzheId;


    /**
     * 病床
     */
    @TableField(value = "bingchuang_id")

    private Integer bingchuangId;


    /**
     * 病房使用唯一编号
     */
    @TableField(value = "bingli_uuid_number")

    private String bingliUuidNumber;


    /**
     * 入住时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "ruzhu_time")

    private Date ruzhuTime;


    /**
     * 离开时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "likai_time")

    private Date likaiTime;


    /**
     * 状态
     */
    @TableField(value = "zhuangtai_types")

    private Integer zhuangtaiTypes;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：患者
	 */
    public Integer getHuanzheId() {
        return huanzheId;
    }
    /**
	 * 获取：患者
	 */

    public void setHuanzheId(Integer huanzheId) {
        this.huanzheId = huanzheId;
    }
    /**
	 * 设置：病床
	 */
    public Integer getBingchuangId() {
        return bingchuangId;
    }
    /**
	 * 获取：病床
	 */

    public void setBingchuangId(Integer bingchuangId) {
        this.bingchuangId = bingchuangId;
    }
    /**
	 * 设置：病房使用唯一编号
	 */
    public String getBingliUuidNumber() {
        return bingliUuidNumber;
    }
    /**
	 * 获取：病房使用唯一编号
	 */

    public void setBingliUuidNumber(String bingliUuidNumber) {
        this.bingliUuidNumber = bingliUuidNumber;
    }
    /**
	 * 设置：入住时间
	 */
    public Date getRuzhuTime() {
        return ruzhuTime;
    }
    /**
	 * 获取：入住时间
	 */

    public void setRuzhuTime(Date ruzhuTime) {
        this.ruzhuTime = ruzhuTime;
    }
    /**
	 * 设置：离开时间
	 */
    public Date getLikaiTime() {
        return likaiTime;
    }
    /**
	 * 获取：离开时间
	 */

    public void setLikaiTime(Date likaiTime) {
        this.likaiTime = likaiTime;
    }
    /**
	 * 设置：状态
	 */
    public Integer getZhuangtaiTypes() {
        return zhuangtaiTypes;
    }
    /**
	 * 获取：状态
	 */

    public void setZhuangtaiTypes(Integer zhuangtaiTypes) {
        this.zhuangtaiTypes = zhuangtaiTypes;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：记录时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BingchuangShiyong{" +
            "id=" + id +
            ", huanzheId=" + huanzheId +
            ", bingchuangId=" + bingchuangId +
            ", bingliUuidNumber=" + bingliUuidNumber +
            ", ruzhuTime=" + ruzhuTime +
            ", likaiTime=" + likaiTime +
            ", zhuangtaiTypes=" + zhuangtaiTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
