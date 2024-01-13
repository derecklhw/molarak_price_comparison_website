<template>
  <div v-if="alcoholicDrink">
    <div class="img-wrap">
      <img :src="alcoholicDrink.imageName" />
    </div>
    <div class="alcoholic-drink-details">
      <h1>{{ alcoholicDrink.name }}</h1>
      <h3 class="price">{{ alcoholicDrink.price }}</h3>
      <button class="add-to-cart">Add to Cart</button>
    </div>
  </div>
  <div v-else>
    <NotFoundPage></NotFoundPage>
  </div>
</template>
<script>
import { alcoholicDrinks } from "../temp-data";
import NotFoundPage from "./NotFoundPage.vue";

export default {
  name: "AlcoholicDrinkDetailPage",
  components: { NotFoundPage },
  data() {
    return {
      alcoholicDrink: alcoholicDrinks.find(
        (alcoholicDrink) => alcoholicDrink.id === this.$route.params.id
      ),
    };
  },
};
</script>
