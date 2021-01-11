var mock = require('mockjs')
import qs from 'qs'
/* 
 * 用户角色表http请求模块
 */
// 添加
export const addSUserRole = (data) => {
    return {
        url: '/rest/sUserRole/addSUserRole',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null
        }
    }
}
//修改
export const updSUserRole = (data) => {
    return {
        url: '/rest/sUserRole/updSUserRole',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null;
        }
    }
}
// 删除
export const delSUserRole = (data) => {
    return {
        url: '/rest/sUserRole/delSUserRole',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null;
        }
    }
}
// 分页查询
export const dirSUserRole = (data) => {
    return {
        url: '/rest/sUserRole/dirSUserRole',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null;
        }
    }
}
//查看
export const getSUserRole = (data) => {
    return {
        url: '/rest/sUserRole/getSUserRole',
        method: 'get',
        data:data,
        openMock:false,
        mock:function(params){ 
            return null;
        }
    }
}


