/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jconner.exchanges.bitfinex;


/**
 *
 * @author jconner
 */
public class Bitfinex {

    private final BitfinexPubAPI pubAPI = new BitfinexPubAPI();

    public Bitfinex() {

    }

    public BitfinexPubAPI getPubAPI() {
        return pubAPI;
    }

}
