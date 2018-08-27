package com.guide_finder.servlet;

import com.google.gson.Gson;
import com.guide_finder.service.ChatService;
import jdk.nashorn.internal.parser.JSONParser;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;

//@ServerEndpoint(value = "/echo", encoders = {java.util.ArrayList}, decoders = {MessageDecoder.class})
@ServerEndpoint("/chat")
public class WebSocketChatServlet {

//    private ChatService chatService;
    private Session session;
    private long from_id;
    private long to_id;

//    public WebSocketChatServlet(ChatService chatService) {
//        this.chatService = chatService;
//    }


    @OnOpen
    public void onOpen(Session session) {
        System.out.println("onOpen::" + session.getId());

//        from_id = Long.parseLong(session.getRequestParameterMap().get("from_id").toString());
//        to_id = Long.parseLong(session.getRequestParameterMap().get("to_id").toString());

        String prm = session.getQueryString();
        if (!prm.isEmpty()) {
            String[] listStr = prm.split("&");
            for (String pairWord : listStr) {
                String[] keyval = pairWord.split("=");
                if ("from_id".equals(keyval[0])) {
                    from_id = Long.parseLong(keyval[1]);
                }
                if ("to_id".equals(keyval[0])) {
                    to_id = Long.parseLong(keyval[1]);
                }
            }
        }
        this.session = session;

        ChatService.initialize();
        ChatService.add(this);

    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("onClose::" +  session.getId());
        ChatService.remove(this);
    }

    @OnMessage
    public void onMessage(String data) {
        System.out.println("onMessage::From=" + session.getId() + " mess:" + data);
        ChatService.sendMessage(data);
    }

    @OnError
    public void onError(Throwable t) {
        System.out.println("onError::" + t.getMessage());
    }

    public void sendString(String data) {
        //разбираем data по параметрам
//      String json = new Gson().; //.toJson("ok")
        Map jsonJavaRootObject = new Gson().fromJson(data, Map.class);
        long from_id = Long.parseLong((String)jsonJavaRootObject.get("from_id"));
        long to_id = Long.parseLong((String)jsonJavaRootObject.get("to_id"));
        String message = (String)jsonJavaRootObject.get("message");

        if (this.to_id == to_id || this.from_id == to_id) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

//// Считываем json
//        Object obj = new JSONParser().parse(data); // Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));
//// Кастим obj в JSONObject
//        JSONObject jo = (JSONObject) obj;
//// Достаём firstName and lastName
//        String firstName = (String) jo.get("firstName");
//        String lastName = (String) jo.get("lastName");
//        System.out.println("fio: " + firstName + " " + lastName);
//// Достаем массив номеров
//        JSONArray phoneNumbersArr = (JSONArray) jo.get("phoneNumbers");
//        Iterator phonesItr = phoneNumbersArr.iterator();
//        System.out.println("phoneNumbers:");

    }

}
