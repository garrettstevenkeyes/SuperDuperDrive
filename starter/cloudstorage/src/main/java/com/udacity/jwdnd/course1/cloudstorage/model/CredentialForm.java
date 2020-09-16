package com.udacity.jwdnd.course1.cloudstorage.model;

public class CredentialForm {
    private String credentialUrl;
    private String username;
    private String password;

    public String getUrl() {
        return credentialUrl;
    }

    public void setUrl(String url) {
        this.credentialUrl = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
