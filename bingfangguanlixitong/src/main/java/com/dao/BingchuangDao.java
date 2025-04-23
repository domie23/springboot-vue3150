package com.dao;

import com.entity.BingchuangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BingchuangView;

/**
 * 病床 Dao 接口
 *
 * @author 
 */
public interface BingchuangDao extends BaseMapper<BingchuangEntity> {

   List<BingchuangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
