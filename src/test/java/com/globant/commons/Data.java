package com.globant.commons;

public enum Data {
    URL("https://www.saucedemo.com/"),
    CHROME_DRIVER ("webdriver.chrome.driver"),
    USERNAME("standard_user"),
    PASSWORD("secret_sauce"),
    FIRST_NAME("Omar"),
    LAST_NAME("Ladino"),
    POSTAL_CODE("12345");

    private String value;
    Data(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
