<template>
  <div style="height: 40px;background-color: #2b303b">
    <el-row>
      <el-col :span="2">
        <div style="color: white;font-size: 30px" @click="bk">
          <i class="el-icon-caret-left"></i>
        </div>
      </el-col>
      <el-col :span="20">
        <div style="color: white;text-align: center;font-size: 30px;font-family: -apple-system">
          NULL POINTER NDB
        </div>
      </el-col>
      <el-col :span="2"></el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'DBHeaderCom',
  methods:{
    bk(){
      this.$router.go(-1)
    }
  }
}
</script>
<style scoped>
</style>
