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

export async function getAlcoholicDrinks() {
  const [rows] = await pool.query("SELECT * FROM alcoholic_drinks");
  return rows;
}

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

export async function searchAlcoholicDrinks(search, limit, offset) {
  let query = `
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

  // Check if both 'limit' and 'offset' are provided and add them to the query
  if (limit !== undefined && offset !== undefined) {
    query += " LIMIT ? OFFSET ?";
  }

  // Execute the query with parameters
  const queryParams = [`%${search}%`];

  // Add 'limit' and 'offset' parameters if they are both provided
  if (limit !== undefined && offset !== undefined) {
    queryParams.push(parseInt(limit)); // Assuming 'limit' is a number
    queryParams.push(parseInt(offset)); // Assuming 'offset' is a number
  }

  const [rows] = await pool.query(query, queryParams);
  return rows;
}

export async function countAllAlcoholicDrinks() {
  const [rows] = await pool.query("SELECT COUNT(*) FROM alcoholic_drinks");
  return rows[0]["COUNT(*)"];
}
