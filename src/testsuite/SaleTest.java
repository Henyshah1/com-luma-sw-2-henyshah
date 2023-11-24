package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() throws InterruptedException {

        // Click on sale menu tab
        driver.findElement(By.xpath("//span[.='Sale']")).click();
        Thread.sleep(3000);

        // Click on jackets link on left side under womens category
        driver.findElement(By.linkText("Jackets")).click();
        Thread.sleep(3000);

        // verify text jackets
        String expectedText = "Jackets";
        String actualText = driver.findElement(By.xpath("//span[@class='base' or @data-ui-id='page-title-wrapper']")).getText();
        Assert.assertEquals(expectedText, actualText);

        // count the total items displayed on page and print the name of all items

        List<WebElement> item = driver.findElements(By.xpath("//a[@class='product-item-link']"));
        System.out.println("Total item : " + item.size());
        System.out.println("-----------------");

        for(WebElement e : item){
            System.out.println(e.getText());
        }
    }


    @After
    public void tearDown () {
        closeBrowser();
    }
}
