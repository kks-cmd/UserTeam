		<template>
			<form class="form-horizontal form-validate" v-form="{url:'/rest/sUser/getSUser',method:'get'}">
				<css-input name="uuid" id="uuid" type="hidden"
				 v-model="data.uuid"></css-input>
				<div class="content" style="min-width: 500px;">
					<table class="table table-nobordered editTable form-group-sm">
						<tbody>
							<tr class="firstRow">
								<td colspan="1" class="col-md-1"></td>
								<td colspan="1" class="col-md-1"></td>
								<td colspan="1" class="col-md-1"></td>
								<td colspan="1" class="col-md-1"></td>
								<td colspan="1" class="col-md-1"></td>
								<td colspan="1" class="col-md-1"></td>
								<td colspan="1" class="col-md-1"></td>
								<td colspan="1" class="col-md-1"></td>
								<td colspan="1" class="col-md-1"></td>
								<td colspan="1" class="col-md-1"></td>
								<td colspan="1" class="col-md-1"></td>
								<!-- <td colspan="1" class="col-md-1"></td> -->
							</tr>
															<tr>
														<td colspan="3" class="tdLable">
															真实姓名
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.realName"   :className="'form-control '"  :maxlength="500"  placeholder="请输入真实姓名"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															登录名
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.loginName"   :className="'form-control '"  :maxlength="500"  placeholder="请输入登录名"></css-input>
															</td>
																	</tr>
															<tr>
														<!-- <td colspan="3" class="tdLable">
															密码
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.password"   :className="'form-control '"  :maxlength="500"  placeholder="请输入密码"></css-input>
															</td>
																	</tr>
															<tr> -->
														<td colspan="3" class="tdLable">
															性别
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.sex"   :className="'form-control '"  :maxlength="500"  placeholder="请输入性别"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															手机号
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.mobile"   :className="'form-control '"  :maxlength="500"  placeholder="请输入手机号"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															邮箱
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.mail"   :className="'form-control '"  :maxlength="500"  placeholder="请输入邮箱"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															用户类型
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.userType"   :className="'form-control '"  :maxlength="500"  placeholder="请输入用户类型"></css-input>
															</td>
																	</tr>
															<tr>
														<!-- <td colspan="3" class="tdLable">
															删除标记
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.deleteFlag"   :className="'form-control '"  :maxlength="500"  placeholder="请输入删除标记"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															开启状态
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.openFlag"   :className="'form-control '"  :maxlength="500"  placeholder="请输入开启状态"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															创建时间
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.createTime"   :className="'form-control '"  :maxlength="500"  placeholder="请输入创建时间"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															修改日期
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.updateTime"   :className="'form-control '"  :maxlength="500"  placeholder="请输入修改日期"></css-input>
															</td>
																	</tr>
															<tr> 
														<td colspan="3" class="tdLable">
															备注
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.remark"   :className="'form-control '"  :maxlength="500"  placeholder="请输入备注"></css-input>
															</td>
																	</tr>
															<tr>-->
														<!-- <td colspan="3" class="tdLable">
															上次登录时间
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.lastLoginTime"   :className="'form-control '"  :maxlength="500"  placeholder="请输入上次登录时间"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															总登录次数
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.totalLoginCount"   :className="'form-control '"  :maxlength="500"  placeholder="请输入总登录次数"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															登录失败次数
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.failedLoginCount"   :className="'form-control '"  :maxlength="500"  placeholder="请输入登录失败次数"></css-input>
															</td>
																	</tr>
															<tr> -->
														<td colspan="3" class="tdLable">
															所在机构
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.orgid"   :className="'form-control '"  :maxlength="500"  placeholder="请输入所在机构"></css-input>
															</td>
																	</tr>
															<tr>
														<!-- <td colspan="3" class="tdLable">
															修改密码时间
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.editPwdTime"   :className="'form-control '"  :maxlength="500"  placeholder="请输入修改密码时间"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															激活状态
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.activeStatus"   :className="'form-control '"  :maxlength="500"  placeholder="请输入激活状态"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															激活截止时间
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.activeDeadLine"   :className="'form-control '"  :maxlength="500"  placeholder="请输入激活截止时间"></css-input>
															</td>
																	</tr>
															<tr> -->
														<td colspan="3" class="tdLable">
															省份ID
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.provinceId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入省份ID"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															城市ID
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.cityId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入城市ID"></css-input>
															</td>
																	</tr>
															<tr>
														<!-- <td colspan="3" class="tdLable">
															PC制证状态
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.pcStatus"   :className="'form-control '"  :maxlength="500"  placeholder="请输入PC制证状态"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															移动端制证状态
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.appStatus"   :className="'form-control '"  :maxlength="500"  placeholder="请输入移动端制证状态"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															密码失效分钟数
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.pwdExprityTime"   :className="'form-control '"  :maxlength="500"  placeholder="请输入密码失效分钟数"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															账号锁定时间
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.failLockTime"   :className="'form-control '"  :maxlength="500"  placeholder="请输入账号锁定时间"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															排序号
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.sortNo"   :className="'form-control '"  :maxlength="500"  placeholder="请输入排序号"></css-input>
															</td>
																	</tr>
															<tr> -->
														<td colspan="3" class="tdLable">
															创建人ID
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.creatorId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入创建人ID"></css-input>
															</td>
																	</tr>
															<tr>
														<!-- <td colspan="3" class="tdLable">
															修改人员ID
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.updateUserId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入修改人员ID"></css-input>
															</td>
																	</tr>
															<tr> -->
														<!-- <td colspan="3" class="tdLable">
															县ID
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.countyId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入县ID"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															盐值
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.salt"   :className="'form-control '"  :maxlength="500"  placeholder="请输入盐值"></css-input>
															</td>
																	</tr>
															<tr> -->
														<!-- <td colspan="3" class="tdLable">
															sysId
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.sysId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入sysId"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															oldSysId
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.oldSysId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入oldSysId"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															oldUserId
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.oldUserId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入oldUserId"></css-input>
															</td>
																	</tr>
															<tr> -->
														<!-- <td colspan="3" class="tdLable">
															政务人员账号key
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.certKey"   :className="'form-control '"  :maxlength="500"  placeholder="请输入政务人员账号key"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															组织机构key
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.staffOrg"   :className="'form-control '"  :maxlength="500"  placeholder="请输入组织机构key"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															行政区划key
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.staffRegion"   :className="'form-control '"  :maxlength="500"  placeholder="请输入行政区划key"></css-input>
															</td>
																	</tr>
															<tr> -->
														<td colspan="3" class="tdLable">
															证件号
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.certNo"   :className="'form-control '"  :maxlength="500"  placeholder="请输入证件号"></css-input>
															</td>
																	</tr>
															<tr>
														<!-- <td colspan="3" class="tdLable">
															是否登录国办 1是 2否
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.gbFlag"   :className="'form-control '"  :maxlength="500"  placeholder="请输入是否登录国办 1是 2否"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															证件类型
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.certType"   :className="'form-control '"  :maxlength="500"  placeholder="请输入证件类型"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															是否已经推送国办 1是 2否
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.gbPushFlag"   :className="'form-control '"  :maxlength="500"  placeholder="请输入是否已经推送国办 1是 2否"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															即时通讯字段（业务系统无需关注）
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.isConfirm"   :className="'form-control '"  :maxlength="500"  placeholder="请输入即时通讯字段（业务系统无需关注）"></css-input>
															</td> -->
																	</tr>
						</tbody>
					</table>
				</div>
				<!-- 用户添加修改 -->
					<div class="set-btn" data-spy="affix" data-offset-top="200" style="padding-top: 15px;padding-right: 15px;margin-top: 15px;margin-left: -15px;margin-right: -15px;border-top: 1px solid rgb(244, 244, 244);">
						<css-button v-if="result.data.uuid != null" :type="'primary'" @click="submit('/rest/sUser/updSUser')" :size="'sm'" :icon="'fa-save'">保存</css-button>
					
							<css-button v-else :type="'primary'" @click="submit('/rest/sUser/addSUser')" :size="'sm'" :icon="'fa-save'">保存</css-button>
						<css-button :type="'default'" @click="$dialog.closeTop()" :size="'sm'" :icon="'fa-close'">关闭</css-button>
					</div>
			</form>
		</template>
		<script>
			export default {
				props: {
				    params: {}
				  },
				  data() {
				    return {
				      data:{},
				      result:{data:{}}
				  }},
  methods: {
  }
			};
		</script>
