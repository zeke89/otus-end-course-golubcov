package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    @Step("Open page {url}")
    public static void openPage(String url) {
        open(url);
    }
}
