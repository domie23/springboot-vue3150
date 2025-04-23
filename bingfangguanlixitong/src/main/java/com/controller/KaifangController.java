
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
 * 开方
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kaifang")
public class KaifangController {
    private static final Logger logger = LoggerFactory.getLogger(KaifangController.class);

    @Autowired
    private KaifangService kaifangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
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
        PageUtils page = kaifangService.queryPage(params);

        //字典表数据转换
        List<KaifangView> list =(List<KaifangView>)page.getList();
        for(KaifangView c:list){
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
        KaifangEntity kaifang = kaifangService.selectById(id);
        if(kaifang !=null){
            //entity转view
            KaifangView view = new KaifangView();
            BeanUtils.copyProperties( kaifang , view );//把实体数据重构到view中

                //级联表
                HuanzheEntity huanzhe = huanzheService.selectById(kaifang.getHuanzheId());
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
    public R save(@RequestBody KaifangEntity kaifang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kaifang:{}",this.getClass().getName(),kaifang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("患者".equals(role))
            kaifang.setHuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<KaifangEntity> queryWrapper = new EntityWrapper<KaifangEntity>()
            .eq("huanzhe_id", kaifang.getHuanzheId())
            .eq("kaifang_uuid_number", kaifang.getKaifangUuidNumber())
            .eq("kaifang_name", kaifang.getKaifangName())
            .eq("kaifang_types", kaifang.getKaifangTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaifangEntity kaifangEntity = kaifangService.selectOne(queryWrapper);
        if(kaifangEntity==null){
            kaifang.setInsertTime(new Date());
            kaifang.setCreateTime(new Date());
            kaifangService.insert(kaifang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KaifangEntity kaifang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kaifang:{}",this.getClass().getName(),kaifang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("患者".equals(role))
//            kaifang.setHuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<KaifangEntity> queryWrapper = new EntityWrapper<KaifangEntity>()
            .notIn("id",kaifang.getId())
            .andNew()
            .eq("huanzhe_id", kaifang.getHuanzheId())
            .eq("kaifang_uuid_number", kaifang.getKaifangUuidNumber())
            .eq("kaifang_name", kaifang.getKaifangName())
            .eq("kaifang_types", kaifang.getKaifangTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaifangEntity kaifangEntity = kaifangService.selectOne(queryWrapper);
        if(kaifangEntity==null){
            kaifangService.updateById(kaifang);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        kaifangService.deleteBatchIds(Arrays.asList(ids));
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
            List<KaifangEntity> kaifangList = new ArrayList<>();//上传的东西
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
                            KaifangEntity kaifangEntity = new KaifangEntity();
//                            kaifangEntity.setHuanzheId(Integer.valueOf(data.get(0)));   //患者 要改的
//                            kaifangEntity.setKaifangUuidNumber(data.get(0));                    //开方编号 要改的
//                            kaifangEntity.setKaifangName(data.get(0));                    //药方名称 要改的
//                            kaifangEntity.setKaifangTypes(Integer.valueOf(data.get(0)));   //开方类型 要改的
//                            kaifangEntity.setKaifangContent("");//详情和图片
//                            kaifangEntity.setInsertTime(date);//时间
//                            kaifangEntity.setCreateTime(date);//时间
                            kaifangList.add(kaifangEntity);


                            //把要查询是否重复的字段放入map中
                                //开方编号
                                if(seachFields.containsKey("kaifangUuidNumber")){
                                    List<String> kaifangUuidNumber = seachFields.get("kaifangUuidNumber");
                                    kaifangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> kaifangUuidNumber = new ArrayList<>();
                                    kaifangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("kaifangUuidNumber",kaifangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //开方编号
                        List<KaifangEntity> kaifangEntities_kaifangUuidNumber = kaifangService.selectList(new EntityWrapper<KaifangEntity>().in("kaifang_uuid_number", seachFields.get("kaifangUuidNumber")));
                        if(kaifangEntities_kaifangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(KaifangEntity s:kaifangEntities_kaifangUuidNumber){
                                repeatFields.add(s.getKaifangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [开方编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        kaifangService.insertBatch(kaifangList);
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
