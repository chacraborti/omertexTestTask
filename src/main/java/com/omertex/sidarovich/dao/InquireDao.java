package com.omertex.sidarovich.dao;

import com.omertex.sidarovich.bean.Inquiry;
import com.omertex.sidarovich.exception.DAOException;

import java.util.List;

/**
 * Created by ilona on 24.09.15.
 */
public interface InquireDao {
    public void createInquire(Inquiry inquiry) throws DAOException;
    public List<Inquiry> findAllInquire() throws DAOException;
    public void updateInquire(Inquiry inquiry, Long id) throws DAOException;
    public void deleteInquire(Long id) throws DAOException;
    public Inquiry findInquireById(Long id) throws DAOException;
    public List<Inquiry> findByCostumer(String costumerName) throws DAOException;
    public List<Inquiry> findInquiresById(Long id) throws DAOException;
}
