package com.entity.model;

import com.entity.BingchuangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 病床
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BingchuangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 病床编号
     */
    private String bingchuangUuidNumber;


    /**
     * 房间名
     */
    private String fangjianName;


    /**
     * 房间位置
     */
    private String fangjianAddress;


    /**
     * 床号
     */
    private String chuanghao;


    /**
     * 是否使用
     */
    private Integer shifoushiyongTypes;


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
	 * 获取：病床编号
	 */
    public String getBingchuangUuidNumber() {
        return bingchuangUuidNumber;
    }


    /**
	 * 设置：病床编号
	 */
    public void setBingchuangUuidNumber(String bingchuangUuidNumber) {
        this.bingchuangUuidNumber = bingchuangUuidNumber;
    }
    /**
	 * 获取：房间名
	 */
    public String getFangjianName() {
        return fangjianName;
    }


    /**
	 * 设置：房间名
	 */
    public void setFangjianName(String fangjianName) {
        this.fangjianName = fangjianName;
    }
    /**
	 * 获取：房间位置
	 */
    public String getFangjianAddress() {
        return fangjianAddress;
    }


    /**
	 * 设置：房间位置
	 */
    public void setFangjianAddress(String fangjianAddress) {
        this.fangjianAddress = fangjianAddress;
    }
    /**
	 * 获取：床号
	 */
    public String getChuanghao() {
        return chuanghao;
    }


    /**
	 * 设置：床号
	 */
    public void setChuanghao(String chuanghao) {
        this.chuanghao = chuanghao;
    }
    /**
	 * 获取：是否使用
	 */
    public Integer getShifoushiyongTypes() {
        return shifoushiyongTypes;
    }


    /**
	 * 设置：是否使用
	 */
    public void setShifoushiyongTypes(Integer shifoushiyongTypes) {
        this.shifoushiyongTypes = shifoushiyongTypes;
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
