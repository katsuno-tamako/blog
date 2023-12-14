<template>
  <div>
    <div style="margin:  300px 0 500px 0">
      <DBSearchCom/>
    </div>
    <div>
      <el-card>
        <DBClassifyCom/>
      </el-card>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import DBClassifyCom from "../../components/DBCom/DBClassifyCom";
import DBSearchCom from "../../components/DBCom/DBSearchCom";
export default {
  name: 'DBIndex',
  components : {DBSearchCom,DBClassifyCom}
}
</script>
<style scoped>
</style>
