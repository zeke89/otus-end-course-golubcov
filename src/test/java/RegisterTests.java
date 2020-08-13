import io.qameta.allure.Severity;
import org.testng.annotations.Test;
import pages.JoinPage;
import pages.MainPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class RegisterTests extends BaseTest {

    @Severity(CRITICAL)
    @Test(description = "Check register")
    public void checkSearch() {
        MainPage mainPage = MainPage.open();
        mainPage.fillLogin("zeke1989");
        mainPage.fillEmail("golubcov.e+test1@gmail.com");
        mainPage.fillPassword("IQ123123");
        JoinPage joinPage = mainPage.clickSubmitButton();
        joinPage.checkTitle("Create your account");
    }
}
