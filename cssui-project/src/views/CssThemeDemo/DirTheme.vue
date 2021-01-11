<template>
  <div>
    <div class="theme-title">
        <h3>主题设置</h3>
    </div>
    <div class="theme-breviary-cont">
        <div class="breviary" style="height: 425px; width: 420px;">
        <ul class="con">
            <li v-for="item in themes">
                <a href="javascript:void(0);">
                    <img :src="item.src" @click="preview(item)" :alt="item.title" :class="active(item)">
                    <div class="txtbg"></div> <span class="txt">{{item.title}}</span></a></li>
        </ul>
    </div>
    <div class="open-head-menu">
        <ul>
            <li>
                <p>开启顶栏导航：</p>
                <css-switch v-model="openBtn"  active-color="#13ce66" inactive-color="#d2d2d2"></css-switch>
            </li>
            <li>
                <p>开启边框：</p>
                <css-switch v-model="openBorder" @change="changeBorder" active-color="#13ce66" inactive-color="#d2d2d2"></css-switch>
            </li>
        </ul>
    </div>
    </div>
</div>
</template>
<script>
export default {
  props:{
      isOpen:Boolean,
      isBorder:Boolean
  },
  data(){
    return {
      curTheme:"default",
      openBtn:this.isOpen,
      openBorder:false,
      themes:{
        default:{id:'default',data:'static/cssui/newThemes/',src:'static/cssui/newThemes/images/default.jpg',title:'海洋蓝',active:true},
        red:{id:'red',data:'static/cssui/newThemes/',src:'static/cssui/newThemes/images/red.jpg',title:'中国红',active:false},
        orange:{id:'orange',data:'static/cssui/newThemes/',src:'static/cssui/newThemes/images/orange.jpg',title:'秋意橙',active:false},
        qing:{id:'qing',data:'static/cssui/newThemes/',src:'static/cssui/newThemes/images/qing.jpg',title:'清新绿',active:false},
        dark:{id:'dark',data:'static/cssui/newThemes/',src:'static/cssui/newThemes/images/black.jpg',title:'炫酷黑',active:false},
        gray:{id:'gray',data:'static/cssui/newThemes/',src:'static/cssui/newThemes/images/gray.jpg',title:'商务灰',active:false},
      }
    }
  },
  methods:{
    initActive(){
        var i = 0;
        for(var t in this.themes){
            if(this.themes[t].id == window.curtheme){
                this.themes[t].active = true;
                this.curTheme = this.themes[t].id;
                i++;
            }else{
                this.themes[t].active = false;
            }
        }
        if(i<1){
            this.themes.default.active = true;
        }
    },
    active(item){
      if(item&&item.active){
        return "active"
      }else{
        return "";
      }
    },
    preview(item){
      this.themes[this.curTheme]['active']=false;
      this.curTheme=item.id;
      item['active']=true;
      this.changeCss(item.data);
      window.curtheme = item.id;
    },
    //火狐样式切换兼容
    firefoxCss(ondesc){
        var old=$("[theme]");
        var link = document.createElement('link');
		link.rel = 'stylesheet';
        link.type = 'text/css';
        link.setAttribute("theme","main");
        var links = $(link);
        if(!this.openBorder){ //没有开启边框
            links[0].href = ondesc +this.curTheme+'2/main.css';
        }else{
            links[0].href = ondesc +this.curTheme+'/main.css';
        }
        document.getElementsByTagName('head')[0].insertBefore(link,old[0]);
        setTimeout(() => {
            old.remove();
        }, 200);
    },
    changeCss(ondesc) {
        var links = $("[theme]");
        if(isFF){
            this.firefoxCss(ondesc);
        }else{
         if(!this.openBorder){ //没有开启边框
                links[0].href = ondesc +this.curTheme+'2/main.css';
            }else{
                links[0].href = ondesc +this.curTheme+'/main.css';
            }
        }
    },
    changeBorder(val){
        if(this.openBorder){ //开启边框
            window.openBorder = true;
        }else{
            window.openBorder = false;
        }
         this.changeCss('static/cssui/newThemes/');
    },
    changeTheme(item){
      this.$dialog.closeTop();
    },
    colse(){
      this.$dialog.closeTop();
    },
    resizeHandle(){
        var h = $(window).height()-70;
        $(this.$el).find('div.theme-breviary-cont').css('height',h+'px');
    }
  },
  mounted(){
      if('openBorder' in window){
          this.openBorder = window.openBorder;
      }else{
          this.openBorder = this.isBorder;
      }
      this.initActive();
      window.openMenu = this.isOpen;
     
      window.addEventListener('resize',this.resizeHandle);
      var that = this;
      this.$nextTick(()=>{
          that.resizeHandle();
      })
  },
  beforeDestroy(){
    window.removeEventListener('resize',this.resizeHandle);
  },
  watch:{
      openBtn:{
          handler(){
              window.openMenu = this.openBtn;
              if(this.openBtn){ //开启头部菜单
                    this.$attrs.srcComponent.$router.push({
                        name:"firstPage2",
                        params:{settingOpen:true}
                    }); // 登录成功，跳转到主页
              }else{ //关闭头部菜单
                    this.$attrs.srcComponent.$router.push({
                        name:'firstPage',
                        params:{settingOpen:true}
                    }) // 登录成功，跳转到主页
              }
          }
      },
      openBorder:{
          handler(){
              if(this.openBorder){ //开启边框
                    window.openBorder = true;
                    // var links = $("[theme]");
                    // var href = links[0].href;
                    // var arr = href.split('newThemes/');
                    // var linkFirst = arr[0]+'newThemes/';
                    // var linkEnd = arr[1].split('/main.css')[0];
                    // var end = linkEnd.split('2')[0];
                    // var endLink = 'static/cssui/newThemes/' + end + '/main.css';
                    // if(linkEnd.indexOf('2')>=0)
                    //     links[0].href = endLink;
              }else{ 
                   window.openBorder = false;
                //    var links = $("[theme]");
                //    var href = links[0].href;
                //    var arr = href.split('newThemes/');
                //    var linkFirst = arr[0]+'newThemes/';
                //    var linkEnd = arr[1].split('/main.css')[0];
                //    linkEnd = linkEnd.split('2')[0];
                //    links[0].href = 'static/cssui/newThemes/' + linkEnd + '2/main.css';
                    
            }
          }
      }
  }
}
</script>
<style lang="scss">
.theme-title{
    height: 40px;
    border-bottom: 1px solid rgb(244, 244, 244);
    margin-left: -15px; margin-right: -15px;
    h3{
        line-height: 30px;
        float: left;
        margin-left: 10px;
    }
    span{
        float: right;
    }
}
.open-head-menu{
    border-bottom: 1px solid rgb(244, 244, 244);
    border-top: 1px solid rgb(244, 244, 244);
    margin-left: -15px; margin-right: -15px;
    p{
        float: left;
        margin:0;
        margin-left: 35px;
        line-height: 70px;
    }
    .css-switch{
        margin-top: 25px;
        margin-left: 10px;
    }
    li{
        height: 70px;
    }

}
.theme-breviary-cont{
    overflow-y: auto;
    overflow-x: hidden;
    margin: 0 -15px 0 -5px;
}
.theme-breviary-cont::-webkit-scrollbar {
    width: 10px;     
    height: 1px;
}
.theme-breviary-cont::-webkit-scrollbar-thumb {
    border-radius: 5px;
    background:rgba(0, 0, 0, 0.2)
}
.breviary{
    margin-top: 20px;
    >.con li {
        margin: 0 10px;
        margin-bottom: 30px;
        .txt{
            width: 100%;
            text-align: center;
            left: 0!important;
        }
    }
}
</style>