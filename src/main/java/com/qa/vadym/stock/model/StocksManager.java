package com.qa.vadym.stock.model;

import com.qa.vadym.stock.exception.StockNotFoundException;
import com.qa.vadym.stock.service.StockService;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class StocksManager {
    private StockService stockService;
    private List<Stock> stocks;

    public StocksManager(StockService stockService, List<Stock> stocks) {
        this.stockService = stockService;
        this.stocks = stocks;
    }

    public BigDecimal getStocksValue() {
        BigDecimal marketValue = BigDecimal.ZERO;

        for (Stock stock : stocks) {
            marketValue = marketValue.add(stockService.getPrice(stock).multiply(new BigDecimal(stock.getQuantity())));
        }
        return marketValue;
    }

    public Stock returnMostValuableStock() throws StockNotFoundException {
        return stocks.stream()
                .max(Comparator.comparing(stock -> stockService.getPrice(stock).doubleValue()))
                .orElseThrow(() -> new StockNotFoundException("Most valuable stock wos not found"));

    }

}
