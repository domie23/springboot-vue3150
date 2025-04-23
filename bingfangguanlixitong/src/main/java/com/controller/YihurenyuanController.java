
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
 * 医护人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yihurenyuan")
public class YihurenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(YihurenyuanController.class);

    @Autowired
    private YihurenyuanService yihurenyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private HuanzheService huanzheService;
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
        PageUtils page = yihurenyuanService.queryPage(params);

        //字典表数据转换
        List<YihurenyuanView> list =(List<YihurenyuanView>)page.getList();
        for(YihurenyuanView c:list){
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
        YihurenyuanEntity yihurenyuan = yihurenyuanService.selectById(id);
        if(yihurenyuan !=null){
            //entity转view
            YihurenyuanView view = new YihurenyuanView();
            BeanUtils.copyProperties( yihurenyuan , view );//把实体数据重构到view中

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
    public R save(@RequestBody YihurenyuanEntity yihurenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yihurenyuan:{}",this.getClass().getName(),yihurenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YihurenyuanEntity> queryWrapper = new EntityWrapper<YihurenyuanEntity>()
            .eq("username", yihurenyuan.getUsername())
            .or()
            .eq("yihurenyuan_phone", yihurenyuan.getYihurenyuanPhone())
            .or()
            .eq("yihurenyuan_id_number", yihurenyuan.getYihurenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YihurenyuanEntity yihurenyuanEntity = yihurenyuanService.selectOne(queryWrapper);
        if(yihurenyuanEntity==null){
            yihurenyuan.setCreateTime(new Date());
            yihurenyuan.setPassword("123456");
            yihurenyuanService.insert(yihurenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者医护人员手机号或者医护人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YihurenyuanEntity yihurenyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yihurenyuan:{}",this.getClass().getName(),yihurenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<YihurenyuanEntity> queryWrapper = new EntityWrapper<YihurenyuanEntity>()
            .notIn("id",yihurenyuan.getId())
            .andNew()
            .eq("username", yihurenyuan.getUsername())
            .or()
            .eq("yihurenyuan_phone", yihurenyuan.getYihurenyuanPhone())
            .or()
            .eq("yihurenyuan_id_number", yihurenyuan.getYihurenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YihurenyuanEntity yihurenyuanEntity = yihurenyuanService.selectOne(queryWrapper);
        if("".equals(yihurenyuan.getYihurenyuanPhoto()) || "null".equals(yihurenyuan.getYihurenyuanPhoto())){
                yihurenyuan.setYihurenyuanPhoto(null);
        }
        if(yihurenyuanEntity==null){
            yihurenyuanService.updateById(yihurenyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者医护人员手机号或者医护人员身份证号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yihurenyuanService.deleteBatchIds(Arrays.asList(ids));
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
            List<YihurenyuanEntity> yihurenyuanList = new ArrayList<>();//上传的东西
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
                            YihurenyuanEntity yihurenyuanEntity = new YihurenyuanEntity();
//                            yihurenyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //yihurenyuanEntity.setPassword("123456");//密码
//                            yihurenyuanEntity.setYihurenyuanName(data.get(0));                    //医护人员姓名 要改的
//                            yihurenyuanEntity.setYihurenyuanPhone(data.get(0));                    //医护人员手机号 要改的
//                            yihurenyuanEntity.setYihurenyuanIdNumber(data.get(0));                    //医护人员身份证号 要改的
//                            yihurenyuanEntity.setYihurenyuanPhoto("");//详情和图片
//                            yihurenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            yihurenyuanEntity.setYihurenyuanEmail(data.get(0));                    //电子邮箱 要改的
//                            yihurenyuanEntity.setYihurenyuanZhiweiTypes(Integer.valueOf(data.get(0)));   //医护职位 要改的
//                            yihurenyuanEntity.setCreateTime(date);//时间
                            yihurenyuanList.add(yihurenyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //医护人员手机号
                                if(seachFields.containsKey("yihurenyuanPhone")){
                                    List<String> yihurenyuanPhone = seachFields.get("yihurenyuanPhone");
                                    yihurenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> yihurenyuanPhone = new ArrayList<>();
                                    yihurenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("yihurenyuanPhone",yihurenyuanPhone);
                                }
                                //医护人员身份证号
                                if(seachFields.containsKey("yihurenyuanIdNumber")){
                                    List<String> yihurenyuanIdNumber = seachFields.get("yihurenyuanIdNumber");
                                    yihurenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yihurenyuanIdNumber = new ArrayList<>();
                                    yihurenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("yihurenyuanIdNumber",yihurenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<YihurenyuanEntity> yihurenyuanEntities_username = yihurenyuanService.selectList(new EntityWrapper<YihurenyuanEntity>().in("username", seachFields.get("username")));
                        if(yihurenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YihurenyuanEntity s:yihurenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //医护人员手机号
                        List<YihurenyuanEntity> yihurenyuanEntities_yihurenyuanPhone = yihurenyuanService.selectList(new EntityWrapper<YihurenyuanEntity>().in("yihurenyuan_phone", seachFields.get("yihurenyuanPhone")));
                        if(yihurenyuanEntities_yihurenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YihurenyuanEntity s:yihurenyuanEntities_yihurenyuanPhone){
                                repeatFields.add(s.getYihurenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [医护人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //医护人员身份证号
                        List<YihurenyuanEntity> yihurenyuanEntities_yihurenyuanIdNumber = yihurenyuanService.selectList(new EntityWrapper<YihurenyuanEntity>().in("yihurenyuan_id_number", seachFields.get("yihurenyuanIdNumber")));
                        if(yihurenyuanEntities_yihurenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YihurenyuanEntity s:yihurenyuanEntities_yihurenyuanIdNumber){
                                repeatFields.add(s.getYihurenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [医护人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yihurenyuanService.insertBatch(yihurenyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        YihurenyuanEntity yihurenyuan = yihurenyuanService.selectOne(new EntityWrapper<YihurenyuanEntity>().eq("username", username));
        if(yihurenyuan==null || !yihurenyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(yihurenyuan.getId(),username, "yihurenyuan", "医护人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","医护人员");
        r.put("username",yihurenyuan.getYihurenyuanName());
        r.put("tableName","yihurenyuan");
        r.put("userId",yihurenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody YihurenyuanEntity yihurenyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<YihurenyuanEntity> queryWrapper = new EntityWrapper<YihurenyuanEntity>()
            .eq("username", yihurenyuan.getUsername())
            .or()
            .eq("yihurenyuan_phone", yihurenyuan.getYihurenyuanPhone())
            .or()
            .eq("yihurenyuan_id_number", yihurenyuan.getYihurenyuanIdNumber())
            ;
        YihurenyuanEntity yihurenyuanEntity = yihurenyuanService.selectOne(queryWrapper);
        if(yihurenyuanEntity != null)
            return R.error("账户或者医护人员手机号或者医护人员身份证号已经被使用");
        yihurenyuan.setCreateTime(new Date());
        yihurenyuanService.insert(yihurenyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        YihurenyuanEntity yihurenyuan = new YihurenyuanEntity();
        yihurenyuan.setPassword("123456");
        yihurenyuan.setId(id);
        yihurenyuanService.updateById(yihurenyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        YihurenyuanEntity yihurenyuan = yihurenyuanService.selectOne(new EntityWrapper<YihurenyuanEntity>().eq("username", username));
        if(yihurenyuan!=null){
            yihurenyuan.setPassword("123456");
            boolean b = yihurenyuanService.updateById(yihurenyuan);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrYihurenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        YihurenyuanEntity yihurenyuan = yihurenyuanService.selectById(id);
        if(yihurenyuan !=null){
            //entity转view
            YihurenyuanView view = new YihurenyuanView();
            BeanUtils.copyProperties( yihurenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
