<template>
  <div>
    <el-divider>All Categories</el-divider>
    <el-row :gutter="20">
      <el-col :span="4" style="text-align: center" v-for="c in dbClassify" :key="c">
        <div @click="toDBCPage(c)" style="cursor:pointer">
          <el-card shadow="hover" >
            {{c}}
          </el-card>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'DBClassifyCom',
  created() {
    axios.get('/DB/selectMainClassify').then((res)=>{this.dbClassify = res.data})
  },
  methods : {
    toDBCPage(c){
      this.$router.push({path:'/DBCPage',query:{classify:c}});
    }
  },
  data(){
    return{
      dbClassify : ''
    }
  }
}
</script>
<style scoped>
</style>
