<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='huanzhe'"  label='患者姓名' prop="huanzheName">
               <el-input v-model="ruleForm.huanzheName"  placeholder='患者姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='huanzhe'"  label='患者手机号' prop="huanzhePhone">
               <el-input v-model="ruleForm.huanzhePhone"  placeholder='患者手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='huanzhe'"  label='患者身份证号' prop="huanzheIdNumber">
               <el-input v-model="ruleForm.huanzheIdNumber"  placeholder='患者身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='huanzhe'" label='患者照片' prop="huanzhePhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.huanzhePhoto?ruleForm.huanzhePhoto:''"
                         @change="huanzhePhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='huanzhe'"  label='年龄' prop="age">
               <el-input v-model="ruleForm.age"  placeholder='年龄' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='huanzhe'"  label='电子邮箱' prop="huanzheEmail">
               <el-input v-model="ruleForm.huanzheEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='huanzhe'"  label='婚姻' prop="hunyinTypes">
                 <el-select v-model="ruleForm.hunyinTypes"  placeholder='请选择婚姻'>
                     <el-option
                             v-for="(item,index) in hunyinTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='huanzhe'"  label='现住址' prop="xianAddress">
               <el-input v-model="ruleForm.xianAddress"  placeholder='现住址' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='huanzhe'"  label='户籍地址' prop="hujiAddress">
               <el-input v-model="ruleForm.hujiAddress"  placeholder='户籍地址' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yihurenyuan'"  label='医护人员姓名' prop="yihurenyuanName">
               <el-input v-model="ruleForm.yihurenyuanName"  placeholder='医护人员姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yihurenyuan'"  label='医护人员手机号' prop="yihurenyuanPhone">
               <el-input v-model="ruleForm.yihurenyuanPhone"  placeholder='医护人员手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yihurenyuan'"  label='医护人员身份证号' prop="yihurenyuanIdNumber">
               <el-input v-model="ruleForm.yihurenyuanIdNumber"  placeholder='医护人员身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='yihurenyuan'" label='医护人员头像' prop="yihurenyuanPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.yihurenyuanPhoto?ruleForm.yihurenyuanPhoto:''"
                         @change="yihurenyuanPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yihurenyuan'"  label='电子邮箱' prop="yihurenyuanEmail">
               <el-input v-model="ruleForm.yihurenyuanEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='yihurenyuan'"  label='医护职位' prop="yihurenyuanZhiweiTypes">
                 <el-select v-model="ruleForm.yihurenyuanZhiweiTypes"  placeholder='请选择医护职位'>
                     <el-option
                             v-for="(item,index) in yihurenyuanZhiweiTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yisheng'"  label='医生姓名' prop="yishengName">
               <el-input v-model="ruleForm.yishengName"  placeholder='医生姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yisheng'"  label='医生手机号' prop="yishengPhone">
               <el-input v-model="ruleForm.yishengPhone"  placeholder='医生手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yisheng'"  label='医生身份证号' prop="yishengIdNumber">
               <el-input v-model="ruleForm.yishengIdNumber"  placeholder='医生身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='yisheng'" label='医生头像' prop="yishengPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.yishengPhoto?ruleForm.yishengPhoto:''"
                         @change="yishengPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yisheng'"  label='电子邮箱' prop="yishengEmail">
               <el-input v-model="ruleForm.yishengEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='yisheng'"  label='科室' prop="keshiTypes">
                 <el-select v-model="ruleForm.keshiTypes"  placeholder='请选择科室'>
                     <el-option
                             v-for="(item,index) in keshiTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yisheng'"  label='职位' prop="zhiweiTypes">
                 <el-select v-model="ruleForm.zhiweiTypes"  placeholder='请选择职位'>
                     <el-option
                             v-for="(item,index) in zhiweiTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yisheng'"  label='擅长' prop="yishengShanchang">
               <el-input v-model="ruleForm.yishengShanchang"  placeholder='擅长' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yisheng'"  label='所获荣誉' prop="yishengRongyu">
               <el-input v-model="ruleForm.yishengRongyu"  placeholder='所获荣誉' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users'"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
        ruleForm: {},
        flag: '',
        usersFlag: false,
        // sexTypesOptions : [],
// 注册表 患者
    // 注册的类型字段 患者
        // 性别
        sexTypesOptions : [],
        // 婚姻
        hunyinTypesOptions : [],
// 注册表 医护人员
    // 注册的类型字段 医护人员
        // 性别
        sexTypesOptions : [],
        // 医护职位
        yihurenyuanZhiweiTypesOptions : [],
// 注册表 医生
    // 注册的类型字段 医生
        // 性别
        sexTypesOptions : [],
        // 科室
        keshiTypesOptions : [],
        // 职位
        zhiweiTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
// 注册表 患者
// 注册表 医护人员
// 注册表 医生
      } else {
        this.$message.error(data.msg);
      }
    });

// 注册表 患者 的级联表
// 注册表 医护人员 的级联表
// 注册表 医生 的级联表

      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
              this.sexTypesOptions = data.data.list;
          } else {
              this.$message.error(data.msg);
          }
      });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=hunyin_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.hunyinTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=yihurenyuan_zhiwei_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.yihurenyuanZhiweiTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=keshi_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.keshiTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=zhiwei_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.zhiweiTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
  },
  methods: {
    chongzhi() {
      this.$router.replace({ path: "/pay" });
    },
    huanzhePhotoUploadChange(fileUrls) {
        this.ruleForm.huanzhePhoto = fileUrls;
    },
    yihurenyuanPhotoUploadChange(fileUrls) {
        this.ruleForm.yihurenyuanPhoto = fileUrls;
    },
    yishengPhotoUploadChange(fileUrls) {
        this.ruleForm.yishengPhoto = fileUrls;
    },


    onUpdateHandler() {
                         if((!this.ruleForm.huanzheName)&& 'huanzhe'==this.flag){
                             this.$message.error('患者姓名不能为空');
                             return
                         }

                             if( 'huanzhe' ==this.flag && this.ruleForm.huanzhePhone&&(!isMobile(this.ruleForm.huanzhePhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.huanzheIdNumber)&& 'huanzhe'==this.flag){
                             this.$message.error('患者身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.huanzhePhoto)&& 'huanzhe'==this.flag){
                             this.$message.error('患者照片不能为空');
                             return
                         }

                         if((!this.ruleForm.age)&& 'huanzhe'==this.flag){
                             this.$message.error('年龄不能为空');
                             return
                         }

                             if( 'huanzhe' ==this.flag && this.ruleForm.huanzheEmail&&(!isEmail(this.ruleForm.huanzheEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.hunyinTypes)&& 'huanzhe'==this.flag){
                             this.$message.error('婚姻不能为空');
                             return
                         }

                         if((!this.ruleForm.xianAddress)&& 'huanzhe'==this.flag){
                             this.$message.error('现住址不能为空');
                             return
                         }

                         if((!this.ruleForm.hujiAddress)&& 'huanzhe'==this.flag){
                             this.$message.error('户籍地址不能为空');
                             return
                         }

                         if((!this.ruleForm.yihurenyuanName)&& 'yihurenyuan'==this.flag){
                             this.$message.error('医护人员姓名不能为空');
                             return
                         }

                             if( 'yihurenyuan' ==this.flag && this.ruleForm.yihurenyuanPhone&&(!isMobile(this.ruleForm.yihurenyuanPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.yihurenyuanIdNumber)&& 'yihurenyuan'==this.flag){
                             this.$message.error('医护人员身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.yihurenyuanPhoto)&& 'yihurenyuan'==this.flag){
                             this.$message.error('医护人员头像不能为空');
                             return
                         }

                             if( 'yihurenyuan' ==this.flag && this.ruleForm.yihurenyuanEmail&&(!isEmail(this.ruleForm.yihurenyuanEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.yihurenyuanZhiweiTypes)&& 'yihurenyuan'==this.flag){
                             this.$message.error('医护职位不能为空');
                             return
                         }

                         if((!this.ruleForm.yishengName)&& 'yisheng'==this.flag){
                             this.$message.error('医生姓名不能为空');
                             return
                         }

                             if( 'yisheng' ==this.flag && this.ruleForm.yishengPhone&&(!isMobile(this.ruleForm.yishengPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.yishengIdNumber)&& 'yisheng'==this.flag){
                             this.$message.error('医生身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.yishengPhoto)&& 'yisheng'==this.flag){
                             this.$message.error('医生头像不能为空');
                             return
                         }

                             if( 'yisheng' ==this.flag && this.ruleForm.yishengEmail&&(!isEmail(this.ruleForm.yishengEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.keshiTypes)&& 'yisheng'==this.flag){
                             this.$message.error('科室不能为空');
                             return
                         }

                         if((!this.ruleForm.zhiweiTypes)&& 'yisheng'==this.flag){
                             this.$message.error('职位不能为空');
                             return
                         }

                         if((!this.ruleForm.yishengShanchang)&& 'yisheng'==this.flag){
                             this.$message.error('擅长不能为空');
                             return
                         }

                         if((!this.ruleForm.yishengRongyu)&& 'yisheng'==this.flag){
                             this.$message.error('所获荣誉不能为空');
                             return
                         }

        if((!this.ruleForm.sexTypes) && this.flag!='users'){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
