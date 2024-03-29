import mysql from "mysql2";
import dotenv from "dotenv";

dotenv.config();

const pool = mysql
  .createPool({
    host: process.env.MYSQL_HOST,
    user: process.env.MYSQL_USER,
    password: process.env.MYSQL_PASSWORD,
    database: process.env.MYSQL_DATABASE,
  })
  .promise();

/**
 * Retrieves all alcoholic drinks from the database.
 * @returns {Promise<Array<Object>>} - The alcoholic drinks.
 *
 */
export async function getAlcoholicDrinks() {
  const [rows] = await pool.query("SELECT * FROM alcoholic_drinks");
  return rows;
}

/**
 * Retrieves an alcoholic drink from the database using the provided 'id'.
 * @param {number} id - The id of the alcoholic drink to retrieve.
 * @returns {Promise<Object>} - The alcoholic drink.
 */
export async function getAlcoholicDrink(id) {
  const query = `
    SELECT 
      ad.id AS alcoholic_drinks_id, 
      ad.name AS alcoholic_drinks_name, 
      ad.brand AS alcoholic_drinks_brand, 
      ad.imageUrl AS alcoholic_drinks_imageUrl,
      adv.volume,
      c.website_name,
      c.website_url,
      c.price
    FROM alcoholic_drinks ad
    LEFT JOIN alcoholic_drinks_volumes adv ON ad.id = adv.alcoholic_drinks_id
    LEFT JOIN comparison c ON adv.id = c.alcoholic_drinks_volumes_id
    WHERE ad.id = ?;
  `;

  const [rows] = await pool.query(query, [id]);

  return rows[0];
}

/**
 * Searches for alcoholic drinks based on the provided search term.
 * @param {string} search - The search term to match against the name of alcoholic drinks.
 * @param {number} limit - The maximum number of results to return.
 * @param {number} offset - The number of results to skip before starting to return data.
 * @returns {Promise<{ data: Array<Object>, count: number }>} - The search results and the total count of matching records.
 */
export async function searchAlcoholicDrinks(search, limit, offset) {
  // Query for fetching data
  let dataQuery = `
    SELECT 
      ad.id AS alcoholic_drinks_id, 
      ad.name AS alcoholic_drinks_name, 
      ad.brand AS alcoholic_drinks_brand, 
      ad.imageUrl AS alcoholic_drinks_imageUrl,
      adv.volume,
      c.website_url,
      c.price
    FROM alcoholic_drinks ad
    LEFT JOIN alcoholic_drinks_volumes adv ON ad.id = adv.alcoholic_drinks_id
    LEFT JOIN comparison c ON adv.id = c.alcoholic_drinks_volumes_id
    WHERE ad.name LIKE ?`;

  // Query for counting total records
  let countQuery = `
    SELECT COUNT(*) AS total
    FROM alcoholic_drinks ad
    WHERE ad.name LIKE ?`;

  const queryParams = [`%${search}%`];

  // Add 'limit' and 'offset' parameters for the data query if they are both provided
  if (limit !== undefined && offset !== undefined) {
    dataQuery += " LIMIT ? OFFSET ?";
    queryParams.push(parseInt(limit)); // Assuming 'limit' is a number
    queryParams.push(parseInt(offset)); // Assuming 'offset' is a number
  }

  // Execute the data query
  const [dataRows] = await pool.query(dataQuery, queryParams);

  // Execute the count query
  const [countRows] = await pool.query(countQuery, [`%${search}%`]);

  // Extract the total count
  const totalCount = countRows[0].total;

  return {
    data: dataRows,
    count: totalCount,
  };
}

/**
 * Retrieves the comparison data for the alcoholic drink with the provided 'id'.
 * @param {number} id - The id of the alcoholic drink.
 * @returns {Promise<Array<Object>>} - The comparison data.
 */
export async function getAlcoholicDrinkComparison(id) {
  // Retrieve the name of the alcoholic drink using the provided 'id'
  const [drinkRows] = await pool.query(
    "SELECT name FROM alcoholic_drinks WHERE id = ?",
    [id]
  );

  // Extract the name from the result
  const { name } = drinkRows[0];

  // Use the name to search for entries in the 'alcoholic_drinks' table
  const query = `
    SELECT 
      ad.id AS alcoholic_drinks_id, 
      ad.name AS alcoholic_drinks_name, 
      ad.brand AS alcoholic_drinks_brand, 
      ad.imageUrl AS alcoholic_drinks_imageUrl,
      adv.volume,
      c.website_name,
      c.website_url,
      c.price
    FROM alcoholic_drinks ad
    LEFT JOIN alcoholic_drinks_volumes adv ON ad.id = adv.alcoholic_drinks_id
    LEFT JOIN comparison c ON adv.id = c.alcoholic_drinks_volumes_id
    WHERE ad.name = ? AND ad.id != ?;  -- Exclude the entry with the provided 'id'
  `;

  const [comparisonRows] = await pool.query(query, [name, id]);

  return comparisonRows;
}
