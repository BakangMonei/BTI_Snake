package com.neizathedev.breakingtheice.Model;/**
 * @Author: Monei Bakang Mothuti
 * @Date: Thursday June 2023
 * @Time: 3:03 PM
 */

public class Message {
    String key;
    String message;
    String name;

    public Message() {
    }

    public Message(String message, String name, String key) {
        this.message = message;
        this.name = name;
        this.key = key;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}