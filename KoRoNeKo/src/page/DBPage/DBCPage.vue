<template>
  <div>
    <div>
      <DBHeaderCom/>
    </div>

    <el-container>
      <el-aside style="margin-left:10px;margin-top: 20px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)" width="200px">
        <div v-for="u in subClassify" :key="u"
             style="padding: 0 2%;font-size: 15px;cursor:pointer"
             @click="selectBySub(u)"
        >
          <el-card  shadow="hover">
            {{u}}
          </el-card>
        </div>
      </el-aside>
      <el-main>
        <div style="margin-right:10px">
          <div v-for="d in db" :key="d.DId" @click="toDB(d.DataId)" style="cursor:pointer">
            <el-card shadow="hover">
              <el-row>
                <el-col :span="12">
                  <div style="margin-left: 20px">
                    {{d.DName}}
                  </div>
                </el-col>
                <el-col :span="12">
                  <el-tag>
                    <span>{{d.MainDClssify}}</span>
                  </el-tag>
                  <el-tag>
                    <span>{{d.SubDClassify}}</span>
                  </el-tag>
                  <span></span>
                </el-col>
              </el-row>
            </el-card>
          </div>
        </div>
      </el-main>
    </el-container>


  </div>
</template>

<script>
import axios from 'axios'
import DBHeaderCom from "../../components/DBCom/DBHeaderCom";
export default {
  name: "DBCPage",
  components : {
    DBHeaderCom
  },
  created() {
    this.classify = this.$route.query.classify;
    axios.get('/DB/selectDBByMainClassify',{params:{mainClassify : this.$route.query.classify}}).then((res)=>{
      this.db = res.data;
    });
    axios.get('/DB/selectDBSubClassify',{params:{MainDClssify:this.$route.query.classify}}).then(
      (res)=>{
        this.subClassify = res.data;
      }
    )

  },
  methods : {
    toDB(DataId){
      this.$router.push({path : '/DBPage',query:{DataId : DataId}});
    },
    selectBySub(sub){
      axios.get('/DB/selectDBBySubClassify',{params:{SubDClassify:sub}}).then(
        (res)=>{
          this.db = res.data;
        }
      )
    }
  },
  data(){
    return{
      classify : '',
      subClassify : '',
      db : {
        DId : ''
      }
    }
  }
}
</script>




