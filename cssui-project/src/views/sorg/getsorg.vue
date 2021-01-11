		<template>
			<form class="form-horizontal form-validate" v-form="{url:'/rest/sOrg/getSOrg',method:'get'}">
				<css-input name="uuid" id="uuid" type="hidden"
				 v-model="data.uuid"></css-input>
					<css-input :name="'parentid'" id="parentid"
					 type="hidden" v-model="data.parentid"></css-input>
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
															组织机构名称
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.orgName"   :className="'form-control '"  :maxlength="500"  placeholder="请输入组织机构名称"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
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
															创建人真实姓名
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.creatorName"   :className="'form-control '"  :maxlength="500"  placeholder="请输入创建人真实姓名"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															组织机构编码
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.orgCode"   :className="'form-control '"  :maxlength="500"  placeholder="请输入组织机构编码"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															codeName
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.codeName"   :className="'form-control '"  :maxlength="500"  placeholder="请输入codeName"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															父节点id
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.parentid"   :className="'form-control '"  :maxlength="500"  placeholder="请输入父节点id"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															序号
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.sortNo"   :className="'form-control '"  :maxlength="500"  placeholder="请输入序号"></css-input>
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
															修改日期
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.updateTime"   :className="'form-control '"  :maxlength="500"  placeholder="请输入修改日期"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															修改人ID
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.updateUserId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入修改人ID"></css-input>
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
															<tr>
														<td colspan="3" class="tdLable">
															即时通讯字段（业务系统无需关注）
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.disLevel"   :className="'form-control '"  :maxlength="500"  placeholder="请输入即时通讯字段（业务系统无需关注）"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															即时通讯字段（业务系统无需关注）
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.isConfirm"   :className="'form-control '"  :maxlength="500"  placeholder="请输入即时通讯字段（业务系统无需关注）"></css-input>
															</td>
																	</tr>
						</tbody>
					</table>
				</div>
					<div class="set-btn" data-spy="affix" data-offset-top="200" style="padding-top: 15px;padding-right: 15px;margin-top: 15px;margin-left: -15px;margin-right: -15px;border-top: 1px solid rgb(244, 244, 244);">
						<css-button v-if="result.data.uuid != null" :type="'primary'" @click="submit('/rest/sOrg/updSOrg',saveSOrgTree)" :size="'sm'" :icon="'fa-save'">保存</css-button>
					
							<css-button v-else :type="'primary'" @click="submit('/rest/sOrg/addSOrg',saveSOrgTree)" :size="'sm'" :icon="'fa-save'">保存</css-button>
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
    saveSOrgTree(data) {
      if (this.params.uuid) {
        this.csstree.find("sOrgtree").updFolder(data);
      } else {
        this.csstree.find("sOrgtree").addFolder(data);
      }
    }
  }
			};
		</script>
