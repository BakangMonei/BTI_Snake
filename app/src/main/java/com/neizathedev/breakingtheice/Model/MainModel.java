package com.neizathedev.breakingtheice.Model;/**
 * @Author: Monei Bakang Mothuti
 * @Date: Thursday June 2023
 * @Time: 3:01 PM
 */

/**
 * @Author: Monei Bakang Mothuti
 * @Date: Thursday June 2023
 * @Time: 3:01 PM
 */
public class MainModel {
    String Address;
    String Country;
    String DOB;
    String Gender;
    String IDPassport;
    String Password;
    String email;
    String firstName;
    String lastName;
    String phoneNumber;
    String rePassword;
    String url;

    public MainModel() {
    }

    public MainModel(String email, String firstName, String lastName, String password, String rePassword, String DOB, String gender, String phoneNumber, String address, String country, String IDPassport, String url) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Password = password;
        this.rePassword = rePassword;
        this.DOB = DOB;
        this.Gender = gender;
        this.phoneNumber = phoneNumber;
        this.Address = address;
        this.Country = country;
        this.IDPassport = IDPassport;
        this.url = url;
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

    public String getPassword() {
        return this.Password;
    }

    public String getRePassword() {
        return this.rePassword;
    }

    public String getDOB() {
        return this.DOB;
    }

    public String getGender() {
        return this.Gender;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
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

    public String getUrl() {
        return this.url;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MainModel mainModel = (MainModel) o;
        if (this.email.equals(mainModel.email) && this.firstName.equals(mainModel.firstName) && this.lastName.equals(mainModel.lastName) && this.Password.equals(mainModel.Password) && this.rePassword.equals(mainModel.rePassword) && this.DOB.equals(mainModel.DOB) && this.Gender.equals(mainModel.Gender) && this.phoneNumber.equals(mainModel.phoneNumber) && this.Address.equals(mainModel.Address) && this.Country.equals(mainModel.Country) && this.IDPassport.equals(mainModel.IDPassport) && this.url.equals(mainModel.url)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "MainModel{" +
                "Address='" + Address + '\'' +
                ", Country='" + Country + '\'' +
                ", DOB='" + DOB + '\'' +
                ", Gender='" + Gender + '\'' +
                ", IDPassport='" + IDPassport + '\'' +
                ", Password='" + Password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", rePassword='" + rePassword + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}