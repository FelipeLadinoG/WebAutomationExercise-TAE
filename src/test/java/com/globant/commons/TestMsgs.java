package com.globant.commons;

public enum TestMsgs {
    BUY_ERROR_MESSAGE("Message is not the same."),
    REMOVE_ERROR_MESSAGE("Shopping cart is not empty."),
    LOGOUT_ERROR_MESSAGE ("Login failed."),
    ORDER_MESSAGE("Thank you for your order!");

    private String value;
    TestMsgs(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
