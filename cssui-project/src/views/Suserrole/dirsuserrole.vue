<template>
    <form v-list="{url:'/rest/sUserRole/dirSUserRole',dict:[]}" method="post">
		<css-content>
			<template v-slot:header>
				<div class="input-group input-group-sm">
					<div class="table-search">
						<ul>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.roleId" id="item.roleId"
											 name="item.roleId" :maxlength="50" placeholder="请输入roleId">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.userId" id="item.userId"
											 name="item.userId" :maxlength="50" placeholder="请输入userId">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.sysId" id="item.sysId"
											 name="item.sysId" :maxlength="50" placeholder="请输入sysId">
											</css-input>
									</li>
							<li>
								<css-button v-funcode="'acl_sUserRole/dirSUserRole'" :type="'primary'" @click="query()" :size="'sm'" :icon="'fa-search'">查询</css-button>
							</li>
						</ul>
					</div>
				</div>
			</template>
			<template v-slot:body>
				<div class="controls" style="margin: 0px 0px 5px 0px; padding-top: 0px;">
					<div class="btn-group">
							<css-button v-funcode="'acl_sUserRole/addSUserRole'" v-target="{id:'addSUserRole',type:'cssDialog',url:'/rest/sUserRole/getSUserRole',
							 params:{uuid:null}, title:'添加用户角色表',component:'GetSUserRole'}"
							 :type="'default'" :size="'sm'" :icon="'fa-plus'">添加</css-button>
						<css-button v-funcode="'acl_sUserRole/delSUserRole'" :type="'default'" :size="'sm'" :icon="'fa-trash-o'" @click="execBatch('/rest/sUserRole/delSUserRole')">删除</css-button>
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
										<th width="150px" @click="orderField('roleId')" class="order">roleId</th>
										<th width="150px" @click="orderField('userId')" class="order">userId</th>
										<th width="150px" @click="orderField('sysId')" class="order">sysId</th>
							</tr>
						</thead>
						<tbody>
							<tr v-for="data in result.datas">
								<td class="text-center">
									<input type="checkbox" :checked="data.checked" @click="checkSingle(data)" :value="data.uuid" />
								</td>
								<td class="text-center">
									<a title="修改用户角色表" href="javascript:;" v-funcode="'acl_sUserRole/updSUserRole'"
									 v-target="{id:'updSUserRole',type:'cssDialog',url:'/rest/sUserRole/getSUserRole',
									 params:{uuid:data.uuid},title:'修改用户角色表',component:'GetSUserRole'}">修改</a>
									<a title="删除用户角色表" href="javascript:;" v-funcode="'acl_sUserRole/delSUserRole'"
									 @click="exec('/rest/sUserRole/delSUserRole',data.uuid)">  删除</a>
								</td>
													<td class="text-center">{{data.roleId}}</td>
													<td class="text-center">{{data.userId}}</td>
													<td class="text-center">{{data.sysId}}</td>
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
		name: "dirSUserRole",
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