/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jconner.exchanges.poloniex;

/**
 *
 * @author jconner
 */
public class Poloniex {

    private final PoloPubAPI pubAPI = new PoloPubAPI();

    public Poloniex() {

    }

    public PoloPubAPI getPubAPI() {
        return pubAPI;
    }

}
