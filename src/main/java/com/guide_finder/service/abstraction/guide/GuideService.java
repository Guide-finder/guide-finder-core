package com.guide_finder.service.abstraction.guide;

import com.guide_finder.model.user.Guide;
import com.guide_finder.model.user.User;

import java.sql.SQLException;

public interface GuideService {
    Guide getGuideById(long id);

}
