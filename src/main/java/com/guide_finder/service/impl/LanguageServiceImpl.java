package com.guide_finder.service.impl;

import com.guide_finder.dao.abstraction.LanguageDao;
import com.guide_finder.model.user.Language;
import com.guide_finder.service.abstraction.LanguageService;

import java.sql.SQLException;
import java.util.List;

public class LanguageServiceImpl implements LanguageService {

    private final LanguageDao userDao;

    private static volatile LanguageServiceImpl instance;

    private LanguageServiceImpl() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.userDao = new UserDaoFactory().getUserDao();
    }

    public static UserServiceImpl getInstance() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        if (instance == null) {
            synchronized (UserServiceImpl.class) {
                if (instance == null) {
                    instance = new UserServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public Language getLanguageById(long id) {
        return null;
    }

    @Override
    public Language getLanguageByName(String name) {
        return null;
    }

    @Override
    public void saveLanguage(Language language) {

    }

    @Override
    public void editLanguage(Language language) {

    }

    @Override
    public void remove(long id) {

    }

    @Override
    public List<Language> getAllUsers() {
        return null;
    }
}
