var mock = require('mockjs')
import qs from 'qs'
/* 
 * 机构部门表http请求模块
 */
// 添加
export const addSOrgDept = (data) => {
    return {
        url: '/rest/sOrgDept/addSOrgDept',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null
        }
    }
}
//修改
export const updSOrgDept = (data) => {
    return {
        url: '/rest/sOrgDept/updSOrgDept',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null;
        }
    }
}
// 删除
export const delSOrgDept = (data) => {
    return {
        url: '/rest/sOrgDept/delSOrgDept',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null;
        }
    }
}
// 分页查询
export const dirSOrgDept = (data) => {
    return {
        url: '/rest/sOrgDept/dirSOrgDept',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(params){
            return null;
        }
    }
}
//查看
export const getSOrgDept = (data) => {
    return {
        url: '/rest/sOrgDept/getSOrgDept',
        method: 'get',
        data:data,
        openMock:false,
        mock:function(params){ 
            return null;
        }
    }
}
//获取字典树
export const jsonSOrgDeptTree = (data) => {
    return {
        url: '/rest/sOrgDept/jsonSOrgDeptTree',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(){
            return null;
        }
    }
}
export const saveSOrgDeptTree = (data) => {
    return {
        url: '/rest/sOrgDept/saveSOrgDeptTree',
        method: 'post',
        data:data,
        openMock:false,
        mock:function(){
            return null;
        }
    }
}


