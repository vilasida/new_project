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
//         TODO:
//        enter a number under "Number"
        WebElement textField = driver.findElement(By.cssSelector("input[type='number']"));
        assertTrue(textField.isEnabled());
        textField.clear();
        String enteredNumber = "78";
        textField.sendKeys(enteredNumber);
        assertTrue(textField.getAttribute("value").contentEquals(enteredNumber));

//          check that button is not clickable
        WebElement buttonClear = driver.findElement(By.id("clear_result_button_number"));
        assertFalse(buttonClear.isEnabled());

//        click on "Result" button
        WebElement buttonResult = driver.findElement(By.id("result_button_number"));
        assertTrue(buttonResult.isEnabled());
        buttonResult.click();

//        check that text is displayed
        WebElement textMessage = driver.findElement(By.id("result_number"));
        assertTrue(textMessage.isDisplayed());

//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
       String actualText = textMessage.getText();
       // String actualText = textMessage.getText(); //incorrect
        assertTrue(actualText.contentEquals("You entered number: \"" + enteredNumber + "\""));

//        check that the button "Clear Result" is clickable now
        assertTrue(buttonClear.isEnabled());

//        click on "Clear Result"
        buttonClear.click();

//        check that the text is still ("You entered number: "NUMBER YOU ENTERED""), but it is not displayed
        actualText = textMessage.getText();
        assertTrue(actualText.contentEquals(""));
        assertFalse(textMessage.isDisplayed());
    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
//        check current url is base_url
        assertEquals(base_url, driver.getCurrentUrl(),);

//        click on "This is a link to Homepage"
        WebElement linkHome = driver.findElement(By.linkText("This is a link to Homepage"));
        assertTrue(linkHome.isDisplayed());
        linkHome.click();

//        check that current url is not base_url
        String currentURL = driver.getCurrentUrl();
        assertFalse(currentURL.contentEquals(base_url));

//        verify that current url is homepage
        assertTrue(currentURL.contentEquals("https://kristinek.github.io/test-sample/"));
    }
}
