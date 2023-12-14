<template>
  <div>
    {{this.article}}
    <el-divider></el-divider>
    <div v-for="a in article" :key="a.id">
      <mavon-editor
        ref="md"
        :value="a.context"
        :subfield = "prop.subfield"
        :defaultOpen = "prop.defaultOpen"
        :toolbarsFlag = "prop.toolbarsFlag"
        :editable="prop.editable"
        :scrollStyle="prop.scrollStyle"
      >

      </mavon-editor>
    </div>

  </div>
</template>

<script>
import axios from 'axios'
import marked from 'marked';
export default {
  name: 'showAllArticle',
  created() {
    axios.get('/article/selectAllArticle').then((res)=>{
      this.article = res.data;
    });
  },
  data(){
    return{
      article : {}
    }
  },
  computed: {
    prop () {
      let data = {
        subfield: false,// 单双栏模式
        defaultOpen: 'preview',//edit： 默认展示编辑区域 ， preview： 默认展示预览区域
        editable: false,
        toolbarsFlag: false,
        scrollStyle: true
      };
      return data
    }
  },
}
</script>
<style scoped>
</style>
