package com.omertex.sidarovich.service;

import com.omertex.sidarovich.bean.Inquiry;
import com.omertex.sidarovich.dao.InquireDao;
import com.omertex.sidarovich.exception.DAOException;
import com.omertex.sidarovich.exception.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by ilona on 24.09.15.
 */
@Service
public class InquireService {
@Autowired
InquireDao inquireDao;
    public void createInquire(Inquiry inquiry) throws ServiceException {
        try {
            inquiry.setCreateDate(new Date());
            inquireDao.createInquire(inquiry);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


    public List<Inquiry> findAllInquire() throws ServiceException {
        List<Inquiry> inquiries;
        try {
            inquiries =inquireDao.findAllInquire();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return inquiries;
    }


    public void updateInquire(Inquiry inquiry, Long id) throws ServiceException{
        try {
            inquireDao.updateInquire(inquiry, id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


    public void deleteInquire(Long id) throws ServiceException {
        try {
            inquireDao.deleteInquire(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Inquiry findInquireById(Long id) throws ServiceException {
        Inquiry inquiry;
        try {
            inquiry = inquireDao.findInquireById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return inquiry;
    }

    public List<Inquiry> findInquiresByCostumer(String costumerName) throws ServiceException{
        List<Inquiry> inquiries;
        try {
            inquiries =inquireDao.findByCostumer(costumerName);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return inquiries;
    }

    public List<Inquiry> findInquiresById(Long id) throws ServiceException{
        List<Inquiry> inquiries;
        try {
            inquiries =inquireDao.findInquiresById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return inquiries;
    }

    public List<Inquiry> findByIdInquireCostumer(Long id, List<Inquiry> inquiryList) throws ServiceException{
        List<Inquiry> inquiries;
        try {
            inquiries =inquireDao.findInquiresById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return inquiries;
    }
}
