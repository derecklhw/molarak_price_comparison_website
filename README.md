# molarak_price_comparison_website

## Scraper

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
mvn javadoc:javadoc
```

or

```bash
mvn site
```

Selenium Installation

Pre-requisites:

Google Chrome & Chrome Driver version: 118.0.5993.70

Downloads: <https://chromedriver.chromium.org/downloads> 

Reference:  <https://www.youtube.com/watch?v=OlMX0gxyL58>

Selenium Configuration

```java
System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
ChromeOptions options = new ChromeOptions();
options.addArguments("--headless");
```

MySQL Database

Import dump

```bash
sudo mysql molarak < dump_molarak.sql
```

Export dump

```bash
sudo mysqldump -u root -p molarak > dump_molarak.sql
```

## Web

### frontend

#### Project setup

```bash
npm install
```

#### Compiles and hot-reloads for development

```bash
npm run serve
```

#### Compiles and minifies for production

```bash
npm run build
```

#### Lints and fixes files

```bash
npm run lint
```



### Backend

#### Run

```bash
npm run dev
```
