import { createApp } from "vue";
import App from "./App.vue";
import "./main.css";
import * as VueRouter from "vue-router";
import ProductsPage from "./pages/ProductsPage.vue";
import ProductDetailPage from "./pages/ProductDetailPage.vue";
import NotFoundPage from "./pages/NotFoundPage.vue";

createApp(App)
  .use(
    VueRouter.createRouter({
      history: VueRouter.createWebHistory(process.env.BASE_URL),
      routes: [
        {
          path: "/products",
          name: "Products Page",
          component: ProductsPage,
        },
        {
          path: "/products/:id",
          name: "Product Detail Page",
          component: ProductDetailPage,
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
