package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KaifangEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 开方 服务类
 */
public interface KaifangService extends IService<KaifangEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}