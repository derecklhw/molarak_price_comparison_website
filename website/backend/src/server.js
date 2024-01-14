import express from "express";

import {
  getAlcoholicDrink,
  getAlcoholicDrinks,
  searchAlcoholicDrinks,
  getAlcoholicDrinkComparison,
} from "./database.js";

const app = express();
app.use(express.json());

/**
 * Endpoint to get all alcoholic drinks.
 *
 * @route GET /alcoholic_drinks
 * @returns {Promise<Array>} - Array of alcoholic drinks.
 */
app.get("/alcoholic_drinks", async (req, res) => {
  const alcoholicDrinks = await getAlcoholicDrinks();
  res.json(alcoholicDrinks);
});

/**
 * Endpoint to get a specific alcoholic drink by ID.
 *
 * @route GET /alcoholic_drinks/:id
 * @param {string} req.params.id - The ID of the alcoholic drink.
 * @returns {Promise<Object>} - The alcoholic drink object.
 */
app.get("/alcoholic_drinks/:id", async (req, res) => {
  const alcoholicDrink = await getAlcoholicDrink(req.params.id);
  res.json(alcoholicDrink);
});

/**
 * Endpoint to search for alcoholic drinks.
 *
 * @route GET /alcoholic_drinks/search/:search
 * @param {string} req.params.search - The search query.
 * @param {number} req.query.limit - The maximum number of results to return.
 * @param {number} req.query.offset - The offset for pagination.
 * @returns {Promise<Array>} - Array of matching alcoholic drinks.
 */
app.get("/alcoholic_drinks/search/:search", async (req, res) => {
  const { limit, offset } = req.query;
  const alcoholicDrinks = await searchAlcoholicDrinks(
    req.params.search,
    limit,
    offset
  );
  res.json(alcoholicDrinks);
});

/**
 * Endpoint to get a comparison of alcoholic drinks.
 *
 * @route GET /alcoholic_drinks/comparison/:id
 * @param {string} req.params.id - The ID of the alcoholic drink for comparison.
 * @returns {Promise<Array>} - Array of alcoholic drinks for comparison.
 */
app.get("/alcoholic_drinks/comparison/:id", async (req, res) => {
  const alcoholicDrinks = await getAlcoholicDrinkComparison(req.params.id);
  res.json(alcoholicDrinks);
});

/**
 * Error handling middleware.
 *
 * @param {Error} err - The error object.
 * @param {Object} req - The request object.
 * @param {Object} res - The response object.
 * @param {Function} next - The next middleware function.
 */
app.use((err, req, res, next) => {
  console.log(err.stack);
  res.status(500).send("Something broke!");
});

app.listen(8000, () => {
  console.log("Server is listening on port 8000");
});
