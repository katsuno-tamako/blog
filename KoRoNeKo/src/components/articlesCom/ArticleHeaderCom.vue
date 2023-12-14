<template>
  <div>
    <div>
      <div style="height: 50px">
        <div style="margin: 0 10%">
          <el-row style="margin-top: 10px">
            <el-col :span="12" style="text-align: left">
            <span style="font-size: 18px;font-style: normal;color: #426799;">
              <el-page-header @back="goBack">
                   <template slot="content">
                 <router-link to="/" style="text-decoration: none">
                NullPointer
              </router-link>
              </template>
              </el-page-header>


            </span>
            </el-col>
            <el-col :span="12" style="text-align: right">
              <el-input style="width: 50%" size="medium" v-model="keyword" placeholder="Search Forum">
                <el-button   @click="search" slot="append" icon="el-icon-search"></el-button>
              </el-input>
            </el-col>
          </el-row>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: 'ArticleHeaderCom',
  methods : {
    search(){
      this.$router.push({path : '/SearchPage',query:{key : this.keyword}});
      location.reload();

    },
    goBack(){
      this.$router.go(-1);
    }
  },
  data () {
    return{
      keyword : ''
    }
  }
}
</script>
<style scoped>
</style>
