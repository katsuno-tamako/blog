<template>
  <div>
    <div>
      <el-button @click="openDia">修改头像</el-button>
    </div>


    <el-dialog
      :visible.sync="dialog"
    >
    <el-form>
      <el-form-item style="text-align: center">
        <el-image
          :src="imgUrl"
          style="width: 200px;height: 200px"
        >

        </el-image>
      </el-form-item>
      <el-form-item style="text-align: center">

        <el-upload
          :action="lUrl+'/admin/uploadAvatar'"
          :on-success="successA"
          :limit="1"
        >
          <el-button size="small" type="primary">点击上传</el-button>
        </el-upload>

      </el-form-item>


      <el-form-item style="text-align: center">
        <el-button @click="confirmUP" type="primary">提交</el-button>
      </el-form-item>
    </el-form>
    </el-dialog>


  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'editAdminImg',
  methods:{
    openDia(){
      this.dialog = true;
      axios.get('/request/getLocal').then((res)=>{
        this.lUrl=res.data
        axios.get('/admin/getAvatar').then((res)=>{
          this.adv = res.data
          this.imgUrl = this.lUrl+this.adv;
          console.log(this.adv);
        });
      });

    },
    successA(pos, $file){
      this.admin.adminImg = $file.response.url;
      console.log(this.admin.adminImg);
    },
    confirmUP(){
      axios.post('/admin/updateAvatar',
        {
          adminId:this.admin.adminId,
          adminImg : this.admin.adminImg
        }
      ).then(
        (res)=>{
          axios.get('/admin/returnAdminInfo').then((res)=>{this.admin = res.data});
          this.dialog = false;
          axios.get('/admin/getAvatar').then((res)=>{this.adv = res.data});
        }
      )
    }
  },
  data(){
    return{
      imgUrl : '',
      lUrl : '',
      aUrl : '',
      dialog : false,
      adv : '',
      admin : {
        adminImg : ''
      }
    }
  }
}
</script>
<style scoped>
</style>
