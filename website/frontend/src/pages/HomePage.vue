<template>
  <h1>{{ msg }}</h1>
  <br />
  <br />
  <div class="input-group input-group-lg">
    <div class="input-group mb-3">
      <input
        type="text"
        class="form-control"
        placeholder="What you're looking for? For example whiskey..."
        v-model="searchQuery"
        @keydown.enter="onEnter"
      />
      <router-link
        :to="'alcoholic-drinks/search/' + searchQuery + '?limit=9&offset=0'"
        ><button class="btn btn-dark btn-lg" type="button" id="search-button">
          Search
        </button>
      </router-link>
    </div>
  </div>
</template>
<script>
export default {
  name: "HomePage",
  data() {
    return {
      msg: "Welcome to MoLarak Website",
      searchQuery: "",
    };
  },
  methods: {
    onEnter() {
      this.$router.push(
        "alcoholic-drinks/search/" + this.searchQuery + "?limit=9&offset=0"
      );
    },
  },
};
</script>
