package com.entity.vo;

import com.entity.YihurenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 医护人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yihurenyuan")
public class YihurenyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 医护人员姓名
     */

    @TableField(value = "yihurenyuan_name")
    private String yihurenyuanName;


    /**
     * 医护人员手机号
     */

    @TableField(value = "yihurenyuan_phone")
    private String yihurenyuanPhone;


    /**
     * 医护人员身份证号
     */

    @TableField(value = "yihurenyuan_id_number")
    private String yihurenyuanIdNumber;


    /**
     * 医护人员头像
     */

    @TableField(value = "yihurenyuan_photo")
    private String yihurenyuanPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "yihurenyuan_email")
    private String yihurenyuanEmail;


    /**
     * 医护职位
     */

    @TableField(value = "yihurenyuan_zhiwei_types")
    private Integer yihurenyuanZhiweiTypes;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：医护人员姓名
	 */
    public String getYihurenyuanName() {
        return yihurenyuanName;
    }


    /**
	 * 获取：医护人员姓名
	 */

    public void setYihurenyuanName(String yihurenyuanName) {
        this.yihurenyuanName = yihurenyuanName;
    }
    /**
	 * 设置：医护人员手机号
	 */
    public String getYihurenyuanPhone() {
        return yihurenyuanPhone;
    }


    /**
	 * 获取：医护人员手机号
	 */

    public void setYihurenyuanPhone(String yihurenyuanPhone) {
        this.yihurenyuanPhone = yihurenyuanPhone;
    }
    /**
	 * 设置：医护人员身份证号
	 */
    public String getYihurenyuanIdNumber() {
        return yihurenyuanIdNumber;
    }


    /**
	 * 获取：医护人员身份证号
	 */

    public void setYihurenyuanIdNumber(String yihurenyuanIdNumber) {
        this.yihurenyuanIdNumber = yihurenyuanIdNumber;
    }
    /**
	 * 设置：医护人员头像
	 */
    public String getYihurenyuanPhoto() {
        return yihurenyuanPhoto;
    }


    /**
	 * 获取：医护人员头像
	 */

    public void setYihurenyuanPhoto(String yihurenyuanPhoto) {
        this.yihurenyuanPhoto = yihurenyuanPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getYihurenyuanEmail() {
        return yihurenyuanEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setYihurenyuanEmail(String yihurenyuanEmail) {
        this.yihurenyuanEmail = yihurenyuanEmail;
    }
    /**
	 * 设置：医护职位
	 */
    public Integer getYihurenyuanZhiweiTypes() {
        return yihurenyuanZhiweiTypes;
    }


    /**
	 * 获取：医护职位
	 */

    public void setYihurenyuanZhiweiTypes(Integer yihurenyuanZhiweiTypes) {
        this.yihurenyuanZhiweiTypes = yihurenyuanZhiweiTypes;
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
