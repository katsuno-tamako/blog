<template>
  <div>
    <div style="margin: 10px">
      <div style="font-size: 20px">
        <el-page-header @back="goBack" content="详情页面">
        </el-page-header>
      </div>
      <el-divider></el-divider>
      <el-form>
        <el-form-item style="margin-left: 10px">
          <template slot="label">添加主标题：</template>
          <el-input v-model="article.articlesPO.context_mainTitle" maxlength="10" show-word-limit style="width: 500px" :value="article.articlesPO.context_mainTitle"></el-input>
        </el-form-item>

        <el-form-item style="margin-left: 10px">
          <template slot="label">添加副标题：</template>
          <el-input v-model="article.articlesPO.context_subTitle" maxlength="20" show-word-limit style="width: 500px" :value="article.articlesPO.context_subTitle"></el-input>
        </el-form-item>

        <el-form-item style="margin-left: 10px">
          <template slot="label">文章分类：</template>
          <el-select placeholder="请选择主分类"
                     @change="showSub_Classify"
                     v-model="article.articlesPO.mainClassify" :value="article.articlesPO.mainClassify">
            <el-option
              v-for="main in mainClassify"
              :key="main.cid"
              :value="main.classifyName"
              :label="main.classifyName"
            >
            </el-option>
          </el-select>

          <el-select placeholder="请选择子分类" v-model="article.articlesPO.subClassify" :value="article.articlesPO.mainClassify">
            <el-option

              v-for="sub in subClassify"
              :key="sub.value"
              :value="sub.subClassifyName"
              :label="sub.subClassifyName"
            >
            </el-option>
          </el-select>
        </el-form-item>

<!--        <el-form-item style="margin-left: 10px">-->
<!--          <template slot="label">添加标签：</template>-->
<!--          <el-select-->
<!--            v-model="article.articlesPO.context_label"-->
<!--            :value="article.articlesPO.context_label"-->
<!--            multiple-->
<!--            filterable-->
<!--            allow-create-->
<!--            default-first-option-->
<!--            placeholder="请确定标签"-->
<!--          >-->
<!--            <el-option-->
<!--              v-for="l in label" :key="l.label"-->
<!--              :label="l.label"-->
<!--              :value="l.label"-->
<!--            >-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->

<!--        <el-form-item style="margin-left: 10px">-->
<!--          <template slot="label">是否可以评论</template>-->
<!--          <el-switch-->
<!--            v-model="article.articlesPO.isComment"-->
<!--            active-value="true"-->
<!--            inactive-value="false"-->
<!--          ></el-switch>-->
<!--        </el-form-item>-->

<!--        <el-form-item style="margin-left: 10px">-->
<!--          <template slot="label">选择封面</template>-->
<!--          <el-row>-->
<!--            <el-col :span="12">-->
<!--              <el-switch-->
<!--                v-model="article.articlesPO.isCover"-->
<!--                :value="article.articlesPO.isCover"-->
<!--                active-value="true"-->
<!--                inactive-value="false"-->
<!--              ></el-switch>-->
<!--            </el-col>-->
<!--            <el-col :span="12">-->

<!--&lt;!&ndash;              <div v-if="article.articlesPO.isCover === 'true'">&ndash;&gt;-->
<!--&lt;!&ndash;                <el-button @click="showImgDialog = true">查看当前封面图片</el-button>&ndash;&gt;-->
<!--&lt;!&ndash;                <el-dialog&ndash;&gt;-->
<!--&lt;!&ndash;                  :visible.sync="showImgDialog"&ndash;&gt;-->
<!--&lt;!&ndash;                >&ndash;&gt;-->
<!--&lt;!&ndash;                  <div>&ndash;&gt;-->
<!--&lt;!&ndash;                    <el-image&ndash;&gt;-->
<!--&lt;!&ndash;                      :src="article.location+article.articlesPO.coverImg"&ndash;&gt;-->
<!--&lt;!&ndash;                    ></el-image>&ndash;&gt;-->
<!--&lt;!&ndash;                  </div>&ndash;&gt;-->
<!--&lt;!&ndash;                  <el-button @click="showImgDialog = false">确定</el-button>&ndash;&gt;-->
<!--&lt;!&ndash;                </el-dialog>&ndash;&gt;-->

<!--&lt;!&ndash;                <el-upload&ndash;&gt;-->
<!--&lt;!&ndash;                  ref="up-load"&ndash;&gt;-->
<!--&lt;!&ndash;                  :auto-upload="true"&ndash;&gt;-->
<!--&lt;!&ndash;                  action="http://localhost:8113/article/uploadCover"&ndash;&gt;-->
<!--&lt;!&ndash;                  :on-success="upSuccess"&ndash;&gt;-->
<!--&lt;!&ndash;                >&ndash;&gt;-->
<!--&lt;!&ndash;                  <el-button slot="trigger" size="small" type="primary">选取文件</el-button>&ndash;&gt;-->
<!--&lt;!&ndash;                </el-upload>&ndash;&gt;-->

<!--&lt;!&ndash;              </div>&ndash;&gt;-->

<!--            </el-col>-->
<!--          </el-row>-->
<!--        </el-form-item>-->

        <el-form-item>
          <div>
            <mavon-editor
              ref="md"
              v-model="article.articlesPO.context"
              :value="article.articlesPO.context"
              @imgAdd="imgAdd"

            ></mavon-editor>
          </div>

        </el-form-item>

        <el-form-item>
          <el-button @click="updateArticle" type="primary">提交</el-button>
        </el-form-item>

      </el-form>
    </div>
  </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'EditArticlePage',
  created() {
    axios.get('/article/selectArticleById',{params : {articleId : this.$route.query.articleId}}).then(
      (res)=>{
        this.article = res.data;
      }
    );

    axios.get('/admin/selectAllLabel').then((res)=>{this.label = res.data;});


    axios.get('/article/selectAllArticleClassify').then((res)=>
    {
      this.mainClassify = res.data;
      console.log(res.data);
    });

  },
  methods : {
    goBack(){
      this.$router.go(-1);
    },
    updateArticle(){
      axios.post('/article/updateArticleById',this.article.articlesPO).then();
      this.$router.push('/ManageArticles')
    },
    showSub_Classify(value){
      console.log(value);
      axios.get('/classify/selectSubClassifyByName',{params:{classifyName:value}}).then(
        (res)=>{
          this.subClassify = res.data;
          console.log(res);
        }
      )
    },
    upSuccess(pos, $file){
      console.log($file.response.url);
      this.article.articlesPO.coverImg = $file.response.url;
    },
    imgAdd(pos, $file) {
      let _this = this;
      let formData = new FormData();
      formData.append('image', $file);
      axios({
        url: 'admin/pid',
        method: 'post',
        data: formData,
        headers:
          {'Content-Type': 'multipart/form-data'}
      }).then((response) => {
        console.log(response);
        if (response.status === 200) {
          let url = response.data.url;
          _this.$refs.md.$img2Url(pos, url);
        }

        console.log("utl:"+this.url)
      })
    }
  },
  data(){
    return{
      articleId : '',
      mainClassify : [],
      subClassify : [],
      article : {
        articlesPO : {
          chooseMainClassify : '',
          chooseSubClassify : '',
          context : '',
          context_mainTitle : '',
          context_subTitle : '',
          context_label : [],
          isComment : '',
          isCover : '',
          coverImg : ''
        },
        location : ''
      },
      label : '',
      showImgDialog : false
    }
  }
}
</script>
<style scoped>
</style>
