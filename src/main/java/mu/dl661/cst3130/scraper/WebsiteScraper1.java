package mu.dl661.cst3130.scraper;

import java.time.Duration;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        for (int page = 1; page <= 3; page++) {
            driver.get(url + "/" + itemName + "?p=" + page + "&product_list_limit=96");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".item.product.product-item")));

            String htmlSource = driver.getPageSource();

            Document doc = Jsoup.parse(htmlSource);
            Elements prods = doc.select(".item.product.product-item");

            for (Element prod : prods) {
                Elements prodAnchorTags = prod.select("a.product.photo.product-item-photo");

                for (Element prodAnchorTag : prodAnchorTags) {
                    String websiteUrl = prodAnchorTag.attr("href");

                    driver.get(websiteUrl);

                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".product-info-main")));

                    String productHtmlSource = driver.getPageSource();

                    Document productDoc = Jsoup.parse(productHtmlSource);

                    String name = productDoc.select(".page-title-wrapper.product > h1").text();
                    System.out.println(name);

                }
            }
        }

        // Exit driver and close Chrome
        driver.quit();
    }
}