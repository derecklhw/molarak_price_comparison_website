<template>
  <div v-if="alcoholicDrink">
    <div class="img-wrap">
      <img :src="alcoholicDrink.alcoholic_drinks_imageUrl" />
    </div>
    <div class="alcoholic-drink-details">
      <h1>
        <strong>{{ alcoholicDrink.alcoholic_drinks_brand }}</strong>
        <h3>{{ alcoholicDrink.alcoholic_drinks_name }}</h3>
      </h1>
      <div class="d-flex justify-content-between">
        <h3 class="mb-0">Price from £{{ alcoholicDrink.price }}</h3>
        <h3 class="mb-0">Volume: {{ alcoholicDrink.volume }}cl</h3>
      </div>
      <button class="add-to-cart" @click="redirectToPurchase">Buy</button>
    </div>
    <AlcoholicDrinksComparisonList
      :alcoholicDrinks="comparaisonAlcoholicDrinks"
    ></AlcoholicDrinksComparisonList>
  </div>
  <div v-else>
    <NotFoundPage></NotFoundPage>
  </div>
</template>
<script>
import AlcoholicDrinksComparisonList from "@/components/AlcoholicDrinksComparisonList.vue";
import NotFoundPage from "./NotFoundPage.vue";
import axios from "axios";

export default {
  name: "AlcoholicDrinkDetailPage",
  components: { NotFoundPage, AlcoholicDrinksComparisonList },
  data() {
    return {
      alcoholicDrink: null,
      comparaisonAlcoholicDrinks: [],
    };
  },
  async created() {
    await axios
      .get(`/alcoholic_drinks/${this.$route.params.id}`)
      .then((res) => {
        this.alcoholicDrink = res.data;
        axios
          .get(`/alcoholic_drinks/comparison/${this.$route.params.id}`)
          .then((res) => {
            console.log(res.data);
            this.comparaisonAlcoholicDrinks = res.data;
          });
      });
  },
  methods: {
    /**
     * Redirects the user to the merchant's website for purchasing the alcoholic drink.
     */
    redirectToPurchase() {
      const purchaseUrl = this.alcoholicDrink.website_url;
      window.location.href = purchaseUrl;
    },
  },
};
</script>
