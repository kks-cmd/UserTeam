var mock = require('mockjs')
import qs from 'qs'
/* 
 * 组织机构http请求模块
 */
// 添加
export const addSOrg = (data) => {
    return {
        url: '/rest/sOrg/addSOrg',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null
        }
    }
}
//修改
export const updSOrg = (data) => {
    return {
        url: '/rest/sOrg/updSOrg',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null;
        }
    }
}
// 删除
export const delSOrg = (data) => {
    return {
        url: '/rest/sOrg/delSOrg',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null;
        }
    }
}
// 分页查询
export const dirSOrg = (data) => {
    return {
        url: '/rest/sOrg/dirSOrg',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null;
        }
    }
}
//查看
export const getSOrg = (data) => {
    return {
        url: '/rest/sOrg/getSOrg',
        method: 'get',
        data:data,
        openMock:false,
        mock:function(params){ 
            return null;
        }
    }
}
//获取字典树
export const jsonSOrgTree = (data) => {
    return {
        url: '/rest/sOrg/jsonSOrgTree',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(){
            return null;
        }
    }
}
export const saveSOrgTree = (data) => {
    return {
        url: '/rest/sOrg/saveSOrgTree',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(){
            return null;
        }
    }
}


