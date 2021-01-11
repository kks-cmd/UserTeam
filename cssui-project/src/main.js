import 'babel-polyfill'
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import cssui from 'css-ui'
import api from '@/http/api.js'
import {http,app} from './config.js'
import md5 from 'js-md5'
Vue.config.productionTip = false; //是阻止显示生产模式的消息
Vue.use({
  install: function (Vue) {
    Vue.component('Home', resolve => require([`@/views/Home/Home.vue`], resolve));
    Vue.component('DirTheme', resolve => require([`@/views/CssThemeDemo/DirTheme`], resolve));
    Vue.component('DirThemeDialog', resolve => require([`@/views/CssThemeDemo/DirThemeDialog`], resolve));

    //suserrole业务组件注册配置项
    Vue.component('DirSUserRole', resolve => require([`@/views/Suserrole/dirsuserrole.vue`], resolve));
    Vue.component('GetSUserRole', resolve => require([`@/views/Suserrole/getsuserrole.vue`], resolve));

    //suser业务组件注册配置项
    Vue.component('DirSUser', resolve => require([`@/views/Suser/dirsuser.vue`], resolve));
    Vue.component('GetSUser', resolve => require([`@/views/Suser/getsuser.vue`], resolve));

    //sorg业务组件注册配置项
    Vue.component('DirSOrg', resolve => require([`@/views/sorg/dirsorg.vue`], resolve));
    Vue.component('GetSOrg', resolve => require([`@/views/sorg/getsorg.vue`], resolve));
    Vue.component('DirSOrgMain', resolve => require([`@/views/sorg/dirsorgmain.vue`], resolve));
    

    //sorgdept业务组件注册配置项
    Vue.component('DirSOrgDept', resolve => require([`@/views/SorgDept/dirsorgdept.vue`], resolve));
    Vue.component('GetSOrgDept', resolve => require([`@/views/SorgDept/getsorgdept.vue`], resolve));
    Vue.component('DirSOrgDeptMain', resolve => require([`@/views/SorgDept/dirsorgdeptmain.vue`], resolve));


}
})
Vue.prototype.$md5 = md5 
Vue.use(cssui,{config:{http:http,app:app},api:api});
//初始化grid字典
window.Slw.Dict=new Vue().dict;
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
