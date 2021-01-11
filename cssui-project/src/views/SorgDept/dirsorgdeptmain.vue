<template>
  <div>
    <div class="tab-pane-middle">
      <div class="tab-pane-body-2 l-autoscroll" id="sOrgDeptContent">
        <component ref="DirSOrgDept" :is="'DirSOrgDept'" :params="params"></component>
      </div>
    </div>
    <div class="tab-pane-left noscroll" id="SOrgDeptTreePanel">
      <div class="box-lefttree">
        <div class="pull-left">
          <button @click="saveSOrgDeptTree()" type="button" class="btn btn-default btn-save">
            <i class="fa fa-save" title="保存顺序"></i>
          </button>
        </div>
        <div class="pull-left">
          <span>机构部门表树</span>
        </div>
      </div>
      <css-tree
        :id="'sOrgDepttree'"
        ref="sOrgDepttree"
        :treeParams="treeParams"
        :isMove="isMove"
        @clickNode="clickNode"
      ></css-tree>
    </div>
  </div>
</template>
<script>
import {http} from "@/config";
import DirSOrgDept from "./dirsorgdept";
export default {
  components: {
    DirSOrgDept
  },
  data() {
    return {
      params: { parentId: "0" },
      result: {},
      treeParams: {
        isClickRootNode: true,
        initDataUrl: "",
        initMethodType: "get" 
      },
      isMove: true
    };
  },
  methods: {
    saveSOrgDeptTree: function() {
	  var that=this;
      var ids=this.csstree.find("sOrgDepttree").saveTree();
	  this.$dialog.confirm('确认要进行机构部门表顺序保存操作？',function (params) {
		  that.$http.sorgdept.saveSOrgDeptTree(ids).then(res => {
that.$dialog.tip('保存成功！');
})
	  })
    },
    clickNode(node) {
      this.params.parentId = node.id;
      this.$refs.DirSOrgDept.data.parentId = node.id;
      this.$refs.DirSOrgDept.reset();
    }
  },
  mounted() {
    $("#SOrgDeptTreePanel").jqsplit({
      next: "sOrgDeptContent",
      size: 190,
      draggable: true,
      toggle: true
    });
    this.csstree.add("sOrgDepttree", this.$refs.sOrgDepttree);
  },
  created(){
    let url = http.axiosOption.baseURL;
    if (url.endsWith("/")) {
      url=url.substring(0, url.length - 1);
    }
    this.treeParams.initDataUrl = url + "/rest/sOrgDept/jsonSOrgDeptTree";
  }
};
</script>