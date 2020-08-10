package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static enitity.GitHubPages.VERIFIED_DEVICE;
import static utils.GitHubProperties.properties;

public class VerifiedDevicePage extends BasePage {

    private final SelenideElement verifiedDeviceBlock = $x("//div[@class = 'auth-form-body mt-3']");

    @Step("Open page [main]")
    public static VerifiedDevicePage open() {
        openPage(getURL());
        return page(VerifiedDevicePage.class);
    }

    public static String getURL() {
        return properties.getGitHubPage(VERIFIED_DEVICE.getName());
    }

    @Step("Check open verified device page")
    public void checkOpenVerifiedDeviceBlock() {
        verifiedDeviceBlock.shouldHave(visible);
    }

}
