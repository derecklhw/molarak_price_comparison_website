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
  const [rows] = await pool.query(
    "SELECT * FROM alcoholic_drinks WHERE id = ?",
    [id]
  );
  return rows[0];
}
