<template>
  <el-menu class="el-menu-vertical-demo" id="menu" default-active="2" background-color="#545c64" text-color="#fff"
           ext-align="left" active-text-color="#ffd04b" unique-opened>
    <el-submenu v-for="(nav, key) in NavbarList" :key="key" :index="nav.id" :popper-append-to-body="false">
      <template slot="title">
        <i :class="nav.img"></i>
        <span>{{ nav.title }}</span>
      </template>
      <el-menu-item v-for="(s_nav, s_key) in nav.subMenu" :key="s_key" :index="String(s_nav.id)" @click="active(s_nav)"
                    style="min-width: 100px">
        <span>{{ s_nav.title }}</span>
      </el-menu-item>
    </el-submenu>
  </el-menu>
</template>

<script>
export default {
  name: 'Navbar',
  data () {
    return {
      NavbarList: [{'title': '人员信息管理', 'id': '1', 'img': 'el-icon-user', 'subMenu': [{'id': '3', 'title': '项目人员管理', 'menuId': '1', 'content': 'PerManagement'}, {'id': '4', 'title': '人员报表查询', 'menuId': '1', 'content': 'PerReport'}]}, {'title': '实时监测', 'id': '2', 'img': 'el-icon-monitor', 'subMenu': [{'id': '5', 'title': '人员信息监测', 'menuId': '2', 'content': 'PerInfoMonitoring'}]}, {'title': '轨迹管理', 'id': '3', 'img': 'el-icon-location', 'subMenu': [{'id': '6', 'title': '人员实时轨迹', 'menuId': '3', 'content': 'PerRealTimeTrack'}, {'id': '7', 'title': '人员统计信息', 'menuId': '3', 'content': 'PerInfoStatistics'}]}, {'title': '考勤管理', 'id': '4', 'img': 'el-icon-coffee-cup', 'subMenu': [{'id': '8', 'title': '考勤管理', 'menuId': '4', 'content': 'AttManagement'}]}, {'title': '区域管理', 'id': '5', 'img': 'el-icon-coordinate', 'subMenu': [{'id': '9', 'title': '区域管理', 'menuId': '5', 'content': 'RegionalManagement'}]}, {'title': '告警管理', 'id': '6', 'img': 'el-icon-view', 'subMenu': [{'id': '10', 'title': '告警管理', 'menuId': '6', 'content': 'AlarmManagement'}]}, {'title': '超级管理员', 'id': '7', 'img': 'el-icon-s-custom', 'subMenu': [{'id': '11', 'title': '组织结构管理', 'menuId': '7', 'content': 'OrganManagement'}, {'id': '12', 'title': '管理人员设置', 'menuId': '7', 'content': 'SetAdmin'}]}]
    }
  },
  methods: {
    active (nav) {
      this.$store.commit('addEditableTabs', nav)
      // console.log('nav=', JSON.stringify(this.$store.state.editableTabs))
      this.$store.commit('saveEditableTabsValue', nav.id)
    }
  }
}
</script>

<style scoped>
.el-submenu .el-menu-item {
  min-width: 100px;
}
</style>
