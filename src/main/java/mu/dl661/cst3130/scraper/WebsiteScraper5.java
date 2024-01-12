package mu.dl661.cst3130.scraper;

import java.time.Duration;

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

public class WebsiteScraper5 extends Thread {
    private String url;
    private static final Logger logger = LoggerFactory.getLogger(WebsiteScraper5.class);

    // Constructor
    public WebsiteScraper5(String url) {
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
        String itemName = "whiskey";

        String urlToScraped = url + "/GB/en/cat/foodhall/wines-spirits/spirits/" + itemName;
        driver.get(urlToScraped);
        logger.info("Scraping: " + urlToScraped);
        wait.until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.cssSelector(".col-xs-6.col-sm-4.c-listing-items__item")));

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
        Elements prods = doc.select(".col-xs-6.col-sm-4.c-listing-items__item");

        for (Element prod : prods) {
            System.out.println(url);
            // processProduct(prod, random, volumeOptions);
        }
        logger.info("Finished scraping: " + urlToScraped);

    }
}
