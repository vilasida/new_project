package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Sample4Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/test-sample/examples/act";
    String home_url="https://kristinek.github.io/test-sample/";
    String home_url2="https://kristinek.github.io/test-sample/";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void enterNumber() throws Exception {
//         TODO:
//        enter a number under "Number"
        WebElement numArea = driver.findElement(By.id("number"));
        WebElement ResultButton = driver.findElement(By.id("result_button_number"));
        WebElement result = driver.findElement(By.id("result_number"));
        WebElement clear=driver.findElement(By.id("clear_result_button_number"));
       String num1="69";
       String num2="You entered number: ";
        numArea.clear();
        assertEquals(numArea.getAttribute("value"), "");
        numArea.sendKeys(num1);
        assertEquals(numArea.getAttribute("value"), num1);
//        check that button is not clickable
        assertTrue(ResultButton.isEnabled());
//        click on "Result" button
        ResultButton.click();
//        check that text is displayed
        assertTrue(numArea.isDisplayed());
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
        assertEquals(result.getText(), num2+"\""+ num1+ "\"" );
//        check that the button "Clear Result" is clickable now
        assertTrue(clear.isEnabled());
//        click on "Clear Result"
        clear.click();
//        check that the text is still ("You entered number: "NUMBER YOU ENTERED""), but it is not displayed
        assertFalse(result.isDisplayed());
    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
//        check current url is base_url
        assertEquals(base_url, driver.getCurrentUrl());
//        click on "This is a link to Homepage
        WebElement link= driver.findElement(By.id("homepage_link"));
        link.click();
//        check that current url is not base_url
        assertFalse(driver.getCurrentUrl(), equals(home_url));
//        verify that current url is homepage
        assertEquals(home_url, driver.getCurrentUrl());
    }
}
