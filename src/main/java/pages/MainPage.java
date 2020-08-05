package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MainPage extends BasePage {

    private final SelenideElement logoGitHub = $x("//a[@class = 'mr-4']");

    @Step("Open page [main]")
    public static MainPage open() {
        openPage("https://github.com/");
        return page(MainPage.class);
    }

//    public static String getURL() {
//        return "https://github.com/";
//                //properties.getIqoptionPage(lang, MAIN.getName(), isRegulated);
//    }

    @Step("Check open main page")
    public void checkOpenMainPage() {
        logoGitHub.shouldHave(visible);
    }
}
