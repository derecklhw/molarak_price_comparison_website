<template>
  <nav-bar></nav-bar>
  <div class="page-wrap">
    <router-view></router-view>
  </div>
</template>

<script>
import NavBar from "./components/NavBar.vue";
export default {
  name: "App",
  components: { NavBar },
};
</script>

<style></style>
