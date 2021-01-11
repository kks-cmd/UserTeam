var mock = require('mockjs')
/* 
 * 基础字典服务
 */

export const load = (data) => {
    return {
        url: '/rest/sdict/loadDict',
        method: 'get',
        params:data,
        openMock:true,
        mock:function(){
            return {
				"d_table_type":[{"uuid":"a865a8208ae828ad06b9bb034557bad3","name":"非标准字典","parentId":"b4b8f68164aa3eab4f73ce911156c596","code":"2","tableName":"d_table_type","remark":"","tableType":"2","updateTime":"Oct 31, 2019 9:55:36 AM"},{"uuid":"acca7fc55ab2b07056eb5abaeffd9b37","name":"标准字典","parentId":"b4b8f68164aa3eab4f73ce911156c596","code":"1","tableName":"d_table_type","remark":"","tableType":"2","updateTime":"Oct 31, 2019 9:55:26 AM"}],              
                "d_usertype":[{"uuid":"8e991d4c91a098429f62e3ae37d9c804","name":"普通用户","parentId":"cf624c60e42ec94b709cc08372116fc1","code":"1","tableName":"d_usertype","remark":"","orderNum":1,"tableType":"2"},{"uuid":"a2fb017251044f815fb490a192549ccc","name":"系统管理员","parentId":"cf624c60e42ec94b709cc08372116fc1","code":"2","tableName":"d_usertype","remark":"","orderNum":2,"tableType":"2"},{"uuid":"f486089bbcfddae415169561ce4b388e","name":"安全保密员","parentId":"cf624c60e42ec94b709cc08372116fc1","code":"3","tableName":"d_usertype","remark":"","orderNum":3,"tableType":"2"},{"uuid":"9a6dad32787a43a5ad4597461bd11ba5","name":"安全审计员","parentId":"cf624c60e42ec94b709cc08372116fc1","code":"4","tableName":"d_usertype","remark":"","orderNum":4,"tableType":"2"},{"uuid":"9fbe3619ffe43adaf2cf86eca66fd953","name":"单位管理员","parentId":"cf624c60e42ec94b709cc08372116fc1","code":"5","tableName":"d_usertype","remark":"","orderNum":5,"tableType":"2"},{"uuid":"c82cbca90872eb3621f327accec6cec2","name":"分系统安全保密员","parentId":"cf624c60e42ec94b709cc08372116fc1","code":"6","tableName":"d_usertype","remark":"","orderNum":6,"tableType":"2"},{"uuid":"a78d9033fcd06019e6629a3a9b41cf5f","name":"个人用户","parentId":"cf624c60e42ec94b709cc08372116fc1","code":"11","tableName":"d_usertype","remark":"","orderNum":7,"tableType":"2"},{"uuid":"0c6487c6960b6a38660fb1e2c4e76ef9","name":"企业用户","parentId":"cf624c60e42ec94b709cc08372116fc1","code":"21","tableName":"d_usertype","remark":"","orderNum":8,"tableType":"2"},{"uuid":"e823105738d9c7f977d6610a6e000f95","name":"内门户用户","parentId":"cf624c60e42ec94b709cc08372116fc1","code":"31","tableName":"d_usertype","remark":"","orderNum":9,"tableType":"2"},{"uuid":"abc7a8fd727c463afdf2ff1856484b19","name":"外门户用户","parentId":"cf624c60e42ec94b709cc08372116fc1","code":"32","tableName":"d_usertype","remark":"","orderNum":10,"tableType":"2"},{"uuid":"1cfdc2f1fc7c6f0a3695688f9cc68f76","name":"企业子用户","parentId":"cf624c60e42ec94b709cc08372116fc1","code":"22","tableName":"d_usertype","remark":"","orderNum":11,"tableType":"2"}],
                "d_sex":[{"uuid":"8707ef9b62ba48b93c08b6956d080b76","name":"男","parentId":"81b3cf045c0b7a503108f5c694116366","code":"1","tableName":"d_sex","remark":"","orderNum":1,"tableType":"2"},{"uuid":"c23846e73682462a5bb5b75d271629bd","name":"女","parentId":"81b3cf045c0b7a503108f5c694116366","code":"2","tableName":"d_sex","remark":"","orderNum":2,"tableType":"2"}],
                "d_root@d_viewType":[{"uuid":"4115b369a21b625bcbd82074d447db47","name":"登录用户","parentId":"c23cf7bef5777075960b8c2592eac064","code":"1","tableName":"d_viewType","remark":"<font color='blue'>登录用户</font>","orderNum":1,"tableType":"2"},{"uuid":"896b0a19fd9bfd3369b24cad18a7545d","name":"管理员","parentId":"c23cf7bef5777075960b8c2592eac064","code":"2","tableName":"d_viewType","remark":"<font color='red'>管理用户</font>","orderNum":2,"tableType":"2"}],
                "d_viewType":[{"uuid":"4115b369a21b625bcbd82074d447db48","name":"登录用户","parentId":"c23cf7bef5777075960b8c2592eac064","code":"1","tableName":"d_viewType","remark":"<font color='blue'>登录用户</font>","orderNum":1,"tableType":"2"},{"uuid":"896b0a19fd9bfd3369b24cad18a7545d","name":"管理员","parentId":"c23cf7bef5777075960b8c2592eac064","code":"2","tableName":"d_viewType","remark":"<font color='red'>管理用户</font>","orderNum":2,"tableType":"2"}],
                "d_root@d_truefalse":[{"uuid":"8707ef9b62ba48b93c08b6956d080b92","name":"是","parentId":"51f288f442c7a1dc40ee0454bbb3e8ea","code":"1","tableName":"d_truefalse","remark":"是","orderNum":1,"tableType":"2"},{"uuid":"c23846e73682462a08b5b75d271629bd","name":"否","parentId":"51f288f442c7a1dc40ee0454bbb3e8ea","code":"2","tableName":"d_truefalse","remark":"否","orderNum":2,"tableType":"2"}],
                "d_para_g@S_IconColor":[
                    {"uuid":"4115b369a21b625bcbd82074d447db10","name":"red","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"red","tableName":"S_IconColor","remark":"<span class='text-red'>■■■■■■</span>","orderNum":1,"tableType":"2"},
                    {"uuid":"4115b369a21b625bcbd82074d447db11","name":"yellow","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"yellow","tableName":"S_IconColor","remark":"<span class='text-yellow'>■■■■■■</span>","orderNum":2,"tableType":"2"},
                    {"uuid":"4115b369a21b625bcbd82074d447db12","name":"aqua","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"aqua","tableName":"S_IconColor","remark":"<span class='text-aqua'>■■■■■■</span>","orderNum":3,"tableType":"2"},
                    {"uuid":"4115b369a21b625bcbd82074d447db13","name":"blue","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"blue	","tableName":"S_IconColor","remark":"<span class='text-blue'>■■■■■■</span>","orderNum":4,"tableType":"2"},
                    {"uuid":"4115b369a21b625bcbd82074d447db14","name":"black","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"black","tableName":"S_IconColor","remark":"<span class='text-black'>■■■■■■</span>","orderNum":5,"tableType":"2"},
                    {"uuid":"4115b369a21b625bcbd82074d447db15","name":"light-blue","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"light-blue","tableName":"S_IconColor","remark":"<span class='text-light-blue'>■■■■■■</span>","orderNum":6,"tableType":"2"},
                    {"uuid":"4115b369a21b625bcbd82074d447db16","name":"green","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"green","tableName":"S_IconColor","remark":"<span class='text-green'>■■■■■■</span>","orderNum":7,"tableType":"2"},
                    {"uuid":"4115b369a21b625bcbd82074d447db17","name":"gray","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"gray","tableName":"S_IconColor","remark":"<span class='text-gray'>■■■■■■</span>","orderNum":8,"tableType":"2"},
                    {"uuid":"4115b369a21b625bcbd82074d447db18","name":"navy","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"navy","tableName":"S_IconColor","remark":"<span class='text-navy'>■■■■■■</span>","orderNum":9,"tableType":"2"},
                    {"uuid":"4115b369a21b625bcbd82074d447db19","name":"teal","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"teal","tableName":"S_IconColor","remark":"<span class='text-teal'>■■■■■■</span>","orderNum":10,"tableType":"2"},
                    {"uuid":"4115b369a21b625bcbd82074d447db21","name":"olive","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"olive","tableName":"S_IconColor","remark":"<span class='text-olive'>■■■■■■</span>","orderNum":11,"tableType":"2"},
                    {"uuid":"4115b369a21b625bcbd82074d447db12","name":"lime","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"lime","tableName":"S_IconColor","remark":"<span class='text-lime'>■■■■■■</span>","orderNum":12,"tableType":"2"},
                    {"uuid":"4115b369a21b625bcbd82074d447db14","name":"orange","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"orange","tableName":"S_IconColor","remark":"<span class='text-orange'>■■■■■■</span>","orderNum":13,"tableType":"2"},
                    {"uuid":"4115b369a21b625bcbd82074d447db14","name":"fuchsia","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"fuchsia","tableName":"S_IconColor","remark":"<span class='text-fuchsia'>■■■■■■</span>","orderNum":14,"tableType":"2"},
                    {"uuid":"4115b369a21b625bcbd82074d447db14","name":"purple","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"purple","tableName":"S_IconColor","remark":"<span class='text-purple'>■■■■■■</span>","orderNum":15,"tableType":"2"},
                    {"uuid":"4115b369a21b625bcbd82074d447db14","name":"maroon","parentId":"4b587eb16259ce4aafcfb50246a7fe54","code":"maroon","tableName":"S_IconColor","remark":"<span class='text-maroon'>■■■■■■</span>","orderNum":16,"tableType":"2"},
                ],
                "d_para_g@S_ColorStyle":[{"uuid":"4115b369a21b625bcbd82074d447d110","name":"文字着色","parentId":"8e6dcfdd46d73a8c83d448cb2ee98d87","code":"text","tableName":"S_ColorStyle","remark":"","orderNum":1,"tableType":"2"},{"uuid":"4115b369a21b625bcbd82074d447d111","name":"背景着色","parentId":"8e6dcfdd46d73a8c83d448cb2ee98d87","code":"bg","tableName":"S_ColorStyle","remark":"","orderNum":2,"tableType":"2"}]
          }
        }
    }
}


