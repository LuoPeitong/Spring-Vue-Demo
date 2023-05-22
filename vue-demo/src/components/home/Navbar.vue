<template>
  <el-menu class="el-menu-vertical-demo" id="menu" default-active="2" background-color="#545c64" text-color="#fff"
           ext-align="left" active-text-color="#ffd04b" unique-opened>
    <el-submenu v-for="(nav, key) in NavbarList" :key="key" :index="nav.id" :popper-append-to-body="false">
      <template slot="title">
        <i :class="nav.img"></i>
        <span>{{ nav.title }}</span>
      </template>
      <el-menu-item v-for="(s_nav, s_key) in nav.funcList" :key="s_key" :index="s_nav.id" @click="active(s_nav)"
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
      NavbarList: [{'title': '', 'id': '', 'img': '', 'funcList': []}]
    }
  },
  mounted () {
    this.getMenu()
  },
  methods: {
    active (nav) {
      this.$store.commit('addEditableTabs', nav)
      this.$store.commit('saveEditableTabsValue', nav.id)
    },
    getMenu () {
      this.$axios
        .post('getMenu', {})
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            this.NavbarList = successResponse.data.object
          }
        })
        .catch(failResponse => {
        })
    }
  }
}
</script>

<style scoped>
.el-submenu .el-menu-item {
  min-width: 100px;
}
</style>
