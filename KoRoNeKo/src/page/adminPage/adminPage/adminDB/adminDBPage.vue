<template>
  <div>
    <div style="padding-top:15px;font-size: 20px;text-align: center">NULL POINTER EDB \(ΦωΦ)/ </div>
    <el-divider></el-divider>
    <div style="margin: 0 10px">

      <el-table
        :data="DBPO"
        style="100%"
      >


      <el-table-column
        prop="DName"
        label="DBNamw"
      ></el-table-column>

      <el-table-column
        prop="MainDClssify"
        label="MainDClssify"
      ></el-table-column>

      <el-table-column
        prop="SubDClassify"
        label="SubDClassify"
      ></el-table-column>



        <el-table-column
        label="Operate"
        width="200"
        >
<!--          @click="editArticle(scope.row.articleId)"-->
          <template slot-scope="scope">
          <el-button  type="text" size="small" @click="adminEditDBPage(scope.row.DataId)">Edit</el-button>
          <el-button  type="text" size="small" @click="deleteDB(scope.row.DataId)">Delete</el-button>
          </template>
        </el-table-column>

      </el-table>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'adminDBPage',
  created() {
    axios.get('/DB/selectAllDB').then((res)=>{this.DBPO=res.data});
  },
  methods : {
    adminEditDBPage(DataId){
      this.$router.push({path : '/adminEditDBPage', query : {DataId : DataId}})
    },
    deleteDB(DataId){
      this.$alert('是否删除','Tip',{
        confirmButtonText : 'Confirm',
        callback:action => {
          axios.get('/DB/deleteDB',{params:{DataId:DataId}}).then((res)=>{
            axios.get('/DB/selectAllDB').then((res)=>{this.DBPO=res.data});

          });
        }

      });

    }
  },
  data(){
    return{
      DBPO : []
    }
  }
}
</script>
<style scoped>
</style>
