<template>
  <div>
    <Navbar id="menu"/>
    <Tabs id="tabs"/>
  </div>
</template>

<script>
import Navbar from './Navbar'
import Tabs from './Tabs'

export default {
  name: 'AppIndex',
  components: {
    Navbar,
    Tabs
  }
}
</script>

<style scoped>
#menu {
  width: 15vw;
  height: 100vh;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 1000;
}

#tabs {
  width: 84%;
  margin-left: 15vw;
}
</style>
