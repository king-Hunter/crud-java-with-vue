import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

// Import Bootstrap an BootstrapVue CSS files (order is important)
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import axios from "axios";
// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)
Vue.config.productionTip = false

Vue.prototype.$http = axios;

const URLBase = "http://localhost:9090";
Vue.prototype.$baseURL = URLBase;
Vue.prototype.$api = URLBase + "/api/";


new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
