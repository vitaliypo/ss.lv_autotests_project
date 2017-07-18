package testtask.lv.ss.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaliy on 7/16/2017.
 */
public class BookmarksPage extends Page {

    //constructor
    public BookmarksPage(WebDriver driver){
        super(driver);
    }

    public List<String> getBookmarksNames() {
//        reuse SearchResultsPage vars and methods
        SearchResultsPage page = new SearchResultsPage(driver);
        List<WebElement> bookmarksList = page.getAdsList();
        List<String> bookmarksNamesList = new ArrayList<String>();
        for (WebElement bookmark : bookmarksList) {
            bookmarksNamesList.add(bookmark.findElement(By.className("am")).getText());
        }
        return bookmarksNamesList;
    }
}