<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='bingchuang'">
                    <el-form-item class="select" v-if="type!='info'"  label="病床" prop="bingchuangId">
                        <el-select v-model="ruleForm.bingchuangId" :disabled="ro.bingchuangId" filterable placeholder="请选择病床" @change="bingchuangChange">
                            <el-option
                                    v-for="(item,index) in bingchuangOptions"
                                    v-bind:key="item.id"
                                    :label="'房间名:'+item.fangjianName+' 床号:'+item.chuanghao"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='bingchuang' ">
                    <el-form-item class="input" v-if="type!='info'"  label="病床编号" prop="bingchuangUuidNumber">
                        <el-input v-model="bingchuangForm.bingchuangUuidNumber"
                                  placeholder="病床编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="病床编号" prop="bingchuangUuidNumber">
                            <el-input v-model="ruleForm.bingchuangUuidNumber"
                                      placeholder="病床编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='bingchuang' ">
                    <el-form-item class="input" v-if="type!='info'"  label="房间名" prop="fangjianName">
                        <el-input v-model="bingchuangForm.fangjianName"
                                  placeholder="房间名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="房间名" prop="fangjianName">
                            <el-input v-model="ruleForm.fangjianName"
                                      placeholder="房间名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='bingchuang' ">
                    <el-form-item class="input" v-if="type!='info'"  label="房间位置" prop="fangjianAddress">
                        <el-input v-model="bingchuangForm.fangjianAddress"
                                  placeholder="房间位置" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="房间位置" prop="fangjianAddress">
                            <el-input v-model="ruleForm.fangjianAddress"
                                      placeholder="房间位置" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='bingchuang' ">
                    <el-form-item class="input" v-if="type!='info'"  label="床号" prop="chuanghao">
                        <el-input v-model="bingchuangForm.chuanghao"
                                  placeholder="床号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="床号" prop="chuanghao">
                            <el-input v-model="ruleForm.chuanghao"
                                      placeholder="床号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='bingchuang' ">
                    <el-form-item class="input" v-if="type!='info'"  label="是否使用" prop="shifoushiyongValue">
                        <el-input v-model="bingchuangForm.shifoushiyongValue"
                                  placeholder="是否使用" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="是否使用" prop="shifoushiyongValue">
                            <el-input v-model="ruleForm.shifoushiyongValue"
                                      placeholder="是否使用" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='huanzhe'">
                    <el-form-item class="select" v-if="type!='info'"  label="患者" prop="huanzheId">
                        <el-select v-model="ruleForm.huanzheId" :disabled="ro.huanzheId" filterable placeholder="请选择患者" @change="huanzheChange">
                            <el-option
                                    v-for="(item,index) in huanzheOptions"
                                    v-bind:key="item.id"
                                    :label="item.huanzheName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='huanzhe' ">
                    <el-form-item class="input" v-if="type!='info'"  label="患者姓名" prop="huanzheName">
                        <el-input v-model="huanzheForm.huanzheName"
                                  placeholder="患者姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="患者姓名" prop="huanzheName">
                            <el-input v-model="ruleForm.huanzheName"
                                      placeholder="患者姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='huanzhe' ">
                    <el-form-item class="input" v-if="type!='info'"  label="患者手机号" prop="huanzhePhone">
                        <el-input v-model="huanzheForm.huanzhePhone"
                                  placeholder="患者手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="患者手机号" prop="huanzhePhone">
                            <el-input v-model="ruleForm.huanzhePhone"
                                      placeholder="患者手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='huanzhe' ">
                    <el-form-item class="input" v-if="type!='info'"  label="患者身份证号" prop="huanzheIdNumber">
                        <el-input v-model="huanzheForm.huanzheIdNumber"
                                  placeholder="患者身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="患者身份证号" prop="huanzheIdNumber">
                            <el-input v-model="ruleForm.huanzheIdNumber"
                                      placeholder="患者身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='huanzhe' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.huanzhePhoto" label="患者照片" prop="huanzhePhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (huanzheForm.huanzhePhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.huanzhePhoto" label="患者照片" prop="huanzhePhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.huanzhePhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='huanzhe' ">
                    <el-form-item class="input" v-if="type!='info'"  label="年龄" prop="age">
                        <el-input v-model="huanzheForm.age"
                                  placeholder="年龄" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="年龄" prop="age">
                            <el-input v-model="ruleForm.age"
                                      placeholder="年龄" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='huanzhe' ">
                    <el-form-item class="input" v-if="type!='info'"  label="电子邮箱" prop="huanzheEmail">
                        <el-input v-model="huanzheForm.huanzheEmail"
                                  placeholder="电子邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="电子邮箱" prop="huanzheEmail">
                            <el-input v-model="ruleForm.huanzheEmail"
                                      placeholder="电子邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='huanzhe' ">
                    <el-form-item class="input" v-if="type!='info'"  label="婚姻" prop="hunyinValue">
                        <el-input v-model="huanzheForm.hunyinValue"
                                  placeholder="婚姻" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="婚姻" prop="hunyinValue">
                            <el-input v-model="ruleForm.hunyinValue"
                                      placeholder="婚姻" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='huanzhe' ">
                    <el-form-item class="input" v-if="type!='info'"  label="现住址" prop="xianAddress">
                        <el-input v-model="huanzheForm.xianAddress"
                                  placeholder="现住址" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="现住址" prop="xianAddress">
                            <el-input v-model="ruleForm.xianAddress"
                                      placeholder="现住址" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='huanzhe' ">
                    <el-form-item class="input" v-if="type!='info'"  label="户籍地址" prop="hujiAddress">
                        <el-input v-model="huanzheForm.hujiAddress"
                                  placeholder="户籍地址" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="户籍地址" prop="hujiAddress">
                            <el-input v-model="ruleForm.hujiAddress"
                                      placeholder="户籍地址" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="huanzheId" name="huanzheId" type="hidden">
            <input id="bingchuangId" name="bingchuangId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="病房使用唯一编号" prop="bingliUuidNumber">
                       <el-input v-model="ruleForm.bingliUuidNumber"
                                 placeholder="病房使用唯一编号" clearable  :readonly="ro.bingliUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="病房使用唯一编号" prop="bingliUuidNumber">
                           <el-input v-model="ruleForm.bingliUuidNumber"
                                     placeholder="病房使用唯一编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item v-if="type!='info'"  class="input" label="入住时间" prop="ruzhuTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="ruleForm.ruzhuTime"
                                type="datetime"
                                placeholder="入住时间"
                                :disabled="ro.ruzhuTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.ruzhuTime" label="入住时间" prop="ruzhuTime">
                            <span v-html="ruleForm.ruzhuTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

                <el-col :span="12" v-if="type=='info'">
                    <el-form-item v-if="type!='info'"  class="input" label="离开时间" prop="likaiTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="ruleForm.likaiTime"
                                type="datetime"
                                placeholder="离开时间"
                                :disabled="ro.likaiTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.likaiTime" label="离开时间" prop="likaiTime">
                            <span v-html="ruleForm.likaiTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

                <el-col :span="12" v-if="type=='info'">
                    <el-form-item class="select" v-if="type!='info'"  label="状态" prop="zhuangtaiTypes">
                        <el-select v-model="ruleForm.zhuangtaiTypes" :disabled="ro.zhuangtaiTypes" placeholder="请选择状态">
                            <el-option
                                v-for="(item,index) in zhuangtaiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="状态" prop="zhuangtaiValue">
                        <el-input v-model="ruleForm.zhuangtaiValue"
                            placeholder="状态" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                bingchuangForm: {},
                huanzheForm: {},
                ro:{
                    huanzheId: false,
                    bingchuangId: false,
                    bingliUuidNumber: false,
                    ruzhuTime: false,
                    likaiTime: false,
                    zhuangtaiTypes: false,
                    insertTime: false,
                },
                ruleForm: {
                    huanzheId: '',
                    bingchuangId: '',
                    bingliUuidNumber: new Date().getTime(),
                    ruzhuTime: '',
                    likaiTime: '',
                    zhuangtaiTypes: '',
                    insertTime: '',
                },
                zhuangtaiTypesOptions : [],
                bingchuangOptions : [],
                huanzheOptions : [],
                rules: {
                   huanzheId: [
                              { required: true, message: '患者不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   bingchuangId: [
                              { required: true, message: '病床不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   bingliUuidNumber: [
                              { required: true, message: '病房使用唯一编号不能为空', trigger: 'blur' },
                          ],
                   ruzhuTime: [
                              { required: true, message: '入住时间不能为空', trigger: 'blur' },
                          ],
                   // likaiTime: [
                   //            { required: true, message: '离开时间不能为空', trigger: 'blur' },
                   //        ],
                   zhuangtaiTypes: [
                              { required: true, message: '状态不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   insertTime: [
                              { required: true, message: '记录时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=zhuangtai_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zhuangtaiTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `bingchuang/page?page=1&limit=100&shifoushiyongTypes=1`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.bingchuangOptions = data.data.list;
            }
         });
         this.$http({
             url: `huanzhe/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.huanzheOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            bingchuangChange(id){
                this.$http({
                    url: `bingchuang/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.bingchuangForm = data.data;
                    }
                });
            },
            huanzheChange(id){
                this.$http({
                    url: `huanzhe/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.huanzheForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `bingchuangShiyong/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.bingchuangChange(data.data.bingchuangId)
                        _this.huanzheChange(data.data.huanzheId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`bingchuangShiyong/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.bingchuangShiyongCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.bingchuangShiyongCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>

