import express from "express";

import { getAlcoholicDrink, getAlcoholicDrinks } from "./database.js";

const app = express();
app.use(express.json());

app.get("/alcoholic_drinks", async (req, res) => {
  const alcoholicDrinks = await getAlcoholicDrinks();
  res.json(alcoholicDrinks);
});

app.get("/alcoholic_drinks/:id", async (req, res) => {
  const alcoholicDrink = await getAlcoholicDrink(req.params.id);
  res.json(alcoholicDrink);
});

app.use((err, req, res, next) => {
  console.log(err.stack);
  res.status(500).send("Something broke!");
});

app.listen(8000, () => {
  console.log("Server is listening on port 8000");
});
