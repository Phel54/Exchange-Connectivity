package com.kepf.Exchangeconnectivity.modules;

public class MarketData {
    private double BUY_LIMIT;
    private double LAST_TRADED_PRICE;
    private double ASK_PRICE;
    private String TICKER;
    private double MAX_PRICE_SHIFT;
    private int SELL_LIMIT;
    private double BID_PRICE;

    public MarketData() {
    }

    public MarketData(double BUY_LIMIT, double LAST_TRADED_PRICE, double ASK_PRICE, String TICKER, double MAX_PRICE_SHIFT, int SELL_LIMIT, double BID_PRICE) {
        this.BUY_LIMIT = BUY_LIMIT;
        this.LAST_TRADED_PRICE = LAST_TRADED_PRICE;
        this.ASK_PRICE = ASK_PRICE;
        this.TICKER = TICKER;
        this.MAX_PRICE_SHIFT = MAX_PRICE_SHIFT;
        this.SELL_LIMIT = SELL_LIMIT;
        this.BID_PRICE = BID_PRICE;
    }

    public double getBUY_LIMIT() {
        return BUY_LIMIT;
    }

    public void setBUY_LIMIT(double BUY_LIMIT) {
        this.BUY_LIMIT = BUY_LIMIT;
    }

    public double getLAST_TRADED_PRICE() {
        return LAST_TRADED_PRICE;
    }

    public void setLAST_TRADED_PRICE(double LAST_TRADED_PRICE) {
        this.LAST_TRADED_PRICE = LAST_TRADED_PRICE;
    }

    public double getASK_PRICE() {
        return ASK_PRICE;
    }

    public void setASK_PRICE(double ASK_PRICE) {
        this.ASK_PRICE = ASK_PRICE;
    }

    public String getTICKER() {
        return TICKER;
    }

    public void setTICKER(String TICKER) {
        this.TICKER = TICKER;
    }

    public double getMAX_PRICE_SHIFT() {
        return MAX_PRICE_SHIFT;
    }

    public void setMAX_PRICE_SHIFT(double MAX_PRICE_SHIFT) {
        this.MAX_PRICE_SHIFT = MAX_PRICE_SHIFT;
    }

    public int getSELL_LIMIT() {
        return SELL_LIMIT;
    }

    public void setSELL_LIMIT(int SELL_LIMIT) {
        this.SELL_LIMIT = SELL_LIMIT;
    }

    public double getBID_PRICE() {
        return BID_PRICE;
    }

    public void setBID_PRICE(double BID_PRICE) {
        this.BID_PRICE = BID_PRICE;
    }

    @Override
    public String toString() {
        return "MarketData{" +
                "BUY_LIMIT=" + BUY_LIMIT +
                ", LAST_TRADED_PRICE=" + LAST_TRADED_PRICE +
                ", ASK_PRICE=" + ASK_PRICE +
                ", TICKER='" + TICKER + '\'' +
                ", MAX_PRICE_SHIFT=" + MAX_PRICE_SHIFT +
                ", SELL_LIMIT=" + SELL_LIMIT +
                ", BID_PRICE=" + BID_PRICE +
                '}';
    }
}
