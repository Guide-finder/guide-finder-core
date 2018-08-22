package com.guide_finder.dao.impl;

import com.guide_finder.dao.abstraction.LanguageDao;
import com.guide_finder.dao.executor.Executor;
import com.guide_finder.model.user.Language;
import javafx.util.Pair;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class LanguageDaoImpl implements LanguageDao {
    private final Executor executor;

    public LanguageDaoImpl(Connection connection) {
        this.executor = new Executor(connection);
    }

    @Override
    public Language getLanguageById(long id) {
        return executor.execQuery("SELECT * FROM language WHERE id='" + id + "'", result -> {
            if (result.next()) {
                return  new Language(
                        result.getLong(1),
                        result.getString(2)
                );
            } else {
                return null;
            }
        });
    }

    @Override
    public Language getLanguageByName(String name) {
        return executor.execQuery("SELECT * FROM language WHERE name='" + name + "'", result -> {
            if (result.next()) {
                return  new Language(
                        result.getLong(1),
                        result.getString(2)
                );
            } else {
                return null;
            }
        });
    }

    @Override
    public void saveLanguage(Language language) {
        executor.execUpdate("INSERT INTO language (name) VALUES ('" + language.getName() + "')");
    }

    @Override
    public void editLanguage(Language language) {
        executor.execUpdate("UPDATE language SET name='" + language.getName() + "'");
    }

    @Override
    public void remove(long id) {
        executor.execUpdate("DELETE FROM language WHERE id='" + id + "'");
    }

    @Override
    public List<Language> getAllLanguages() {
        return executor.execQuery("SELECT * FROM languages;",
                result -> {
                    List<Language> listCouries = new ArrayList<>();
                    while (result.next()) {
                        listCouries.add(
                                new Language(result.getLong(1),
                                        result.getString(2))
                        );
                    }
                    return listCouries;
                });
    }
}
