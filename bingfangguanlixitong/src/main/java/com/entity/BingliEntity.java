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
 * 病例
 *
 * @author 
 * @email
 */
@TableName("bingli")
public class BingliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BingliEntity() {

	}

	public BingliEntity(T t) {
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
     * 病例编号
     */
    @TableField(value = "bingli_uuid_number")

    private String bingliUuidNumber;


    /**
     * 住院时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "zhuyuan_time")

    private Date zhuyuanTime;


    /**
     * 遗传史
     */
    @TableField(value = "yichuan_text")

    private String yichuanText;


    /**
     * 患者主诉
     */
    @TableField(value = "zhusu_text")

    private String zhusuText;


    /**
     * 诊断结果
     */
    @TableField(value = "zhenduan_text")

    private String zhenduanText;


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
	 * 设置：病例编号
	 */
    public String getBingliUuidNumber() {
        return bingliUuidNumber;
    }
    /**
	 * 获取：病例编号
	 */

    public void setBingliUuidNumber(String bingliUuidNumber) {
        this.bingliUuidNumber = bingliUuidNumber;
    }
    /**
	 * 设置：住院时间
	 */
    public Date getZhuyuanTime() {
        return zhuyuanTime;
    }
    /**
	 * 获取：住院时间
	 */

    public void setZhuyuanTime(Date zhuyuanTime) {
        this.zhuyuanTime = zhuyuanTime;
    }
    /**
	 * 设置：遗传史
	 */
    public String getYichuanText() {
        return yichuanText;
    }
    /**
	 * 获取：遗传史
	 */

    public void setYichuanText(String yichuanText) {
        this.yichuanText = yichuanText;
    }
    /**
	 * 设置：患者主诉
	 */
    public String getZhusuText() {
        return zhusuText;
    }
    /**
	 * 获取：患者主诉
	 */

    public void setZhusuText(String zhusuText) {
        this.zhusuText = zhusuText;
    }
    /**
	 * 设置：诊断结果
	 */
    public String getZhenduanText() {
        return zhenduanText;
    }
    /**
	 * 获取：诊断结果
	 */

    public void setZhenduanText(String zhenduanText) {
        this.zhenduanText = zhenduanText;
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
        return "Bingli{" +
            "id=" + id +
            ", huanzheId=" + huanzheId +
            ", bingliUuidNumber=" + bingliUuidNumber +
            ", zhuyuanTime=" + zhuyuanTime +
            ", yichuanText=" + yichuanText +
            ", zhusuText=" + zhusuText +
            ", zhenduanText=" + zhenduanText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
