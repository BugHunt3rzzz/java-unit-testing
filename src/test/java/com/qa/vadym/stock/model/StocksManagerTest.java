package com.qa.vadym.stock.model;

import com.google.common.collect.Lists;
import com.qa.vadym.stock.service.StockService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static com.qa.vadym.stock.model.Stock.APPL;
import static com.qa.vadym.stock.model.Stock.GGL;
import static com.qa.vadym.stock.model.Stock.UBER;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StocksManagerTest {

    private StockHolder apple = new StockHolder(APPL, 3);
    private StockHolder uber = new StockHolder(UBER, 3);
    private StockHolder google = new StockHolder(GGL, 10);

    @Mock
    private StockService stockService;
    private StocksManager stocksManager;

    @BeforeEach
    void setup() {
        List<StockHolder> stockHolders = Lists.newArrayList(apple, uber, google);
        stocksManager = new StocksManager(stockService, stockHolders);

        when(stockService.getPrice(APPL)).thenReturn(new BigDecimal("3"));
        when(stockService.getPrice(UBER)).thenReturn(new BigDecimal("8"));
        when(stockService.getPrice(GGL)).thenReturn(new BigDecimal("5"));
    }

    @Test
    void getStocksValuePositive() {
        BigDecimal stocksValue = stocksManager.getStocksValue();
        Assertions.assertThat(stocksValue).isEqualTo(BigDecimal.valueOf(9));
    }

    @Test
    void returnMostValuableStock() {
        Stock stock = stocksManager.returnMostValuableStock();
        System.out.println(stock);
        Assertions.assertThat(stock).isEqualTo(UBER);
    }

    @Test
    void returnMostValuableStockHolder() {
        StockHolder stockHolder = stocksManager.returnMostValuableStockHolder();
        System.out.println(stockHolder);
        Assertions.assertThat(stockHolder).isEqualTo(google);
    }
}