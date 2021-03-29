package com.kepf.Exchangeconnectivity.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketData {

    @JsonProperty("LAST_TRADED_PRICE")
    private double last_traded_price;
    @JsonProperty("BID_PRICE")
    private double bid_price;
    @JsonProperty("SELL_LIMIT")
    private int sell_limit;
    @JsonProperty("MAX_PRICE_SHIFT")
    private int max_price_shift;
    @JsonProperty("TICKER")
    private String ticker;
    @JsonProperty("ASK_PRICE")
    private double ask_price;
    @JsonProperty("BUY_LIMIT")
    private int buy_limit;

}