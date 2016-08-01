/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jconner.poloapi;

import com.jconner.utils.StringUtilities;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author jconner
 */
public class PublicAPI {

    private static final Logger LOGGER = Logger.getLogger(PublicAPI.class.getName());
    String basePublicURL = " https://poloniex.com/public?command=";

    public PublicAPI() {

    }

    /*
     Returns the ticker for all markets.
     */
    public List<PublicTicker> returnTicker() {
        List<PublicTicker> result = new ArrayList<>();
        try {
            URL url = new URL(basePublicURL + "returnTicker");
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            String isAsString = StringUtilities.getStringFromInputStream(is);

            ObjectMapper mapper = new ObjectMapper();
            Map map = mapper.readValue(isAsString, Map.class);
            
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                PublicTicker single = mapper.convertValue(pair.getValue(), PublicTicker.class);
                single.setMarketName(pair.getKey().toString());
                result.add(single);
            }

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception: ", e);
        }

        return (result);
    }

    /*
     Returns the 24-hour volume for all markets, plus totals for primary currencies. Sample output:

     {"BTC_LTC":{"BTC":"2.23248854","LTC":"87.10381314"},"BTC_NXT":{"BTC":"0.981616","NXT":"14145"}
    
     *** Not neccessary, this info can be found from publicTicker's quoteVolume and baseVolume
     */
    public JSONObject return24Volume() {
        JSONObject result = new JSONObject();
        try {
            URL url = new URL(basePublicURL + "return24hVolume");
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            String isAsString = StringUtilities.getStringFromInputStream(is);

            result = (JSONObject) JSONValue.parse(isAsString);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception: ", e);
        }

        return (result);
    }

    /*
     Returns the order book for a given market, as well as a sequence number for use with the Push API and an indicator specifying whether the market is frozen. You may set currencyPair to "all" to get the order books of all markets. Sample output:

     {"asks":[[0.00007600,1164],[0.00007620,1300], ... ], "bids":[[0.00006901,200],[0.00006900,408], ... ], "isFrozen": 0, "seq": 18849}
     */
    public JSONObject returnOrderBook(String currencyPair, Integer depth) {
        JSONObject result = new JSONObject();
        try {
            URL url = new URL(basePublicURL + "returnOrderBook&currencyPair="
                    + currencyPair + "&depth=" + depth);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            String isAsString = StringUtilities.getStringFromInputStream(is);

            result = (JSONObject) JSONValue.parse(isAsString);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception: ", e);
        }

        return (result);
    }

    /*
     Returns the past 200 trades for a given market, or up to 50,000 trades between a range specified in UNIX timestamps by the "start" and "end" GET parameters. Sample output:

     [{"date":"2014-02-10 04:23:23","type":"buy","rate":"0.00007600","amount":"140","total":"0.01064"},{"date":"2014-02-10 01:19:37","type":"buy","rate":"0.00007600","amount":"655","total":"0.04978"}, ... ]
     */
    public JSONArray returnTradeHistory(String currencyPair) {
        JSONArray result = new JSONArray();
        try {
            URL url = new URL(basePublicURL + "returnTradeHistory&currencyPair="
                    + currencyPair);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            String isAsString = StringUtilities.getStringFromInputStream(is);

            result = (JSONArray) JSONValue.parse(isAsString);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception: ", e);
        }

        return (result);
    }

    /*
     Returns the past 200 trades for a given market, or up to 50,000 trades between a range specified in UNIX timestamps by the "start" and "end" GET parameters. Sample output:

     [{"date":"2014-02-10 04:23:23","type":"buy","rate":"0.00007600","amount":"140","total":"0.01064"},{"date":"2014-02-10 01:19:37","type":"buy","rate":"0.00007600","amount":"655","total":"0.04978"}, ... ]
     */
    public JSONArray returnTradeHistoryByDate(String currencyPair, Long start, Long end) {
        JSONArray result = new JSONArray();
        try {
            URL url = new URL(basePublicURL + "returnTradeHistory&currencyPair="
                    + currencyPair + "&start=" + start + "&end=" + end);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            String isAsString = StringUtilities.getStringFromInputStream(is);

            result = (JSONArray) JSONValue.parse(isAsString);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception: ", e);
        }

        return (result);
    }

    /*
     Returns candlestick chart data. Required GET parameters are "currencyPair", "period" (candlestick period in seconds; valid values are 300, 900, 1800, 7200, 14400, and 86400), "start", and "end". "Start" and "end" are given in UNIX timestamp format and used to specify the date range for the data returned. Sample output:

     [{"date":1405699200,"high":0.0045388,"low":0.00403001,"open":0.00404545,"close":0.00427592,"volume":44.11655644,
     "quoteVolume":10259.29079097,"weightedAverage":0.00430015}, ...]
     */
    public JSONArray returnChartData(String currencyPair, Long start, Long end, Integer period) {
        JSONArray result = new JSONArray();
        try {
            URL url = new URL(basePublicURL + "returnChartData&currencyPair="
                    + currencyPair + "&start=" + start + "&end=" + end + "&period=" + period);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            String isAsString = StringUtilities.getStringFromInputStream(is);

            result = (JSONArray) JSONValue.parse(isAsString);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception: ", e);
        }

        return (result);
    }

    /*
     Returns information about currencies. Sample output:

     {"1CR":{"maxDailyWithdrawal":10000,"txFee":0.01,"minConf":3,"disabled":0},"ABY":{"maxDailyWithdrawal":10000000,"txFee":0.01,"minConf":8,"disabled":0}, ... }
     */
    public JSONObject returnCurrencies() {
        JSONObject result = new JSONObject();
        try {
            URL url = new URL(basePublicURL + "returnCurrencies");
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            String isAsString = StringUtilities.getStringFromInputStream(is);

            result = (JSONObject) JSONValue.parse(isAsString);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception: ", e);
        }

        return (result);
    }

    /*
     Returns the list of loan offers and demands for a given currency, specified by the "currency" GET parameter. Sample output:

     {"offers":[{"rate":"0.00200000","amount":"64.66305732","rangeMin":2,"rangeMax":8}, ... ],"demands":[{"rate":"0.00170000","amount":"26.54848841","rangeMin":2,"rangeMax":2}, ... ]}
     */
    public JSONObject returnLoanOrders(String currency) {
        JSONObject result = new JSONObject();
        try {
            URL url = new URL(basePublicURL + "returnLoanOrders&currency=" + currency);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            String isAsString = StringUtilities.getStringFromInputStream(is);

            result = (JSONObject) JSONValue.parse(isAsString);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception: ", e);
        }

        return (result);
    }
}
