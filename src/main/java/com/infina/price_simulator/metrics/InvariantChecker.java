package com.infina.price_simulator.metrics;

import com.infina.price_simulator.model.ExpectedValues;
import com.infina.price_simulator.state.CoinState;

import java.util.List;
import java.util.Map;

public final class InvariantChecker {

    private InvariantChecker() {
    }


     // Beklenen fiyat ve update sayısı ile gerçek CoinState değerlerini karşılaştırır.

    public static boolean check(
            List<CoinState> coins,
            Map<String, ExpectedValues> expectedValues
    ) {

        for (CoinState coin : coins) {

            ExpectedValues expected = expectedValues.get(coin.getId());

            if (expected == null) {
                return false;
            }

            if (expected.expectedPrice() != coin.getCurrentPrice()) {
                return false;
            }

            if (expected.expectedUpdateCount() != coin.getUpdateCount()) {
                return false;
            }
        }

        return true;
    }
}