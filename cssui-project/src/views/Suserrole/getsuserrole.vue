		<template>
			<form class="form-horizontal form-validate" v-form="{url:'/rest/sUserRole/getSUserRole',method:'get'}">
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
								<td colspan="1" class="col-md-1"></td>
							</tr>
															<tr>
														<td colspan="3" class="tdLable">
															roleId
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.roleId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入roleId"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															userId
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.userId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入userId"></css-input>
															</td>
																	</tr>
															<tr>
														<td colspan="3" class="tdLable">
															sysId
														</td>
															<td colspan="9">
																							 <css-input type="text" v-model="result.data.sysId"   :className="'form-control '"  :maxlength="500"  placeholder="请输入sysId"></css-input>
															</td>
																	</tr>
						</tbody>
					</table>
				</div>
					<div class="set-btn" data-spy="affix" data-offset-top="200" style="padding-top: 15px;padding-right: 15px;margin-top: 15px;margin-left: -15px;margin-right: -15px;border-top: 1px solid rgb(244, 244, 244);">
						<css-button v-if="result.data.uuid != null" :type="'primary'" @click="submit('/rest/sUserRole/updSUserRole')" :size="'sm'" :icon="'fa-save'">保存</css-button>
					
							<css-button v-else :type="'primary'" @click="submit('/rest/sUserRole/addSUserRole')" :size="'sm'" :icon="'fa-save'">保存</css-button>
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
