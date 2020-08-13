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
    private final SelenideElement searchForm = $x("//form[@class = 'js-site-search-form']");
    private final SelenideElement registerForm = $x("//form[@class = 'home-hero-signup text-gray-dark js-signup-form js-signup-form-submit']");
    private final SelenideElement loginInput = registerForm.$x("//input[@id = 'user[login]']");
    private final SelenideElement emailInput = registerForm.$x("//input[@id = 'user[email]']");
    private final SelenideElement passwordInput = registerForm.$x("//input[@id = 'user[password]']");
    private final SelenideElement submitButton = registerForm.$x("//button[@type = 'submit']");

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

    @Step("Fill search query - [{q}]")
    public SearchPage fillSearchQuery(String q) {
        searchForm.shouldHave(visible).click();
        searchForm.val(q);
        return page(SearchPage.class);
    }

    @Step("Fill login - [{login}]")
    public void fillLogin(String login) {
        loginInput.shouldHave(visible).click();
        loginInput.val(login);
    }

    @Step("Fill email - [{email}]")
    public void fillEmail(String email) {
        emailInput.shouldHave(visible).click();
        emailInput.val(email);
    }

    @Step("Fill password - [{password}]")
    public void fillPassword(String password) {
        passwordInput.shouldHave(visible).click();
        passwordInput.val(password);
    }

    @Step("Click submit button")
    public JoinPage clickSubmitButton() {
        submitButton.shouldHave(visible).click();
        return page(JoinPage.class);
    }
}
