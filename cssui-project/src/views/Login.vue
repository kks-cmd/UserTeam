<template>
  <div class="login-wrapper">
    <div class="login-content">
      <div class="login-middle">
        <div class="middle-body">
          <form ref="loginForm" class="form-validate">
            <br />
            <br />
            <div class="btn" style="text-align: left;">
              <div class="title">应用开发平台</div>
              <div class="wel_txt">请登录</div>
              <p class="account">
                <span class="type"></span>
                <input
                  type="text"
                  class="required csspwd"
                  title="账号必填！"
                  name="loginName"
                  id="loginName"
                  v-model="loginForm.account"
                />
              </p>
              <p class="password">
                <span class="type"></span>
                <input
                  type="password"
                  class="required csspwd"
                  title="密码必填！"
                  name="password"
                  id="password"
                  v-model="loginForm.password"
                />
              </p>
              <div class="btn" style="text-align: left;">
                <a href="#" class="submit" @click="login()">登 录</a>
                <a herf="#" class="reset" @click="loginReset()">取 消</a>
              </div>
            </div>
          </form>
        </div>
      </div>
      <div class="login-left">
        <div class="left-body"></div>
      </div>
      <div class="clear-fix"></div>
    </div>
    <div class="help"></div>
  </div>
</template>
<script>
import {app} from "@/config";
export default {
  data() {
    return {
      submitFlag: false,
      loading: false,
      loginForm: {
        account: "sysadmin",
        password: "admin111111",
        captcha: ""
      },
      fieldRules: {
        account: [{ required: true, message: "请输入账号", trigger: "blur" }],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }]
      },
      checked: true
    };
  },
  methods: {
    
    login() {
      if (this.submitFlag == true) alert("登录中，请稍候...");
        let userInfo = {//请求参数
            loginName: this.loginForm.account,
            password: this.$md5(this.loginForm.password)
        };
      this.submitFlag = true;
      this.$http//vue实例挂载的$http，http请求api对象
		    .login//api属性对象，src下http下api.js中注册的业务请求对象名称
        .login(userInfo)//api属性对象方法,src下http下moudules中业务请求文件中的api方法名称
        .then(res => {//http请求成功
            sessionStorage.setItem("userId",res.uuid);// 保存用户到本地会话
		    sessionStorage.setItem("userName",res.realName);// 保存用户到本地会话
            this.$router.push("/"); // 登录成功，跳转到主页 
        })
        .catch(res => {//http请求失败
            this.submitFlag = false;
            this.$dialog.alert(res.response.data.detail);
        });
    },
    loginReset() {}
  }
};
</script>
<style>
@import "../../public/static/cssui/css/login.css";
</style>
