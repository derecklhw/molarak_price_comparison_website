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
        String itemName = "blended-scotch-whisky";
        Random random = new Random();
        Integer[] volumeOptions = { 50, 70, 100 };

        for (int page = 1; page <= 3; page++) {
            driver.get(url + "/" + itemName + "?p=" + page + "&product_list_limit=96");
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

            for (Element prod : prods) {
                processProduct(prod, random, volumeOptions);
            }
        }

    }

    private void processProduct(Element prod, Random random, Integer[] volumeOptions) {
        String name = extractProductName(prod);
        String brand = extractBrand(name);
        name = name.replaceFirst(Pattern.quote(brand), "").trim();

        String category = "scotch-whisky";
        String imageUrl = extractImageUrl(prod);
        int volume = volumeOptions[random.nextInt(volumeOptions.length)];
        String websiteUrl = extractWebsiteUrl(prod);
        Double price = extractPrice(prod);

        System.out.println(name);
        System.out.println(brand);
        System.out.println(category);
        System.out.println(imageUrl);
        System.out.println(volume);
        System.out.println(websiteUrl);
        System.out.println(price);
        System.out.println();
    }

    private String extractProductName(Element prod) {
        Elements prodAnchorTags = prod.select("a.product-item-link");
        return !prodAnchorTags.isEmpty() ? prodAnchorTags.first().text() : "";
    }

    private String extractBrand(String name) {
        String brand = RegexUtil.matchFirstGroup(name, "The\\s+(\\w+)");
        return brand != null ? brand : name.split("\\s+")[0];
    }

    private String extractImageUrl(Element prod) {
        Elements prodImageTags = prod.select("img.product-image-photo");
        if (!prodImageTags.isEmpty()) {
            String src = prodImageTags.first().attr("src");
            return !RegexUtil.matches(src, "data:image/png;base64,.*") ? src : null;
        }
        return null;
    }

    private String extractWebsiteUrl(Element prod) {
        Elements prodAnchorTags = prod.select("a.product-item-link");
        return !prodAnchorTags.isEmpty() ? prodAnchorTags.first().attr("href") : "";
    }

    private Double extractPrice(Element prod) {
        Elements prodPriceTags = prod.select("span.price");
        if (!prodPriceTags.isEmpty()) {
            String priceText = prodPriceTags.text().trim().replaceAll("[^\\d. ]", "");
            return extractMaxPrice(priceText);
        }
        return null;
    }

    private Double extractMaxPrice(String priceText) {
        Pattern pattern = Pattern.compile("\\d+\\.?\\d*");
        Matcher matcher = pattern.matcher(priceText);

        double maxPrice = 0.0;
        while (matcher.find()) {
            double foundPrice = Double.parseDouble(matcher.group());
            if (foundPrice > maxPrice) {
                maxPrice = foundPrice;
            }
        }
        return maxPrice > 0.0 ? maxPrice : null;
    }

}