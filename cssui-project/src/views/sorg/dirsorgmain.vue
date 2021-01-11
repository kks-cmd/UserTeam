<template>
  <div>
    <div class="tab-pane-middle">
      <div class="tab-pane-body-2 l-autoscroll" id="sOrgContent">
        <component ref="DirSOrg" :is="'DirSOrg'" :params="params"></component>
      </div>
    </div>
    <div class="tab-pane-left noscroll" id="SOrgTreePanel">
      <div class="box-lefttree">
        <div class="pull-left">
          <button @click="saveSOrgTree()" type="button" class="btn btn-default btn-save">
            <i class="fa fa-save" title="保存顺序"></i>
          </button>
        </div>
        <div class="pull-left">
          <span>组织机构树</span>
        </div>
      </div>
      <css-tree
        :id="'sOrgtree'"
        ref="sOrgtree"
        :treeParams="treeParams"
        :isMove="isMove"
        @clickNode="clickNode"
      ></css-tree>
    </div>
  </div>
</template>
<script>
import {http} from "@/config";
import DirSOrg from "./dirsorg";
export default {
  components: {
    DirSOrg
  },
  data() {
    return {
      params: { parentid: "0" },
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
    saveSOrgTree: function() {
	  var that=this;
      var ids=this.csstree.find("sOrgtree").saveTree();
	  this.$dialog.confirm('确认要进行组织机构顺序保存操作？',function (params) {
		  that.$http.sorg.saveSOrgTree(ids).then(res => {
that.$dialog.tip('保存成功！');
})
	  })
    },
    clickNode(node) {
      this.params.parentid = node.id;
      this.$refs.DirSOrg.data.parentid = node.id;
      this.$refs.DirSOrg.reset();
    }
  },
  mounted() {
    $("#SOrgTreePanel").jqsplit({
      next: "sOrgContent",
      size: 190,
      draggable: true,
      toggle: true
    });
    this.csstree.add("sOrgtree", this.$refs.sOrgtree);
  },
  created(){
    let url = http.axiosOption.baseURL;
    if (url.endsWith("/")) {
      url=url.substring(0, url.length - 1);
    }
    this.treeParams.initDataUrl = url + "/rest/sOrg/jsonSOrgTree";
  }
};
</script>