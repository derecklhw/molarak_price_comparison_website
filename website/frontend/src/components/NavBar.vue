<template>
  <nav class="nav-bar">
    <router-link to="/" class="alcoholic-drinks-link">
      <div class="logo-wrap">
        <img :src="logo" />
      </div>
    </router-link>
  </nav>
</template>
<script>
import logo from "@/assets/logo-circle.svg";

export default {
  name: "NavBar",
  components: {},
  data() {
    return {
      logo,
    };
  },
};
</script>
