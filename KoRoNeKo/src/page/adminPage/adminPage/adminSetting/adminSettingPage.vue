<template>
  <div style="padding: 20px;">
    <div style="box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)">

      <div style="padding: 20px;font-size: 25px;font-weight: bolder">
        设置
      </div>

      <el-divider></el-divider>

      <div style="margin: 10px 10px">
        <editAdminNameCom/>
      </div>

      <div style="margin: 10px 10px">
        <editAdminImg/>
      </div>



      <div style="margin:10px 10px">
        <el-button @click="rePasswordDialog = true">更改密码</el-button>
        <el-dialog
          :visible.sync="rePasswordDialog">
          <el-form>
            <el-form-item label="新密码">
              <el-input v-model="newPassword" show-password maxlength="16"
                        show-word-limit></el-input>
            </el-form-item>
            <el-form-item label="确认密码">
              <div v-if="new_2_password!='' && newPassword!=new_2_password"
                style="font-size: 12px;color: red"
              >请输入相同的密码!</div>
              <el-input v-model="new_2_password" show-password maxlength="16"
                        show-word-limit></el-input>
            </el-form-item>
            <el-form-item>
              <el-button
                :disabled="!new_2_password || !newPassword || newPassword!=new_2_password"
                @click="changePassword"
              >确定</el-button>
            </el-form-item>
          </el-form>

        </el-dialog>


        <el-divider></el-divider>

      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import editAdminImg from "../../../../components/adminCom/adminSetting/editAdminImg";
import editAdminNameCom from "../../../../components/adminCom/adminSetting/editAdminNameCom";
export default {
  name: 'adminSettingPage',
  components : {
    editAdminImg,editAdminNameCom
  },
  created() {
  },
  methods:{
    changePassword(){
      axios.get('/admin/changePassword',{params:{newPassword : this.newPassword}}).then(
        (res)=>{
          this.$alert('Change Password Success', 'Tip', {
            confirmButtonText: 'OK',
            callback: action => {
              this.$router.push('adminLogin');
            }
          });
        }
      )
    }
  },
  data(){
    return{
      rePasswordDialog : false,
      newPassword : '',
      new_2_password : ''
    }
  }
}
</script>
<style scoped>
</style>
