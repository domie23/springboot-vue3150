package com.entity.vo;

import com.entity.BingchuangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 病床
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bingchuang")
public class BingchuangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 病床编号
     */

    @TableField(value = "bingchuang_uuid_number")
    private String bingchuangUuidNumber;


    /**
     * 房间名
     */

    @TableField(value = "fangjian_name")
    private String fangjianName;


    /**
     * 房间位置
     */

    @TableField(value = "fangjian_address")
    private String fangjianAddress;


    /**
     * 床号
     */

    @TableField(value = "chuanghao")
    private String chuanghao;


    /**
     * 是否使用
     */

    @TableField(value = "shifoushiyong_types")
    private Integer shifoushiyongTypes;


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
	 * 设置：病床编号
	 */
    public String getBingchuangUuidNumber() {
        return bingchuangUuidNumber;
    }


    /**
	 * 获取：病床编号
	 */

    public void setBingchuangUuidNumber(String bingchuangUuidNumber) {
        this.bingchuangUuidNumber = bingchuangUuidNumber;
    }
    /**
	 * 设置：房间名
	 */
    public String getFangjianName() {
        return fangjianName;
    }


    /**
	 * 获取：房间名
	 */

    public void setFangjianName(String fangjianName) {
        this.fangjianName = fangjianName;
    }
    /**
	 * 设置：房间位置
	 */
    public String getFangjianAddress() {
        return fangjianAddress;
    }


    /**
	 * 获取：房间位置
	 */

    public void setFangjianAddress(String fangjianAddress) {
        this.fangjianAddress = fangjianAddress;
    }
    /**
	 * 设置：床号
	 */
    public String getChuanghao() {
        return chuanghao;
    }


    /**
	 * 获取：床号
	 */

    public void setChuanghao(String chuanghao) {
        this.chuanghao = chuanghao;
    }
    /**
	 * 设置：是否使用
	 */
    public Integer getShifoushiyongTypes() {
        return shifoushiyongTypes;
    }


    /**
	 * 获取：是否使用
	 */

    public void setShifoushiyongTypes(Integer shifoushiyongTypes) {
        this.shifoushiyongTypes = shifoushiyongTypes;
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
