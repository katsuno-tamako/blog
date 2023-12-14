<template>
  <div>
    <div style="text-align: center">
      <span style="font-size: 30px;font-weight: bolder">
        NULL POINTER EDB \(ΦωΦ)/
      </span>
    </div>
    <div style="text-align: center;margin-top: 20px">
      <el-input v-model="keyword" placeholder="(; ΦωΦ)" style="width: 60%;box-shadow: 1px 1px 1px 1px rgba(0, 0, 0, 0.1)"></el-input>
      <el-button style="box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)" @click="sl" >
        <i class="el-icon-search"></i>
      </el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'DBSearchCom',
  methods:{
    sl(){
      this.$router.push({path:'/DBSearchPage',query:{keyword:this.keyword}});
    }
  },
  data(){
      return{
        keyword : ''
      }
  }
}
</script>
<style scoped>
</style>
