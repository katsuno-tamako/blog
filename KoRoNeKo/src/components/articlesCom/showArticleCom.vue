<template>
  <div>
    <div style="height: 680px">
      <div v-for="a in articlesPOList" :key="a.id" @click="goArticlePage(a.articleId)">
        <!--      <div v-if="a.isCover != 'true'" >-->

        <div  class="content">
          <el-card shadow="hover" :body-style="{padding:'0px'}"
                   style="height:120px; cursor:pointer;border-radius: 10px;background-color: #00ffff" >

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
  <!--{{articlesPOList}}-->

    <div class="block">
      <el-pagination
        background
        :pager-count="11"
        layout="prev, pager, next"
        :page-size="5"
        :total="articleNum"
        :current-page.sync="current_page"
        @current-change="change"
      >

      </el-pagination>
    </div>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'showArticleCom',
  created() {
    axios.get('/article/selectArticNumber').then(
      (res)=>{
        this.articleNum=res.data;
        axios.get('/article/selectArticleByLimt',{params:{page:1,size:5}}).then(
          (res)=>{
            this.articlesPOList = res.data;
          }
        );

      });
  },
  methods : {
    change(){
      console.log(this.current_page);
      axios.get('/article/selectArticleByLimt',{params:{page:this.current_page,size:5}}).then(
        (res)=>{
          this.articlesPOList = res.data;
        }
      );
    },
    goArticlePage(articleId){
      this.$router.push({path : '/article', query : {articleId : articleId}})
    }
  },
  data(){
    return{
      articleNum : '',
      pageTotal : '',
      current_page : 1,
      articlesPOList : {
        articleId : '',
        adminName : ''
      }
    }
  }
}
</script>
<style scoped>
  .content{
    box-shadow: 0 0px 1px rgba(0, 0, 0, .1), 0 0 6px rgba(0, 0, 0, .04);
    margin: 10px 0;
    border-radius: 10px;
  }
</style>
