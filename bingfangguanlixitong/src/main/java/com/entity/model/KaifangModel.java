package com.entity.model;

import com.entity.KaifangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 开方
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KaifangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 患者
     */
    private Integer huanzheId;


    /**
     * 开方编号
     */
    private String kaifangUuidNumber;


    /**
     * 药方名称
     */
    private String kaifangName;


    /**
     * 开方类型
     */
    private Integer kaifangTypes;


    /**
     * 开方内容
     */
    private String kaifangContent;


    /**
     * 开方时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：患者
	 */
    public Integer getHuanzheId() {
        return huanzheId;
    }


    /**
	 * 设置：患者
	 */
    public void setHuanzheId(Integer huanzheId) {
        this.huanzheId = huanzheId;
    }
    /**
	 * 获取：开方编号
	 */
    public String getKaifangUuidNumber() {
        return kaifangUuidNumber;
    }


    /**
	 * 设置：开方编号
	 */
    public void setKaifangUuidNumber(String kaifangUuidNumber) {
        this.kaifangUuidNumber = kaifangUuidNumber;
    }
    /**
	 * 获取：药方名称
	 */
    public String getKaifangName() {
        return kaifangName;
    }


    /**
	 * 设置：药方名称
	 */
    public void setKaifangName(String kaifangName) {
        this.kaifangName = kaifangName;
    }
    /**
	 * 获取：开方类型
	 */
    public Integer getKaifangTypes() {
        return kaifangTypes;
    }


    /**
	 * 设置：开方类型
	 */
    public void setKaifangTypes(Integer kaifangTypes) {
        this.kaifangTypes = kaifangTypes;
    }
    /**
	 * 获取：开方内容
	 */
    public String getKaifangContent() {
        return kaifangContent;
    }


    /**
	 * 设置：开方内容
	 */
    public void setKaifangContent(String kaifangContent) {
        this.kaifangContent = kaifangContent;
    }
    /**
	 * 获取：开方时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：开方时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
