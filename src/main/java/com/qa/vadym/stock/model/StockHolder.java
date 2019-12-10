package com.qa.vadym.stock.model;

public class StockHolder {
    private Stock stock;
    private int quantity;

    public StockHolder(Stock stock, int quantity) {
        this.stock = stock;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Stock getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "StockHolder{" +
                "stock=" + stock +
                ", quantity=" + quantity +
                '}';
    }
}

