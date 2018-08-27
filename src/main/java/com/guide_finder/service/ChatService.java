package com.guide_finder.service;

import com.guide_finder.servlet.WebSocketChatServlet;

import javax.websocket.Session;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
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