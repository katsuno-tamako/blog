<template>
  <div>
    <div>

      <div style="font-size: 30px;margin: 10px 0 0 30px">
        主页设置
      </div>

      <div style="margin: 20px 0 0 30px">
        <span>修改主页介绍：</span>
        <el-button @click="openIntroDia" size="mini" icon="el-icon-edit"></el-button>
      </div>

      <el-dialog
        :visible.sync="introDia"
      >
        <el-form>
          <el-form-item label="主页信息">
            <el-input type="textarea" v-model="IndexInfoPO.introduction"></el-input>
          </el-form-item>

          <el-form-item>
            <el-button @click="updateIntro">提交</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>

      <div style="margin: 20px 0 0 30px">
        <span>修改联系方式：</span>
        <el-button @click="openContact" size="mini" icon="el-icon-edit"></el-button>
      </div>

      <el-dialog
        :visible.sync="contactDia">
        <el-form>
          <el-form-item label="Email">
            <el-input v-model="IndexInfoPO.email"></el-input>
          </el-form-item>
          <el-form-item label="GitHubUrl">
            <el-input v-model="IndexInfoPO.gitHubUrl"></el-input>
          </el-form-item>
          <el-form-item label="QQ">
            <el-input v-model="IndexInfoPO.qq"></el-input>
          </el-form-item>
          <el-form-item label="BiliBili">
            <el-input v-model="IndexInfoPO.biliBili"></el-input>
          </el-form-item>
          <el-form-item label="weibo">
            <el-input v-model="IndexInfoPO.weibo"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button @click="updateContact">确定</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>

    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'SAdminIndexManagePage',
  created() {
  },
  methods : {
    openIntroDia(){
      axios.get('/admin/selectAllIndexInfo').then((res)=>{this.IndexInfoPO = res.data;console.log(this.IndexInfoPO)});
      this.introDia = true;
    },
    openContact(){
      axios.get('/admin/selectAllIndexInfo').then((res)=>{this.IndexInfoPO = res.data;console.log(this.IndexInfoPO)});
      this.contactDia = true;
    },
    updateContact(){
      axios.post('/admin/updateIndexInfo',this.IndexInfoPO).then((res)=>{
        this.contactDia = false;
      })
    },
    updateIntro(){
      axios.post('/admin/updateIndexInfo',this.IndexInfoPO).then((res)=>{
        this.introDia = false;
      })
    }
  },
  data(){
    return{
      introDia : false,
      contactDia : false,
      IndexInfoPO : {
        Introduction : ''
      }
    }
  }
}
</script>
<style scoped>
</style>
