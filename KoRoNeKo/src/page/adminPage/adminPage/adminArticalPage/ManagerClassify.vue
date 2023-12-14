<template>
  <div>
    <div>
<!--      -->
      <div>
        <div style="font-size: 20px;margin: 10px 0 0 20px">
          文章分类管理
        </div>
      </div>
      <el-divider></el-divider>
      <div style="margin-left: 20px">
        添加主分类：
        <el-input v-model="articleClassify.classifyName" style="width: 200px" maxlength="5" show-word-limit></el-input>
        <el-button @click="addMainClassify">提交</el-button>
      </div>
      <el-divider></el-divider>
      <div style="margin: 10px 10px">
        <el-row :gutter="10">
          <el-col :span="4" v-for="main in showMainClassify" :key="main.id">
            <el-card shadow="never" style="text-align: center">
              <el-row>
                <el-col :span="12">{{main.classifyName}}</el-col>
                <el-col :span="12"><el-button @click="openEdit(main.cid)">
                  <i class="el-icon-edit"></i>
                </el-button></el-col>
              </el-row>
            </el-card>
          </el-col>
        </el-row>
      </div>

      <el-dialog
        :visible.sync="diaSubLog"
      >
        <div style="text-align: right">
          <el-button @click="deleteMainClassify" type="danger" icon="el-icon-delete"></el-button>
        </div>
        <div>
          <el-form>
            <el-form-item label="添加子分类">
              <el-input v-model="addSubClassify.subClassifyName"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button @click="submitSubClassify" type="primary">提交</el-button>

            </el-form-item>
          </el-form>
        </div>
        <el-divider></el-divider>
        <el-row :gutter="10">
          <el-col :span="12" v-for="sub in showSubClassify" :key="sub.cid">
            <el-card shadow="hidden">
              <el-col :span="12">
                <span style="font-size: 15px">
                  {{sub.subClassifyName}}
                </span>
              </el-col>
              <el-col :span="12">
                <el-button style="margin-bottom: 10px" @click="deleteSub(sub.subid)" icon="el-icon-delete" circle></el-button>
              </el-col>
            </el-card>
          </el-col>
        </el-row>

        <el-divider></el-divider>
        <el-button @click="diaSubLog = false" >Return</el-button>
      </el-dialog>

<!--      -->
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'ManagerClassify',
  created() {
    axios.get('/article/selectAllArticleClassify').then((res)=>{this.showMainClassify = res.data;});
  },
  methods : {
    openEdit(cid){
      this.cid = cid;
      this.diaSubLog = true;
      axios.get('/article/selectSubClassify',{params : {cid:cid}}).then((res)=>{this.showSubClassify = res.data;}).then();
    },
    submitSubClassify(){
      this.addSubClassify.cid = this.cid;
      axios.post('/classify/SubClassifyPO',this.addSubClassify).then(
        (res)=>{
          axios.get('/article/selectSubClassify',{params : {cid:this.cid}}).then((res)=>{this.showSubClassify = res.data;}).then();

        }
      );
    },
    deleteSub(subid){
      axios.get('/classify/deleteSubClassify',{params : {subid : subid}}).then(
        (res)=>{
          axios.get('/article/selectSubClassify',{params : {cid:this.cid}}).then((res)=>{this.showSubClassify = res.data;}).then();
        }
      );
    },
    deleteMainClassify(){
      axios.get('/article/deleteMainClassify',{params : {cid : this.cid}}).then(
        (res)=>{
          axios.get('/article/selectAllArticleClassify').then((res)=>{this.showMainClassify = res.data;});
          this.diaSubLog=false;
        }
      );
    },
    addMainClassify(){
      this.articleClassify.articleLevel = 0;
      axios.post('/article/insertClassify',this.articleClassify).then(
        (res)=>{
          this.articleClassify.articleLevel = '';
          this.articleClassify.classifyName = '';
          axios.get('/article/selectAllArticleClassify').then((res)=>{this.showMainClassify = res.data;});

        }
      )

    }
  },
  data(){
    return{
      cid : '',
      diaSubLog : false,
      classifyName : '',
      articleClassify : {
        classifyName : '',
        articleLevel : ''
      },
      showMainClassify : {
        classifyName : '',
        articleLevel : '',
        cid : ''
      },
      showSubClassify : {
        cid : '',
        subClassifyName : ''
      },
      addSubClassify : {
        cid : '',
        subClassifyName : ''
      }


    }
  }
}
</script>
<style scoped>
</style>
