package com.dao;

import com.entity.YihurenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YihurenyuanView;

/**
 * 医护人员 Dao 接口
 *
 * @author 
 */
public interface YihurenyuanDao extends BaseMapper<YihurenyuanEntity> {

   List<YihurenyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
