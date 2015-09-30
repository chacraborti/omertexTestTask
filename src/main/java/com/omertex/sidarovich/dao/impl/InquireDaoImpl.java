package com.omertex.sidarovich.dao.impl;


import com.omertex.sidarovich.bean.Attribute;
import com.omertex.sidarovich.bean.Inquiry;
import com.omertex.sidarovich.dao.InquireDao;
import com.omertex.sidarovich.exception.DAOException;
import com.omertex.sidarovich.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by ilona on 24.09.15.
 */
@Repository
public class InquireDaoImpl implements InquireDao{
    private static final Logger LOG = Logger.getLogger(InquireDaoImpl.class);

    @Override
    public void createInquire(Inquiry inquiry) throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            if(inquiry !=null){
                session.save(inquiry);
                Set<Attribute> attributes=inquiry.getAttributes();
                for(Attribute attribute: attributes){
                    attribute.setInquiry(inquiry);
                    session.save(attribute);
                }
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DAOException (e);
        }
    }

    @Override
    public List<Inquiry> findAllInquire() throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Inquiry> inquiries;
        try{
        Criteria criteria = session.createCriteria(Inquiry.class);
        inquiries = criteria.list();
        session.getTransaction().commit();
        }catch (HibernateException e){
            throw new DAOException(e);
        }
        return inquiries;
    }

    @Override
    public void updateInquire(Inquiry inquiry, Long id) throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        session.beginTransaction();
        Inquiry existingInquiry = (Inquiry) session.get(Inquiry.class, id);
        existingInquiry.setCostumerName(inquiry.getCostumerName());
        existingInquiry.setDescription(inquiry.getDescription());
        existingInquiry.setTopic(inquiry.getTopic());
        existingInquiry.setAttributes(inquiry.getAttributes());
        try {
            Set<Attribute> attributes=inquiry.getAttributes();
            for(Attribute attribute: attributes){
                attribute.setInquiry(inquiry);
                session.saveOrUpdate(attribute);
            }
            session.save(existingInquiry);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DAOException (e);
        }
    }

    @Override
    public void deleteInquire(Long id) throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Inquiry inquiry = (Inquiry) session.get(Inquiry.class, id);
            Set<Attribute> attributes=inquiry.getAttributes();
            for(Attribute attribute: attributes){
                session.delete(attribute);
            }
            session.delete(inquiry);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DAOException (e);
        }
    }

    @Override
    public Inquiry findInquireById(Long id) throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        Inquiry inquiry;
        try{
        session.beginTransaction();
        inquiry = (Inquiry) session.get(Inquiry.class, id);
        session.getTransaction().commit();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DAOException (e);
        }
        return inquiry;
    }

    @Override
    public List<Inquiry> findByCostumer(String costumerName) throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        List<Inquiry> inquiries;
        try{
        session.beginTransaction();
        inquiries = session.createCriteria(Inquiry.class)
                        .add(Restrictions.like("costumerName", costumerName))
                        .list();
        session.getTransaction().commit();
        }catch (HibernateException e){
            throw new DAOException(e);
        }
        return inquiries;
    }

    @Override
    public List<Inquiry> findInquiresById(Long id) throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        List<Inquiry> inquiries;
        try{
        session.beginTransaction();
        inquiries = session.createCriteria(Inquiry.class)
                .add(Restrictions.like("id", id))
                .list();
        session.getTransaction().commit();
        }catch (HibernateException e){
            throw new DAOException(e);
        }
        return inquiries;
    }
}
