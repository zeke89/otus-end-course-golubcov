package enitity;

import java.util.ArrayList;
import java.util.List;

public enum GitHubPages {

    MAIN("%s"),
    LOGIN("%s/login"),
    VERIFIED_DEVICE("%s/sessions/verified-device"),
    SEARCH("%s/search"),
    JOIN("%s/join"),
    ABOUT("%s/about");


    private final String name;

    GitHubPages(String name) {
        this.name = name;
    }

    /**
     * Get page name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Get enum name to lower case
     *
     * @return String
     */
    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public static List<String> getPagesNames() {
        List<String> pagesNames = new ArrayList<>();
        for (GitHubPages l : GitHubPages.values()) {
            pagesNames.add(l.getName());
        }
        return pagesNames;
    }

}
