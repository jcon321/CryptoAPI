/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jconner.poloapi;

/**
 *
 * @author jconner
 */
public class PublicTicker {
    
    private String marketName;
    private Integer id;
    private Double highestBid;
    private Double low24hr;
    private Double last;
    private Double high24hr;
    private Double percentChange;
    private String isFrozen;
    private Double lowestAsk;
    private Double quoteVolume;
    private Double baseVolume;
    
    public PublicTicker() {
        
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(Double highestBid) {
        this.highestBid = highestBid;
    }

    public Double getLow24hr() {
        return low24hr;
    }

    public void setLow24hr(Double low24hr) {
        this.low24hr = low24hr;
    }

    public Double getLast() {
        return last;
    }

    public void setLast(Double last) {
        this.last = last;
    }

    public Double getHigh24hr() {
        return high24hr;
    }

    public void setHigh24hr(Double high24hr) {
        this.high24hr = high24hr;
    }

    public Double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(Double percentChange) {
        this.percentChange = percentChange;
    }

    public String isIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(String isFrozen) {
        this.isFrozen = isFrozen;
    }

    public Double getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(Double lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public Double getQuoteVolume() {
        return quoteVolume;
    }

    public void setQuoteVolume(Double quoteVolume) {
        this.quoteVolume = quoteVolume;
    }

    public Double getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(Double baseVolume) {
        this.baseVolume = baseVolume;
    }
    
}
