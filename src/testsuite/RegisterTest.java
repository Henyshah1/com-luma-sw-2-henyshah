package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSignInPageDisplay() throws InterruptedException {
        driver.findElement(By.linkText("Create an Account")).click();
        Thread.sleep(3000);

        String expectedText = "Create New Customer Account";
        String actualText = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }
    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        driver.findElement(By.linkText("Create an Account")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("firstname")).sendKeys("Marshela");
        Thread.sleep(3000);

        driver.findElement(By.id("lastname")).sendKeys("patel");
        Thread.sleep(3000);

        driver.findElement(By.id("email_address")).sendKeys("Marshelapatel2@gmail.com");
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys("marshelashah1@1999#");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys("marshelashah1@1999#");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[.='Create an Account']")).click();

        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[@class='message-success success message']")).getText();
        Assert.assertEquals(expectedText, actualText);

        driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();
        Thread.sleep(3000);

        driver.findElement(By.partialLinkText("Sign ")).click();
        Thread.sleep(3000);

        String expectedText1 = "You are signed out";
        String actualText1 = driver.findElement(By.xpath("//span[@class='base' and @data-ui-id='page-title-wrapper']")).getText();
        Assert.assertEquals(expectedText1, actualText1);
    }
    @After
    public void tearDown(){
        closeBrowser();

    }

}
