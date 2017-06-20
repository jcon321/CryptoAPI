/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jconner.exchanges.bitfinex;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 *
 * @author jconner
 */
public class BitfinexPubTicker {
    
    private String marketName;
    private Double mid;
    private Double bid;
    private Double ask;
    @JsonProperty("last_price")
    private Double lastPrice;
    private Double low;
    private Double high;
    private Double volume;
    private Double timestamp;
    
    public BitfinexPubTicker() {
        
    }

    @Override
    public String toString() {
        
        return String.format(""
                + "%s%24s\n"
                + "%s%32s\n"
                + "%s%32s\n"
                + "%s%32s\n"
                + "%s%25s\n"
                + "%s%23s\n"
                + "%s%22s\n"
                + "%s%29s\n"
                + "%s%26s\n", 
                "Market Name:", marketName, 
                "Mid:", mid,
                "Bid:", bid,
                "Ask:", ask,
                "Last Price:", lastPrice,
                "Lowest Trade:", low,
                "Highest Trade:", high,
                "Volume:", volume,
                "Timestamp:", timestamp);
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }
    
}
