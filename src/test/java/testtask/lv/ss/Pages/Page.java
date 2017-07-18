package testtask.lv.ss.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;

  @FindBy(xpath = "//*[@id=\"main_table\"]/span[2]/b[3]/a")
  WebElement searchLink;

  @FindBy(xpath = "//*[@id=\"main_table\"]/span[2]/span/b/a")
  WebElement bookmarks;

//   Constructor injecting the WebDriver interface
  public Page(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

    public SearchPage goToSearch() {
        searchLink.click();
        return new SearchPage(driver);
    }

    public BookmarksPage goToBookmarks() {
        bookmarks.click();
        return new BookmarksPage(driver);
    }
}