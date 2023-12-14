<template>
  <div>
    <div>
      <div style="font-size: 19px;text-align: center">Label</div>
      <el-divider></el-divider>
      <div style="text-align: center;font-size: 15px;color: #426799">
       <div v-for="c in mainClassify" :key="c.cid" style="margin: 10px 0px">
         <div>
           <el-link type="primary" @click="goClassify(c.classifyName)">
             {{c.classifyName}}
           </el-link>
         </div>
       </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'indexMenu_head',
  created() {
    axios.get('/article/selectAllArticleClassify').then((res)=>{this.mainClassify=res.data;});
  },
  methods : {
    goClassify(c){
      this.$router.push({path : '/classifyPage',query : {classifyName : c}});
      location.reload();
    }
  },
  data(){
    return{
      mainClassify : {}
    }
  }
}
</script>
<style scoped>
</style>
