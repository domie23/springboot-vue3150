package com.entity.view;

import com.entity.YihurenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 医护人员
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yihurenyuan")
public class YihurenyuanView extends YihurenyuanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 性别的值
		*/
		private String sexValue;
		/**
		* 医护职位的值
		*/
		private String yihurenyuanZhiweiValue;



	public YihurenyuanView() {

	}

	public YihurenyuanView(YihurenyuanEntity yihurenyuanEntity) {
		try {
			BeanUtils.copyProperties(this, yihurenyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}
			/**
			* 获取： 医护职位的值
			*/
			public String getYihurenyuanZhiweiValue() {
				return yihurenyuanZhiweiValue;
			}
			/**
			* 设置： 医护职位的值
			*/
			public void setYihurenyuanZhiweiValue(String yihurenyuanZhiweiValue) {
				this.yihurenyuanZhiweiValue = yihurenyuanZhiweiValue;
			}












}
