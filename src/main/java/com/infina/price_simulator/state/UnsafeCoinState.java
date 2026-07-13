package com.infina.price_simulator.state;

public class UnsafeCoinState extends CoinState{
    public UnsafeCoinState(String id, long initialPrice) {
        super(id, initialPrice);
    }

    @Override
    public void applyDelta(long delta) {
        updateState(delta);
    }
}
