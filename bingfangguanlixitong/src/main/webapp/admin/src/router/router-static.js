import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import bingchuang from '@/views/modules/bingchuang/list'
    import bingchuangShiyong from '@/views/modules/bingchuangShiyong/list'
    import bingli from '@/views/modules/bingli/list'
    import dictionary from '@/views/modules/dictionary/list'
    import huanzhe from '@/views/modules/huanzhe/list'
    import kaifang from '@/views/modules/kaifang/list'
    import yaopin from '@/views/modules/yaopin/list'
    import yihurenyuan from '@/views/modules/yihurenyuan/list'
    import yisheng from '@/views/modules/yisheng/list'
    import dictionaryHunyin from '@/views/modules/dictionaryHunyin/list'
    import dictionaryKaifang from '@/views/modules/dictionaryKaifang/list'
    import dictionaryKeshi from '@/views/modules/dictionaryKeshi/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShifoushiyong from '@/views/modules/dictionaryShifoushiyong/list'
    import dictionaryYaopin from '@/views/modules/dictionaryYaopin/list'
    import dictionaryYihurenyuanZhiwei from '@/views/modules/dictionaryYihurenyuanZhiwei/list'
    import dictionaryZhiwei from '@/views/modules/dictionaryZhiwei/list'
    import dictionaryZhuangtai from '@/views/modules/dictionaryZhuangtai/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryHunyin',
        name: '婚姻',
        component: dictionaryHunyin
    }
    ,{
        path: '/dictionaryKaifang',
        name: '开方类型',
        component: dictionaryKaifang
    }
    ,{
        path: '/dictionaryKeshi',
        name: '科室',
        component: dictionaryKeshi
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShifoushiyong',
        name: '是否使用',
        component: dictionaryShifoushiyong
    }
    ,{
        path: '/dictionaryYaopin',
        name: '药品类型',
        component: dictionaryYaopin
    }
    ,{
        path: '/dictionaryYihurenyuanZhiwei',
        name: '医护职位',
        component: dictionaryYihurenyuanZhiwei
    }
    ,{
        path: '/dictionaryZhiwei',
        name: '职位',
        component: dictionaryZhiwei
    }
    ,{
        path: '/dictionaryZhuangtai',
        name: '状态',
        component: dictionaryZhuangtai
    }


    ,{
        path: '/bingchuang',
        name: '病床',
        component: bingchuang
      }
    ,{
        path: '/bingchuangShiyong',
        name: '病床使用',
        component: bingchuangShiyong
      }
    ,{
        path: '/bingli',
        name: '病例',
        component: bingli
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/huanzhe',
        name: '患者',
        component: huanzhe
      }
    ,{
        path: '/kaifang',
        name: '开方',
        component: kaifang
      }
    ,{
        path: '/yaopin',
        name: '药品',
        component: yaopin
      }
    ,{
        path: '/yihurenyuan',
        name: '医护人员',
        component: yihurenyuan
      }
    ,{
        path: '/yisheng',
        name: '医生',
        component: yisheng
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
