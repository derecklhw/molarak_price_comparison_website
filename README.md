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
mvn javadoc:javadoc
```

or

```bash
mvn site
```

Selenium config

Pre-requisites:

1. Google Chrome 119.0.6045.159 - has been downgraded to 118, will need to write docs on the process <https://www.youtube.com/watch?v=OlMX0gxyL58>
2. Chrome Driver 119.0.6045.159 <https://chromedriver.chromium.org/downloads>

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
