package com.guide_finder.service.abstraction;

import com.guide_finder.model.user.Language;

import java.util.List;

public interface LanguageService {
    Language getLanguageById(long id);

    Language getLanguageByName(String name);

    void saveLanguage(Language language);

    void editLanguage(Language language);

    void remove(long id);

    List<Language> getAllUsers();

}
