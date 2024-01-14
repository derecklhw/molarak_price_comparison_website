<template>
  <div class="grid-wrap">
    <div
      class="alcoholic-drink-item"
      v-for="alcoholicDrink in alcoholicDrinks"
      :key="alcoholicDrink.alcoholic_drinks_id"
    >
      <img :src="alcoholicDrink.alcoholic_drinks_imageUrl || defaultImage" />
      <h3 class="alcoholic-drink-name mb-0 mt-2">
        <strong> {{ alcoholicDrink.alcoholic_drinks_brand }}</strong>
      </h3>
      <h3 class="alcoholic-drink-name mt-1">
        {{ alcoholicDrink.alcoholic_drinks_name }}
      </h3>
      <!-- <p class="alcoholic-drink-price">{{ alcoholicDrink.price }}</p> -->
      <router-link :to="'/alcoholic-drinks/' + alcoholicDrink.id"
        ><button class="btn btn-dark">Compare</button></router-link
      >
    </div>
  </div>
</template>
<script>
import defaultImage from "@/assets/default-image.png";

export default {
  name: "AlcoholicDrinksList",
  props: ["alcoholicDrinks"],
  data() {
    return {
      defaultImage,
    };
  },
};
</script>
