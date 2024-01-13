<template>
  <h1>Alcoholic Drinks</h1>
  <AlcoholicDrinksList :alcoholicDrinks="alcoholicDrinks"></AlcoholicDrinksList>
</template>
<script>
import { alcoholicDrinks } from "../temp-data";
import AlcoholicDrinksList from "../components/AlcoholicDrinksList.vue";

export default {
  name: "AlcoholicDrinksPage",
  components: { AlcoholicDrinksList },
  data() {
    return {
      alcoholicDrinks: alcoholicDrinks,
    };
  },
};
</script>
