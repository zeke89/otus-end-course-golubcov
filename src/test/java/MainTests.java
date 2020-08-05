import io.qameta.allure.Severity;
import org.testng.annotations.Test;
import pages.MainPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class MainTests extends BaseTest {

    @Severity(CRITICAL)
    @Test(description = "Page opens")
    public void checkOpenMainPage() {
        MainPage mainPage = MainPage.open();
        mainPage.checkOpenMainPage();
        }
}
