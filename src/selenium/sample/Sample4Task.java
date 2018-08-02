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
        String sendNum = "10";
        String expectedNum = "You entered number: \"10\"";
        WebElement numberInput = driver.findElement(By.id("number"));
        WebElement result_num = driver.findElement(By.id("result_number"));
        WebElement resultButton = driver.findElement(By.id("result_button_number"));
        WebElement clearButton = driver.findElement(By.id("clear_result_button_number"));
//         TODO:
//        enter a number under "Number"
        numberInput.clear();
        numberInput.sendKeys(sendNum);
//        check that button is not clickable
        assertTrue(resultButton.isEnabled());
        assertFalse(clearButton.isEnabled());
//        click on "Result" button
        resultButton.click();
//        check that text is displayed
        assertTrue(result_num.isDisplayed());
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
        assertTrue(result_num.getText().equals(expectedNum));
//        check that the button "Clear Result" is clickable now
        assertTrue(clearButton.isEnabled());
//        click on "Clear Result"
        clearButton.click();
//        check that the text is still ("You entered number: "NUMBER YOU ENTERED""), but it is not displayed
        assertFalse(result_num.isDisplayed());
        assertTrue(result_num.getAttribute("textContent").equals(expectedNum));
        System.out.println(result_num.getAttribute("textContent"));
    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
//        check current url is base_url
        assertEquals(base_url, driver.getCurrentUrl());
//        click on "This is a link to Homepage"
        driver.findElement(By.linkText("This is a link to Homepage")).click();
//        check that current url is not base_url
        assertNotEquals(base_url, driver.getCurrentUrl());
//        verify that current url is homepage
        assertEquals(driver.getCurrentUrl(), "https://kristinek.github.io/test-sample/");
    }
}
