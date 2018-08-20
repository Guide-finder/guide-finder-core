package com.guide_finder.dao.impl;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractDao<T> {

    private final Class<T> persistentClass;

    private final String getAllQuery;

    private final String getDistinctQuery;

    private final String getDistinctQueryWhere;

    private final String getQueryWhere;

    public AbstractDao() {
        persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        String genericClassName = persistentClass.toGenericString();
        String className = genericClassName.substring(genericClassName.lastIndexOf('.')+1);
        getAllQuery = "FROM " +className;
        getDistinctQuery = "SELECT DISTINCT e FROM " +className+ " e";
        getDistinctQueryWhere = getDistinctQuery + " WHERE e.";
        getQueryWhere = "SELECT e FROM " +className+ " e WHERE e.";
    }

}
