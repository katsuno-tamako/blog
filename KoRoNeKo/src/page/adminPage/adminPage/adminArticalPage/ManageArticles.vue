<template>
  <div>
    <div>
      <el-divider>
        <div style="font-size: 30px">
          Manage Articles
        </div>
      </el-divider>

    </div>
    <div>

<!--        <el-card-->
<!--          :body-style="{ padding: '0px' }"-->
<!--          v-for="a in article.articlesPOList" :key="a.id" shadow="never"-->
<!--          style="margin: 10px 10px;height: 100px">-->
<!--          <div style="font-size: 11px;width: 100%;background-color: #ffe0c2;">-->
<!--            <span style="margin-left: 10px">{{a.date}}</span>-->
<!--          </div>-->
<!--          <div>-->
<!--            <el-row>-->
<!--              <el-col :span="20">-->
<!--                <div style="margin-left: 20px">-->
<!--                  <div style="font-size: 20px;margin-top: 3px">{{a.context_mainTitle}}</div>-->
<!--                  <div style="font-size: 15px;margin-top: 3px">{{a.context_subTitle}}</div>-->
<!--                  <div style="font-size: 15px;margin-top: 3px">{{a.adminName}}</div>-->
<!--                </div>-->
<!--              </el-col>-->
<!--              <el-col :span="2">-->
<!--                <el-button icon="el-icon-edit" circle @click="editArticle(a.articleId)" style="margin-top: 25px"></el-button>-->
<!--              </el-col>-->
<!--              <el-col :span="2">-->
<!--                <el-button icon="el-icon-delete" circle @click="deleteArticle(a.articleId)" style="margin-top: 25px"></el-button>-->
<!--              </el-col>-->
<!--            </el-row>-->
<!--          </div>-->
<!--        </el-card>-->

    </div>
    <div style="margin: 0 10px">
    <el-table
      :data="article.articlesPOList"
      border
      style="width: 100%"
    >
      <el-table-column
        fixed
        prop="date"
        label="Date"
        sortable
      ></el-table-column>
      <el-table-column
        prop="context_mainTitle"
        label="Title"
        sortable
      ></el-table-column>
      <el-table-column
        prop="mainClassify"
        label="Classify"
        sortable
      ></el-table-column>
      <el-table-column
        prop="subClassify"
        label="subClassify"
        sortable
      ></el-table-column>
      <el-table-column
        prop="adminName"
        label="Author"
        sortable
      ></el-table-column>
      <el-table-column
        fixed="right"
        label="Operation"
        width="100"
      >
        <template slot-scope="scope">
          <el-button @click="editArticle(scope.row.articleId)" type="text" size="small">Edit</el-button>
          <el-button @click="deleteArticle(scope.row.articleId)" type="text" size="small">Delete</el-button>
        </template>
      </el-table-column>

    </el-table>

    </div>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'ManageArticles',
  created() {
    axios.get('/article/selectAllArticle').then(
      (res)=>{
        this.article = res.data;
      }
    );
  },
  methods : {
    deleteArticle(articleId){

      this.$alert('是否删除该文章','Tip',{
        confirmButtonText: 'Confirm',
        callback:action => {
          axios.get('/article/deleteArticle',{params : {articleId : articleId}}).then(
            (res=>{
              axios.get('/article/selectAllArticle').then(
                (res)=>{
                  this.article = res.data;
                }
              );
            })
          );
        }
      });



      },
    editArticle(articleId){
      this.$router.push({path : '/EditArticlePage', query : {articleId : articleId}})
    }
  },
  data(){
    return{
      article : {
        articlesPOList : [],
        location : ''
      }
    }
  }
}
</script>
<style scoped>
  a{
    color: black;
    text-decoration: none;
  }
</style>
