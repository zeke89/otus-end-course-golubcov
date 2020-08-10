import io.qameta.allure.Severity;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.VerifiedDevicePage;
import utils.GitHubProperties;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static utils.GitHubProperties.properties;

public class LoginTests extends BaseTest {

    @Severity(CRITICAL)
    @Test(description = "Check working login")
    public void checkLoginUser() {
        LoginPage loginPage = LoginPage.open();
        VerifiedDevicePage verifiedDevicePage = loginPage.executeLogin(properties.getLoginUser(), properties.getPasswordUser());
        verifiedDevicePage.checkOpenVerifiedDeviceBlock();
    }
}
