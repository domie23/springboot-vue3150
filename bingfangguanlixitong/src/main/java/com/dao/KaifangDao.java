package com.dao;

import com.entity.KaifangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KaifangView;

/**
 * 开方 Dao 接口
 *
 * @author 
 */
public interface KaifangDao extends BaseMapper<KaifangEntity> {

   List<KaifangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
