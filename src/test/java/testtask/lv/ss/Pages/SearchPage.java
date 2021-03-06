package testtask.lv.ss.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * Created by Vitaliy on 7/13/2017.
 */
public class SearchPage extends Page {

    @FindBy(id = "ptxt")
    WebElement searchKeywordField;

    @FindBy(className = "in1s")
    WebElement searchPeriod;

    @FindBy(id = "sbtn")
    WebElement searchButton;

    @FindBy(xpath = "//*[@name=\"topt[8][min]\"]")
    WebElement minPriceField;

    @FindBy(xpath = "//*[@name=\"topt[8][max]\"]")
    WebElement maxPriceField;

//    constructor
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage enterSearchKeyword(String keyword) {
        searchKeywordField.sendKeys(keyword);
        driver.findElements(By.className("td6")).get(0).click();
        return this;
    }

    public SearchPage setSearchPeriod(String value) {
        Select searchPeriod = new Select(driver.findElement(By.name("pr")));
        searchPeriod.selectByValue(value);
        return this;
    }

    public SearchPage setSubheader(String value) {
        Select subHeader = new Select(driver.findElement(By.name("pr")));
        subHeader.selectByValue(value);
        return this;
    }

    public SearchResultsPage submitSearch() {
//        Sometimes search keywords suggestions overlay submit button,
//        so we have to click somewhere on the page to get rid of it
//        and repeat if necessary
        boolean success = false;
        int retriesCounter = 0;
        while(retriesCounter < 100 & !success) {
            try {
                retriesCounter++;
                searchButton.click();
                success = true;
            } catch (WebDriverException e) {
                if(retriesCounter>=100) throw e;
                driver.findElements(By.className("td6")).get(0).click();
            }
        }
        return new SearchResultsPage(driver);
    }

    public SearchPage setPrice(String min, String max) {
        minPriceField.sendKeys(min);
        maxPriceField.sendKeys(max);
        return this;
    }
}