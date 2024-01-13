<template>
  <div class="grid-wrap">
    <div
      class="alcoholic-drink-item"
      v-for="alcoholicDrink in alcoholicDrinks"
      :key="alcoholicDrink.id"
    >
      <img :src="alcoholicDrink.imageName" />
      <h3 class="alcoholic-drink-name">{{ alcoholicDrink.name }}</h3>
      <p class="alcoholic-drink-price">{{ alcoholicDrink.price }}</p>
      <router-link :to="'/alcoholic-drinks/' + alcoholicDrink.id"
        ><button>View Details</button></router-link
      >
    </div>
  </div>
</template>
<script>
export default {
  name: "AlcoholicDrinksList",
  props: ["alcoholicDrinks"],
};
</script>
