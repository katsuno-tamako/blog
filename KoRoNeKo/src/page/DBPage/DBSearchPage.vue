<template>
  <div>
    <div><DBHeaderCom/></div>
    <div>
      <el-divider></el-divider>
      <div style="text-align: center;font-size: 20px">
        <div v-if="this.$route.query.keyword === ''">
          All
        </div>
        <div v-else>
          关键字：{{this.$route.query.keyword}}

        </div>
      </div>
      <el-divider></el-divider>
    </div>
    <div style="margin: 10px 5%">
      <div v-for="d in db" :key="d.DId" @click="toDB(d.DataId)" style="cursor:pointer">
        <el-card shadow="hover">
          <el-row>
            <el-col :span="20">
              <div style="margin-left: 20px;font-size: 17px">
                {{d.DName}}
              </div>
            </el-col>
            <el-col :span="4">
              <el-tag>
                <span>{{d.MainDClssify}}</span>
              </el-tag>
              <el-tag>
                <span>{{d.SubDClassify}}</span>
              </el-tag>
            </el-col>
          </el-row>
        </el-card>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import DBHeaderCom from "../../components/DBCom/DBHeaderCom";
export default {
  name: 'DBSearchPage',
  components : {DBHeaderCom},
  created() {
    axios.get('/DB/selectDBByKeyword',{params:{keyword:this.$route.query.keyword}}).then(
      (res)=>{
        this.db = res.data;
      }
    )
  },
  methods : {
    toDB(DataId){
      this.$router.push({path : '/DBPage',query:{DataId : DataId}});
    }
  },
  data(){
    return{
      db : ''
    }
  }
}
</script>
<style scoped>
</style>
