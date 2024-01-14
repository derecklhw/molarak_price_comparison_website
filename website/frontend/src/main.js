import { createApp } from "vue";
import App from "./App.vue";
import "./main.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap";
import * as VueRouter from "vue-router";
import AlcoholicDrinksPage from "./pages/AlcoholicDrinksPage.vue";
import AlcoholicDrinkDetailPage from "./pages/AlcoholicDrinkDetailPage.vue";
import NotFoundPage from "./pages/NotFoundPage.vue";
import HomePage from "./pages/HomePage.vue";

createApp(App)
  .use(
    VueRouter.createRouter({
      history: VueRouter.createWebHistory(process.env.BASE_URL),
      routes: [
        {
          path: "/",
          name: "Home Page",
          component: HomePage,
        },
        {
          path: "/alcoholic-drinks/search/:search",
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
