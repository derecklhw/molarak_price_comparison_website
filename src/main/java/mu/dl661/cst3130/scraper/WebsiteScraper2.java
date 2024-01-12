package mu.dl661.cst3130.scraper;

import java.time.Duration;
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

public class WebsiteScraper2 extends Thread {
    private String url;
    private static final Logger logger = LoggerFactory.getLogger(WebsiteScraper2.class);

    // Constructor
    public WebsiteScraper2(String url) {
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
        String itemName = "scotch-whisky";

        String urlToScraped = url + "/whisky/shop-all-" + itemName + "/?current=n_" + 1 + "_n&size=n_75_n";
        driver.get(urlToScraped);
        logger.info("Scraping: " + urlToScraped);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector(".Productstyled__StyledProduct-sc-1u7jkhl-0.gYdgyw")));

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
        Elements prods = doc.select(".Productstyled__StyledProduct-sc-1u7jkhl-0.gYdgyw");

        for (Element prod : prods) {
            processProduct(prod);
        }

        logger.info("Finished scraping: " + urlToScraped);
    }

    private void processProduct(Element prod) {
        String name = extractProductName(prod);
        String brand = extractBrand(name);
        name = name.replaceFirst(Pattern.quote(brand), "").trim();

        // Remove "The " with a space in front of the name
        if (RegexUtil.matches(name, "^The\\s")) {
            name = name.replaceFirst("^The\\s", "").trim();
        }

        String category = "scotch-whisky";
        String imageUrl = extractImageUrl(prod);
        int volume = extractVolume(prod);
        String websiteUrl = extractWebsiteUrl(prod);
        Double price = extractPrice(prod);
    }

    private String extractProductName(Element prod) {
        Elements prodAnchorTags = prod.select("a.Productstyled__StyledProductTitle-sc-1u7jkhl-4.fkAzjy");
        return !prodAnchorTags.isEmpty() ? prodAnchorTags.first().text() : "";
    }

    private String extractBrand(String name) {
        String brand = RegexUtil.matchFirstGroup(name, "The\\s+(\\w+)");
        return brand != null ? brand : name.split("\\s+")[0];
    }

    private String extractImageUrl(Element prod) {
        Elements prodImageTags = prod.select(
                "img.Imagestyled__StyledImage-sc-o2u3zt-0.fqTGiu.Productstyled__StyledProductImage-sc-1u7jkhl-2.hGWvXZ");
        return !prodImageTags.isEmpty() ? url + prodImageTags.first().attr("src") : "";
    }

    private int extractVolume(Element prod) {
        Elements prodVolumeTags = prod.select("div.Productstyled__StyledProductAttributes-sc-1u7jkhl-5.hJkuHj");
        if (!prodVolumeTags.isEmpty()) {
            String volumeText = RegexUtil.matchFirstGroup(prodVolumeTags.first().text(), "(\\d+)\\s*cl");
            if (volumeText != null) {
                try {
                    return Integer.parseInt(volumeText);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    private String extractWebsiteUrl(Element prod) {
        Elements prodAnchorTags = prod.select("a.Productstyled__StyledProductImageAnchor-sc-1u7jkhl-1.kehXyw");
        return !prodAnchorTags.isEmpty() ? url + prodAnchorTags.first().attr("href") : "";
    }

    private double extractPrice(Element prod) {
        Elements prodPriceTags = prod.select("div.Discount__StyledPrice-sc-fd12ta-0.bZMozI.priceText");
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