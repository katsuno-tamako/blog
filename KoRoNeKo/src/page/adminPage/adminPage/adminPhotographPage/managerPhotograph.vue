<template>
  <div>
    <div>
      <el-card>
        <el-button @click="uploadImageDialog = true">添加图片</el-button>
        <el-button @click="createAlbumDialog = true">添加相册</el-button>

        <el-dialog
          :visible.sync="uploadImageDialog">
          <div>
            <div style="box-shadow: 0 1px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);padding: 20px">
              <div>
                <el-button @click="insertPhoto">
                  提交
                </el-button>
              </div>
              <el-divider></el-divider>
              <div>
                <span>图片名称：</span>
                <el-input style="width: 50%;margin: 10px 0" v-model="photograph.imageName"></el-input>
              </div>
              <div>
                <span>图片种类：</span>
                <el-input style="width: 50%;margin: 10px 0" v-model="photograph.imageClassify"></el-input>
              </div>

              <div>
                <span>选择相册：</span>

                <el-select v-model="photograph.album">
                  <el-option
                             v-for="a in albums" :key="a.aid"
                             :value="a.albumId" :label="a.albumName">
                  </el-option>
                </el-select>
              </div>

              <div>
                <span >图片介绍：</span>
                <el-input style="width: 50%;margin: 10px 0" v-model="photograph.imageIntroduction" type="textarea"></el-input>
              </div>

            </div>
            <el-row>
              <el-col :span="4">
                <div style="margin: 20px 10px">
                  <el-upload
                    ref="up-load"
                    :auto-upload="true"
                    :action="serverUrl+'/photographController/uploadPicture'"
                    :on-success="upSuccess"
                    :limit="1"
                  >
                    <el-button size="small" type="primary">选择图片</el-button>
                  </el-upload>
                </div>
              </el-col>
              <el-col :span="20">
                <el-image
                  :src="severLocal+photograph.imagePath"
                >
                  <div slot="error" style="text-align: center">

                  </div>
                </el-image>
              </el-col>
            </el-row>
          </div>
        </el-dialog>

        <el-dialog :visible.sync="createAlbumDialog">
          <el-input placeholder="请输入相册名" v-model="albumsPO.albumName"></el-input>
          <el-button @click="createAlbum">添加</el-button>
        </el-dialog>

      </el-card>
    </div>
    <div>
      <el-row>
        <el-col :span="6" v-for="a in albums" :key="a.aid">
          <el-card :body-style="{ padding: '0px' }" style="height: 330px;margin: 20px" >
            <div @click="showImage(a.albumId)" style="width: 100%;height: 300px;text-align: center">
              <el-image
                :src="serverUrl+a.coverImage"
                style="height: 250px;margin-top: 10px"
                fit="fill"
              ></el-image>
              <div>
                {{a.albumName}}
              </div>
            </div>
            <div>
              <div style="text-align: right;margin-right: 10px">
                <el-link @click="deleteAlbun(a.albumId)">删除相册</el-link>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>


    <el-dialog
      :visible.sync="showAlbums"
      style="width: 100%"
      width="90%"
    >
      <div>
        <div>
          <div>
            <el-divider></el-divider>
          </div>
          <el-row>
            <el-col :span="6" v-for="a in albumsImage.photographPOS" :key="a.pid">
              <el-card :body-style="{ padding: '0px' }" style="margin: 10px;text-align: center">
                <div style="font-size: 12px;color: #712747">{{a.imageDate}}</div>
                <el-image
                  :src="albumsImage.localURL+a.imagePath"
                  style="height: 200px"
                  fit="fill"
                ></el-image>

                <div style="font-size: 18px;margin:5px 0 0 0">
                  {{a.imageName}}
                </div>
                <div style="font-size: 14px">
                  {{a.imageClassify}}
                </div>
                <div style="font-size: 10px;color: slategrey;height: 30px">
                  {{a.imageIntroduction}}
                </div>
                <div>
                  <el-link @click="setAlbumCover(a.imagePath,a.album)">设置为封面</el-link>
                </div>
                <div>
                  <el-link @click="deleteAlbumImage(a.pid,a.album,a.imagePath)">删除</el-link>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </div>
      </div>
    </el-dialog>

    <el-divider></el-divider>
    <div>

    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'managerPhotograph',
  created() {
    axios.get('/photographController/selectAllAlbums').then((res)=>{this.albums = res.data});
    axios.get('/request/getLocal').then((res)=>{this.serverUrl = res.data});
  },
  methods:{
    createAlbum(){
      axios.post('/photographController/createNewAblums',this.albumsPO).then(
        (res)=>{
          this.createAlbumDialog = false;
          location.reload();
        }
      );
    },
    showImage(a){
      this.showAlbums = true;
      console.log("--");
      axios.get('/photographController/selectPhotoByAlbum',{params : {album : a}}).then(
        (res)=>{
          this.albumsImage = res.data;
        }
      )
    },
    upSuccess(pos, $file){
      console.log($file.response.url);
      console.log();
      this.severLocal = $file.response.localUrl;
      this.photograph.imagePath = $file.response.url;
    },
    insertPhoto(){
      axios.post('/photographController/insertPhoto',this.photograph).then((res)=>{location.reload()})
    },
    setAlbumCover(imagePath,album){
      axios.get('/photographController/setAlbumCover',{params:{imagePath:imagePath,album:album}}).then(
        (res)=>{
          this.$notify({
            title:'Tip',
            message:'封面设置成功'
          })
        }
      );
    },
    deleteAlbun(a){
      axios.get('/photographController/deleteAlbumByAlbumId',{params : {albumId:a}}).then(
        (res)=>{
          axios.get('/photographController/selectAllAlbums').then((res)=>{this.albums = res.data});

        }
      )
    },
    deleteAlbumImage(pid,a,path){
      axios.get('/photographController/deleteAlbumImageByPid',{params : {pid:pid,path:path}}).then(
        (res)=>{
          axios.get('/photographController/selectPhotoByAlbum',{params : {album : a}}).then(
            (res)=>{
              this.albumsImage = res.data;
            }
          )
        }
      )
    }
  },
  watch : {
    showAlbums : function (value) {
      if(value === false){
        axios.get('/photographController/selectAllAlbums').then((res)=>{this.albums = res.data});

      }
    }
  },
  data(){
    return{
      uploadImageDialog : false,
      createAlbumDialog : false,
      showAlbums : false,
      albums : {},
      serverUrl : '',
      albumsPO : {
        aid : '',
        albumName : '',
        coverImage : '',
        albumId : ''
      },
      albumsImage : {
        localURL : '',
        photographPOS : {
          pid : ''
        }
      },
      photograph : {
        imageName : '',
        imageClassify : '',
        imageIntroduction : '',
        album : '',
        imagePath : ''
      },
      severLocal : '',
      openAlbumAid : ''
    }
  }
}
</script>
<style scoped>
</style>
