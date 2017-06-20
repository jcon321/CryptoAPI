/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jconner.driver;

import com.jconner.exchanges.bitfinex.Bitfinex;
import com.jconner.exchanges.bitfinex.BitfinexPubTicker;
import com.jconner.exchanges.poloniex.Poloniex;
import com.jconner.exchanges.poloniex.PoloPubTicker;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver {

    private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());
    
    public static void main(String[] args) {

        Poloniex polo = new Poloniex();
        Bitfinex bitfinex = new Bitfinex();

        while (true) {
            
            // Poloniex
            LOGGER.log(Level.INFO, "\n{0}", "Poloniex Public Ticker");
            List<PoloPubTicker> poloTicker = polo.getPubAPI().returnTicker();
            for (PoloPubTicker ticker1 : poloTicker) {
                if (ticker1.getMarketName().equals("BTC_ETH")) {
                    LOGGER.log(Level.INFO, "\n{0}", ticker1.toString());
                }
            }
            
            // Bitfinex
            BitfinexPubTicker bitfinexTicker = bitfinex.getPubAPI().returnTicker("ethbtc");
            LOGGER.log(Level.INFO, "\n{0}", "Bitfinex Public Ticker");
            LOGGER.log(Level.INFO, "\n{0}", bitfinexTicker.toString());
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
