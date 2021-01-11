import Vue from 'vue'
import Router from 'vue-router'
import {
	$store
} from '../store'
import Login from '@/views/Login'
import Index from '@/views/Index.vue'
import Cookies from "js-cookie";
Vue.use(Router)
var isLogin = () => {
	if (sessionStorage.getItem("userId") && sessionStorage.getItem("userName")) {
		return true
	} else {
		return false
	}
}
var loadUser = (sucess) => {
	var vue = new Vue();
	vue.$http.user
		.getUserByCookie()
		.then(res => {
			if(res){
				$store().commit("setUserInfo", res); // 保存当前登录用户信息
				sessionStorage.setItem("userId", res.uuid);
				sessionStorage.setItem("userName", res.realName);
				if (sucess) {
					sucess();
				}
			}
		}).catch(error => {
			console.log(error);
		});
}
var loginAuth = (ticket, sucess) => {
	var vue = new Vue();
	vue.$http.login
		.ssoTicket({
			cssSsoTicket: ticket
		})
		.then(res => {
			if (sucess) {
				sucess();
			}
		}).catch(res => {
			alert(res.response.data.detail);
		});
}
const router = new Router({
	routes: [{
			path: '/',
			name: '首页',
			component: Index,
			meta: {
				requireAuth: true
			}
		},
		{
			path: '/login',
			name: '登录',
			component: Login
		},
	]

})
router.beforeEach((to, from, next) => {
	if (to.meta.requireAuth) { //判断该路由是否需要登录权限
		if (isLogin()) {
			next();
		} else {
			if (window.location.href.indexOf('cssSsoTicket') >= 0) { // 如果cssSsoTicket存在
				//如果url中包含cssSsoTicket   split？分割成数组，取第二个
				var cssSsoTicket = window.location.search.split("cssSsoTicket")[1].substring(1);
				loginAuth(cssSsoTicket, function() {
					loadUser(function() {
						next();
					})
				});
			} else {
				loadUser(function() {
					next();
				})
			}
		}
	} else {
		next();
	}
	if (to.meta.title) {
		document.title = to.meta.title;
	}
});
export default router
