package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.page;
import static enitity.GitHubPages.ABOUT;
import static utils.GitHubProperties.properties;

public class AboutPage extends BasePage {

    private final ElementsCollection noticeAboutCompany = $$x("//div[@class = 'h2-mktg d-block mb-0']");

    @Step("Open page [about]")
    public static AboutPage open() {
        openPage(getURL());
        return page(AboutPage.class);
    }

    public static String getURL() {
        return properties.getGitHubPage(ABOUT.getName());
    }

    @Step("Check notice - [{noticeText}] about сompany number - [{numberItem}]")
    public void checkNoticeAboutCompany(String noticeText, int numberItem) {
        noticeAboutCompany.get(numberItem - 1).shouldHave(visible, text(noticeText));
    }
}
