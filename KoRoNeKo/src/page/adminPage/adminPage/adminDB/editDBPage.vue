<template>
  <div>
    {{db}}
    <el-form :model="db">
      <el-form-item>
        <el-input v-model="db.DName"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="u">1</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'editDBPage',
  created() {
    // axios.get('/DB/selectDBByDBID',{params : {DataId : this.$route.query.DataId}}).then(
    //   (res)=>{
    //     this.db = res.data;
    //   }
    // );
  },
  methods : {
    u(){
      axios.post('/DB/updateDB',this.db).then();
    }
  },
  data(){
    return{
      db : {
        DName : '---'
      }
    }
  }
}
</script>
<style scoped>
</style>
