var mock = require('mockjs')
import qs from 'qs'
/* 
 * 用户http请求模块
 */
// 添加
export const addSUser = (data) => {
    return {
        url: '/rest/sUser/addSUser',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null
        }
    }
}
//修改
export const updSUser = (data) => {
    return {
        url: '/rest/sUser/updSUser',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null;
        }
    }
}
// 删除
export const delSUser = (data) => {
    return {
        url: '/rest/sUser/delSUser',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null;
        }
    }
}
// 分页查询
export const dirSUser = (data) => {
    return {
        url: '/rest/sUser/dirSUser',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null;
        }
    }
}
//查看
export const getSUser = (data) => {
    return {
        url: '/rest/sUser/getSUser',
        method: 'get',
        data:data,
        openMock:false,
        mock:function(params){ 
            return null;
        }
    }
}


