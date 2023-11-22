# molarak_price_comparison_website

Install default OpenJDK

```bash
sudo apt-get install default-jdk
```

Install Maven

```bash
sudo apt-get install maven
```

<https://www.hostinger.com/tutorials/how-to-install-maven-on-ubuntu>

Build project

```bash
mvn package
```

Run project

```bash
java -jar target/molarak-1.0-jar-with-dependencies.jar
```

Create JDOC

```bash
mvn site
```

Selenium config

Pre-requisites:

1. Google Chrome 119.0.6045.159
2. Chrome Driver 119.0.6045.159 <https://chromedriver.chromium.org/downloads>

```java
System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
ChromeOptions options = new ChromeOptions();
options.addArguments("--headless");
```
