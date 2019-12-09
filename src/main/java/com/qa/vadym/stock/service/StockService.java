package com.qa.vadym.stock.service;

import com.qa.vadym.stock.model.Stock;

import java.math.BigDecimal;

public interface StockService {
    public BigDecimal getPrice(Stock stock);
}
