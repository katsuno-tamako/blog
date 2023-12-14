<template>
  <div>
    <div>文章分类</div>
    <el-divider></el-divider>
    {{showMainClassify}}
    <el-divider></el-divider>
    <el-input v-model="articleClassify.classifyName"></el-input>
    <el-button @click="submitClassify(0)">添加</el-button>
    <div>
      <el-row>
        <el-col :span="4" v-for="main in showMainClassify" :key="main.id">
          {{main.classifyName}}
          <el-button @click="showSub(main.cid)"></el-button>
        </el-col>
      </el-row>

      <el-dialog
        :visible.sync="subDialog"
      >
      {{showSubClassify}}
      </el-dialog>

    </div>


    <div>
      <div>文章标签</div>
      <el-button @click="dialog=true" icon="el-icon-plus" circle></el-button>
      <div>
        <el-divider>已有标签：</el-divider>
        <div v-for="l in label" :key="l.label">
          <div>{{l.id}}</div>
          <div>{{l.label}}</div>
          <div>{{l.labelIntroduce}}</div>
          <div><el-button @click="deleteLabel(l.id)">删除</el-button></div>
        </div>
      </div>
    </div>


    <el-dialog
      :visible.sync="dialog"
    >
      <el-form>
        <el-form-item label="标签名">
          <el-input v-model="labelV.label"></el-input>
        </el-form-item>

        <el-form-item label="标签描述">
          <el-input v-model="labelV.labelIntroduce"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button @click="submitLabelInfo">提交</el-button>
          <el-button @click="dialog = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'ManageArticlesClassify',
  created() {
      axios.get('/admin/selectAllLabel').then(
        (res)=>{
          this.label = res.data;
        }
      );

      axios.get('/article/selectAllArticleClassify').then(
        (res)=>{
          this.showMainClassify = res.data;
        }
      )

  },
  methods : {
    submitLabelInfo(){
      axios.post('/admin/insertLabel', this.labelV).then();
      this.dialog = false;
      axios.get('/admin/selectAllLabel').then(
        (res)=>{
          this.label = res.data;
        }
      );
    },

    deleteLabel(lid){
      axios.get('/admin/deleteLabel',{params : {id : lid}});

    },
    showSub(cid){
      this.subDialog = true;
      console.log(cid);
      axios.get('/article/selectSubClassify',{params : {cid : cid}}).then((res)=>{
        this.showSubClassify = res.data;
      })
    },
    submitClassify(level){
      this.articleClassify.articleLevel = level;
      axios.post('/article/insertClassify',this.articleClassify).then(
        (res)=>{
          this.articleClassify.articleLevel = '';
          this.articleClassify.classifyName = ''
        }
      )
    },
    addSubClassify(cid){
      console.log(cid)
    },
    addMainClassify(cid){
      this.addSubClassify.cid = cid;
      axios.post('/article/addSubClassify',this.addSubClassify).then();
    }
  },
  data(){
    return{
      mainCid : '',
      insertSub : '',
      mainDialog : false,
      chooseCid : '',
      subDialog : false,
      dialog : false,
      label : {
        label : '',
        labelIntroduce : ''
      },
      articleClassify : {
        classifyName : '',
        articleLevel : ''
      },
      showMainClassify : {
        cid : '',
        subClassifyPOList : {}
      },
      addMainClassify : {

      },
      addSubClassify : {
        cid : '',
        subClassifyName : ''
      },
      showSubClassify : {
        subid : '',
        subClassifyName : ''
      },
      chooseMainClassify : '',
      labelV : {
        label : '',
        labelIntroduce : ''
      }
    }
  }
}
</script>
<style scoped>
</style>
