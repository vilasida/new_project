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
        WebElement result=driver.findElement(By.id("result_button_number")); //atrod pogu result
        WebElement clearResult=driver.findElement(By.id("clear_result_button_number")); //atrod clear pogu
        WebElement field= driver.findElement(By.name("vfb-9"));
        WebElement text=driver.findElement(By.id("result_number"));
        field.clear(); //notīra ja kaut kas jau bija sākumā
        field.sendKeys("10"); //aizsūta jaunu virkni
        assertFalse("error1",clearResult.isEnabled()); //nav enabled
        result.click(); //piespiež result pogu
        assertTrue("error2",text.isDisplayed()); //pārbauda vai teksts ir attēlots
        assertTrue("error3"+text.getText(),text.getText().equals("You entered number: \"10\"")); //pārbauda vai teksts atbilst
        assertTrue("clickable",clearResult.isEnabled());
        clearResult.click(); //notīra rezultātu
        assertEquals("You entered number: \"10\"",text.getAttribute("innerText")); //pārbauda vai teksts ir tāds pats
        assertFalse("error5",text.isDisplayed()); //pārbauda vai teksts nav attēlots

//        enter a number under "Number"
//        check that button is not clickable
//        click on "Result" button
//        check that text is displayed
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
//        check that the button "Clear Result" is clickable now
//        click on "Clear Result"
//        check that the text is still ("You entered number: "NUMBER YOU ENTERED""), but it is not displayed
    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
        assertEquals(base_url, driver.getCurrentUrl());
        driver.findElement(By.id("homepage_link")).click();
        assertFalse(driver.getCurrentUrl().equals(base_url));
        assertEquals("https://kristinek.github.io/test-sample/", driver.getCurrentUrl());
//        check current url is base_url
//        click on "This is a link to Homepage"
//        check that current url is not base_url
//        verify that current url is homepage
    }
}
