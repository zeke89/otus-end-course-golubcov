package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static utils.GitHubProperties.properties;
import static enitity.GitHubPages.MAIN;

public class MainPage extends BasePage {

    private final SelenideElement logoGitHub = $x("//a[@class = 'mr-4']");

    @Step("Open page [main]")
    public static MainPage open() {
        openPage(getURL());
        return page(MainPage.class);
    }

    public static String getURL() {
        return properties.getGitHubPage(MAIN.getName());
    }

    @Step("Check open main page")
    public void checkOpenMainPage() {
        logoGitHub.shouldHave(visible);
    }
}
