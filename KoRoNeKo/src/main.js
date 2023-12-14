// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import 'github-markdown-css';
import axios from "axios";
import showdown from 'showdown'
import Viewer from "v-viewer";
import 'viewerjs/dist/viewer.css'
import VueLazyload from "vue-lazyload";

Vue.prototype.$axios = axios;
axios.defaults.baseURL = "/api";
Vue.config.productionTip = false;
Vue.use(mavonEditor);
Vue.use(ElementUI);
Vue.use(Viewer);

Viewer.setDefaults({
  Options: {
    inline: true,
    button: false,
    navbar: true,
    title: true,
    toolbar: true,
    tooltip: true,
    movable: true,
    zoomable: true,
    rotatable: true,
    scalable: true,
    transition: true,
    fullscreen: true,
    keyboard: true,
    url: 'data-source'
  }
});

/* eslint-disable no-new */
Vue.prototype.md2html = (md)=> {
  let converter = new showdown.Converter();
  let text = md.toString();
  let html = converter.makeHtml(text);
  return html;
};

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
