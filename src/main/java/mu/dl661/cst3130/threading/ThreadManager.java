package mu.dl661.cst3130.threading;

import mu.dl661.cst3130.scraper.*;

public class ThreadManager {
    public void runScraperThreads() {
        Thread website1 = new WebsiteScraper1("http://www.whiskyshop.com");
        Thread website2 = new WebsiteScraper2("http://www.masterofmalt.com");
        Thread website3 = new WebsiteScraper3("https://www.onbuy.com");
        Thread website4 = new WebsiteScraper4("http://www.thewhiskyexchange.com");
        Thread website5 = new WebsiteScraper5("https://spiritskiosk.com");

        website1.start();
        website2.start();
        website3.start();
        website4.start();
        website5.start();

        try {
            website1.join();
            website2.join();
            website3.join();
            website4.join();
            website5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
