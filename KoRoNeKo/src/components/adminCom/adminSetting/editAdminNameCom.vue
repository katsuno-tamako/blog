<template>
  <div>
    <el-button @click="openDialog">
      更改昵称
    </el-button>

    <el-dialog
      :visible.sync="dialog"
    >
      <el-form>
        <el-form-item>
          <span>当前昵称：{{admin.adminName}}</span>
        </el-form-item>

        <el-form-item label="新的昵称">
          <el-input v-model="newName"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button @click="up">确定</el-button>
        </el-form-item>

      </el-form>
    </el-dialog>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'editAdminNameCom',
  created() {

  },
  methods : {
    openDialog(){
      this.dialog = true;
      this.newName = '';
      axios.get('/admin/selectAdmin').then(
        (res)=>{
          this.admin = res.data;
        }
      )
    },
    up(){
      axios.get('/admin/changeName',{params:{newName:this.newName}}).then();
      this.dialog = false;
    }
  },
  data(){
    return{
      dialog : false,
      admin : {},
      newName : ''
    }
  }
}
</script>
<style scoped>
</style>
