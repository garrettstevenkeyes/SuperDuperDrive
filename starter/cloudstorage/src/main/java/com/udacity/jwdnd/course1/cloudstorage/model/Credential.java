package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credential {
    private Integer credentialId;
    private String url;
    private String username;
    private String key;
    private String password;
    private Integer userId;

    public Integer getCredentialId(){
        return credentialId;
    }
    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public String getCredentialUrl() {
        return url;
    }
    public void setCredentialUrl(String url) {
        this.url = url;
    }

    public String getCredentialUsername() {
        return username;
    }
    public void setCredentialUsername(String username) {
        this.username = username;
    }

    public String getCredentialKey(){
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    public String getCredentialPassword(){
        return password;
    }
    public void setCredentialPassword(String password) {
        this.password = password;
    }

    public Integer getCredentialUserId(){
        return userId;
    }
    public void setCredentialUserId(Integer userId) {
        this.userId = userId;
    }
}
