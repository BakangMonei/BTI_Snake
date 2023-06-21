package com.neizathedev.breakingtheice.Model;

/**
 * @Author: Monei Bakang Mothuti
 * @Date: Thursday June 2023
 * @Time: 3:04 PM
 */

public class User {
    public String Address;
    public String Country;
    public String DOB;
    public String Gender;
    public String IDPassport;
    public String Uid;
    public String email;
    public String firstName;
    public String lastName;
    public String pass;
    public String phoneNumber;
    public String rePass;

    public User() {
    }

    public User(String email, String firstName, String lastName, String gender, String address, String country, String IDPassport, String DOB, String phoneNumber, String pass, String rePass, String Uid) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Gender = gender;
        this.Address = address;
        this.Country = country;
        this.IDPassport = IDPassport;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
        this.pass = pass;
        this.rePass = rePass;
        this.Uid = Uid;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getGender() {
        return this.Gender;
    }

    public String getAddress() {
        return this.Address;
    }

    public String getCountry() {
        return this.Country;
    }

    public String getIDPassport() {
        return this.IDPassport;
    }

    public String getDOB() {
        return this.DOB;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPass() {
        return this.pass;
    }

    public String getRePass() {
        return this.rePass;
    }

    public String getUid() {
        return this.Uid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public void setIDPassport(String IDPassport) {
        this.IDPassport = IDPassport;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRePass(String rePass) {
        this.rePass = rePass;
    }

    public void setUid(String Uid) {
        this.Uid = Uid;
    }
}
