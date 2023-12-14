<template>
  <div>
    <div><indexHead/></div>
    <el-divider></el-divider>

    <div style="margin: 0 8%">
      <el-row>
        <el-col :span="5">
          <div>
            <!--            <index-menu_top/>-->
            <indexMenu_left/>
          </div>
        </el-col>
        <el-col :span="19">
          <div style="margin: 0 5%">
            <div>
              <div v-for="a in art.articlesPOList" :key="a.id" @click="goArticlePage(a.articleId)" class="content">
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

    <div style="margin: 0 20%">

    </div>
    <indexFoot/>
  </div>
</template>

<script>
import axios from 'axios'
import indexHead from "../../components/indexCom/indexHead";
import indexMenu_left from "../../components/indexCom/indexMenu_left";
import indexFoot from "../../components/indexCom/indexFoot";
export default {
  name: 'SearchPage',
  components : {
    indexHead,indexMenu_left,indexFoot
  },
  created() {
    console.log(this.$route.query.key);
    axios.get('/article/selectArticlesByKey',{params : {key : this.$route.query.key}}).then((res)=>{
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
    box-shadow: 0 0px 1px rgba(0, 0, 0, .1), 0 0 6px rgba(0, 0, 0, .04);
    margin: 25px 0;
  }
</style>
