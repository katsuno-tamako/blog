import Vue from 'vue'
import Router from 'vue-router'

import adminLogin from "../page/adminPage/adminLogin/adminLogin";

Vue.use(Router);

export default new Router(
  {
    routes : [
      {
        path : '/adminLogin',
        component : adminLogin
      }
    ]
  }
)
