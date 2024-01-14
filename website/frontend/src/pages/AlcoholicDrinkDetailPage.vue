<template>
  <div v-if="alcoholicDrink">
    <div class="img-wrap">
      <img :src="alcoholicDrink.alcoholic_drinks_imageUrl" />
    </div>
    <div class="alcoholic-drink-details">
      <h1>{{ alcoholicDrink.alcoholic_drinks_name }}</h1>
      <h3 class="price">{{ alcoholicDrink.price }}</h3>
      <button class="add-to-cart">Add to Cart</button>
    </div>
  </div>
  <div v-else>
    <NotFoundPage></NotFoundPage>
  </div>
</template>
<script>
import NotFoundPage from "./NotFoundPage.vue";
import axios from "axios";

export default {
  name: "AlcoholicDrinkDetailPage",
  components: { NotFoundPage },
  data() {
    return {
      alcoholicDrink: null,
    };
  },
  async created() {
    const response = await axios.get(
      `/alcoholic_drinks/${this.$route.params.id}`
    );
    const alcoholicDrink = response.data;
    this.alcoholicDrink = alcoholicDrink;
  },
};
</script>
