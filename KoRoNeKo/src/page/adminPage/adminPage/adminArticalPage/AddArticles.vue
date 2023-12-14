<template>
  <div>
    <div>
      <div style="margin: 10px">
        <div style="font-size: 20px">添加文章</div>
        <el-divider></el-divider>
        <el-form>
          <el-form-item style="margin-left: 10px">
            <template slot="label">添加主标题：</template>
            <el-input v-model="article.context_mainTitle" style="width: 500px"   maxlength="30" show-word-limit></el-input>
          </el-form-item>

          <el-form-item style="margin-left: 10px">
            <template slot="label">添加副标题：</template>
            <el-input v-model="article.context_subTitle" style="width: 500px" maxlength="40" show-word-limit></el-input>
          </el-form-item>

          <el-form-item style="margin-left: 10px">
            <template slot="label">文章分类：</template>
            <el-select placeholder="请选择主分类"
                       @change="showSub_Classify"
                       v-model="article.chooseMainClassify"
                       >

              <el-option
                v-for="main in mainClassify"
                :key="main.cid"
                :value="main.classifyName"
                :label="main.classifyName"
              >
              </el-option>
            </el-select>

            <el-select placeholder="请选择子分类" v-model="article.chooseSubClassify">
              <el-option

                v-for="sub in subClassify"
                :key="sub.value"
                :value="sub.subClassifyName"
                :label="sub.subClassifyName"
              >
              </el-option>
            </el-select>
          </el-form-item>

          <el-form-item>
            <div>
              <mavon-editor
                ref="md"
                v-model="article.context"
                @imgAdd="imgAdd"
                @save="saveNote"
              ></mavon-editor>
            </div>

          </el-form-item>

          <el-form-item>



            <el-button @click="submitInfo" type="primary"
              :disabled="!article.chooseMainClassify || !article.chooseSubClassify ||
                         !article.context || !article.context_mainTitle || !article.context_subTitle
                        "
            >提交</el-button>
          </el-form-item>

        </el-form>
      </div>
    </div>

    <el-dialog
      :visible.sync="dialog"
      width="30%"
    >
      <el-form style="text-align: center">
        <el-form-item>
          <div style="font-size: 20px">
            提交成功
          </div>
        </el-form-item>
        <el-form-item>
          <el-button @click="dialogSuccess">确定</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'AddArticles',
  created() {
    axios.get('/admin/selectAllLabel').then((res)=>{this.label = res.data;});
    axios.get('/article/selectAllArticleClassify').then((res)=>
    {
      this.mainClassify = res.data;
      console.log(res.data);
    });

  },
  methods : {
    submitInfo(){
      axios.post('/admin/receiveArticles', this.article).then((res)=>{
        console.log(res.status);
        this.dialog = true;
        console.log(this.dialog)
      });

    },
    saveNote(){
      axios.post('mkPage/addNote',this.note).then((res)=>{
        console.log(res.data.status);
      })
    },
    upSuccess(pos, $file){
      console.log($file.response.url);
      this.article.coverImg = $file.response.url;
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
    },
    dialogSuccess(){
      this.dialog = false;
      this.$router.push('/ManageArticles');
    },
    showSub_Classify(value){
      console.log(value);
      axios.get('/classify/selectSubClassifyByName',{params:{classifyName:value}}).then(
        (res)=>{
          this.subClassify = res.data;
          console.log(res);
        }
      )

    }
  },
  watch : {
    'article.chooseMainClassify' : function () {

    }
  },
  data(){
    return{
      dialog : false,
      label : '',
      mainClassify : [],
      subClassify : [],
      article : {
        chooseMainClassify : '',
        chooseSubClassify : '',
        context : '',
        context_mainTitle : '',
        context_subTitle : '',
        context_label : [],
        isComment : '',
        isCover : '',
        coverImg : ''
      }
    }
  }
}
</script>
<style scoped>
</style>
