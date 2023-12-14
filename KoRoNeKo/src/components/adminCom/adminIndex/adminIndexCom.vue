<template>
  <div>
    <div style="margin: 20px">
      <div style="font-size: 30px">Home</div>
      <div style="
                  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
                  margin-top: 20px;
                  padding: 20px 0;
                ">
        <div style="margin: 10px;font-size: 20px">Hi~  {{admin.adminName}}</div>
        <div style="margin: 10px;font-size: 20px">Welcome to the console of Null Pointer!</div>
        <div  style="margin: 10px;font-size: 15px;color: gray">You can manage the website from here.</div>
      </div>




<!--      <div-->
<!--        style="box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);-->

<!--               margin-top: 20px;-->
<!--               padding: 20px 0;"-->
<!--      >-->
<!--        <div style="font-size: 20px;padding: 10px 0 0 20px;text-align: center">Click Top 5</div>-->
<!--        <el-divider></el-divider>-->
<!--        <el-row  style="padding: 20px;text-align: center">-->
<!--          <el-col :span="6">Name and Author</el-col>-->
<!--          <el-col :span="6">Date</el-col>-->
<!--          <el-col :span="6">Click Number</el-col>-->
<!--          <el-col :span="6"></el-col>-->
<!--        </el-row>-->
<!--        <div v-for="a in article" :key="a.id"-->
<!--             style="padding: 20px;text-align: center"-->
<!--        >-->
<!--&lt;!&ndash;          <el-divider></el-divider>&ndash;&gt;-->
<!--          <el-row>-->
<!--            <el-col :span="6">-->
<!--              <div style="font-size: 20px;font-weight: 500">-->
<!--                {{a.context_mainTitle}}-->
<!--              </div>-->
<!--              <div style="font-size: 13px;color: gray">-->
<!--                {{a.adminPO.adminName}}-->
<!--              </div>-->
<!--            </el-col>-->
<!--            <el-col :span="6">-->
<!--              <div>-->
<!--                {{a.date}}-->
<!--              </div>-->
<!--            </el-col>-->
<!--            <el-col :span="6">-->
<!--              {{a.article_gradePO.clickNum}}-->
<!--            </el-col>-->
<!--            <el-col :span="6">-->
<!--              <el-link @click="goArticlePage(a.articleId)">-->
<!--                <i class="el-icon-right"></i>-->
<!--              </el-link>-->
<!--            </el-col>-->
<!--          </el-row>-->
<!--        </div>-->
<!--      </div>-->

    </div>


    <div class="pic">
      <img
        src="../../../assets/image/adminIndex_2.png"
        style="height: 300px"
      />
    </div>

  </div>
</template>

<script>
import axios from 'axios'
import calenderCom from "./calenderCom";
import indexStatisticCom from "./indexStatisticCom";
export default {
  name: 'adminIndexCom',
  components : {
    calenderCom,indexStatisticCom
  },
  created() {
    axios.get('/admin/selectAdmin').then((res)=>{this.admin = res.data});
    axios.get('/article/selectArticleOrderByClickNum').then((res)=>{this.article = res.data});

  },
  methods : {
    goArticlePage(articleId){
      this.$router.push({path : '/article', query : {articleId : articleId}})
    }
  },
  data(){
    return{
      admin : {},
      article : {
        article_gradePO : {
          clickNum : ''
        }
      }

    }
  }
}
</script>
<style scoped>
  .pic{
    position: fixed;
    right: 10px;
    bottom : 0;
  }
</style>
