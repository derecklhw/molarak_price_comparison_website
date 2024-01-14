<template>
  <br />
  <h2><strong>Comparison</strong></h2>
  <div v-if="alcoholicDrinks.length > 0" class="grid-wrap">
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
      <h3 class="alcoholic-drink-name mt-1">£ {{ alcoholicDrink.price }}</h3>
      <button
        class="btn btn-dark"
        @click="redirectToPurchase(alcoholicDrink.website_url)"
      >
        To merchant
      </button>
    </div>
  </div>
  <div v-else>
    <h5>Nothing to compare</h5>
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
  methods: {
    /**
     * Redirects the user to the merchant's website for purchasing the alcoholic drink.
     * @param {string} website_url - The URL of the merchant's website.
     */
    redirectToPurchase(website_url) {
      window.location.href = website_url;
    },
  },
};
</script>
