package com.guide_finder.servlet.user;

import com.google.gson.Gson;
import com.guide_finder.dto.UserCoordsDto;
import com.guide_finder.service.abstraction.user.UserService;
import com.guide_finder.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/guidesAround")
public class GuidesAroundServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double longitude = Double.valueOf(req.getParameter("longitude"));
        Double latitude = Double.valueOf(req.getParameter("latitude"));

       /* Double [] arr1 ={60.6703354, 28.5122424};
        Double [] arr2 ={60.6713334, 28.5102404};
        Double [] arr3 ={60.6753334, 28.5132404};
        Double [] arr4 ={60.6733334, 28.5152404};*/
        List<UserCoordsDto> list = userService.getGuidesAround(longitude, latitude);



      /*  UserCoordsDto dto = new UserCoordsDto(98,60.6703354, 28.5122424);
        UserCoordsDto dto1 = new UserCoordsDto(99,60.6713334, 28.5102404);
        UserCoordsDto dto2 = new UserCoordsDto(100,60.6753334, 28.5132404);
        UserCoordsDto dto3 = new UserCoordsDto(101,60.6733334, 28.5152404);*/



/*
        list.add(dto);
        list.add(dto1);
        list.add(dto2);
        list.add(dto3);*/

        Gson gson = new Gson();

        String jsonInString = gson.toJson(list);


        req.setAttribute("coordList", jsonInString);
        req.getRequestDispatcher("/testCoord.jsp").forward(req, resp);
    }
}
