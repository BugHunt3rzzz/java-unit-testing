package com.qa.vadym.stock.model;

public class Stock {
    private String stockId;
    private String name;
    private int quantity;

    public Stock() {
    }

    public Stock(String stockId, String name, int quantity) {
        this.stockId = stockId;
        this.name = name;
        this.quantity = quantity;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTicker() {
        return name;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId='" + stockId + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

