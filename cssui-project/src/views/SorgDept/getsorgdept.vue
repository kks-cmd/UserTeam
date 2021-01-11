		<template>
			<form class="form-horizontal form-validate" v-form="{url:'/rest/sOrgDept/getSOrgDept',method:'get'}">
				<css-input name="uuid" id="uuid" type="hidden"
				 v-model="data.uuid"></css-input>
					<css-input :name="'parentId'" id="parentId"
					 type="hidden" v-model="data.parentId"></css-input>
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
								<td colspan="1" class="col-md-1"></td>
							</tr>
															<tr>
														<td colspan="3" class="tdLable">
															父ID
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.parentId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入父ID"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															组织ID
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.orgId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入组织ID"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															部门名称
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.name"   :className="'form-control '"  :maxlength="500"  placeholder="请输入部门名称"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															地址
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.address"   :className="'form-control '"  :maxlength="500"  placeholder="请输入地址"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															电话
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.phone"   :className="'form-control '"  :maxlength="500"  placeholder="请输入电话"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															传真
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.fax"   :className="'form-control '"  :maxlength="500"  placeholder="请输入传真"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															邮编
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.zipCode"   :className="'form-control '"  :maxlength="500"  placeholder="请输入邮编"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															排序号
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.orderNum"   :className="'form-control '"  :maxlength="500"  placeholder="请输入排序号"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															部门编码
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.deptCode"   :className="'form-control '"  :maxlength="500"  placeholder="请输入部门编码"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															删除标记
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.delFlag"   :className="'form-control '"  :maxlength="500"  placeholder="请输入删除标记"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															创建人ID
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.creatorId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入创建人ID"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															修改人员ID
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.updateUserId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入修改人员ID"></css-input>
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
															更新时间
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.updateTime"   :className="'form-control '"  :maxlength="500"  placeholder="请输入更新时间"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															deptType
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.deptType"   :className="'form-control '"  :maxlength="500"  placeholder="请输入deptType"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															managerType
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.managerType"   :className="'form-control '"  :maxlength="500"  placeholder="请输入managerType"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															provinceId
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.provinceId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入provinceId"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															cityId
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.cityId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入cityId"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															countyId
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.countyId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入countyId"></css-input>
															</td>
																	</tr>
						</tbody>
					</table>
				</div>
					<div class="set-btn" data-spy="affix" data-offset-top="200" style="padding-top: 15px;padding-right: 15px;margin-top: 15px;margin-left: -15px;margin-right: -15px;border-top: 1px solid rgb(244, 244, 244);">
						<css-button v-if="result.data.uuid != null" :type="'primary'" @click="submit('/rest/sOrgDept/updSOrgDept',saveSOrgDeptTree)" :size="'sm'" :icon="'fa-save'">保存</css-button>
					
							<css-button v-else :type="'primary'" @click="submit('/rest/sOrgDept/addSOrgDept',saveSOrgDeptTree)" :size="'sm'" :icon="'fa-save'">保存</css-button>
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
    saveSOrgDeptTree(data) {
      if (this.params.uuid) {
        this.csstree.find("sOrgDepttree").updFolder(data);
      } else {
        this.csstree.find("sOrgDepttree").addFolder(data);
      }
    }
  }
			};
		</script>
