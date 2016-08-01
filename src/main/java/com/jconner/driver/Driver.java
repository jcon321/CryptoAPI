/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jconner.driver;

import com.jconner.poloapi.PoloAPI;
import com.jconner.poloapi.PublicTicker;
import java.util.List;

public class Driver {

    public static void main(String[] args) {

        PoloAPI polo = new PoloAPI();

        List<PublicTicker> ticker = polo.getPubAPI().returnTicker();
        System.out.println(polo.getPubAPI().return24Volume().toJSONString());
        System.out.println("");
    }
}
