package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static enitity.GitHubPages.LOGIN;
import static utils.GitHubProperties.properties;

public class LoginPage extends BasePage {

    private final SelenideElement loginForm = $x("//div[@class = 'auth-form-body mt-3']");
    private final SelenideElement emailInput = loginForm.$x(".//input[@id = 'login_field']");
    private final SelenideElement passwordInput = loginForm.$x(".//input[@id = 'password']");
    private final SelenideElement submitButton = loginForm.$x(".//input[@type = 'submit']");

    @Step("Open page [/login]")
    public static LoginPage open() {
        openPage(getURL());
        return page(LoginPage.class);
    }

    public static String getURL() {
        return properties.getGitHubPage(LOGIN.getName());
    }

    @Step("Enter login - [{login}]")
    public void enterLogin(String login) {
        emailInput.shouldHave(visible).click();
        emailInput.val(login);
    }

    @Step("Enter password - [{password}]")
    public void enterPassword(String password) {
        passwordInput.shouldHave(visible).click();
        passwordInput.val(password);
    }

    @Step("Click submit button")
    public void clickSubmitButton() {
        submitButton.shouldHave(visible).click();
    }

    @Step("Execute login user email:{login} password:{password}")
    public VerifiedDevicePage executeLogin(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        clickSubmitButton();
        return page(VerifiedDevicePage.class);
    }
}
