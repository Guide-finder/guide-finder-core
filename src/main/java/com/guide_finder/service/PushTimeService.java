package com.guide_finder.service;


import com.google.gson.Gson;
import com.guide_finder.dto.UserCoordsDto;
import com.guide_finder.service.abstraction.location.LocationService;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.UserServiceImpl;
import com.guide_finder.service.impl.location.LocationServiceImpl;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.Session;

public class PushTimeService implements Runnable {

    private static PushTimeService instance;
    private static Map<String, Session> sMap = new ConcurrentHashMap<>();
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

        LocationServiceImpl lsi = new LocationServiceImpl();
        UserService userService = new UserServiceImpl();

        //Double longitude = Double.valueOf(req.getParameter("longitude"));
        //Double longitude = 60.67429839472416;
        //Double latitude = Double.valueOf(req.getParameter("latitude"));
        //Double latitude = 28.51392690887258;




        int size = 0;
        int trigg = 0;

        while (true) {
            if(size!=sMap.size() | trigg!=lsi.getCoordsCount()) {
                size = sMap.size();
                trigg = lsi.getCoordsCount();
                try {
                    Thread.sleep(5 * 1000);
                    for (String key : sMap.keySet()) {

                        Session s = sMap.get(key);

                        Double latitude = Double.parseDouble(sMap.get(key).getRequestParameterMap().get("latitude").get(0));
                        Double longitude = Double.parseDouble(sMap.get(key).getRequestParameterMap().get("longitude").get(0));
                        int x = 0;
                        if (s.isOpen()) {

                            if (x != lsi.getCoordsCount()) {
                                x = lsi.getCoordsCount();
                                List<UserCoordsDto> list = userService.getGuidesAround(latitude, longitude);
                                String json = new Gson().toJson(list);
                                s.getBasicRemote().sendText(json);
                            }
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
}
