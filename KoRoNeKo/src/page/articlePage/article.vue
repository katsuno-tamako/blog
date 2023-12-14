<template>
  <div>
    <div><ArticleHeaderCom/></div>
    <el-divider></el-divider>
    <div style="background-color: #ff734a;padding: 20px 0;margin: 20px 0">


      <div style="margin: 10px 10%;text-align: center;color: white">
        <div style="font-size: 28px;font-weight: normal">{{article.articlesPO.context_mainTitle}}</div>
      </div>

      <div style="text-align: center">
        <el-tag style="margin: 10px 0;background-color: white;color:#ff734a;font-weight: bolder " size="small">
          {{article.articlesPO.mainClassify}}
        </el-tag>
        <el-tag style="margin: 10px 0;background-color: white;color:#ff734a;font-weight: bolder " size="small">
          {{article.articlesPO.subClassify}}
        </el-tag>

      </div>
    </div>


    <el-row>
      <el-col :span="4" style="text-align: center">
              <div>
                <el-card style="width: 95%" shadow="never">
                  <div>
                    <el-image
                      :src="article.location+article.articlesPO.adminPO.adminImg"
                style="border-radius:50%;height: 80px;width: 80px;"
              ></el-image>
              <div style="font-weight: bolder;font-size: 18px">
                {{article.articlesPO.adminName}}
              </div>
              </div>
            <div style="font-size: 13px;color: gray">{{article.articlesPO.date}}</div>

          </el-card>
        </div>
      </el-col>
      <el-col :span="16">

        <div>

          <mavon-editor
            ref="md"
            :value="article.articlesPO.context"
            :subfield = "prop.subfield"
            :defaultOpen = "prop.defaultOpen"
            :toolbarsFlag = "prop.toolbarsFlag"
            :editable="prop.editable"
            :scrollStyle="prop.scrollStyle"
          >

          </mavon-editor>
        </div>




      </el-col>
      <el-col :span="4">
        <div style="font-size: 13px;text-align: center;color: gray">
          <span>点击量：</span>
          <span>
            {{article.articlesPO.article_gradePO.clickNum}}
          </span>
        </div>
      </el-col>
    </el-row>
    <div style="height: 300px">
      <div>

      </div>
    </div>

  </div>
</template>

<script>
import axios from 'axios';
import indexHead from "../../components/indexCom/indexHead";
import ArticleHeaderCom from "../../components/articlesCom/ArticleHeaderCom";
export default {
  name: 'article',
  components : {
    indexHead,ArticleHeaderCom
  },
  created() {
    this.articleId = this.$route.query.articleId;
    axios.get('/article/selectArticleById',{params : {articleId : this.$route.query.articleId}}).then(
      (res)=>{
        this.article = res.data;
        axios.get('/article/plusArticleClick',{params:{articleId:this.$route.query.articleId}}).then()
      }
    );



  },
  computed: {
    prop () {
      let data = {
        subfield: false,// 单双栏模式
        defaultOpen: 'preview',//edit： 默认展示编辑区域 ， preview： 默认展示预览区域
        editable: false,
        toolbarsFlag: false,
        scrollStyle: true
      };
      return data
    }
  },
  data(){
    return{
      articleId : '',
      article : {
        articlesPO : {
          adminPO : ''
        },
        location : ''
      }
    }
  }
}
</script>
<style scoped>
</style>
