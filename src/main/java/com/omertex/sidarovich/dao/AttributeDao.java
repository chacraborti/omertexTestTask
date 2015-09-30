package com.omertex.sidarovich.dao;

import com.omertex.sidarovich.bean.Attribute;
import com.omertex.sidarovich.exception.DAOException;

import java.util.List;

/**
 * Created by ilona on 27.09.15.
 */
public interface AttributeDao {
    public void createAttribute(Attribute attribute) throws DAOException;
    public List<Attribute> findAllAttribute() throws DAOException;
    public void updateAttribute(Attribute attribute) throws DAOException;
    public void deleteAttribute(Long id) throws DAOException;
    public Attribute findAttributeById(Long id) throws DAOException;
}
