package com.guide_finder.service.impl;

import com.guide_finder.dao.impl.role.GuideDaoImpl;
import com.guide_finder.model.user.Guide;
import com.guide_finder.model.user.User;
import com.guide_finder.service.abstraction.guide.GuideService;
import com.guide_finder.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;

public class GuideServiceImpl implements GuideService {

    private GuideDaoImpl guideDao = null;

    public GuideServiceImpl() {
        try {
            guideDao = new GuideDaoImpl(DBHelper.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Guide getGuideById(long id) {
        return guideDao.getGuideById(id);
    }
}
