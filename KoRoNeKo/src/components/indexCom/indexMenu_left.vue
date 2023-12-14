<template>
  <div>
    <div style="text-align: center; box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.1);width: 100%;border-radius: 15px;">
      <div style="padding-top: 20px">
          <img style="width: 100px;height: 100px;border-radius:50%; " src='../../assets/image/hd_1.jpg'/>
      </div>

      <div style="font-size: 20px;margin-top: 10px;color: #712747">
        NullPointer #ΦωΦ
      </div>


      <div style="margin: 40px 10%" class="introduction">
        {{introduction.introduction}}
      </div>
      <div>
        <el-row>
          <el-col :span="12">
            <el-card :body-style="{ padding: '0px' }"  shadow="hover">
              <div @click="toAlbumPage" style="height: 25px; cursor:pointer ;color: #426799;">
                <i class="el-icon-picture-outline-round"></i>
                相册
              </div>
            </el-card>
          </el-col>
          <el-col :span="12">
            <el-card :body-style="{ padding: '0px' }"  shadow="hover">
              <div @click="toDB" style="height: 25px; cursor:pointer;color: #426799; " >
                <i class="el-icon-tickets"></i>
                DB
              </div>
            </el-card>
          </el-col>
        </el-row>
      </div>


      <el-collapse style="margin-top: 20px">
        <el-collapse-item>
          <template slot="title">
            <div style="text-align: center;width: 100%;color: #426799;">
              <i class="el-icon-menu"></i>
              <span>Tag</span>
            </div>
          </template>
          <div v-for="main in mainClassify" :key="main.cid">
            <el-dropdown placement="right">
          <span @click="goClassify(main.classifyName)" style="font-size: 20px">
            <el-link>{{main.classifyName}}</el-link>
          </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item v-for="sub in main.subClassifyPOList" :key="sub.subid">
              <span @click="goSubClassify(sub.subClassifyName)">
                {{sub.subClassifyName}}
              </span>
                </el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>

        </el-collapse-item>
      </el-collapse>

      <div style="padding-bottom: 100px">

      </div>

    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'indexMenu_left',
  created() {
    axios.get('/article/selectAllArticleClassify').then((res)=>{this.mainClassify=res.data;});
    axios.get('/admin/selectAllIndexInfo').then((res)=>{this.introduction=res.data;});
  },
  methods : {
    goClassify(c){
      this.$router.push({path : '/classifyPage',query : {classifyName : c}});
      location.reload();
    },
    toDB(){
      this.$router.push('/DBIndex');
    },
    goSubClassify(c){
      console.log(c);
      this.$router.push({path : '/subClassifyPage',query : {classifyName : c}});
      location.reload();
    },
    toAlbumPage(){
      // this.$router.push('/albumPage')
      let text= this.$router.resolve({
        path: '/albumPage'
      });
      // 打开一个新的页面
      window.open(text.href, '_blank')
    }
  },
  data(){
    return{
      mainClassify : {
        subClassifyPoList : {}
      },
      introduction : {
        introduction : ''
      }
    }
  }
}
</script>
<style scoped>
  .el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }
  .introduction{
    font-size: 12px;
    color: #174f55;
    font-family: Monospace;
  }
</style>
