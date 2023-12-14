<template>
  <div>
    <el-card>
      <div>设置Album Page 轮播图片</div>
      <div>
        <el-upload
          :action="sUrl+'/photographController/upImageToCarousel'"
          :on-success="selectAlbumCarousel"
        >
          <el-button size="small" type="primary">点击上传</el-button>
        </el-upload>
      </div>
    </el-card>
    <el-card>
      <div v-for="a in albumsCarousel" :key="a.id" style="height: 200px;text-align: center">
        <el-row>
          <el-col :span="12">
            <el-image
              :src="sUrl+a.path"
              style="height: 180px"
              :preview-src-list="[sUrl+a.path]"
            ></el-image>
          </el-col>
          <el-col :span="12">
            <el-button @click="del(a.id,a.path)">删除</el-button>
          </el-col>
        </el-row>

      </div>
    </el-card>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'photographSettingPage',
  created() {
    axios.get('/request/getLocal').then((res)=>{this.sUrl = res.data});
    axios.get('/photographController/selectImage').then((res)=>{this.albumsCarousel = res.data});
  },
  methods : {
    selectAlbumCarousel(){
      axios.get('/photographController/selectImage').then((res)=>{this.albumsCarousel = res.data});
    },
    del(id,path){
      this.$alert('是否删除','Tip',{
        confirmButtonText : 'Confirm',
        callback : action => {
          axios.get('/photographController/deleteAlbumCarousel',{params:{id:id,path:path}}).then(
            (res)=>{
              axios.get('/photographController/selectImage').then((res)=>{this.albumsCarousel = res.data});
            }
          );
        }
      });

    }
  },
  data(){
    return{
      sUrl : '',
      albumsCarousel : ''
    }
  }
}
</script>
<style scoped>
</style>
s
