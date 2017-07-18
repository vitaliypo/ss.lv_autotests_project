package testtask.lv.ss.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaliy on 7/14/2017.
 */
public class SearchResultsPage extends Page{

    @FindBy(xpath = "//*[@class = \"a18\"]")
    WebElement sortByPrice;

    @FindBy(linkText = "Расширенный поиск")
    WebElement extendedSearchLink;

    @FindBy(xpath = "//tbody/tr[@id=\"head_line\"]/following-sibling::tr[@style!=\"display:none;\"]")
    List<WebElement> adsLIst;

    @FindBy(id = "a_fav_sel")
    WebElement addToBookmarks;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage sortByPrice() {
        sortByPrice.click();
        return this;
    }

    public SearchResultsPage setDealType(String value) {
        Select dealType = new Select(driver.findElement(By.xpath("//*[@class = \"filter_sel\"]")));
        dealType.selectByVisibleText(value);
        return this;
    }

    public SearchPage goToExtendedSearch() {
        extendedSearchLink.click();
        return new SearchPage(driver);
    }

    public List<String> selectAdsByIndexes(int[] indexes) {
        List<String> adsNames = new ArrayList<String>();
        for (int ad : indexes) {
            adsLIst.get(ad).findElement(By.tagName("input")).click();
            adsNames.add(adsLIst.get(ad).findElement(By.className("am")).getText());
        }
        return adsNames;
    }

    public List<WebElement> getAdsList() {
        return adsLIst;
    }

    public int getAdsQuantity() {
        return adsLIst.size();
    }

    public SearchResultsPage addToBookmarks() {
        addToBookmarks.click();
        return this;
    }
}
