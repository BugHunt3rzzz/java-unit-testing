package com.qa.vadym.stock.model;

public enum Stock {
    APPL(1, "Apple"),
    GGL(2, "Google"),
    UBER(3, "Uber");

    private int id;
    private String name;

    Stock(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
