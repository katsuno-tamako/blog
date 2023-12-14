<template>
  <div>
    <div>
      <indexHead/>
    </div>
    <el-divider></el-divider>
    <div style="margin: 0 10%">
      <el-row>
        <el-col :span="4">
          <div>
            <indexMenu_left/>
          </div>
        </el-col>
        <el-col :span="20">
          <div class="content" style="margin: 0 5%">
            <div>
              <div v-for="a in art.articlesPOList" :key="a.id" @click="goArticlePage(a.articleId)" class="content">

<!--                <div v-if="a.isCover != 'true'" >-->
<!--                  <el-divider></el-divider>-->
<!--                  <div style="height: 50px;">-->
<!--                    <div style="font-size: 20px">{{a.context_mainTitle}}</div>-->
<!--                    <div>{{a.date}}</div>-->
<!--                  </div>-->

<!--                </div>-->

                <el-card shadow="hover" :body-style="{padding:'0px'}" style="height:120px;">
                  <el-row>
                    <el-col :span="20">
                      <div style="font-size: 20px;margin: 10px 0 0 10px;">{{a.context_mainTitle}}</div>
                      <div style="font-size: 14px;margin: 5px 0 0 10px;color: #174f55">{{a.context_subTitle}}</div>
                      <div style="font-size: 12px;margin: 5px 0 0 10px;color:gray;">
                        {{a.adminPO.adminName}}
                      </div>
                      <div style="font-size: 12px;margin: 20px 0 0 10px">{{a.date}}</div>
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
        </el-col>
      </el-row>
    </div>

    <indexFoot/>

  </div>
</template>

<script>
import indexMenu_top from "../../components/indexCom/indexMenu_top";
import showAllArticle from "../../components/articlesCom/showAllArticle";
import ArticleCoverCom from "../../components/articlesCom/ArticleCoverCom";
import indexHead from "../../components/indexCom/indexHead";
import indexMenu_left from "../../components/indexCom/indexMenu_left";
import indexFoot from "../../components/indexCom/indexFoot";
import axios from "axios";
export default {
  name: 'classifyPage',
  components : {
    indexMenu_top,showAllArticle,ArticleCoverCom,indexHead,indexMenu_left,indexFoot
  },
  created() {
    console.log(this.$route.query.classifyName);

    axios.get('/article/selectArticleByClassify',{params : {classify : this.$route.query.classifyName}}).then((res)=>{
      this.art = res.data;
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
      }
    }
  }
}
</script>
<style scoped>
  .content{
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    margin: 25px 0;
  }
</style>
