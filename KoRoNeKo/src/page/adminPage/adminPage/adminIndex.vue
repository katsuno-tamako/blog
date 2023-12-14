<template>
  <div>
    <div>
      <adminTitleCom/>
    </div>
    <div>

    </div>
    <div>
      <el-row>
        <el-col :span="4">
          <el-menu
            default-active="2"
            class=""
            @open="handleOpen"
            @close="handleClose"
          >

            <el-menu-item>
              <template slot="title">
                <router-link to="adminIndex">
                    <div style="width: 100%;height: 100%;color: #712747">
                      <i class="el-icon-s-platform"></i>
                      主页
                    </div>
                </router-link>
              </template>
            </el-menu-item>

            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-tickets"></i>
                <span style="color: #712747">
                  Articles
                </span>
              </template>

              <el-menu-item index="1-1">
                <router-link to="ManageArticles">
                  <div style="width: 100%;height: 100%;color: #712747">
                    <i class="el-icon-document-copy"></i>
                  Manage Articles
                  </div>
                </router-link>
              </el-menu-item>
              <el-menu-item index="1-2">
                <router-link to="AddArticles">
                  <div style="width: 100%;height: 100%;color: #712747">
                    <i class="el-icon-document-add"></i>
                    Add Article
                  </div>
                </router-link>
              </el-menu-item>


<!--              <el-menu-item index="1-3">-->
<!--                <router-link to="ManageArticlesClassify">-->
<!--                  <div style="width: 100%;height: 100%">-->
<!--                  管理文章分类-->
<!--                  </div>-->
<!--                </router-link>-->
<!--              </el-menu-item>-->

              <el-menu-item index="1-3">
                <router-link to="ManagerClassify">
                  <div style="width: 100%;height: 100%;color: #712747">
                    <i class="el-icon-collection-tag"></i>
                    Classification
                  </div>
                </router-link>
              </el-menu-item>
            </el-submenu>

            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-camera"></i>
                <span style="color: #712747">摄影</span>
              </template>

              <el-menu-item index="2-1">
                <router-link to="/managerPhotograph">
                  <div style="width: 100%;height: 100%;color: #712747">
                  <i class="el-icon-picture-outline"></i>
                  图片管理
                  </div>
                </router-link>
              </el-menu-item>

              <el-menu-item index="2-2">
                <router-link to="/photographSettingPage">
                  <div style="width: 100%;height: 100%;color: #712747">
                  <i class="el-icon-setting"></i>
                  设置
                  </div>
                </router-link>
              </el-menu-item>

            </el-submenu>

            <el-submenu index="3">
              <template slot="title">
                <div style="width: 100%;height: 100%;color: #712747">
                  <i class="el-icon-crop"></i>
                    NPDB
                </div>
              </template>

              <el-menu-item index="3-1">
                <router-link to="/adminDBPage">
                  <div style="width: 100%;height: 100%;color: #712747">
                    <i class="el-icon-document"></i>

                    DB Manage
                  </div>
                </router-link>
              </el-menu-item>
              <el-menu-item index="3-1">
                <router-link to="/adminAddDBPage">
                  <div style="width: 100%;height: 100%;color: #712747">
                    <i class="el-icon-document-add"></i>

                    Add DB
                  </div>
                </router-link>
              </el-menu-item>
            </el-submenu>


            <el-submenu index="4" v-if="this.authority === 'admin'">
              <template slot="title">
                <div style="width: 100%;height: 100%;color: #712747">
                  <i class="el-icon-cpu"></i>
                  Admin
                </div>
              </template>

              <el-menu-item index="4-1">
                <router-link to="/SAdminManageAccountPage">
                  <div style="width: 100%;height: 100%;color: #712747">
                    <i class="el-icon-place"></i>
                    账号管理
                  </div>
                </router-link>
              </el-menu-item>

              <el-menu-item index="4-1">
                <router-link to="/SAdminIndexManagePage">
                  <div style="width: 100%;height: 100%;color: #712747">
                    <i class="el-icon-place"></i>
                    主页管理
                  </div>
                </router-link>
              </el-menu-item>

            </el-submenu>

            <el-menu-item>
              <span slot="title">
                <router-link to="adminSettingPage">
                  <div style="width: 100%;height: 100%;color: #712747">
                    <i class="el-icon-setting"></i>
                  设置
                  </div>
                </router-link>
              </span>
            </el-menu-item>

          </el-menu>
        </el-col>
        <el-col :span="20">
          <div v-if="this.$route.path === '/adminIndex'">
            <adminIndexCom/>
          </div>
          <div v-else>
            <router-view/>
          </div>
        </el-col>
      </el-row>

    </div>
  </div>
</template>

<script>
import adminIndexCom from "../../../components/adminCom/adminIndex/adminIndexCom";
import adminTitleCom from "../../../components/adminCom/adminIndex/adminTitleCom";
import axios from 'axios';
export default {
  name: 'adminIndex',
  components : {adminIndexCom,adminTitleCom},
  methods : {
    handleOpen(key, keyPath){
      console.log(key, keyPath);
    },
    handleClose(key, keyPath){
      console.log(key, keyPath);
    }
  },
  created() {
    axios.get('/admin/JWLogin').then((res)=>{
      this.LStatus = res.data;
      console.log(res);
      if(this.LStatus === 0){
        this.$router.push('/adminLogin')
      }
    });

    axios.get('/admin/detemineAdmin').then(
      (res)=>{
        this.authority = res.data;
        console.log(this.authority)
      }
    );

  },
  data(){
    return{
      LStatus : '',
      authority : ''
    }
  }
}
</script>
<style scoped>
  a {
    text-decoration: none;
  }

  .router-link-active {
    text-decoration: none;
  }
</style>
