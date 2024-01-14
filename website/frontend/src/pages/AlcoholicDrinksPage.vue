<template>
  <h1>Search results for: {{ searchQuery }}</h1>
  <AlcoholicDrinksList :alcoholicDrinks="alcoholicDrinks"></AlcoholicDrinksList>
  <nav>
    <ul class="pagination justify-content-center">
      <li class="page-item">
        <a class="page-link page-link-color" style="color: black" href="#"
          >Previous</a
        >
      </li>
      <li class="page-item">
        <a class="page-link" style="color: black" href="#">1</a>
      </li>
      <li class="page-item">
        <a class="page-link" style="color: black" href="#">2</a>
      </li>
      <li class="page-item">
        <a class="page-link" style="color: black" href="#">3</a>
      </li>
      <li class="page-item">
        <a class="page-link" style="color: black" href="#">Next</a>
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
    };
  },
  async created() {
    // Default values for limit and offset
    const defaultLimit = 9;
    const defaultOffset = 0;

    // Getting the limit and offset from the router query parameters
    // If they are not provided, use the default values
    const limit = this.$route.query.limit || defaultLimit;
    const offset = this.$route.query.offset || defaultOffset;

    this.searchQuery = this.$route.params.search;

    await axios
      .get(
        `/alcoholic_drinks/search/${this.$route.params.search}?limit=${limit}&offset=${offset}`
      )
      .then((response) => {
        this.alcoholicDrinks = response.data;
      });
  },
};
</script>
