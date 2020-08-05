import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.browserCapabilities;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static com.codeborne.selenide.logevents.SelenideLogger.removeListener;
import static com.codeborne.selenide.testng.ScreenShooter.captureSuccessfulTests;
import static io.qameta.allure.selenide.LogType.BROWSER;

public class BaseTest {
    @BeforeSuite(alwaysRun = true)
    public void configuration() throws IOException {

        reportsFolder = "target/screenshots";
        browserCapabilities = new DesiredCapabilities();

        baseUrl = System.getProperty("selenide.baseUrl", "http://localhost:8080/");
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("safebrowsing.enabled", true);
        prefs.put("profile.default_content_settings.popups", 0);

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(String.valueOf(BROWSER), Level.SEVERE);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("disable-extensions");
        options.addArguments("safebrowsing-disable-extension-blacklist");
        options.addArguments("safebrowsing-disable-download-protection");

        browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        browserCapabilities.acceptInsecureCerts();
        browserCapabilities.setCapability("timeZone", "Europe/Moscow");
        browserCapabilities.setCapability("enableVNC", true);
        browserCapabilities.setCapability("name", "Web iqoption.com");
        browserCapabilities.setCapability("sessionTimeout", "5m");
        browserCapabilities.setCapability("goog:loggingPrefs", logPrefs);

        timeout = 6000;
        pollingInterval = 400;
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        addListener("allureSelenide", new AllureSelenide());
        captureSuccessfulTests = false;
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (hasWebDriverStarted()) {
            closeWebDriver();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void clearData() {
        removeListener("allureSelenide");
        if (hasWebDriverStarted()) {
            closeWebDriver();
        }
    }
}
