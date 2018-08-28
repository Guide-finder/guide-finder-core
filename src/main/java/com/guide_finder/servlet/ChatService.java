package com.guide_finder.servlet;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChatService {

    private static ChatService instance;
    //    private static Map<String, Session> sMap = new HashMap<String, Session>();
    private ChatService() {}

    private static Set<WebSocketChatServlet> webSockets = Collections.newSetFromMap(new ConcurrentHashMap<>());

//    public ChatService() {
//        this.webSockets = Collections.newSetFromMap(new ConcurrentHashMap<>());
//    }

    public static void initialize() {
        if (instance == null) {
            instance = new ChatService();
        }
    }

    public static void sendMessage(String data) {
        for (WebSocketChatServlet user : webSockets) {
            try {
                user.sendString(data);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void add(WebSocketChatServlet webSocket) {
        webSockets.add(webSocket);
    }

    public static void remove(WebSocketChatServlet webSocket) {
        webSockets.remove(webSocket);
    }
}