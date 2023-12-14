<template>
  <div>

    <div v-for="a in art.articlesPOList" :key="a.id" @click="goArticlePage(a.articleId)">
<!--      <div v-if="a.isCover != 'true'" >-->

      <div  class="content">
        <el-card shadow="hover" :body-style="{padding:'0px'}" style="height:120px; cursor:pointer;" >

          <el-row>
            <el-col :span="20">
              <div style="font-size: 20px;margin: 10px 0 0 10px;">{{a.context_mainTitle}}</div>
              <div style="font-size: 14px;margin: 5px 0 0 10px;color:gray">
                {{a.context_subTitle}}
              </div>
              <div style="font-size: 12px;margin: 5px 0 0 10px;color:gray;">
                {{a.adminPO.adminName}}
              </div>
              <div style="font-size: 12px;margin: 20px 0 0 10px;color:gray;">
                {{a.date}}
              </div>
            </el-col>
            <el-col :span="4">
              <el-tag style="margin-top: 35px;background-color: #ff6886;color: white" size="small">
                {{a.mainClassify}}
                &nbsp;
                {{a.subClassify}}
              </el-tag>
            </el-col>
          </el-row>

        </el-card>
      </div>
    </div>



  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'ArticleCoverCom',
  created() {
    axios.get('/article/selectAllArticle').then((res)=>{
      console.log(res);
      this.art = res.data;
      console.log(this.art.location)
    });

  },
  methods : {
    goArticlePage(articleId){
      this.$router.push({path : '/article', query : {articleId : articleId}})
    }
  },
  data(){
    return{
      art : {
        location : '',
        articlesPOList : {
          articleId : '',
          adminName : ''
        }
      },
      nowTime : ''
    }
  }
}
</script>
<style scoped>
  .content{
    box-shadow: 0 0px 1px rgba(0, 0, 0, .1), 0 0 6px rgba(0, 0, 0, .04);
    margin: 10px 0;
  }
</style>
