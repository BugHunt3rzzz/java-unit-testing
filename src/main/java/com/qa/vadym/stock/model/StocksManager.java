package com.qa.vadym.stock.model;

import com.qa.vadym.stock.exception.StockNotFoundException;
import com.qa.vadym.stock.service.StockService;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class StocksManager {
    private StockService stockService;
    private List<StockHolder> stockHolders;

    public StocksManager(StockService stockService, List<StockHolder> stockHolders) {
        this.stockService = stockService;
        this.stockHolders = stockHolders;
    }

    public BigDecimal getStocksValue() {
        BigDecimal marketValue = BigDecimal.ZERO;

        for (StockHolder stockHolder : stockHolders) {
            marketValue = marketValue.add(
                    stockService.getPrice(stockHolder.getStock()).multiply(new BigDecimal(stockHolder.getQuantity())));
        }
        return marketValue;
    }

    public Stock returnMostValuableStock() {
        return stockHolders.stream()
                .map(StockHolder::getStock)
                .max(Comparator.comparing(stock -> stockService.getPrice(stock).doubleValue()))
                .orElseThrow(() -> new StockNotFoundException("no stock found"));
    }

    public StockHolder returnMostValuableStockHolder() {
        return stockHolders.stream()
                .max(Comparator.comparing(stockHolder ->
                        stockService.getPrice(stockHolder.getStock()).doubleValue() * stockHolder.getQuantity()))
                .orElseThrow(() -> new StockNotFoundException("no stock found"));
    }
}
