var sidebarExpand = function(){
    $("#sidebarIndex").removeClass("collapse48 collapse75");
      $("#sidebarIndex").find("span").css("display", "");
      $(".wrapper-left").animate({width: "210px"},100);
      $(".wrapper-body-2").animate({margin: "0 0 0 210px"},100);
}
var sidebarCollapse = function(){
    let collapseWidth = 75;
    $("#sidebarIndex").addClass("collapse" + collapseWidth);
    $(".wrapper-left").css("width", collapseWidth + "px");
    $(".wrapper-body-2").css("margin", "0 0 0 " + collapseWidth + "px");
}
var checkFlag = function(that,item) {
    if (that.sidebar.beforeEl && item.id == that.sidebar.beforeEl.id) {
      return false;
    } else {
      return true;
    }
}
var hide = function(that) {
    $("#sidebarFloatMenu").hide();
    unbindEvent();
    that.sidebar.beforeEl = {};
}
var unbindEvent = function() {
    $("#sidebarFloatMenu").unbind();
}
export const mouseleave = function(that){
    hide(that);
}
export const clickDropdownMenu = function(that,showTab){
    var item = {
        id:showTab.id,
        path:showTab.component,
        name:showTab.title
    }
    that.openTab(item);            
}
export const changeTheme = function(that){
    that.$dialog.show(
        {
            id:'DirThemeDialog',
            title : '主题',
            isHeader:true
        },{name:'DirThemeDialog',data :{}
        }
    );
}
export const initNewTab=function(vue){
    //数据加载完成后的操作
    var newTab=JSON.parse(sessionStorage.getItem('newTab'));
    if(newTab){
        vue.$csstabs.find("main_tab").open(newTab);
        // sessionStorage.removeItem('newTab')
    }
}
export const initLayout = function(that){
    let g_bodyHeight = $(window).height(); //window高度
    $(".wrapper .wrapper-content").height(g_bodyHeight); //设置wrapper-content高度
    that.g_tabHeight = $(window).height() - $(".wrapper-header").outerHeight() - 39;
    that.$autoscroll.init($(".wrapper-left")[0], that.g_tabHeight); //根据tab页面高度判断是否需要滚动条
}
export const createInit = function(that){

    $(window).bind("resize", ()=> { //window绑定resize事件
        try {
          if (that.resizeTimer) clearTimeout(that.resizeTimer); 
          that.resizeTimer = setTimeout(function() {
            that.initLayout();  //初始化页面
            that.$csstabs.find("main_tab").initComponent(that.g_tabHeight); //浏览器窗口大小发生改变时根据tab页面高度重新加载tab页面
          }, 50);
        } catch (error) {
          console.log(error);
        }
      });
}
export const menuMove = function(that,item){
      var $sub = $("#sidebarFloatMenu");
      if (checkFlag(that,item)) {
        unbindEvent();
        that.floatMenus = item.menus;
        var floatMenus = that.floatMenus;
        that.$refs.floatMenu.$nextTick(() => {
          $sub.css("display", "block");
          that.sidebar.beforeEl = item;
          var top = $(event.target).offset().top - 1;
          var offset = isIE ? 3 : 15;
          if (top + $sub.height() + offset > $(window).height())
            top = $(window).height() - $sub.height() - offset;
          $sub.css({
            left: 75 + "px",
            top: top + "px"
          });
          $sub.show();
        });
        $(document).one("click", function() {
          hide(that);
        });
        $sub.on("mouseleave", function(e) {
          e.preventDefault ? e.preventDefault() : (e.returnValue = false);
          hide(that);
        });
      }
}
export const openTab = function(that,item){
    var curclose = "close" in item ? item.close :true;
    var tab = {
        id: item.id,
        active: "active",
        close: curclose,
        component: item.path,
        title: item.name,
        timer: new Date().getTime()
    };
    that.$csstabs.find("main_tab").open(tab); //打开tab页面
    event.preventDefault();
}
export const initMenu = function(that,menus){
    for (let i in menus) { //遍历菜单对象
        menus[i].active = ""; //
        if (menus[i].menus && menus[i].menus.length > 0) { //如果存在子菜单，初始化子菜单
            that.initMenu(menus[i].menus);
        }
    }
    //当前选中菜单为第一个
    that.$menuselect = that.menus[0];
    that.$menuselect.close = false;
    that.openTab(that.$menuselect); 
}
export const loadMenu = function(that,userId,sysId){
    that.$http.menu.loadNavTree({
        'userId': userId,
        'sysId': sysId
    })
    .then(res => {
        for (let i in res) {
            that.menus.push(res[i]); //属性
        }
        that.initMenu(res); //初始化menu
		initNewTab(that);
    }).catch(res=>{
        console.log(res);
    })
}

export const changeExpand = function(that){
    that.$refs.cssSidebarMenu.init();
    if (that.isExpand) 
        sidebarExpand(); //menu展开时设置展开样式
    else sidebarCollapse(); //menu收缩时设置收缩样式
    for(let i in that.tabs){ //遍历tab
        if(that.tabs[i].active == 'active'){ //如果tab状态为active时，设置点击状态
            that.$refs.main_tab.clickTab(that.tabs[i]);
            break;
        }
    }
}

export const findPermissions = function(that,userId,sysId){
    that.$http // vue实例挂载的$http，请求api对象
    .permission//api属性对象，src/http/api.js中注册的业务请求对象名称
    .loadPermissions({ //api属性对象方法，src/http/moudules中permissions业务请求文件中的api方法名称
        'userId': userId, //用户uuid
        'sysId':sysId
    })
    .then(res => {
        that.permission.setPermission(res); //权限的存储
    }).catch(error => {
        console.log(error);
    });
}
export const logout = function(that) {
    that.$http.login
    .logout()
    .then(res => {
          sessionStorage.removeItem('userId');
          sessionStorage.removeItem('userName');
          if(res){
              location.href=res;
          }else{
              that.$router.push("/login").catch(data => {  }); 
          }
          that.deleteCookie('cssSessionId');
    })
    .catch(function(res) {
    });
}
