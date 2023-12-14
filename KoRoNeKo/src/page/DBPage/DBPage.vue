<template>
  <div>
    <div>
      <DBHeaderCom/>
    </div>
    <div style="margin: 50px 0">
      <el-divider>
        <span style="font-size: 30px;font-weight: bold">
          {{db.DName}}
        </span>
      </el-divider>
    </div>
    <div style="margin: 0 10%">
      <mavon-editor
        ref="md"
        :value="db.DContent"
        :subfield = "prop.subfield"
        :defaultOpen = "prop.defaultOpen"
        :toolbarsFlag = "prop.toolbarsFlag"
        :editable="prop.editable"
        :scrollStyle="prop.scrollStyle"
      >

      </mavon-editor>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import DBHeaderCom from "../../components/DBCom/DBHeaderCom";
export default {
  name: 'DBPage',
  components : {DBHeaderCom},
  created() {
    axios.get('/DB/selectDBByDataId',{params : {DataId : this.$route.query.DataId}}).then((res)=>{
      this.db = res.data;
    })
  },
  computed: {
    prop () {
      let data = {
        subfield: false,// 单双栏模式
        defaultOpen: 'preview',//edit： 默认展示编辑区域 ， preview： 默认展示预览区域
        editable: false,
        toolbarsFlag: false,
        scrollStyle: true,
        navigation: true,
      };
      return data
    }
  },
  data(){
    return{
      db : {}
    }
  }
}
</script>
<style scoped>
</style>
