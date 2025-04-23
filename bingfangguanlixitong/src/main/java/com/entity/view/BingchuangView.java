package com.entity.view;

import com.entity.BingchuangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 病床
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("bingchuang")
public class BingchuangView extends BingchuangEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 是否使用的值
		*/
		private String shifoushiyongValue;



	public BingchuangView() {

	}

	public BingchuangView(BingchuangEntity bingchuangEntity) {
		try {
			BeanUtils.copyProperties(this, bingchuangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 是否使用的值
			*/
			public String getShifoushiyongValue() {
				return shifoushiyongValue;
			}
			/**
			* 设置： 是否使用的值
			*/
			public void setShifoushiyongValue(String shifoushiyongValue) {
				this.shifoushiyongValue = shifoushiyongValue;
			}












}
