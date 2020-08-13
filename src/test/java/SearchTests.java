import io.qameta.allure.Severity;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class SearchTests extends BaseTest {

    @Severity(CRITICAL)
    @Test(description = "Check search")
    public void checkSearch() {
        MainPage mainPage = MainPage.open();
        SearchPage searchPage = mainPage.fillSearchQuery("golubcov");
        searchPage.checkSearchResult();
    }
}
