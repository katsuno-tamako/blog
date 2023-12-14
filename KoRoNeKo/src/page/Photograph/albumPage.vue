<template>
  <div>
<!--    <div style="position: relative;width: 100%">-->
<!--      <div style="position: absolute;z-index: 100;width: 100%">-->
<!--        <albumHeaderCom/>-->
<!--  &lt;!&ndash;      <index-head/>&ndash;&gt;-->
<!--      </div>-->
<!--      <div style="z-index: 10">-->
<!--        <el-carousel autoplay="true" height="850px" interval="4000">-->
<!--          <el-carousel-item v-for="i in albumsCarousel" :key="i.id">-->
<!--            <el-image-->
<!--              :src="local+i.path"-->
<!--            ></el-image>-->
<!--          </el-carousel-item>-->
<!--        </el-carousel>-->
<!--      </div>-->
<!--    </div>-->

    <div style="position: relative;width: 100%">
      <div style="position: absolute;z-index: 100;width: 100%">
        <albumHeaderCom/>
      </div>
      <img src="../../assets/image/albums_index2.jpg"
        width="100%"
      >
    </div>

    <div>
      <el-divider></el-divider>
    </div>

    <div v-for="a in albums" :key="a.aid" style="margin-top: 100px">
      <div style="text-align: center;font-size: 26px;font-weight: 700">
        {{a.albumName}}
      </div>
      <div style="margin: 10px 5%">
<!--        -->
        <el-row type="Grid">
        <el-col :span="8" v-for="p in a.photographPOList" :key="p.pid" style="text-align: center">
            <el-card :body-style="{ padding: '0px' }" style="margin: 20px" shadow="hover" >
              <el-image
                :src="local+p.imagePath"
                style="width: 100%"
                @click="openDraw(local+p.imagePath,p)"
                lazy
              >
              </el-image>
              <div style="margin: 20px 0 30px 20px;text-align: left;font-size: 20px">
                {{p.imageName}}
              </div>

            </el-card>
        </el-col>
      </el-row>
<!--        -->
      <el-divider></el-divider>
      </div>
    </div>

    <div>

    </div>

    <el-drawer
      :visible.sync="drawer"
      size="80%"
      :show-close="false"
    >
      <div style="">
        <el-row :gutter="20">
          <el-col :span="18" style="text-align: center">
            <el-image
              :src="imagePath"
              style="height: 700px"
              fit="contain"
              :preview-src-list="[imagePath]"
            >
            </el-image>
          </el-col>
          <el-col :span="6">
            <div style="font-size: 30px">
              {{chooseImage.imageName}}
            </div>
            <div style="font-size: 15px;color: slategrey;margin-top: 10px">
              {{chooseImage.author}}
              |
              {{chooseImage.imageDate}}
            </div>
            <div style="margin-top: 10px">
              {{chooseImage.imageIntroduction}}
            </div>

          </el-col>
        </el-row>

      </div>


    </el-drawer>
  </div>
</template>

<script>
import axios from 'axios'
import indexHead from "../../components/indexCom/indexHead";
import albumHeaderCom from "../../components/PhotographCom/albumHeaderCom";
export default {
  name: 'albumPage',
  components : {indexHead,albumHeaderCom},
  created() {
    axios.get('/photographController/selectAlbumsAndImg').then((res)=>{this.albums = res.data});
    axios.get('/request/getLocal').then((res)=>{this.local = res.data});
    axios.get('/photographController/selectImage').then((res)=>{this.albumsCarousel = res.data});
  },
  methods : {
    openDraw(imagePath,chooseImage){
      this.drawer = true;
      this.imagePath = imagePath;
      this.chooseImage = chooseImage;
    }
  },
  data(){
    return{
      albums : {
        photographPOList : {}
      },
      local : '',
      albumsCarousel : '',
      drawer : false,
      imagePath : '',
      chooseImage : ''
    }
  }
}
</script>
<style scoped>

</style>
