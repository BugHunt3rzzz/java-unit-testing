package com.qa.vadym.stock.model;

import com.google.common.collect.Lists;
import com.qa.vadym.stock.exception.StockNotFoundException;
import com.qa.vadym.stock.service.StockService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StocksManagerTest {

    @Mock
    private StockService stockService;

    private StocksManager stocksManager;

    @BeforeEach
    void setup() {
        Stock apple = new Stock("1", "Apple", 3);
        Stock uber = new Stock("2", "Uber", 3);
        Stock google = new Stock("2", "Google", 3);
        List<Stock> stocks = Lists.newArrayList(apple,uber,google);
        stocksManager = new StocksManager(stockService, stocks);
    }

    @Test
    void getStocksValuePositive() {
        when(stockService.getPrice(any())).thenReturn(new BigDecimal("1"));

        BigDecimal stocksValue = stocksManager.getStocksValue();

        Assertions.assertThat(stocksValue).isEqualTo(BigDecimal.valueOf(9));
    }

    @Test
    void returnMostValuableStock() {
        when(stockService.getPrice(any())).thenReturn(new BigDecimal("1"));

        Stock stock = new Stock();
        try {
            stock = stocksManager.returnMostValuableStock();
        } catch (StockNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(stock);
        Assertions.assertThat(stock).isNotNull();
    }
}