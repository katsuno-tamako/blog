<template>
    <div>
      <div>
        <el-form>
          <el-form-item>
            <template slot="label">DName:</template>
            <el-input v-model="dbpo.DName"  style="width: 500px"   maxlength="30" show-word-limit></el-input>
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
            ></mavon-editor>
          </el-form-item>

          <el-form-item>
            <el-button @click="updateC">提交</el-button>
          </el-form-item>


        </el-form>
      </div>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'adminEditDBPage',
  created() {
    axios.get('/DB/selectDBByDataId',{params:{DataId:this.$route.query.DataId}}).then(
      (res)=>{
        this.dbpo=res.data;
      }
    );
  },
  methods:{
    updateC(){
      console.log(this.dbpo);
      axios.post('/DB/updateDB',{
        DName : this.dbpo.DName,
        MainDClssify : this.dbpo.MainDClssify,
        SubDClassify : this.dbpo.SubDClassify,
        DContent : this.dbpo.DContent,
        DataId : this.dbpo.DataId,
      }).then();
      this.$router.push('/adminDBPage');
    },
    t(){
      axios.post('/test/test',this.dbpo).then();

    },
    upSuccess(pos, $file){
      console.log($file.response.url);
      this.article.articlesPO.coverImg = $file.response.url;
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
    }
  },
  data(){
    return{
      DataId : '',
      dbpo : {}
    }
  }
}
</script>
<style scoped>
</style>
