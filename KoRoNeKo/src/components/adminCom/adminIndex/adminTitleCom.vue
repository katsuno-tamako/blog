<template>
  <div>
    <div style="background-color: #712747;height: 30px">
      <el-row>
        <el-col :span="2">
          <el-link @click="toIndex">
            <i class="el-icon-s-home" style="font-size: 30px"></i>
          </el-link>
        </el-col>
        <el-col :span="18">
          <span style="font-size: 22px;font-family: Bahnschrift;color: white">
            Null Pointer Exception
          </span>
        </el-col>
        <el-col :span="2" style="text-align: center">
          <el-link :underline="false" @click="logout">
            <span>退出登录</span>
          </el-link>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'adminTitleCom',
  created() {
  },
  methods : {
    toIndex(){
       let text= this.$router.resolve({
         path: '/'
       });
      // 打开一个新的页面
      window.open(text.href, '_blank')
    },
    logout(){
      axios.get('/admin/removeSession').then();
      this.$router.push('/adminLogin');
    }
  },
  data(){
    return{
      admin : {}
    }
  }
}
</script>
<style scoped>
</style>
