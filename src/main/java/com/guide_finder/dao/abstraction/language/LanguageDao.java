package com.guide_finder.dao.abstraction.language;

import com.guide_finder.model.user.Language;
import javafx.util.Pair;

import java.util.List;


public interface LanguageDao {
    Language getLanguageById(long id);

    Language getLanguageByName(String name);

    void editLanguage(Language language);

    void saveLanguage(Language language);

    void remove(long id);

    List<Language> getAllLanguages();
}