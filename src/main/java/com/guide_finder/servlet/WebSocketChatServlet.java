package com.guide_finder.servlet;

import com.guide_finder.service.ChatService;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

//@ServerEndpoint(value = "/echo", encoders = {java.util.ArrayList}, decoders = {MessageDecoder.class})
@ServerEndpoint("/chat")
public class WebSocketChatServlet {

//    private ChatService chatService;
    private Session session;

    private long sender_id;
    private long reciever_id;

//    public WebSocketChatServlet(ChatService chatService) {
//        this.chatService = chatService;
//    }


    @OnOpen
    public void onOpen(Session session) {
        System.out.println("onOpen::" + session.getId());

        String prm = session.getQueryString();
        if (!prm.isEmpty()) {

        }


        ChatService.initialize();
        ChatService.add(this);

//        chatService.add(this);
        this.session = session;
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
        try {
            session.getBasicRemote().sendText(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
