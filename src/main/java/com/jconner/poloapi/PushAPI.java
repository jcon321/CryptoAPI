/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jconner.poloapi;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author jconner
 */
@ClientEndpoint
public class PushAPI {

    private static final Logger LOGGER = Logger.getLogger(PushAPI.class.getName());
    private final String basePushURL = "wss://api.poloniex.com";
    private final static Object waitLock = new Object();

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Received msg: " + message);
    }

    private static void wait4TerminateSignal() {
        synchronized (waitLock) {
            try {
                waitLock.wait();
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, "Exception: ", e);
            }
        }
    }

    public PushAPI() {
        WebSocketContainer container;
        Session session = null;
        try {
            container = ContainerProvider.getWebSocketContainer();
            session = container.connectToServer(PushAPI.class, URI.create(basePushURL));
            wait4TerminateSignal();
        } catch (DeploymentException | IOException e) {
            LOGGER.log(Level.SEVERE, "Exception: ", e);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (IOException e) {
                    LOGGER.log(Level.SEVERE, "Exception: ", e);
                }
            }
        }
    }
}
