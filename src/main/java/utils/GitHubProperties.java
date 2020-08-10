package utils;

import com.google.j2objc.annotations.Property;

public class GitHubProperties {

    public static final GitHubProperties properties = new GitHubProperties();

    @Property("domain")
    protected String domain;

    @Property("schema")
    private String schema;

    public String getDomain() {
        return domain;
    }

    public String getSchema() {
        return schema;
    }

    @Property("login.user")
    private String loginUser;

    @Property("password.user")
    private String passwordUser;

    public String getBaseUrl() {
        return getSchema() + getDomain();
    }

    public String getGitHubPage(String page) {
        return String.format(page);
    }

    public String getLoginUser() {
        return loginUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }
}
