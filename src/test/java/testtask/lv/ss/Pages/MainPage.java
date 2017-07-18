package testtask.lv.ss.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Vitaliy on 7/13/2017.
 */
public class MainPage extends Page{

    @FindBy(xpath = "//*[@id=\"main_table\"]/span[3]/a")
    WebElement ruSwitch;

    //constructor
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage switchToRu() {
        ruSwitch.click();
        return this;
    }

    public SubCategoryPage goToSubcategory(String categoryName) {
        WebElement category = driver.findElement(By.linkText(categoryName));
        category.click();
        return new SubCategoryPage(driver);
    }



}
