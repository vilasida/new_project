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
//        check that button is not clickable ("Clear Result")
//        click on "Result" button
//        check that text is displayed

//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")

//        check that the button "Clear Result" is clickable now
//        click on "Clear Result"
//        check that the text is still ("You entered number: "NUMBER YOU ENTERED""), but it is not displayed

        WebElement NumberArea = driver.findElement(By.id("number"));
        String stringNumber1 = "10";
        String stringNumber2 = "You entered number: ";

        NumberArea.clear();
        assertEquals(NumberArea.getText(), "");
        NumberArea.sendKeys("10"); //        enter a number under "Number"

        WebElement ClearButton = driver.findElement(By.id("clear_result_button_number"));
        ClearButton.click();
        assertFalse(ClearButton.isEnabled()); //        check that button is not clickable ("Clear Result")

        WebElement ResultButton = driver.findElement(By.id("result_button_number"));
        ResultButton.click(); //        click on "Result" button

        WebElement ResultTextArea = driver.findElement(By.id("result_number"));
        assertTrue(ResultTextArea.isDisplayed()); //        check that text is displayed

        // assertEquals(ResultTextArea.getText());
        //        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")

        assertTrue(ClearButton.isEnabled());//        check that the button "Clear Result" is clickable now

        ClearButton.click(); //        click on "Clear Result"

        //        check that the text is still ("You entered number: "NUMBER YOU ENTERED""), but it is not displayed



    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
//        check current url is base_url
        assertEquals(base_url, driver.getCurrentUrl());

//        click on "This is a link to Homepage"
        driver.findElement(By.id("Homepage link.")).click();

//        check that current url is not base_url
        assertFalse(driver.getCurrentUrl().equals(base_url));

//        verify that current url is homepage
        assertEquals("https://kristinek.github.io/test-sample/", driver.getCurrentUrl());


    }
}
