<template>
  <nav class="nav-bar">
    <router-link to="/products" class="products-link">
      <div class="logo-wrap">
        <img :src="logo" />
      </div>
    </router-link>
  </nav>
</template>
<script>
import logo from "@/assets/logo-hexagon.svg";

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
