var mock = require('mockjs')
import Cookies from "js-cookie";
/* 
 * 系统登录模块
 */

// 登录
export const login=(data)=> {
    return {
        url: 'rest/suser/login',
        method: 'post',
        data:data,
        openMock:false, 
        mock:function(){
			Cookies.set('cssSessionId','48c19d1d6d474896b9119e19d4c4e312');
            return {
                uuid:"48c19d1d6d474896b9119e19d4c4e312",
                realName:mock.Random.cname()    
            }  
        }
    }
}

// 登出
export const logout = () => {
    return {
        url: '/rest/suser/quit',
        method: 'get',
        openMock:false,
        mock:function(){
            return ""
        }
    }
}

// 单点ticket验证
export const ssoTicket = (data) => {
    return {
        url: '/rest/suser/getUserByCssSsoTicket',
        params:data,
        method: 'get',
		mock:function(){
			Cookies.set('cssSessionId','48c19d1d6d474896b9119e19d4c4e312');
		    return {
		        uuid:"48c19d1d6d474896b9119e19d4c4e312",
		        realName:mock.Random.cname()    
		    }  
		}
		
    }
}
