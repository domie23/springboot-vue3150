package com.entity.model;

import com.entity.BingliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 病例
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BingliModel implements Serializable {
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
     * 病例编号
     */
    private String bingliUuidNumber;


    /**
     * 住院时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zhuyuanTime;


    /**
     * 遗传史
     */
    private String yichuanText;


    /**
     * 患者主诉
     */
    private String zhusuText;


    /**
     * 诊断结果
     */
    private String zhenduanText;


    /**
     * 记录时间
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
	 * 获取：病例编号
	 */
    public String getBingliUuidNumber() {
        return bingliUuidNumber;
    }


    /**
	 * 设置：病例编号
	 */
    public void setBingliUuidNumber(String bingliUuidNumber) {
        this.bingliUuidNumber = bingliUuidNumber;
    }
    /**
	 * 获取：住院时间
	 */
    public Date getZhuyuanTime() {
        return zhuyuanTime;
    }


    /**
	 * 设置：住院时间
	 */
    public void setZhuyuanTime(Date zhuyuanTime) {
        this.zhuyuanTime = zhuyuanTime;
    }
    /**
	 * 获取：遗传史
	 */
    public String getYichuanText() {
        return yichuanText;
    }


    /**
	 * 设置：遗传史
	 */
    public void setYichuanText(String yichuanText) {
        this.yichuanText = yichuanText;
    }
    /**
	 * 获取：患者主诉
	 */
    public String getZhusuText() {
        return zhusuText;
    }


    /**
	 * 设置：患者主诉
	 */
    public void setZhusuText(String zhusuText) {
        this.zhusuText = zhusuText;
    }
    /**
	 * 获取：诊断结果
	 */
    public String getZhenduanText() {
        return zhenduanText;
    }


    /**
	 * 设置：诊断结果
	 */
    public void setZhenduanText(String zhenduanText) {
        this.zhenduanText = zhenduanText;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：记录时间
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
