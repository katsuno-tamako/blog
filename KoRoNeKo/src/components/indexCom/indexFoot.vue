<template>
  <div>
    <div class="footer">
      <el-divider></el-divider>
      <div style="text-align: center">
        <div>
          <img style="width: 100px;height: 100px;border-radius:50%; " src='../../assets/image/hia.gif'/>

        </div>
        <div>
          <el-button size="mini" @click="openDialog" type="text">关于我</el-button>
        </div>
        <span style="font-size: 10px;color: slategrey">
          @NullPointerException | Ro
        </span>
      </div>

    </div>



    <el-dialog
      :visible.sync="dialog"
    >
      <div>
        <div style="font-size: 20px;text-align: center">
          <span>邮箱:</span>
          <span style="font-weight: bolder">{{introduction.email}}</span>
        </div>
        <div style="font-size: 20px;text-align: center">
          <span>GitHub:</span>
          <span style="font-weight: bolder">{{introduction.gitHubUrl}}</span>
        </div>
        <div style="font-size: 20px;text-align: center">
          <span>QQ:</span>
          <span style="font-weight: bolder">{{introduction.qq}}</span>
        </div>
        <div style="font-size: 20px;text-align: center">
          <span>BilBil:</span>
          <span style="font-weight: bolder">{{introduction.biliBili}}</span>
        </div>
        <div style="font-size: 20px;text-align: center">
          <span>weibo:</span>
          <span style="font-weight: bolder">{{introduction.weibo}}</span>
        </div>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'indexFoot',
  methods : {
      openDialog(){
        this.dialog = true;
        axios.get('/admin/selectAllIndexInfo').then((res)=>{this.introduction=res.data;});
      }
  },
  data(){
    return{
      dialog : false,
      introduction : {
        email : ''
      }
    }
  }
}
</script>
<style scoped>
  .footer{
    /*position:absolute;*/
    bottom:0;
    width:100%;
    height:100px;
  }
</style>
