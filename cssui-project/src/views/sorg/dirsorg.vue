<template>
    <form v-list="{url:'/rest/sOrg/dirSOrg',dict:[]}" method="post">
            <input type='hidden' name='data.parentid' id='data.parentid'
			 v-model='data.parentid'>
		<css-content>
			<template v-slot:header>
				<div class="input-group input-group-sm">
					<div class="table-search">
						<ul>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.orgName" id="item.orgName"
											 name="item.orgName" :maxlength="50" placeholder="请输入组织机构名称">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.deleteFlag" id="item.deleteFlag"
											 name="item.deleteFlag" :maxlength="50" placeholder="请输入删除标记">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.openFlag" id="item.openFlag"
											 name="item.openFlag" :maxlength="50" placeholder="请输入开启状态">
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
											 v-model="data.creatorName" id="item.creatorName"
											 name="item.creatorName" :maxlength="50" placeholder="请输入创建人真实姓名">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.orgCode" id="item.orgCode"
											 name="item.orgCode" :maxlength="50" placeholder="请输入组织机构编码">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.codeName" id="item.codeName"
											 name="item.codeName" :maxlength="50" placeholder="请输入codeName">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.parentid" id="item.parentid"
											 name="item.parentid" :maxlength="50" placeholder="请输入父节点id">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.sortNo" id="item.sortNo"
											 name="item.sortNo" :maxlength="50" placeholder="请输入序号">
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
											 v-model="data.creatorId" id="item.creatorId"
											 name="item.creatorId" :maxlength="50" placeholder="请输入创建人ID">
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
											 v-model="data.updateUserId" id="item.updateUserId"
											 name="item.updateUserId" :maxlength="50" placeholder="请输入修改人ID">
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
											<css-input :className="'input-medium '"
											 v-model="data.disLevel" id="item.disLevel"
											 name="item.disLevel" :maxlength="50" placeholder="请输入即时通讯字段（业务系统无需关注）">
											</css-input>
									</li>
									<li>
											<css-input :className="'input-medium '"
											 v-model="data.isConfirm" id="item.isConfirm"
											 name="item.isConfirm" :maxlength="50" placeholder="请输入即时通讯字段（业务系统无需关注）">
											</css-input>
									</li>
							<li>
								<css-button v-funcode="'acl_sOrg/dirSOrg'" :type="'primary'" @click="query()" :size="'sm'" :icon="'fa-search'">查询</css-button>
							</li>
						</ul>
					</div>
				</div>
			</template>
			<template v-slot:body>
				<div class="controls" style="margin: 0px 0px 5px 0px; padding-top: 0px;">
					<div class="btn-group">
							<css-button v-funcode="'acl_sOrg/addSOrg'" v-target="{id:'addSOrg',type:'cssDialog',url:'/rest/sOrg/getSOrg',
							 params:{uuid:null,parentid:data.parentid}, title:'添加组织机构',component:'GetSOrg'}"
							 :type="'default'" :size="'sm'" :icon="'fa-plus'">添加</css-button>
						<css-button v-funcode="'acl_sOrg/delSOrg'" :type="'default'" :size="'sm'" :icon="'fa-trash-o'" @click="execBatch('/rest/sOrg/delSOrg',removeFolder)">删除</css-button>
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
										<th width="150px" @click="orderField('orgName')" class="order">组织机构名称</th>
										<th width="150px" @click="orderField('deleteFlag')" class="order">删除标记</th>
										<th width="150px" @click="orderField('openFlag')" class="order">开启状态</th>
										<th width="150px" @click="orderField('createTime')" class="order">创建时间</th>
										<th width="150px" @click="orderField('creatorName')" class="order">创建人真实姓名</th>
										<th width="150px" @click="orderField('orgCode')" class="order">组织机构编码</th>
										<th width="150px" @click="orderField('codeName')" class="order">codeName</th>
										<th width="150px" @click="orderField('parentid')" class="order">父节点id</th>
										<th width="150px" @click="orderField('sortNo')" class="order">序号</th>
										<th width="150px" @click="orderField('remark')" class="order">备注</th>
										<th width="150px" @click="orderField('creatorId')" class="order">创建人ID</th>
										<th width="150px" @click="orderField('updateTime')" class="order">修改日期</th>
										<th width="150px" @click="orderField('updateUserId')" class="order">修改人ID</th>
										<th width="150px" @click="orderField('provinceId')" class="order">provinceId</th>
										<th width="150px" @click="orderField('cityId')" class="order">cityId</th>
										<th width="150px" @click="orderField('countyId')" class="order">countyId</th>
										<th width="150px" @click="orderField('disLevel')" class="order">即时通讯字段（业务系统无需关注）</th>
										<th width="150px" @click="orderField('isConfirm')" class="order">即时通讯字段（业务系统无需关注）</th>
							</tr>
						</thead>
						<tbody>
							<tr v-for="data in result.datas">
								<td class="text-center">
									<input type="checkbox" :checked="data.checked" @click="checkSingle(data)" :value="data.uuid" />
								</td>
								<td class="text-center">
									<a title="修改组织机构" href="javascript:;" v-funcode="'acl_sOrg/updSOrg'"
									 v-target="{id:'updSOrg',type:'cssDialog',url:'/rest/sOrg/getSOrg',
									 params:{uuid:data.uuid},title:'修改组织机构',component:'GetSOrg'}">修改</a>
									<a title="删除组织机构" href="javascript:;" v-funcode="'acl_sOrg/delSOrg'"
									 @click="exec('/rest/sOrg/delSOrg',data.uuid,removeFolder)">  删除</a>
								</td>
													<td class="text-center">{{data.orgName}}</td>
													<td class="text-center">{{data.deleteFlag}}</td>
													<td class="text-center">{{data.openFlag}}</td>
													<td class="text-center">{{data.createTime}}</td>
													<td class="text-center">{{data.creatorName}}</td>
													<td class="text-center">{{data.orgCode}}</td>
													<td class="text-center">{{data.codeName}}</td>
													<td class="text-center">{{data.parentid}}</td>
													<td class="text-center">{{data.sortNo}}</td>
													<td class="text-center">{{data.remark}}</td>
													<td class="text-center">{{data.creatorId}}</td>
													<td class="text-center">{{data.updateTime}}</td>
													<td class="text-center">{{data.updateUserId}}</td>
													<td class="text-center">{{data.provinceId}}</td>
													<td class="text-center">{{data.cityId}}</td>
													<td class="text-center">{{data.countyId}}</td>
													<td class="text-center">{{data.disLevel}}</td>
													<td class="text-center">{{data.isConfirm}}</td>
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
		name: "dirSOrg",
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
					this.csstree.find('sOrgtree').removeFolder(ids);
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