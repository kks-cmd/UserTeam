<template>
    <form v-list="{url:'/rest/sOrgDept/dirSOrgDept',dict:[]}" method="post">
            <input type='hidden' name='data.parentId' id='data.parentId'
			 v-model='data.parentId'>
		<css-content>
			<template v-slot:header>
				<div class="input-group input-group-sm">
					<div class="table-search">
						<ul>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.parentId" id="item.parentId"
											 name="item.parentId" :maxlength="50" placeholder="请输入父ID">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.orgId" id="item.orgId"
											 name="item.orgId" :maxlength="50" placeholder="请输入组织ID">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.name" id="item.name"
											 name="item.name" :maxlength="50" placeholder="请输入部门名称">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.address" id="item.address"
											 name="item.address" :maxlength="50" placeholder="请输入地址">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.phone" id="item.phone"
											 name="item.phone" :maxlength="50" placeholder="请输入电话">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.fax" id="item.fax"
											 name="item.fax" :maxlength="50" placeholder="请输入传真">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.zipCode" id="item.zipCode"
											 name="item.zipCode" :maxlength="50" placeholder="请输入邮编">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.orderNum" id="item.orderNum"
											 name="item.orderNum" :maxlength="50" placeholder="请输入排序号">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.deptCode" id="item.deptCode"
											 name="item.deptCode" :maxlength="50" placeholder="请输入部门编码">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.delFlag" id="item.delFlag"
											 name="item.delFlag" :maxlength="50" placeholder="请输入删除标记">
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
											 v-model="data.createTime" id="item.createTime"
											 name="item.createTime" :maxlength="50" placeholder="请输入创建时间">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.updateTime" id="item.updateTime"
											 name="item.updateTime" :maxlength="50" placeholder="请输入更新时间">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.deptType" id="item.deptType"
											 name="item.deptType" :maxlength="50" placeholder="请输入deptType">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.managerType" id="item.managerType"
											 name="item.managerType" :maxlength="50" placeholder="请输入managerType">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.provinceId" id="item.provinceId"
											 name="item.provinceId" :maxlength="50" placeholder="请输入provinceId">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.cityId" id="item.cityId"
											 name="item.cityId" :maxlength="50" placeholder="请输入cityId">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.countyId" id="item.countyId"
											 name="item.countyId" :maxlength="50" placeholder="请输入countyId">
											</css-input>
									</li>
							<li>
								<css-button v-funcode="'acl_sOrgDept/dirSOrgDept'" :type="'primary'" @click="query()" :size="'sm'" :icon="'fa-search'">查询</css-button>
							</li>
						</ul>
					</div>
				</div>
			</template>
			<template v-slot:body>
				<div class="controls" style="margin: 0px 0px 5px 0px; padding-top: 0px;">
					<div class="btn-group">
							<css-button v-funcode="'acl_sOrgDept/addSOrgDept'" v-target="{id:'addSOrgDept',type:'cssDialog',url:'/rest/sOrgDept/getSOrgDept',
							 params:{uuid:null,parentId:data.parentId}, title:'添加机构部门表',component:'GetSOrgDept'}"
							 :type="'default'" :size="'sm'" :icon="'fa-plus'">添加</css-button>
						<css-button v-funcode="'acl_sOrgDept/delSOrgDept'" :type="'default'" :size="'sm'" :icon="'fa-trash-o'" @click="execBatch('/rest/sOrgDept/delSOrgDept',removeFolder)">删除</css-button>
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
										<th width="150px" @click="orderField('parentId')" class="order">父ID</th>
										<th width="150px" @click="orderField('orgId')" class="order">组织ID</th>
										<th width="150px" @click="orderField('name')" class="order">部门名称</th>
										<th width="150px" @click="orderField('address')" class="order">地址</th>
										<th width="150px" @click="orderField('phone')" class="order">电话</th>
										<th width="150px" @click="orderField('fax')" class="order">传真</th>
										<th width="150px" @click="orderField('zipCode')" class="order">邮编</th>
										<th width="150px" @click="orderField('orderNum')" class="order">排序号</th>
										<th width="150px" @click="orderField('deptCode')" class="order">部门编码</th>
										<th width="150px" @click="orderField('delFlag')" class="order">删除标记</th>
										<th width="150px" @click="orderField('creatorId')" class="order">创建人ID</th>
										<th width="150px" @click="orderField('updateUserId')" class="order">修改人员ID</th>
										<th width="150px" @click="orderField('createTime')" class="order">创建时间</th>
										<th width="150px" @click="orderField('updateTime')" class="order">更新时间</th>
										<th width="150px" @click="orderField('deptType')" class="order">deptType</th>
										<th width="150px" @click="orderField('managerType')" class="order">managerType</th>
										<th width="150px" @click="orderField('provinceId')" class="order">provinceId</th>
										<th width="150px" @click="orderField('cityId')" class="order">cityId</th>
										<th width="150px" @click="orderField('countyId')" class="order">countyId</th>
							</tr>
						</thead>
						<tbody>
							<tr v-for="data in result.datas">
								<td class="text-center">
									<input type="checkbox" :checked="data.checked" @click="checkSingle(data)" :value="data.uuid" />
								</td>
								<td class="text-center">
									<a title="修改机构部门表" href="javascript:;" v-funcode="'acl_sOrgDept/updSOrgDept'"
									 v-target="{id:'updSOrgDept',type:'cssDialog',url:'/rest/sOrgDept/getSOrgDept',
									 params:{uuid:data.uuid},title:'修改机构部门表',component:'GetSOrgDept'}">修改</a>
									<a title="删除机构部门表" href="javascript:;" v-funcode="'acl_sOrgDept/delSOrgDept'"
									 @click="exec('/rest/sOrgDept/delSOrgDept',data.uuid,removeFolder)">  删除</a>
								</td>
													<td class="text-center">{{data.parentId}}</td>
													<td class="text-center">{{data.orgId}}</td>
													<td class="text-center">{{data.name}}</td>
													<td class="text-center">{{data.address}}</td>
													<td class="text-center">{{data.phone}}</td>
													<td class="text-center">{{data.fax}}</td>
													<td class="text-center">{{data.zipCode}}</td>
													<td class="text-center">{{data.orderNum}}</td>
													<td class="text-center">{{data.deptCode}}</td>
													<td class="text-center">{{data.delFlag}}</td>
													<td class="text-center">{{data.creatorId}}</td>
													<td class="text-center">{{data.updateUserId}}</td>
													<td class="text-center">{{data.createTime}}</td>
													<td class="text-center">{{data.updateTime}}</td>
													<td class="text-center">{{data.deptType}}</td>
													<td class="text-center">{{data.managerType}}</td>
													<td class="text-center">{{data.provinceId}}</td>
													<td class="text-center">{{data.cityId}}</td>
													<td class="text-center">{{data.countyId}}</td>
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
		name: "dirSOrgDept",
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
			removeFolder(res, ids) {
					this.csstree.find('sOrgDepttree').removeFolder(ids);
			},
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