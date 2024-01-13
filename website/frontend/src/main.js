import { createApp } from "vue";
import App from "./App.vue";
import "./main.css";
import * as VueRouter from "vue-router";
import AlcoholicDrinksPage from "./pages/AlcoholicDrinksPage.vue";
import AlcoholicDrinkDetailPage from "./pages/AlcoholicDrinkDetailPage.vue";
import NotFoundPage from "./pages/NotFoundPage.vue";

createApp(App)
  .use(
    VueRouter.createRouter({
      history: VueRouter.createWebHistory(process.env.BASE_URL),
      routes: [
        {
          path: "/alcoholic-drinks",
          name: "Alcoholic Drinks Page",
          component: AlcoholicDrinksPage,
        },
        {
          path: "/alcoholic-drinks/:id",
          name: "Alcoholic Drinks Detail Page",
          component: AlcoholicDrinkDetailPage,
        },
        {
          path: "/:pathMatch(.*)*",
          name: "Not Found",
          component: NotFoundPage,
        },
      ],
    })
  )
  .mount("#app");
