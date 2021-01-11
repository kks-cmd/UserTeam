<template>
    <form v-list="{url:'/rest/sUser/dirSUser',dict:[]}" method="post">
		<css-content>
			<template v-slot:header>
				<div class="input-group input-group-sm">
					<div class="table-search">
						<ul>
									<!-- <li>
											<css-input :className="'input-medium '"
											 v-model="data.realName" id="item.realName"
											 name="item.realName" :maxlength="50" placeholder="请输入真实姓名">
											</css-input>
									</li> -->
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.loginName" id="item.loginName"
											 name="item.loginName" :maxlength="50" placeholder="请输入登录名">
											</css-input>
									</li>
									<!-- <li>
											<css-input :className="'input-medium '"
											 v-model="data.password" id="item.password"
											 name="item.password" :maxlength="50" placeholder="请输入密码">
											</css-input>
									</li> 
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.sex" id="item.sex"
											 name="item.sex" :maxlength="50" placeholder="请输入性别">
											</css-input>
									</li>-->
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.mobile" id="item.mobile"
											 name="item.mobile" :maxlength="50" placeholder="请输入手机号">
											</css-input>
									</li>
									<!-- <li>
											<css-input :className="'input-medium '"
											 v-model="data.mail" id="item.mail"
											 name="item.mail" :maxlength="50" placeholder="请输入邮箱">
											</css-input>
									</li> 
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.userType" id="item.userType"
											 name="item.userType" :maxlength="50" placeholder="请输入用户类型">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.deleteFlag" id="item.deleteFlag"
											 name="item.deleteFlag" :maxlength="50" placeholder="请输入删除标记">
											</css-input>
									</li> -->
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.openFlag" id="item.openFlag"
											 name="item.openFlag" :maxlength="50" placeholder="请输入开启状态">
											</css-input>
									</li>
									<!-- <li>
											<css-input :className="'input-medium '"
											 v-model="data.createTime" id="item.createTime"
											 name="item.createTime" :maxlength="50" placeholder="请输入创建时间">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.updateTime" id="item.updateTime"
											 name="item.updateTime" :maxlength="50" placeholder="请输入修改日期">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.remark" id="item.remark"
											 name="item.remark" :maxlength="50" placeholder="请输入备注">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.lastLoginTime" id="item.lastLoginTime"
											 name="item.lastLoginTime" :maxlength="50" placeholder="请输入上次登录时间">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.totalLoginCount" id="item.totalLoginCount"
											 name="item.totalLoginCount" :maxlength="50" placeholder="请输入总登录次数">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.failedLoginCount" id="item.failedLoginCount"
											 name="item.failedLoginCount" :maxlength="50" placeholder="请输入登录失败次数">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.orgid" id="item.orgid"
											 name="item.orgid" :maxlength="50" placeholder="请输入所在机构">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.editPwdTime" id="item.editPwdTime"
											 name="item.editPwdTime" :maxlength="50" placeholder="请输入修改密码时间">
											</css-input>
									</li> -->
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.activeStatus" id="item.activeStatus"
											 name="item.activeStatus" :maxlength="50" placeholder="请输入激活状态">
											</css-input>
									</li>
									<!-- <li>
											<css-input :className="'input-medium '"
											 v-model="data.activeDeadLine" id="item.activeDeadLine"
											 name="item.activeDeadLine" :maxlength="50" placeholder="请输入激活截止时间">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.provinceId" id="item.provinceId"
											 name="item.provinceId" :maxlength="50" placeholder="请输入省份ID">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.cityId" id="item.cityId"
											 name="item.cityId" :maxlength="50" placeholder="请输入城市ID">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.pcStatus" id="item.pcStatus"
											 name="item.pcStatus" :maxlength="50" placeholder="请输入PC制证状态">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.appStatus" id="item.appStatus"
											 name="item.appStatus" :maxlength="50" placeholder="请输入移动端制证状态">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.pwdExprityTime" id="item.pwdExprityTime"
											 name="item.pwdExprityTime" :maxlength="50" placeholder="请输入密码失效分钟数">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.failLockTime" id="item.failLockTime"
											 name="item.failLockTime" :maxlength="50" placeholder="请输入账号锁定时间">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.sortNo" id="item.sortNo"
											 name="item.sortNo" :maxlength="50" placeholder="请输入排序号">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.creatorId" id="item.creatorId"
											 name="item.creatorId" :maxlength="50" placeholder="请输入创建人ID">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.updateUserId" id="item.updateUserId"
											 name="item.updateUserId" :maxlength="50" placeholder="请输入修改人员ID">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.countyId" id="item.countyId"
											 name="item.countyId" :maxlength="50" placeholder="请输入县ID">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.salt" id="item.salt"
											 name="item.salt" :maxlength="50" placeholder="请输入盐值">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.sysId" id="item.sysId"
											 name="item.sysId" :maxlength="50" placeholder="请输入sysId">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.oldSysId" id="item.oldSysId"
											 name="item.oldSysId" :maxlength="50" placeholder="请输入oldSysId">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.oldUserId" id="item.oldUserId"
											 name="item.oldUserId" :maxlength="50" placeholder="请输入oldUserId">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.certKey" id="item.certKey"
											 name="item.certKey" :maxlength="50" placeholder="请输入政务人员账号key">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.staffOrg" id="item.staffOrg"
											 name="item.staffOrg" :maxlength="50" placeholder="请输入组织机构key">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.staffRegion" id="item.staffRegion"
											 name="item.staffRegion" :maxlength="50" placeholder="请输入行政区划key">
											</css-input>
									</li> -->
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.certNo" id="item.certNo"
											 name="item.certNo" :maxlength="50" placeholder="请输入证件号">
											</css-input>
									</li>
									<!-- <li>
											<css-input :className="'input-medium '"
											 v-model="data.gbFlag" id="item.gbFlag"
											 name="item.gbFlag" :maxlength="50" placeholder="请输入是否登录国办 1是 2否">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.certType" id="item.certType"
											 name="item.certType" :maxlength="50" placeholder="请输入证件类型">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.gbPushFlag" id="item.gbPushFlag"
											 name="item.gbPushFlag" :maxlength="50" placeholder="请输入是否已经推送国办 1是 2否">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.isConfirm" id="item.isConfirm"
											 name="item.isConfirm" :maxlength="50" placeholder="请输入即时通讯字段（业务系统无需关注）">
											</css-input>
									</li> -->
							<li>
								<css-button v-funcode="'acl_sUser/dirSUser'" :type="'primary'" @click="query()" :size="'sm'" :icon="'fa-search'">查询</css-button>
							</li>
						</ul>
					</div>
				</div>
			</template>
			<template v-slot:body>
				<div class="controls" style="margin: 0px 0px 5px 0px; padding-top: 0px;">
					<div class="btn-group">
							<css-button v-funcode="'acl_sUser/addSUser'" v-target="{id:'addSUser',type:'cssDialog',url:'/rest/sUser/getSUser',
							 params:{uuid:null}, title:'添加用户',component:'GetSUser'}"
							 :type="'default'" :size="'sm'" :icon="'fa-plus'">添加</css-button>
						<css-button v-funcode="'acl_sUser/delSUser'" :type="'default'" :size="'sm'" :icon="'fa-trash-o'" @click="execBatch('/rest/sUser/delSUser')">注销</css-button>

						<!-- 添加功能按钮 -->
						<css-button v-funcode="'acl_sUser/delSUser'" :type="'default'" :size="'sm'" :icon="'fa-gear'" @click="execBatch('/rest/sUser/delSUser')">设置状态</css-button>
						<css-button v-funcode="'acl_sUser/delSUser'" :type="'default'" :size="'sm'" :icon="'fa-user'" @click="execBatch('/rest/sUser/delSUser')">导入</css-button>
						<css-button v-funcode="'acl_sUser/delSUser'" :type="'default'" :size="'sm'" :icon="'fa-download'" @click="execBatch('/rest/sUser/delSUser')">导出</css-button>

					</div>
				</div>
				<div class="table-responsive">
					<table class="table table-bordered table-striped table-hover">
						<thead>
							<tr>
								<th width="25px">
									<input type="checkbox" @click="checkAll()" :checked="result.allChecked" class="cleck-all" />
								</th>
								<th width="120px">操作</th>
										<th width="150px" @click="orderField('realName')" class="order">真实姓名</th>
										<th width="150px" @click="orderField('loginName')" class="order">登录名</th>
										<!-- <th width="150px" @click="orderField('password')" class="order">密码</th> -->
										<th width="150px" @click="orderField('sex')" class="order">性别</th>
										<th width="150px" @click="orderField('mobile')" class="order">手机号</th>
										<th width="150px" @click="orderField('mail')" class="order">邮箱</th>
										<th width="150px" @click="orderField('userType')" class="order">用户类型</th>
										<!-- <th width="150px" @click="orderField('deleteFlag')" class="order">删除标记</th> -->
										<th width="150px" @click="orderField('openFlag')" class="order">开启状态</th>
										<th width="150px" @click="orderField('createTime')" class="order">创建时间</th>
										<!-- <th width="150px" @click="orderField('updateTime')" class="order">修改日期</th> -->
										<th width="150px" @click="orderField('remark')" class="order">备注</th>
										<!-- <th width="150px" @click="orderField('lastLoginTime')" class="order">上次登录时间</th>
										<th width="150px" @click="orderField('totalLoginCount')" class="order">总登录次数</th>
										<th width="150px" @click="orderField('failedLoginCount')" class="order">登录失败次数</th> -->
										<th width="150px" @click="orderField('orgid')" class="order">所在机构</th>
										<!-- <th width="150px" @click="orderField('editPwdTime')" class="order">修改密码时间</th> -->
										<th width="150px" @click="orderField('activeStatus')" class="order">激活状态</th>
										<!-- <th width="150px" @click="orderField('activeDeadLine')" class="order">激活截止时间</th>
										<th width="150px" @click="orderField('provinceId')" class="order">省份ID</th>
										<th width="150px" @click="orderField('cityId')" class="order">城市ID</th> 
										<th width="150px" @click="orderField('pcStatus')" class="order">PC制证状态</th>
										<th width="150px" @click="orderField('appStatus')" class="order">移动端制证状态</th>
										<th width="150px" @click="orderField('pwdExprityTime')" class="order">密码失效分钟数</th>
										<th width="150px" @click="orderField('failLockTime')" class="order">账号锁定时间</th>
										<th width="150px" @click="orderField('sortNo')" class="order">排序号</th>
										<th width="150px" @click="orderField('creatorId')" class="order">创建人ID</th>
										<th width="150px" @click="orderField('updateUserId')" class="order">修改人员ID</th>
										<th width="150px" @click="orderField('countyId')" class="order">县ID</th>
										<th width="150px" @click="orderField('salt')" class="order">盐值</th>
										<th width="150px" @click="orderField('sysId')" class="order">sysId</th>
										<th width="150px" @click="orderField('oldSysId')" class="order">oldSysId</th>
										<th width="150px" @click="orderField('oldUserId')" class="order">oldUserId</th>
										<th width="150px" @click="orderField('certKey')" class="order">政务人员账号key</th>
										<th width="150px" @click="orderField('staffOrg')" class="order">组织机构key</th>
										<th width="150px" @click="orderField('staffRegion')" class="order">行政区划key</th> -->
										<th width="150px" @click="orderField('certNo')" class="order">证件号</th>
										<!-- <th width="150px" @click="orderField('gbFlag')" class="order">是否登录国办 1是 2否</th> -->
										<th width="150px" @click="orderField('certType')" class="order">证件类型</th>
										<!-- <th width="150px" @click="orderField('gbPushFlag')" class="order">是否已经推送国办 1是 2否</th>
										<th width="150px" @click="orderField('isConfirm')" class="order">即时通讯字段（业务系统无需关注）</th> -->
							</tr>
						</thead>
						<tbody>
							<tr v-for="data in result.datas">
								<td class="text-center">
									<input type="checkbox" :checked="data.checked" @click="checkSingle(data)" :value="data.uuid" />
								</td>
								<td class="text-center">
									<a title="修改用户" href="javascript:;" v-funcode="'acl_sUser/updSUser'"
									 v-target="{id:'updSUser',type:'cssDialog',url:'/rest/sUser/getSUser',
									 params:{uuid:data.uuid},title:'修改用户',component:'GetSUser'}">修改</a>
									<a title="删除用户" href="javascript:;" v-funcode="'acl_sUser/delSUser'"
									 @click="exec('/rest/sUser/delSUser',data.uuid)">  注销</a>
								</td>
													<td class="text-center">{{data.realName}}</td>
													<td class="text-center">{{data.loginName}}</td>
													<!-- <td class="text-center">{{data.password}}</td> -->
													<td class="text-center">{{data.sex}}</td>
													<td class="text-center">{{data.mobile}}</td>
													<td class="text-center">{{data.mail}}</td>
													<td class="text-center">{{data.userType}}</td>
													<!-- <td class="text-center">{{data.deleteFlag}}</td> -->
													<td class="text-center">{{data.openFlag}}</td>
													<td class="text-center">{{data.createTime}}</td>
													<!-- <td class="text-center">{{data.updateTime}}</td> -->
													<td class="text-center">{{data.remark}}</td>
													<!-- <td class="text-center">{{data.lastLoginTime}}</td>
													<td class="text-center">{{data.totalLoginCount}}</td>
													<td class="text-center">{{data.failedLoginCount}}</td> -->
													<td class="text-center">{{data.orgid}}</td>
													<!-- <td class="text-center">{{data.editPwdTime}}</td> -->
													<td class="text-center">{{data.activeStatus}}</td>
													<!-- <td class="text-center">{{data.activeDeadLine}}</td>
													<td class="text-center">{{data.provinceId}}</td>
													<td class="text-center">{{data.cityId}}</td>
													<td class="text-center">{{data.pcStatus}}</td>
													<td class="text-center">{{data.appStatus}}</td>
													<td class="text-center">{{data.pwdExprityTime}}</td>
													<td class="text-center">{{data.failLockTime}}</td>
													<td class="text-center">{{data.sortNo}}</td>
													<td class="text-center">{{data.creatorId}}</td>
													<td class="text-center">{{data.updateUserId}}</td>
													<td class="text-center">{{data.countyId}}</td>
													<td class="text-center">{{data.salt}}</td>
													<td class="text-center">{{data.sysId}}</td>
													<td class="text-center">{{data.oldSysId}}</td>
													<td class="text-center">{{data.oldUserId}}</td>
													<td class="text-center">{{data.certKey}}</td>
													<td class="text-center">{{data.staffOrg}}</td>
													<td class="text-center">{{data.staffRegion}}</td> -->
													<td class="text-center">{{data.certNo}}</td>
													<!-- <td class="text-center">{{data.gbFlag}}</td> -->
													<td class="text-center">{{data.certType}}</td>
													<!-- <td class="text-center">{{data.gbPushFlag}}</td>
													<td class="text-center">{{data.isConfirm}}</td> -->
							</tr>
						</tbody>
					</table>
					<css-pagination :page="result.page" @pageChange="query()"></css-pagination>
				</div>
			</template>
		</css-content>
	</form>
</template>
<script>
	export default {
		name: "dirSUser",
		props: {
			params: {}
		},
		data() {
			return {
			  data:{},
			  result: {	checkField: "uuid"}
			};
		},
		methods:{
			
			openImgDialog(obj) {
				var targetcomponent = {
					name: "cropimage",
					data: {
					   data: obj,
					   srcComponent: this
					}
				};
				this.$dialog.show(
					{ title: "图片剪裁", isFooter: false, isHeader: true },
					targetcomponent
				);
			},
		}
	};
</script>