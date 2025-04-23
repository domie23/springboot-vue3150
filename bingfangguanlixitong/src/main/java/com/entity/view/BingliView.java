package com.entity.view;

import com.entity.BingliEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 病例
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("bingli")
public class BingliView extends BingliEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 huanzhe
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
				* 婚姻的值
				*/
				private String hunyinValue;
			/**
			* 现住址
			*/
			private String xianAddress;
			/**
			* 户籍地址
			*/
			private String hujiAddress;

	public BingliView() {

	}

	public BingliView(BingliEntity bingliEntity) {
		try {
			BeanUtils.copyProperties(this, bingliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}















				//级联表的get和set huanzhe

					/**
					* 获取： 患者姓名
					*/
					public String getHuanzheName() {
						return huanzheName;
					}
					/**
					* 设置： 患者姓名
					*/
					public void setHuanzheName(String huanzheName) {
						this.huanzheName = huanzheName;
					}

					/**
					* 获取： 患者手机号
					*/
					public String getHuanzhePhone() {
						return huanzhePhone;
					}
					/**
					* 设置： 患者手机号
					*/
					public void setHuanzhePhone(String huanzhePhone) {
						this.huanzhePhone = huanzhePhone;
					}

					/**
					* 获取： 患者身份证号
					*/
					public String getHuanzheIdNumber() {
						return huanzheIdNumber;
					}
					/**
					* 设置： 患者身份证号
					*/
					public void setHuanzheIdNumber(String huanzheIdNumber) {
						this.huanzheIdNumber = huanzheIdNumber;
					}

					/**
					* 获取： 患者照片
					*/
					public String getHuanzhePhoto() {
						return huanzhePhoto;
					}
					/**
					* 设置： 患者照片
					*/
					public void setHuanzhePhoto(String huanzhePhoto) {
						this.huanzhePhoto = huanzhePhoto;
					}

					/**
					* 获取： 年龄
					*/
					public Integer getAge() {
						return age;
					}
					/**
					* 设置： 年龄
					*/
					public void setAge(Integer age) {
						this.age = age;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getHuanzheEmail() {
						return huanzheEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setHuanzheEmail(String huanzheEmail) {
						this.huanzheEmail = huanzheEmail;
					}

					/**
					* 获取： 婚姻
					*/
					public Integer getHunyinTypes() {
						return hunyinTypes;
					}
					/**
					* 设置： 婚姻
					*/
					public void setHunyinTypes(Integer hunyinTypes) {
						this.hunyinTypes = hunyinTypes;
					}


						/**
						* 获取： 婚姻的值
						*/
						public String getHunyinValue() {
							return hunyinValue;
						}
						/**
						* 设置： 婚姻的值
						*/
						public void setHunyinValue(String hunyinValue) {
							this.hunyinValue = hunyinValue;
						}

					/**
					* 获取： 现住址
					*/
					public String getXianAddress() {
						return xianAddress;
					}
					/**
					* 设置： 现住址
					*/
					public void setXianAddress(String xianAddress) {
						this.xianAddress = xianAddress;
					}

					/**
					* 获取： 户籍地址
					*/
					public String getHujiAddress() {
						return hujiAddress;
					}
					/**
					* 设置： 户籍地址
					*/
					public void setHujiAddress(String hujiAddress) {
						this.hujiAddress = hujiAddress;
					}










}
