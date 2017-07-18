package testtask.lv.ss.Tests;

import org.junit.Assert;
import org.junit.Test;
import testtask.lv.ss.Pages.MainPage;
import testtask.lv.ss.Pages.SearchResultsPage;
import testtask.lv.ss.Utilities;

import java.util.List;

/**
 * Created by Vitaliy on 7/13/2017.
 */
public class TaskTest extends SslvTest {
    @Test
    public void TaskTest(){
//        1. Открыть браузер и развернуть на весь экран.
//        2. Зайти на ss.lv.
//        1-2 steps are executed at SslvTest.class @Before
//        3. Поменять язык на русский.
        MainPage mainPage = new MainPage(driver);
        mainPage
                .switchToRu()
//        4. Зайти в раздел Электротехника, в поиске ввести искомую фразу (напр. ‘Компьютер’) и выбрать разные параметры поиска.
                .goToSubcategory("Электротехника")
                .goToSearch()
                .enterSearchKeyword("Компьютер")
                .setSearchPeriod("30")
                .setSubheader("1")
//        5. Нажать кнопку Искать
                .submitSearch()
//        6. Отсортировать результаты по цене и выбрать тип сделки ‘продажа’.
                .sortByPrice()
                .setDealType("Продажа")
//        7. Зайти в расширенный поиск.
                .goToExtendedSearch()
//        8. Задать параметр поиска по цене от 0 до 300.
                .setPrice("0", "300")
//        9. Выбрать не менее 3 любых случайных объявлений.
                .submitSearch();
        SearchResultsPage page = new SearchResultsPage(driver);
//        generate random indexes for ads
        int qtyOfAdsToChoose = Utilities.getRandomInts(1, 3, page.getAdsQuantity()-1)[0];
        int[] indexes = Utilities.getRandomInts(qtyOfAdsToChoose, 0, page.getAdsQuantity()-1);
//        select ads and get names
        List<String> adsNames = page.selectAdsByIndexes(indexes);
//        10. Нажать “Добавить выбранные в закладки”.
        page.addToBookmarks();
//        11. Открыть "Закладки" и проверить, что объявления на странице совпадают с выбранными ранее
        //get names of ads in bookmarks
        List<String> bookmarksNames = page
                .goToBookmarks()
                .getBookmarksNames();
        //trim and compare names
        Utilities.trimListsForComparison(adsNames, bookmarksNames);
        Assert.assertTrue("Bookmarks and selected ads are not equal", adsNames.containsAll(bookmarksNames));
//        12. Закрыть браузер. - see SslvTests.class @After

    }
}
