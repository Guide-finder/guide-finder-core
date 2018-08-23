package com.guide_finder.service.impl.language;

import com.guide_finder.dao.abstraction.language.LanguageDao;
import com.guide_finder.dao.impl.language.LanguageDaoImpl;
import com.guide_finder.model.user.Language;
import com.guide_finder.service.abstraction.language.LanguageService;
import com.guide_finder.service.impl.user.UserServiceImpl;
import com.guide_finder.util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class LanguageServiceImpl implements LanguageService {

    private final LanguageDao languageDao;

    private static volatile LanguageServiceImpl instance;

    private LanguageServiceImpl() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        languageDao = new LanguageDaoImpl(DBHelper.getConnection());
    }

    public static LanguageServiceImpl getInstance() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        if (instance == null) {
            synchronized (UserServiceImpl.class) {
                if (instance == null) {
                    instance = new LanguageServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public Language getLanguageById(long id) {
        return languageDao.getLanguageById(id);
    }

    @Override
    public Language getLanguageByName(String name) {
        return languageDao.getLanguageByName(name);
    }

    @Override
    public void saveLanguage(Language language) {
        languageDao.saveLanguage(language);
    }

    @Override
    public void editLanguage(Language language) {
        languageDao.editLanguage(language);
    }

    @Override
    public void remove(long id) {
        languageDao.remove(id);
    }

    @Override
    public List<Language> getAllUsers() {
        return languageDao.getAllLanguages();
    }
}