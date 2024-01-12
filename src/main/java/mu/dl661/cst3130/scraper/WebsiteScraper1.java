package mu.dl661.cst3130.scraper;

import java.time.Duration;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mu.dl661.cst3130.utils.RegexUtil;

public class WebsiteScraper1 extends Thread {

    private String url;

    // Constructor
    public WebsiteScraper1(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        String itemName = "blended-scotch-whisky";

        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();

        options.setBinary(
                System.getProperty("user.dir") + "/chrome-linux64/chrome");
        // options.addArguments("--headless");

        // Create instance of web driver - this must be on the path.
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int page = 1; page <= 3; page++) {
            driver.get(url + "/" + itemName + "?p=" + page + "&product_list_limit=96");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".item.product.product-item")));

            // Scroll the page to load all content
            for (int i = 0; i < 2; i++) {
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            String htmlSource = driver.getPageSource();

            Document doc = Jsoup.parse(htmlSource);
            Elements prods = doc.select(".item.product.product-item");

            Random random = new Random();
            Integer[] volumeOptions = { 50, 70, 100 };

            for (Element prod : prods) {

                String name = "";
                String brand = "";
                String category = "scotch-whisky";
                String imageUrl = "";
                int volume = 0;
                String websiteUrl = "";
                Double price = 0.0;

                Elements prodAnchorTags = prod.select("a.product-item-link");

                for (Element prodAnchorTag : prodAnchorTags) {
                    name = prodAnchorTag.text();
                    websiteUrl = prodAnchorTag.attr("href");
                }

                brand = RegexUtil.matchFirstGroup(name, "The\\s+(\\w+)");

                if (brand == null) {
                    brand = name.split("\\s+")[0];
                }

                Elements prodImageTags = prod.select("img.product-image-photo");
                for (Element prodImageTag : prodImageTags) {
                    String src = prodImageTag.attr("src");
                    if (RegexUtil.matches(src, "data:image/png;base64,.*")) {
                        imageUrl = null;
                    } else {
                        imageUrl = src;
                    }
                }

                int randomIndex = random.nextInt(volumeOptions.length);
                volume = volumeOptions[randomIndex];

                Elements prodPriceTags = prod.select("span.price");

                if (!prodPriceTags.isEmpty() && !prodPriceTags.text().trim().isEmpty()) {
                    String priceText = prodPriceTags.text().trim().replaceAll("[^\\d. ]", "");
                    Pattern pattern = Pattern.compile("\\d+\\.?\\d*");
                    Matcher matcher = pattern.matcher(priceText);

                    double maxPrice = 0.0;
                    while (matcher.find()) {
                        double foundPrice = Double.parseDouble(matcher.group());
                        if (foundPrice > maxPrice) {
                            maxPrice = foundPrice;
                        }
                    }

                    if (maxPrice > 0.0) {
                        price = maxPrice;
                    }
                }

            }
        }

        // Exit driver and close Chrome
        driver.quit();
    }
}