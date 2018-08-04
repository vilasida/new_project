package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
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
    public void selectCheckBox() throws Exception {
//         TODO:
//        check that none of the checkboxes are ticked
        List<WebElement> checkBoxes  = driver.findElements(By.xpath("//*[@class='w3-check'][@type='checkbox']"));
        for (WebElement wE : checkBoxes){
            assertFalse(wE.isSelected());
        }

//        tick  "Option 2"
        WebElement option2 = driver.findElement(By.xpath("//*[@class='w3-check'][@type='checkbox'][@value='Option 2']"));
        option2.click();

//        check that "Option 1" and "Option 3' are not ticked, but "Option 2" is ticked
        WebElement option1 = driver.findElement(By.xpath("//*[@class='w3-check'][@type='checkbox'][@value='Option 1']"));
        WebElement option3 = driver.findElement(By.xpath("//*[@class='w3-check'][@type='checkbox'][@value='Option 3']"));
        assertFalse(option1.isSelected());
        assertTrue(option2.isSelected());
        assertFalse(option3.isSelected());

//        tick  "Option 3"
        option3.click();

//        click result
        WebElement resultButtonCheckbox = driver.findElement(By.cssSelector("#result_button_checkbox"));
        resultButtonCheckbox.click();

//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
        WebElement resultCheckbox = driver.findElement(By.cssSelector("#result_checkbox"));
        String expectedString = "You selected value(s): Option 2, Option 3";
        assertEquals(expectedString, resultCheckbox.getText());

    }


    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
//        check that none of the radio are selected
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check.radio"));
        for (WebElement e : radioButtons){
            assertFalse(e.isSelected());
        }

//        select  "Option 3"
        WebElement option3 = driver.findElement(By.cssSelector("#vfb-7-3"));
        option3.click();

//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
        WebElement option1 = driver.findElement(By.cssSelector("#vfb-7-1"));
        WebElement option2 = driver.findElement(By.cssSelector("#vfb-7-2"));
        assertFalse(option1.isSelected());
        assertFalse(option2.isSelected());
        assertTrue(option3.isSelected());

//        select  "Option 1"
        option1.click();

//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected"
        assertTrue(option1.isSelected());
        assertFalse(option2.isSelected());
        assertFalse(option3.isSelected());

//        click result
        WebElement resultButton = driver.findElement(By.cssSelector("#result_button_ratio"));
        resultButton.click();

//        check that 'You selected option: Option 1' text is being displayed
        WebElement resultRatio = driver.findElement(By.cssSelector("#result_radio"));
        String expectedResult = "You selected option: Option 1";
        assertEquals(expectedResult, resultRatio.getText());
    }

    @Test
    public void selectOption() throws Exception {
//         TODO:
//        select "Option 3" in Select
          Select select = new Select(driver.findElement(By.cssSelector(".w3-select")));
          select.selectByVisibleText("Option 3");

//        check that selected option is "Option 3"
          assertEquals("Option 3", select.getFirstSelectedOption().getText());

//        select "Option 2" in Select
          select.selectByVisibleText("Option 2");

//        check that selected option is "Option 2"
          assertEquals("Option 2", select.getFirstSelectedOption().getText());
//        click result

          WebElement resultButton = driver.findElement(By.cssSelector("#result_button_select"));
          resultButton.click();

//        check that 'You selected option: Option 2' text is being displayed
          WebElement resultSelect = driver.findElement(By.cssSelector("#result_select"));
          String expected = "You selected option: Option 2";
          assertEquals(expected, resultSelect.getText());
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
//        enter date '4 of July 2007' using calendar widget
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2007);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DAY_OF_MONTH, 4);
        String result = new SimpleDateFormat("MM/dd/yyyy").format(cal.getTime());

        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        dateBox.click();


        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        for(int i = 0; i<=132; i++){
            //dateWidget.findElement(By.cssSelector()).click();
            dateWidget.findElement(By.className("ui-datepicker-prev")).click();
        }

        dateWidget.findElement(By.xpath("//a[text()='4']")).click();


//        check that correct date is added
        assertEquals(result, dateBox.getAttribute("value"));
        dateBox.clear();

    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
//        enter date '2 of May 1959' using text
        String dateToEnter = "05/02/1959";
        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        dateBox.sendKeys(dateToEnter);

//        check that correct date is added
        assertEquals(dateToEnter, dateBox.getAttribute("value"));
    }
}
