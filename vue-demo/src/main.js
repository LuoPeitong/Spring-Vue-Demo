// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

// 创建 axios 实例
const instance = axios.create({
  // 设置基础URL为 '/api'
  baseURL: '/api',
  // 设置请求超时时间
  timeout: 5000,
  headers: {
    'Content-Type': 'application/json; charset=utf-8'
  },
  // 发送跨域请求时携带凭据（例如 cookie）
  withCredentials: true
})

// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = instance
Vue.config.productionTip = false

Vue.use(ElementUI)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  components: { App },
  template: '<App/>'
})
