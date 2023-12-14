import Vue from 'vue'
import Router from 'vue-router'
import index from "../page/index";
// import admin router
import adminLogin from "../page/adminPage/adminLogin/adminLogin";
import adminIndex from "../page/adminPage/adminPage/adminIndex";
import AddArticles from "../page/adminPage/adminPage/adminArticalPage/AddArticles";
import ManageArticles from "../page/adminPage/adminPage/adminArticalPage/ManageArticles";
import ManageArticlesClassify from "../page/adminPage/adminPage/adminArticalPage/ManageArticlesClassify";
import adminSettingPage from "../page/adminPage/adminPage/adminSetting/adminSettingPage";
import article from "../page/articlePage/article";
import EditArticlePage from "../page/adminPage/adminPage/adminArticalPage/EditArticlePage";
import ManagerClassify from "../page/adminPage/adminPage/adminArticalPage/ManagerClassify";
import managerPhotograph from "../page/adminPage/adminPage/adminPhotographPage/managerPhotograph";
import photographSettingPage from "../page/adminPage/adminPage/adminPhotographPage/photographSettingPage";
import adminDBPage from "../page/adminPage/adminPage/adminDB/adminDBPage";
import adminAddDBPage from "../page/adminPage/adminPage/adminDB/adminAddDBPage";
import adminEditDBPage from "../page/adminPage/adminPage/adminDB/adminEditDBPage";
import editDBPage from "../page/adminPage/adminPage/adminDB/editDBPage";
import DBIndex from "../page/DBPage/DBIndex";
import DBCPage from "../page/DBPage/DBCPage";
import DBPage from "../page/DBPage/DBPage";
import DBSearchPage from "../page/DBPage/DBSearchPage";
import SAdminManageAccountPage from "../page/adminPage/adminPage/SuperAdminPage/SAdminManageAccountPage";
import SAdminIndexManagePage from "../page/adminPage/adminPage/SuperAdminPage/SAdminIndexManagePage";
import AddArticles2 from "../page/adminPage/adminPage/adminArticalPage/AddArticles2";

// index page router
import SearchPage from "../page/indexPage/SearchPage";
import classifyPage from "../page/articlePage/classifyPage";
import subClassifyPage from "../page/articlePage/subClassifyPage";

// photograph router
import albumPage from "../page/Photograph/albumPage";


Vue.use(Router);

export default new Router({
  // mode : 'history',
  routes: [
    {
      path: '/',
      name: 'index',
      component: index
    },
    {
      path:'/AddArticles2',
      name: 'AddArticles2',
      component : AddArticles2
    },
    // All Article router
    {
      // Article page router
      path : '/article',
      name : 'index',
      component : article
    },
    // All admin router
    {
      path : '/adminLogin',
      name : 'adminLogin',
      component: adminLogin
    },
    {
      path : '/SearchPage',
      name : 'SearchPage',
      component : SearchPage
    },
    {
      path : '/classifyPage',
      name : 'classifyPage',
      component : classifyPage
    },
    {
      path : '/subClassifyPage',
      name : 'subClassifyPage',
      component : subClassifyPage
    },
    {
      path : '/albumPage',
      name : 'albumPage',
      component : albumPage
    },
    {
      path : '/DBIndex',
      name : 'DBIndex',
      component : DBIndex
    },
    {
      path : '/DBCPage',
      name : 'DBCPage',
      component : DBCPage
    },
    {
      path : '/DBPage',
      name : 'DBPage',
      component : DBPage
    },
    {
      path : '/DBSearchPage',
      name : 'DBSearchPage',
      component : DBSearchPage
    },
    {
      path : '/adminIndex',
      name : 'adminIndex',
      component : adminIndex,
      children: [
        {
        //  Manage the articles page router
          path : '/ManageArticles',
          name : 'ManageArticles',
          component : ManageArticles
        },
        {
        //  Add articles page router
          path : '/AddArticles',
          name : 'AddArticles',
          component: AddArticles
        },
        {
        //  Manage the articles classification page router
          path : '/ManageArticlesClassify',
          name : 'ManageArticlesClassify',
          component : ManageArticlesClassify
        },
        {
          // Edit article page router
          path : '/EditArticlePage',
          name : 'EditArticlePage',
          component : EditArticlePage
        },
        {
          // Manager classify page router
          path : '/ManagerClassify',
          name : '/ManagerClassify',
          component : ManagerClassify
        },
        {
          path : '/managerPhotograph',
          name : 'managerPhotograph',
          component : managerPhotograph
        },
        {
          path : '/photographSettingPage',
          name : 'photographSettingPage',
          component : photographSettingPage
        },
        {
          path : '/adminDBPage',
          name : 'adminDBPage',
          component : adminDBPage
        },
        {
          path : '/adminAddDBPage',
          name : 'adminAddDBPage',
          component : adminAddDBPage
        },
        {
          path : '/adminEditDBPage',
          name : 'adminEditDBPage',
          component : adminEditDBPage
        },
        {
          path : '/editDBPage',
          name : 'editDBPage',
          component : editDBPage
        },
        {
          path : '/SAdminManageAccountPage',
          name : 'SAdminManageAccountPage',
          component : SAdminManageAccountPage
        },
        {
          path : '/SAdminIndexManagePage',
          name : 'SAdminIndexManagePage',
          component : SAdminIndexManagePage
        },
        {
        //  Admin Setting page router
          path : '/adminSettingPage',
          name : 'adminSettingPage',
          component : adminSettingPage
        }
      ]

    }

  ]
})
