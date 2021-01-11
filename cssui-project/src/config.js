import router from "./router";
function loginHandle(path){
  $css.alert('请登录！',function(){
    if(path){
      location.href=path;
    } else{
      router.push("/login");
    }
  });
}
export const http = {
  axiosOption:{
    method: 'post',
    baseURL: 'http://localhost:8089/examplebase/',
    timeout: 2000,
    withCredentials: true,
	// `validateStatus` 定义对于给定的HTTP 响应状态码是 resolve 或 reject  promise 。如果 `validateStatus` 返回 `true` (或者设置为 `null` 或 `undefined`)，promise 将被 resolve; 否则，promise 将被 rejecte
	validateStatus: function (status) {
	  return status >= 200 && status < 300; // default
	},
  },
   errorHandle:function(error){
      var status=error.response.status;
         if(status&&status===401){
           loginHandle(error.response.data.detail);
         }else{
           return Promise.reject(error);
         }
    },
  // openMock : true,
  openMock : false,
}
export const app = {
  sysName:"应用开发平台",
  sysId:"9999",
  openFuncode:false
}
