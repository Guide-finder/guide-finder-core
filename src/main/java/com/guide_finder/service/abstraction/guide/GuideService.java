package com.guide_finder.service.abstraction.guide;

import com.guide_finder.model.user.User;

import java.sql.SQLException;

public interface GuideService {
    User getGuideById(long id) throws SQLException;

}
