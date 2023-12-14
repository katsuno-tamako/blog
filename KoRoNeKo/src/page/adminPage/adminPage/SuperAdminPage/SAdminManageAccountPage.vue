<template>
  <div>
    <div style="margin: 0 2%">
      <el-card :body-style="{ padding: '0px' }">
        <div style="text-align: right">
          <el-button type="primary" size="mini" icon="el-icon-plus" @click="addA"></el-button>
        </div>
      </el-card>
    </div>
    <div style="margin: 0 2%">
      <el-table
        :data="admin"
      >
        <el-table-column
          prop="adminAccount"
          label="Account"
        ></el-table-column>

        <el-table-column
          prop="adminPassword"
          label="Password"
        ></el-table-column>

        <el-table-column
          prop="adminName"
          label="Name"
        ></el-table-column>

        <el-table-column
          prop="authority"
          label="authority"
        ></el-table-column>

        <el-table-column
          label="Operate"
        >
          <template slot-scope="scope">
            <el-button type="text" @click="delAcc(scope.row.adminId)">Delete</el-button>
          </template>
        </el-table-column>

      </el-table>
    </div>


    <el-dialog
      :visible.sync="addDialog"
    >
      <el-form>
        <el-form-item label="昵称"><el-input  v-model="adminPO.adminName"></el-input></el-form-item>
        <el-form-item label="账号"><el-input  v-model="adminPO.adminAccount"></el-input></el-form-item>
        <el-form-item label="密码"><el-input  v-model="adminPO.adminPassword"></el-input></el-form-item>
        <el-form-item label="权限"><el-input  v-model="adminPO.authority"></el-input></el-form-item>
        <el-form-item>
          <el-button @click="subAccount">Submit</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'SAdminManageAccountPage',
  created() {
    axios.get('/SAdmin/selectAllAdminInfo').then(
      (res)=>{
        this.admin = res.data;
      }
    )
  },
  methods : {
    addA(){
      this.addDialog = true;
    },
    delAcc(adminId){
      axios.get('/SAdmin/deleteAdminAccount',{params:{adminId:adminId}}).then((res)=>{
        axios.get('/SAdmin/selectAllAdminInfo').then(
          (res)=>{
            this.admin = res.data;
          }
        )
      })
    },
    subAccount(){
      axios.post('/SAdmin/insertAdmin',this.adminPO).then(
        (res)=>{
          axios.get('/SAdmin/selectAllAdminInfo').then(
            (res)=>{
              this.admin = res.data;
              this.addDialog=false;
            }
          )
        }
      );
    }
  },
  data(){
    return{
      admin : [],
      adminPO : {
        adminAccount : '',
        adminPassword : '',
        adminName : '',
        authority : ''
      },
      addDialog : false
    }
  }
}
</script>
<style scoped>
</style>
