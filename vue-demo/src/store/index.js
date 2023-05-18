import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {
      username: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).username
    },
    // 所有被打开的标签页
    editableTabs: [],
    // 当前激活的标签页
    editableTabsValue: ''
  },
  mutations: {
    login (state, user) {
      state.user = user
      window.localStorage.setItem('user', JSON.stringify(user))
    },
    // 将当前页添加到标签栏
    addEditableTabs (state, editableTabs) {
      state.editableTabs.push(editableTabs)
      const res = new Map()
      let arr = state.editableTabs
      let val = 'id'
      state.editableTabs = arr.filter((item) => !res.has(item[val]) && res.set(item[val], 1))
    },
    // 标签栏的更新
    saveEditableTabs (state, editableTabs) {
      state.editableTabs = editableTabs
    },
    // 保存当前激活的标签页id
    saveEditableTabsValue (state, editableTabsValue) {
      state.editableTabsValue = editableTabsValue
    }
  }
})
