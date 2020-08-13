package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static enitity.GitHubPages.JOIN;
import static utils.GitHubProperties.properties;

public class JoinPage extends BasePage {

    private final SelenideElement title = $x("//h1");

    @Step("Open page [join]")
    public static JoinPage open() {
        openPage(getURL());
        return page(JoinPage.class);
    }

    public static String getURL() {
        return properties.getGitHubPage(JOIN.getName());
    }

    @Step("Check title - [{titleText}]")
    public void checkTitle(String titleText) {
        title.shouldHave(visible, text(titleText));
    }
}
