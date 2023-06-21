package com.neizathedev.breakingtheice.Model;

/**
 * @Author: Monei Bakang Mothuti
 * @Date: Thursday June 2023
 * @Time: 3:02 PM
 */

public class Member {
    private String email;
    private String id;
    private String mobile;
    private String names;
    private String profileimageurl;
    private String username;

    public Member() {
    }

    public Member(String id, String names, String mobile, String email, String username, String profileimageurl) {
        this.id = id;
        this.names = names;
        this.mobile = mobile;
        this.email = email;
        this.username = username;
        this.profileimageurl = profileimageurl;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNames() {
        return this.names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileimageurl() {
        return this.profileimageurl;
    }

    public void setProfileimageurl(String profileimageurl) {
        this.profileimageurl = profileimageurl;
    }
}
