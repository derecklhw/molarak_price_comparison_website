package mu.dl661.cst3130.scraper;

import java.time.Duration;
import java.util.Random;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mu.dl661.cst3130.utils.RegexUtil;

public class WebsiteScraper3 extends Thread {
    private String url;
    private static final Logger logger = LoggerFactory.getLogger(WebsiteScraper3.class);

    // Constructor
    public WebsiteScraper3(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary(
                System.getProperty("user.dir") + "/chrome-linux64/chrome");
        // options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            scrapePages(driver, js, wait);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    private void scrapePages(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) throws InterruptedException {
        String itemName = "whisky~c14232";
        Random random = new Random();
        Integer[] volumeOptions = { 50, 70, 100 };

        for (int page = 0; page <= 120; page += 60) {
            String urlToScraped = url + "/gb/" + itemName + "/?category=14232&offset=" + page;
            driver.get(urlToScraped);
            logger.info("Scraping: " + urlToScraped);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".product.cb")));

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
            Elements prods = doc.select(".product.cb");

            for (Element prod : prods) {
                processProduct(prod, random, volumeOptions);
            }

            logger.info("Finished scraping: " + urlToScraped);
        }
    }

    private void processProduct(Element prod, Random random, Integer[] volumeOptions) {
        String name = extractProductName(prod);
        String brand = extractBrand(name);
        name = name.replaceFirst(Pattern.quote(brand), "").trim();

        // Remove "The " with a space in front of the name
        if (RegexUtil.matches(name, "^The\\s")) {
            name = name.replaceFirst("^The\\s", "").trim();
        }

        String category = "scotch-whisky";
        String imageUrl = extractImageUrl(prod);
        int volume = extractVolume(prod, random, volumeOptions);
        String websiteUrl = extractWebsiteUrl(prod);
        Double price = extractPrice(prod);

    }

    private String extractProductName(Element prod) {
        Elements prodAnchorTags = prod.select("span.name");
        return !prodAnchorTags.isEmpty() ? prodAnchorTags.first().text() : "";
    }

    private String extractBrand(String name) {
        String brand = RegexUtil.matchFirstGroup(name, "The\\s+(\\w+)");
        return brand != null ? brand : name.split("\\s+")[0];
    }

    private String extractImageUrl(Element prod) {
        Elements prodImageTags = prod.select(
                "span.image > picture > source");
        return !prodImageTags.isEmpty() ? prodImageTags.first().attr("data-src") : "";
    }

    private int extractVolume(Element prod, Random random, Integer[] volumeOptions) {
        Elements prodVolumeTags = prod.select("span.name");
        if (!prodVolumeTags.isEmpty()) {
            String volumeText = prodVolumeTags.first().text();

            String matchText = RegexUtil.matchFirstGroup(volumeText, "(\\d{2})\\s*cl");
            if (matchText != null) {
                try {
                    return Integer.parseInt(matchText);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

        }

        return volumeOptions[random.nextInt(volumeOptions.length)];
    }

    private String extractWebsiteUrl(Element prod) {
        Elements prodAnchorTags = prod.select("div.product.cb");
        return !prodAnchorTags.isEmpty() ? prodAnchorTags.first().attr("data-product-link") : "";
    }

    private double extractPrice(Element prod) {
        Elements prodPriceTags = prod.select("span.price-wrap > span.value");
        if (!prodPriceTags.isEmpty()) {
            String priceText = prodPriceTags.text().trim();

            priceText = priceText.replaceAll("[^\\d.]", "");

            try {
                return Double.parseDouble(priceText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0.0;
    }
}
