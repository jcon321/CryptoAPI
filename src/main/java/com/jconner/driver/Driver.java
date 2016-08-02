/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jconner.driver;

import com.jconner.poloapi.PoloAPI;
import com.jconner.poloapi.PublicTicker;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver {

    private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());
    
    public static void main(String[] args) {

        PoloAPI polo = new PoloAPI();

        while (true) {
            List<PublicTicker> ticker = polo.getPubAPI().returnTicker();

            for (PublicTicker ticker1 : ticker) {
                if (ticker1.getMarketName().equals("BTC_ETC")) {
                    LOGGER.log(Level.INFO, "\n{0}", ticker1.toString());
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
