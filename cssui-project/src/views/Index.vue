<template>
  <div class="wrapper">
    <div class="wrapper-header">
      <css-header 
       :headerData="headerData" 
       @logout="logout"
       :buttons="buttons"
       :logo="true"
       :isLogout="true"
       >
       </css-header>
    </div>
    <div class="wrapper-content">
      <div class="wrapper-middle">
        <css-tabs
          ref="main_tab"
          :isExpand="isExpand"
          :tabs="tabs"
          :g_tabHeight="g_tabHeight"
          @showTab="activeMenu"
          @openDropdown="openDropdownMenu"
        >
            <div class="tabMenu-left tabMenu-more two" slot="tabLeft">
                <css-togglesidebar :isExpand="isExpand" @clickTogglesidebar="clickTogglesidebar"></css-togglesidebar>
                <div class="clear"></div>
                <css-dropdown :id="'dropdownLeft'">
                    <a href="javascript:;">
                    <i class="fa fa-reorder"></i>
                    </a>
                    <template v-slot:dropdown-menu>
                    <css-dropdown-item
                        v-for="(item,index) in tabs"
                        :key="index"
                        :item="item"
                        @clickDropdownItem="clickDropdownMenu"
                    ></css-dropdown-item>
                    </template>
                </css-dropdown>
            </div>

            <div class="tabMenu-right tabMenu-more" slot="tabRight">
                <css-dropdown :id="'dropdownRight'">
                    <a href="javascript:;">
                    <i class="fa fa-reorder"></i>
                    </a>
                    <template v-slot:dropdown-menu>
                        <css-dropdown-item
                            v-for="(item,index) in tabs"
                            :key="index"
                            :item="item"
                            @clickDropdownItem="clickDropdownMenu"
                        ></css-dropdown-item>
                    </template>
                </css-dropdown>
            </div>
        </css-tabs>
      </div>
      <div class="wrapper-left">
        <div
          id="sidebarIndex"
          class="sidebar l-autoscroll"
          scrollSize="-41"
          unselectable="on"
          onselectstart="return false;"
        >
          <css-menu
            @hook:mounted="initNewTab"
            :id="'cssSidebarMenu'"
            ref="cssSidebarMenu"
            :isExpand="isExpand"
            :isParent="true"
            @clickMenu="openTab"
            @menuMove="menuMove"
            @mouseleave="mouseleave"
            :menu="menus"
          ></css-menu>
        </div>
        <div id="sidebarFloatMenu" class="sidebarFloatMenu" style="display: none">
          <css-menu
            :id="'csssidebarFloatMenu'"
            :isExpand="false"
            :isFloatMenu="true"
            :isParent="true"
            ref="floatMenu"
            @clickMenu="openTab"
            :menu="floatMenus"
          ></css-menu>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import api from "@/http/api";
import Cookies from "js-cookie";
import {app} from "@/config";
import Vue from "vue";
import * as index from './index.js'
export default {
  name: "Index",
  data() {
    return {
      resizeTimer: "",
      settingOpen:false,
      g_bodyHeight: "",
      g_tabHeight: 0,
      headerData: {
        icon: "fa-cubes",
        sysName: app.sysName,
        userName: sessionStorage.getItem('userName')
      },
      tabs: [],
      isExpand: true,
      menus: [],
      floatMenus: [],
      sidebar: {
        beforeEl: {}
      },
      buttons:[{
          icon:'fa fa-envelope-o',
          text:'',
          number:'4',
          numberType:'label label-success',
          callback:null
      },{
          icon:'fa fa-gears',
          text:'',
          callback:null
      },{
          icon:'fa-w fa-tachometer fa',
          text:'',
          callback:this.changeTheme
      }  
      ]
    };
  },
  methods: {
    getParams(){
        
    },
    clickDropdownMenu(showTab){
      index.clickDropdownMenu(this,showTab);            
    },
    changeTheme(){
      index.changeTheme(this);
    },
    initNewTab(){
      index.initNewTab(this);
    },
    openDropdownMenu(obj) {
      console.log(obj);
    },
    activeMenu(tab) {
      this.$refs.cssSidebarMenu.openMenuByTab(tab);
    },
    mouseleave() {
      index.mouseleave(this);
    },
    showTip(data){
        this.$dialog.tip('主题');
    },
    menuMove(event,item) {
      index.menuMove(this,item);
    },
    clickTogglesidebar() {
      this.isExpand = !this.isExpand;
    },
    openTab(item) {
      index.openTab(this,item);
    },
    initLayout() {
      index.initLayout(this);
    },
    logout() {
      index.logout(this);
	  },
    // 删除cookie
    deleteCookie: function(name) {
      Cookies.remove(name);
    },
    initMenu(menus) {
      index.initMenu(this,menus);       
    },
  },
  created() {
    if(!'settingOpen' in window){
        window.settingOpen = false;
    }
    this.settingOpen = window.settingOpen;
    this.getParams();
    index.loadMenu(this,sessionStorage.getItem("userId"),app.sysId);
    index.createInit(this)
    index.findPermissions(this,sessionStorage.getItem("userId"),app.sysId);
  },
  watch: {
    '$route': 'getParams',
    isExpand(){
      index.changeExpand(this);
    }
  },
  mounted() {
    this.initLayout();
  }
};
</script>