//加载用户权限
export const loadPermissions = (params) => {
       return {
          url: '/rest/auth/loadAuth',
          method: 'get',
          params,
          openMock:true,
          mock:['acl_newsTypes/dirNewsTypes','acl_newsTypes/addNewsTypes','acl_newsTypes/delNewsTypes','acl_newsTypes/updNewsTypes','acl_sDict/dirSDict','acl_sDict/addSDict','acl_sDict/delSDict','acl_sDict/updSDict','acl_resume/dirResume','acl_resume/addResume','acl_resume/delResume','acl_resume/updResume','acl_job/dirJob','acl_job/addJob','acl_job/delJob','acl_job/updJob','acl_student/dirStudent','acl_student/addStudent','acl_student/updStudent','acl_student/delStudent','acl_student/detailStudent','acl_family/dirFamily','acl_family/addFamily','acl_family/delFamily','acl_family/updFamily',"CssChart","student","cssupload","diremployee","formwidget","employee","list","DelEmployee","gcode","datetime","EmployeeForm","EmployeeTable","Button","AddEmployee","CssWidgets","UpdEmployee","BbsType",'acl_employee/dirEmployee','acl_employee/addEmployee','acl_employee/delEmployee','acl_employee/updEmployee','acl_employee/detailEmployee'],
          
       }
    }