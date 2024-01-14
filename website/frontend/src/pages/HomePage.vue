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
    </div>
    <div>
      <router-link
        v-if="isSearchQueryValid"
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
  computed: {
    /**
     * Checks if the search query is valid.
     * @returns {boolean} - True if the search query is valid, false otherwise.
     */
    isSearchQueryValid() {
      return this.searchQuery.trim().length > 0;
    },
  },
  methods: {
    /**
     * Redirects the user to the search page.
     */
    onEnter() {
      if (this.isSearchQueryValid) {
        this.$router.push(
          "alcoholic-drinks/search/" + this.searchQuery + "?limit=9&offset=0"
        );
      }
    },
  },
};
</script>
