var mock = require('mockjs')
import Cookies from "js-cookie";
import router from "@/router";
/* 
 * 用户信息
 */
// getUserByCookie
export const getUserByCookie = (data) => {
    return {
        url: '/rest/suser/getUserByCookie',
        params:data,
        method: 'get',
        openMock:true,
        mock:function(){
			if(Cookies.get('cssSessionId')){
			    return {
			        uuid:"48c19d1d6d474896b9119e19d4c4e312",
			        realName:mock.Random.cname(),
			    }  
			}else{
				router.push("/login");
			}
        }
    }
}