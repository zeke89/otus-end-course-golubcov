import io.qameta.allure.Severity;
import org.testng.annotations.Test;
import pages.AboutPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class AboutTests extends BaseTest {

    @Severity(CRITICAL)
    @Test(description = "Check information about company")
    public void checkInformationAboutCompany() {
        AboutPage aboutPage = AboutPage.open();
        aboutPage.checkNoticeAboutCompany("October 2007", 1);
        aboutPage.checkNoticeAboutCompany("San Francisco", 2);
        aboutPage.checkNoticeAboutCompany("100 million", 3);
    }

}
