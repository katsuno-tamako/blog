<template>
  <div>
    <div>Add DB</div>
    <div>
      <el-form>
        <el-form-item>
          <template slot="label">DName:</template>
          <el-input v-model="dbpo.DName" style="width: 500px"   maxlength="30" show-word-limit></el-input>
        </el-form-item>
        <el-form-item>
          <template slot="label">Main Clssify:</template>
          <el-input v-model="dbpo.MainDClssify" style="width: 500px"   maxlength="30" show-word-limit></el-input>
        </el-form-item>
        <el-form-item>
          <template slot="label">Sub Classify:</template>
          <el-input v-model="dbpo.SubDClassify" style="width: 500px"   maxlength="30" show-word-limit></el-input>
        </el-form-item>
        <el-form-item>
          <mavon-editor
            ref="md"
            v-model="dbpo.DContent"
            @imgAdd="imgAdd"
            @save="saveNote"
          ></mavon-editor>
        </el-form-item>

        <el-form-item>
          <el-button @click="submitInfo">提交</el-button>
        </el-form-item>


      </el-form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'adminAddDBPage',
  methods : {
    submitInfo(){
      axios.post('/DB/insertDB',this.dbpo).then((res)=>{
        this.$alert('Add Success','Tip',{
          confirmButtonText : 'Confirm',
          callback:action => {
            this.$router.push('/adminDBPage');
          }
        })
      });
    },
    imgAdd(pos, $file) {
      let _this = this;
      let formData = new FormData();
      formData.append('image', $file);
      axios({
        url: 'admin/pid',
        method: 'post',
        data: formData,
        headers:
          {'Content-Type': 'multipart/form-data'}
      }).then((response) => {
        console.log(response);
        if (response.status === 200) {
          let url = response.data.url;
          _this.$refs.md.$img2Url(pos, url);
        }

        console.log("utl:"+this.url)
      })
    },
    saveNote(){
      axios.post('mkPage/addNote',this.note).then((res)=>{
        console.log(res.data.status);
      })
    },
  },
  data(){
    return{
      dbpo : {}
    }
  }
}
</script>
<style scoped>
</style>
