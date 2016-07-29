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
public class PoloAPI {

    private final PublicAPI pubAPI = new PublicAPI();
   // private final PushAPI pushAPI = new PushAPI();

    public PoloAPI() {

    }

    public PublicAPI getPubAPI() {
        return pubAPI;
    }

//    public PushAPI getPushAPI() {
//        return pushAPI;
//    }

}
