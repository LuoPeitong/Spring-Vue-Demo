// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import store from './store/index'
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

// 在路由跳转前进行权限验证
router.beforeEach((to, from, next) => {
  // 判断目标路由是否需要进行权限验证
  if (to.meta.requireAuth) {
    if (store.state.user.username) {
      next()
    } else {
      next({
        path: 'login',
        // 将用户想要访问的页面路径保存下来，以便在登录成功后可以跳转回该页面。
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
}
)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: {App},
  template: '<App/>'
})
