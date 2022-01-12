package selenium.seleniumtest;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Demoqa {


    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

        @Test
        public void demoqaTest(){
        driver.get("https://demoqa.com/automation-practice-form");
        Faker faker = new Faker();
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(faker.name().name());
            actions.sendKeys(Keys.TAB)
                    .sendKeys(faker.name().lastName())
                    .sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress())
                    .sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().phoneNumber())
                .sendKeys(Keys.TAB).sendKeys("12.01.2000" + Keys.ENTER)
                .sendKeys("Music, dancing.." + Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

/*            driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(faker.name().name());
            actions.sendKeys(Keys.TAB)
                    .sendKeys(faker.name().lastName())
                    .sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress())
                    .sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                    .sendKeys(Keys.TAB).sendKeys("123654")
                    .sendKeys(Keys.TAB).sendKeys("12.12.2002"+Keys.ENTER)
                    .sendKeys(Keys.TAB).sendKeys("M").sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
                    .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                    .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress())
                    .sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
                    .sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
                    .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();*/

    }


}
