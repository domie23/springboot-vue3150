
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 病床使用
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/bingchuangShiyong")
public class BingchuangShiyongController {
    private static final Logger logger = LoggerFactory.getLogger(BingchuangShiyongController.class);

    @Autowired
    private BingchuangShiyongService bingchuangShiyongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private BingchuangService bingchuangService;
    @Autowired
    private HuanzheService huanzheService;

    @Autowired
    private YihurenyuanService yihurenyuanService;
    @Autowired
    private YishengService yishengService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("患者".equals(role))
            params.put("huanzheId",request.getSession().getAttribute("userId"));
        else if("医护人员".equals(role))
            params.put("yihurenyuanId",request.getSession().getAttribute("userId"));
        else if("医生".equals(role))
            params.put("yishengId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = bingchuangShiyongService.queryPage(params);

        //字典表数据转换
        List<BingchuangShiyongView> list =(List<BingchuangShiyongView>)page.getList();
        for(BingchuangShiyongView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BingchuangShiyongEntity bingchuangShiyong = bingchuangShiyongService.selectById(id);
        if(bingchuangShiyong !=null){
            //entity转view
            BingchuangShiyongView view = new BingchuangShiyongView();
            BeanUtils.copyProperties( bingchuangShiyong , view );//把实体数据重构到view中

                //级联表
                BingchuangEntity bingchuang = bingchuangService.selectById(bingchuangShiyong.getBingchuangId());
                if(bingchuang != null){
                    BeanUtils.copyProperties( bingchuang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setBingchuangId(bingchuang.getId());
                }
                //级联表
                HuanzheEntity huanzhe = huanzheService.selectById(bingchuangShiyong.getHuanzheId());
                if(huanzhe != null){
                    BeanUtils.copyProperties( huanzhe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHuanzheId(huanzhe.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody BingchuangShiyongEntity bingchuangShiyong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,bingchuangShiyong:{}",this.getClass().getName(),bingchuangShiyong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("患者".equals(role))
            bingchuangShiyong.setHuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        BingchuangShiyongEntity bingchuangShiyongEntity = bingchuangShiyongService.selectOne(new EntityWrapper<BingchuangShiyongEntity>().eq("bingchuang_id", bingchuangShiyong.getBingchuangId()).eq("zhuangtai_types", 1));
        if(bingchuangShiyongEntity != null)
            return R.error("病床已被使用,无法再次入住");


        bingchuangShiyong.setZhuangtaiTypes(1);
        bingchuangShiyong.setInsertTime(new Date());
            bingchuangShiyong.setCreateTime(new Date());
            bingchuangShiyongService.insert(bingchuangShiyong);

        BingchuangEntity bingchuangEntity = new BingchuangEntity();
        bingchuangEntity.setId(bingchuangShiyong.getBingchuangId());
        bingchuangEntity.setShifoushiyongTypes(2);
        bingchuangService.updateById(bingchuangEntity);
            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BingchuangShiyongEntity bingchuangShiyong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,bingchuangShiyong:{}",this.getClass().getName(),bingchuangShiyong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("患者".equals(role))
//            bingchuangShiyong.setHuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<BingchuangShiyongEntity> queryWrapper = new EntityWrapper<BingchuangShiyongEntity>()
            .notIn("id",bingchuangShiyong.getId())
            .andNew()
            .eq("huanzhe_id", bingchuangShiyong.getHuanzheId())
            .eq("bingchuang_id", bingchuangShiyong.getBingchuangId())
            .eq("bingli_uuid_number", bingchuangShiyong.getBingliUuidNumber())
            .eq("zhuangtai_types", bingchuangShiyong.getZhuangtaiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BingchuangShiyongEntity bingchuangShiyongEntity = bingchuangShiyongService.selectOne(queryWrapper);
        if(bingchuangShiyongEntity==null){
            bingchuangShiyongService.updateById(bingchuangShiyong);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 离开
    */
    @RequestMapping("/likai")
    public R likai(@RequestParam Integer id, HttpServletRequest request){
        logger.debug("likai方法:,,Controller:{},,id:{}",this.getClass().getName(),id);

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(!"医护人员".equals(role))
            return R.error(511,"您没有权限执行此操作");


        BingchuangShiyongEntity bingchuangShiyongEntity = bingchuangShiyongService.selectById(id);
        if(bingchuangShiyongEntity == null)
            return R.error("查不到病床使用信息");
        else if(bingchuangShiyongEntity.getZhuangtaiTypes() ==2)
            return R.error("病床使用状态已是离开,请去确认");
        BingchuangEntity bingchuangEntity = bingchuangService.selectById(bingchuangShiyongEntity.getBingchuangId());
        if(bingchuangEntity == null)
            return R.error("查不到病床");
        else if(bingchuangEntity.getShifoushiyongTypes() ==1)
            return R.error("病床状态已是未使用,数据异常");

        bingchuangShiyongEntity.setZhuangtaiTypes(2);
        bingchuangShiyongEntity.setLikaiTime(new Date());
        bingchuangShiyongService.updateById(bingchuangShiyongEntity);//根据id更新
        bingchuangEntity.setShifoushiyongTypes(1);
        bingchuangService.updateById(bingchuangEntity);
        return R.ok();

    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        bingchuangShiyongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<BingchuangShiyongEntity> bingchuangShiyongList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            BingchuangShiyongEntity bingchuangShiyongEntity = new BingchuangShiyongEntity();
//                            bingchuangShiyongEntity.setHuanzheId(Integer.valueOf(data.get(0)));   //患者 要改的
//                            bingchuangShiyongEntity.setBingchuangId(Integer.valueOf(data.get(0)));   //病床 要改的
//                            bingchuangShiyongEntity.setBingliUuidNumber(data.get(0));                    //病房使用唯一编号 要改的
//                            bingchuangShiyongEntity.setRuzhuTime(sdf.parse(data.get(0)));          //入住时间 要改的
//                            bingchuangShiyongEntity.setLikaiTime(sdf.parse(data.get(0)));          //离开时间 要改的
//                            bingchuangShiyongEntity.setZhuangtaiTypes(Integer.valueOf(data.get(0)));   //状态 要改的
//                            bingchuangShiyongEntity.setInsertTime(date);//时间
//                            bingchuangShiyongEntity.setCreateTime(date);//时间
                            bingchuangShiyongList.add(bingchuangShiyongEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        bingchuangShiyongService.insertBatch(bingchuangShiyongList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
