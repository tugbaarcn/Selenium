package selenium.seleniumtest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import selenium.utilities.TestBase;

import java.util.List;

public class HepsiBurada extends TestBase {
    @Test
    public void productNumber() throws InterruptedException {
        driver.get("https://www.hepsiburada.com");
        WebElement searchBox = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        searchBox.sendKeys("kulaklık" + Keys.ENTER);
       driver.findElement(By.xpath("(//*[@data-test-id='dropdown-toggle'])[2]")).click();

 /*       Select select = new Select(dropDown);
        select.selectByIndex(3);*/


        driver.findElement(By.linkText("Artan Fiyat")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class='searchbox-searchInput']")).sendKeys("sony");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@name='markalar']")).click();
        Thread.sleep(2000);
        String sonyUrl= driver.getCurrentUrl();
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(3000);
        driver.get(sonyUrl);
        Thread.sleep(5000);
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);

        List<WebElement> sonyList = driver.findElements(By.xpath("//*[@data-test-id='product-card-image-container']"));

        Assert.assertEquals(78, sonyList.size());


    }
}
