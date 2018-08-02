package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Sample5Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/test-sample/examples/al_and_pu");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void goToAlertedPageViaButton() throws Exception {
//         TODO:
          WebElement alButon=driver.findElement(By.className("w3-blue"));
          alButon.click();
          Alert alert = driver.switchTo().alert();
          alert.accept();
          assertEquals("error1","Booooooooo!", alert.getText());
          alert.accept();
          assertEquals("error2",driver.getCurrentUrl(),("https://kristinek.github.io/test-sample/examples/al_p"));
//        click on "To go to alerted page press Ok. Or stay here" button
//        switch to alert
//        click ok
//        switch to second alert
//        verify alert text
//        click ok on second alert
//        verify that the correct page is opened
    }

    @Test
    public void doNotGoToAlertedPageViaButton() throws Exception {
//         TODO:
        driver.get("https://kristinek.github.io/test-sample/examples/al_and_pu");
        WebElement alButon=driver.findElement(By.className("w3-blue"));
        alButon.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        assertEquals(driver.findElement(By.id("textForAlerts")).getText(),"So you desided to say? Good!");
//        click on "To go to alerted page press Ok. Or stay here" button
//        switch to alert
//        click cancel
//        verify the text on page
    }
}
