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
 * 开方
 *
 * @author 
 * @email
 */
@TableName("kaifang")
public class KaifangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KaifangEntity() {

	}

	public KaifangEntity(T t) {
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
     * 开方编号
     */
    @TableField(value = "kaifang_uuid_number")

    private String kaifangUuidNumber;


    /**
     * 药方名称
     */
    @TableField(value = "kaifang_name")

    private String kaifangName;


    /**
     * 开方类型
     */
    @TableField(value = "kaifang_types")

    private Integer kaifangTypes;


    /**
     * 开方内容
     */
    @TableField(value = "kaifang_content")

    private String kaifangContent;


    /**
     * 开方时间
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
	 * 设置：开方编号
	 */
    public String getKaifangUuidNumber() {
        return kaifangUuidNumber;
    }
    /**
	 * 获取：开方编号
	 */

    public void setKaifangUuidNumber(String kaifangUuidNumber) {
        this.kaifangUuidNumber = kaifangUuidNumber;
    }
    /**
	 * 设置：药方名称
	 */
    public String getKaifangName() {
        return kaifangName;
    }
    /**
	 * 获取：药方名称
	 */

    public void setKaifangName(String kaifangName) {
        this.kaifangName = kaifangName;
    }
    /**
	 * 设置：开方类型
	 */
    public Integer getKaifangTypes() {
        return kaifangTypes;
    }
    /**
	 * 获取：开方类型
	 */

    public void setKaifangTypes(Integer kaifangTypes) {
        this.kaifangTypes = kaifangTypes;
    }
    /**
	 * 设置：开方内容
	 */
    public String getKaifangContent() {
        return kaifangContent;
    }
    /**
	 * 获取：开方内容
	 */

    public void setKaifangContent(String kaifangContent) {
        this.kaifangContent = kaifangContent;
    }
    /**
	 * 设置：开方时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：开方时间
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
        return "Kaifang{" +
            "id=" + id +
            ", huanzheId=" + huanzheId +
            ", kaifangUuidNumber=" + kaifangUuidNumber +
            ", kaifangName=" + kaifangName +
            ", kaifangTypes=" + kaifangTypes +
            ", kaifangContent=" + kaifangContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
