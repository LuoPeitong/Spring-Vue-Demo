<template>
  <el-tabs v-model="$store.state.editableTabsValue" @edit="handleTabsEdit" type="card" closable>
    <el-tab-pane v-for="(item) in $store.state.editableTabs" :key="item.id" :label="item.title" :name="item.id">
      <keep-alive>
        <component :is='item.content'></component>
      </keep-alive>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
// 用import添加标签页涉及到的Vue组件
import func1 from '../func/func1'
import func2 from '../func/func2'
import func3 from '../func/func3'

export default {
  name: 'Tabs',
  components: {
    // 标签页涉及到的Vue组件需要在这里注册
    func1,
    func2,
    func3
  },
  methods: {
    handleTabsEdit (targetName, action) {
      if (action === 'remove') {
        // 拷贝tabs列表
        let tabs = this.$store.state.editableTabs
        let activeName = this.$store.state.editableTabsValue
        if (activeName === targetName) {
          tabs.forEach((tab, index) => {
            if (tab.id === targetName) {
              let nextTab = tabs[index + 1] || tabs[index - 1]
              if (nextTab) {
                activeName = nextTab.id
              }
            }
          })
        }
        this.$store.commit('saveEditableTabsValue', activeName)
        let editableTabs = tabs.filter(tab => tab.id !== targetName)
        this.$store.commit('saveEditableTabs', editableTabs)
      }
    }
  }
}
</script>

<style scoped>

</style>
