<template>
  <div>
    <div class="breviary" style="height: 245px; width: 630px;">
        <ul class="con">
            <li v-for="item in themes" style="margin-bottom:0;">
                <a href="javascript:void(0);">
                    <img :src="item.src" @click="preview(item)" :alt="item.title" :class="active(item)">
                    <div class="txtbg"></div> 
                    <span class="txt">{{item.title}}</span>
                </a>
            </li>
        </ul>
    </div>
    <div class="set-btn" data-spy="affix" data-offset-top="200" style="padding-top: 15px; padding-right: 15px; margin-top: 15px; margin-left: -15px; margin-right: -15px; border-top: 1px solid rgb(244, 244, 244);">
        <button class="btn btn-sm btn-primary" type="button" @click="changeTheme();">
            <i class="fa fa-save"></i> 提交
        </button>  
        <button class="btn btn-sm btn-default" type="button"
                @click="colse();">
            <i class="fa fa-close"></i> 取消
        </button>
    </div>
</div>
</template>
<script>
export default {
  data(){
    return {
      curTheme:"default",
      themes:{
        default:{id:'default',data:'static/cssui/newThemes/default/',src:'static/cssui/themes/images/default.jpg',title:'海洋蓝',active:true},
        red:{id:'red',data:'static/cssui/newThemes/red/',src:'static/cssui/themes/images/red.jpg',title:'中国红',active:false},
        // blue:{id:'blue',data:'static/cssui/newThemes/blue/',src:'static/cssui/themes/darkblue/images/breviary.jpg',title:'深海蓝',active:false},
        orange:{id:'orange',data:'static/cssui/newThemes/orange/',src:'static/cssui/themes/images/orange.jpg',title:'秋意橙',active:false},
        qing:{id:'qing',data:'static/cssui/newThemes/qing/',src:'static/cssui/themes/images/qing.jpg',title:'清新绿',active:false},
        dark:{id:'dark',data:'static/cssui/newThemes/dark/',src:'static/cssui/themes/images/black.jpg',title:'炫酷黑',active:false},
        gray:{id:'gray',data:'static/cssui/newThemes/gray/',src:'static/cssui/themes/images/gray.jpg',title:'商务灰',active:false},
      }
    }
  },
  mounted(){
      this.initActive()
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
        window.openBorder = true;
      this.themes[this.curTheme]['active']=false;
      this.curTheme=item.id;
      item['active']=true;
      this.changeCss(item.data);
      window.curtheme = item.id;
    },
    changeCss(ondesc) {
      var links = $("[theme]");
      links[0].href = ondesc + 'main.css';
    },
    changeTheme(item){
      this.$dialog.closeTop();
    },
    colse(){
      this.$dialog.closeTop();
    }
  }
}
</script>
<style lang="scss">

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