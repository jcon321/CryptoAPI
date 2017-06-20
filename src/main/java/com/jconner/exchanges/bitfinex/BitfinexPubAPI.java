/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jconner.exchanges.bitfinex;

import com.jconner.utils.StringUtilities;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author jconner
 */
public class BitfinexPubAPI {

    private static final Logger LOGGER = Logger.getLogger(BitfinexPubAPI.class.getName());
    String basePublicURL = "https://api.bitfinex.com/v1/";

    public BitfinexPubAPI() {

    }

    public BitfinexPubTicker returnTicker(String market) {
        BitfinexPubTicker result = new BitfinexPubTicker();
        try {
            URL url = new URL(basePublicURL + "pubticker/" + market);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            String isAsString = StringUtilities.getStringFromInputStream(is);

            ObjectMapper mapper = new ObjectMapper();
            
            BitfinexPubTicker single = mapper.readValue(isAsString, BitfinexPubTicker.class);

            single.setMarketName(market);

            result = single;

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception: ", e);
        }

        return (result);
    }

}
