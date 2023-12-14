<template>
  <div>

        <div style="text-align: center;margin: 10% 35% 0 35%;">
          <el-card>
            <div style="font-size: 25px">
              Log in
            </div>
            <el-divider></el-divider>
            <el-form>
              <el-form-item  @keyup.enter.native="adminLogin">
                <el-input v-model="admin.adminAccount" placeholder="Place input admin account">
                  <template slot="append">
                    <i class="el-icon-user"></i>
                  </template>
                </el-input>
              </el-form-item>
              <el-form-item>
                <el-input v-model="admin.adminPassword" placeholder="Place input admin password" type="password" show-password>
                  <template slot="append">
                    <i class="el-icon-lock"></i>
                  </template>
                </el-input>
              </el-form-item>
              <el-form-item>
<!--                <el-checkbox v-model="checked">Remember Me</el-checkbox>-->
              </el-form-item>
              <el-form-item>
                <el-button @click="adminLogin" style="width: 100%;background-color: #445d7d;">
                  <span style="font-size: 15px;font-weight: bolder;color: white">Log in</span>
                </el-button>
              </el-form-item>
            </el-form>
          </el-card>
        </div>

        <el-dialog
          :visible.sync="ErrorDia"
        >
          账号密码错误
          <el-button @click="ErrorDia = false">确定</el-button>
        </el-dialog>




  </div>
</template>

<script>
import axios from 'axios'
import CryptoJS from 'crypto-js'
export default {
  name: 'adminLogin',
  created() {
    axios.get('/plug/getDiskAllFile').then();
  },
  methods : {
    adminLogin(){
      axios.post('/admin/adminLogin',this.admin).then(
        (res)=>{
          if(res.data.code==="200"){
            console.log("Login Success");

            this.$router.push('/adminIndex');

          }
          if(res.data.code === "500"){
            console.log("Login Error");
            this.$message({
              dangerouslyUseHTMLString: true,
              message: '账号密码密码错误 (ΦДΦ；)',
              center: true
            });
          }
        }
      )
    }
  },
  data(){
   return{
     admin : {
       adminAccount : '',
       adminPassword : ''
     },
     ErrorDia : false,
     checked : false
   }
  }
}
</script>
<style scoped>
</style>
