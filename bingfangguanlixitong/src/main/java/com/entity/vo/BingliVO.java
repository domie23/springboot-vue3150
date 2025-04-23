package com.entity.vo;

import com.entity.BingliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 病例
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bingli")
public class BingliVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
