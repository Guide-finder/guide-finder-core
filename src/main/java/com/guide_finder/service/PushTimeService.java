package com.guide_finder.service;


import com.google.gson.Gson;
import com.guide_finder.dto.UserCoordsDto;
import com.guide_finder.service.abstraction.location.LocationService;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.UserServiceImpl;
import com.guide_finder.service.impl.location.LocationServiceImpl;

import java.util.*;
import javax.websocket.Session;

public class PushTimeService implements Runnable {

    private static PushTimeService instance;
    private static Map<String, Session> sMap = new HashMap<String, Session>();
    private PushTimeService() {}

    public static void add(Session s) {
        sMap.put(s.getId(), s);
    }

    public static void initialize() {
        if (instance == null) {
            instance = new PushTimeService();
            new Thread(instance).start();
        }
    }

    @Override
    public void run() {

        final LocationServiceImpl lsi = new LocationServiceImpl();
        final UserService userService = new UserServiceImpl();

        //Double longitude = Double.valueOf(req.getParameter("longitude"));
        Double longitude = 60.67429839472416;
        //Double latitude = Double.valueOf(req.getParameter("latitude"));
        Double latitude = 28.51392690887258;




        int x = 0;

        while (true) {
            try {
                Thread.sleep(10*1000);
                for (String key : sMap.keySet()) {

                    Session s = sMap.get(key);

                    if (s.isOpen()) {

                        if (x != lsi.getCoordsCount()){
                            x = lsi.getCoordsCount();
                            List<UserCoordsDto> list = userService.getGuidesAround(longitude, latitude);
                            String json = new Gson().toJson(list);
                            s.getBasicRemote().sendText(json);}
                            //s.getBasicRemote().sendText("Hello User! I have -> " + x + " records!");}
                    } else {
                        sMap.remove(key);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
