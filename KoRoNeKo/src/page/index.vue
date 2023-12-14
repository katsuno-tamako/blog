<template>
  <div>
    <div>
      <indexHead/>
    </div>
    <el-divider></el-divider>
    <div style="">
      <div style="margin: 0 8%">
        <el-row>
          <el-col :span="5">
            <div>
              <!--            <index-menu_top/>-->
              <indexMenu_left/>
            </div>
          </el-col>
          <el-col :span="19">
            <div class="content">
              <div>
                              <ArticleCoverCom/>
              </div>

              <div>
<!--                <showArticleCom/>-->
              </div>


            </div>
          </el-col>
        </el-row>
      </div>

    </div>


  <div>
    <indexFoot/>
  </div>

  </div>
</template>

<script>
import axios from 'axios'
import indexHead from "../components/indexCom/indexHead";
import indexMenu_left from "../components/indexCom/indexMenu_left";
import indexMenu_top from "../components/indexCom/indexMenu_top";
import showAllArticle from "../components/articlesCom/showAllArticle";
import ArticleCoverCom from "../components/articlesCom/ArticleCoverCom";
import indexFoot from "../components/indexCom/indexFoot";
import showArticleCom from "../components/articlesCom/showArticleCom";
export default {
  name: 'index',
  components : {
    indexMenu_top,showAllArticle,ArticleCoverCom,indexHead,indexMenu_left,indexFoot,showArticleCom
  },
  created() {
    axios.get('/visitor/plusVisitor',{params:{page:'index'}}).then();
  },
  data(){
    return{
      // loading: true
    }
  }
}
</script>
<style scoped>
  .content{
    margin: 0 5%;
  }
</style>
