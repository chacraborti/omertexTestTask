package com.omertex.sidarovich.dao.impl;

import com.omertex.sidarovich.bean.Attribute;
import com.omertex.sidarovich.bean.Inquiry;
import com.omertex.sidarovich.dao.AttributeDao;
import com.omertex.sidarovich.exception.DAOException;
import com.omertex.sidarovich.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by ilona on 27.09.15.
 */
public class AttributeDaoImpl implements AttributeDao {
    @Override
    public void createAttribute(Attribute attribute) throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            if(attribute!=null){
                session.save(attribute);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DAOException (e);
        }
    }

    @Override
    public List<Attribute> findAllAttribute() throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Attribute> attributes;
        try{
            Criteria criteria = session.createCriteria(Inquiry.class);
            attributes = criteria.list();
            session.getTransaction().commit();
        }catch (HibernateException e){
            throw new DAOException(e);
        }
        return attributes;
    }

    @Override
    public void updateAttribute(Attribute attribute) throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        session.beginTransaction();
        Attribute existingAttribute = (Attribute) session.get(Attribute.class, attribute.getId());
        existingAttribute.setName(attribute.getName());
        existingAttribute.setValue(attribute.getValue());
        try {
            session.save(existingAttribute);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DAOException (e);
        }
    }

    @Override
    public void deleteAttribute(Long id) throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Attribute attribute = (Attribute) session.get(Attribute.class, id);
            session.delete(attribute);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DAOException (e);
        }
    }

    @Override
    public Attribute findAttributeById(Long id) throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        Attribute attribute = null;
        try{
            session.beginTransaction();
            attribute = (Attribute) session.get(Attribute.class, id);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DAOException (e);
        }
        return attribute;
    }
}
