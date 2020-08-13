package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static enitity.GitHubPages.SEARCH;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static utils.GitHubProperties.properties;


public class SearchPage extends BasePage {

    private final SelenideElement searchResults = $x("//a[@class = 'v-align-middle']");

    @Step("Open page [search]")
    public static SearchPage open() {
        openPage(getURL());
        return page(SearchPage.class);
    }

    public static String getURL() {
        return properties.getGitHubPage(SEARCH.getName());
    }

    @Step("Check search result")
    public void checkSearchResult() {
        searchResults.shouldHave(visible);
        assertThat("Search results", searchResults.shouldHave(visible).getAttribute("href"), endsWith("golubcov"));
    }
}
