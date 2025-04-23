package com.entity.model;

import com.entity.HuanzheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 患者
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuanzheModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 患者姓名
     */
    private String huanzheName;


    /**
     * 患者手机号
     */
    private String huanzhePhone;


    /**
     * 患者身份证号
     */
    private String huanzheIdNumber;


    /**
     * 患者照片
     */
    private String huanzhePhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 年龄
     */
    private Integer age;


    /**
     * 电子邮箱
     */
    private String huanzheEmail;


    /**
     * 婚姻
     */
    private Integer hunyinTypes;


    /**
     * 现住址
     */
    private String xianAddress;


    /**
     * 户籍地址
     */
    private String hujiAddress;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：患者姓名
	 */
    public String getHuanzheName() {
        return huanzheName;
    }


    /**
	 * 设置：患者姓名
	 */
    public void setHuanzheName(String huanzheName) {
        this.huanzheName = huanzheName;
    }
    /**
	 * 获取：患者手机号
	 */
    public String getHuanzhePhone() {
        return huanzhePhone;
    }


    /**
	 * 设置：患者手机号
	 */
    public void setHuanzhePhone(String huanzhePhone) {
        this.huanzhePhone = huanzhePhone;
    }
    /**
	 * 获取：患者身份证号
	 */
    public String getHuanzheIdNumber() {
        return huanzheIdNumber;
    }


    /**
	 * 设置：患者身份证号
	 */
    public void setHuanzheIdNumber(String huanzheIdNumber) {
        this.huanzheIdNumber = huanzheIdNumber;
    }
    /**
	 * 获取：患者照片
	 */
    public String getHuanzhePhoto() {
        return huanzhePhoto;
    }


    /**
	 * 设置：患者照片
	 */
    public void setHuanzhePhoto(String huanzhePhoto) {
        this.huanzhePhoto = huanzhePhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：年龄
	 */
    public Integer getAge() {
        return age;
    }


    /**
	 * 设置：年龄
	 */
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getHuanzheEmail() {
        return huanzheEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setHuanzheEmail(String huanzheEmail) {
        this.huanzheEmail = huanzheEmail;
    }
    /**
	 * 获取：婚姻
	 */
    public Integer getHunyinTypes() {
        return hunyinTypes;
    }


    /**
	 * 设置：婚姻
	 */
    public void setHunyinTypes(Integer hunyinTypes) {
        this.hunyinTypes = hunyinTypes;
    }
    /**
	 * 获取：现住址
	 */
    public String getXianAddress() {
        return xianAddress;
    }


    /**
	 * 设置：现住址
	 */
    public void setXianAddress(String xianAddress) {
        this.xianAddress = xianAddress;
    }
    /**
	 * 获取：户籍地址
	 */
    public String getHujiAddress() {
        return hujiAddress;
    }


    /**
	 * 设置：户籍地址
	 */
    public void setHujiAddress(String hujiAddress) {
        this.hujiAddress = hujiAddress;
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
