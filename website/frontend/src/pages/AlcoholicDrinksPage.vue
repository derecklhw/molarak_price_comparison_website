<template>
  <h1>Search results for: {{ searchQuery }}</h1>
  <AlcoholicDrinksList :alcoholicDrinks="alcoholicDrinks"></AlcoholicDrinksList>
  <nav v-if="alcoholicDrinks.length > 0">
    <ul class="pagination justify-content-center">
      <li class="page-item">
        <router-link
          :to="`/alcoholic-drinks/search/${searchQuery}?limit=9&offset=${Math.max(
            0,
            offset - 1
          )}`"
          class="page-link"
          style="color: black"
          >Previous</router-link
        >
      </li>
      <!-- Dynamic pagination items -->
      <li class="page-item" v-for="page in displayedPages" :key="page">
        <router-link
          :to="`/alcoholic-drinks/search/${searchQuery}?limit=9&offset=${
            page - 1
          }`"
          class="page-link"
          style="color: black"
          >{{ page }}</router-link
        >
      </li>
      <li class="page-item">
        <router-link
          :to="`/alcoholic-drinks/search/${searchQuery}?limit=9&offset=${Math.min(
            totalPages - 1,
            offset + 1
          )}`"
          class="page-link"
          style="color: black"
          >Next</router-link
        >
      </li>
    </ul>
  </nav>
</template>
<script>
import axios from "axios";
import AlcoholicDrinksList from "../components/AlcoholicDrinksList.vue";

export default {
  name: "AlcoholicDrinksPage",
  components: { AlcoholicDrinksList },
  data() {
    return {
      alcoholicDrinks: [],
      searchQuery: "",
      totalPages: 0,
      limit: 0,
      offset: 0,
      displayedPageCount: 3,
    };
  },
  async created() {
    this.fetchData();
  },
  watch: {
    $route(to, from) {
      if (to.query.offset !== from.query.offset) {
        this.fetchData();
      }
    },
  },
  methods: {
    /**
     * Fetches the alcoholic drinks from the API.
     */
    async fetchData() {
      const defaultLimit = 9;
      const defaultOffset = 0;
      this.limit = this.$route.query.limit || defaultLimit;
      this.offset = parseInt(this.$route.query.offset) || defaultOffset;
      this.searchQuery = this.$route.params.search;

      await axios
        .get(
          `/alcoholic_drinks/search/${this.searchQuery}?limit=${this.limit}&offset=${this.offset}`
        )
        .then((response) => {
          this.alcoholicDrinks = response.data.data;
          this.totalPages = Math.ceil(response.data.count / this.limit);
        });
    },
  },

  computed: {
    /**
     * Returns an array of page numbers to display in the pagination.
     */
    displayedPages() {
      // Determine the start and end page numbers for the pagination
      let startPage = Math.max(
        1,
        this.offset - Math.floor(this.displayedPageCount / 2)
      );
      let endPage = startPage + this.displayedPageCount - 1;

      // Adjust if endPage goes beyond total pages
      if (endPage > this.totalPages) {
        endPage = this.totalPages;
        startPage = Math.max(1, endPage - this.displayedPageCount + 1);
      }

      // Generate the array of page numbers
      return Array.from(
        { length: endPage - startPage + 1 },
        (_, i) => startPage + i
      );
    },
  },
};
</script>
