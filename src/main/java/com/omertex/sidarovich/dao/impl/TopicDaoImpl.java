package com.omertex.sidarovich.dao.impl;

import com.omertex.sidarovich.bean.Topic;
import com.omertex.sidarovich.dao.TopicDao;
import com.omertex.sidarovich.exception.DAOException;
import com.omertex.sidarovich.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ilona on 25.09.15.
 */
@Repository
public class TopicDaoImpl implements TopicDao {
    @Override
    public void createTopic(Topic topic) throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            if(topic!=null){
                session.save(topic);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DAOException (e);
        }
    }

    @Override
    public List<Topic> findAllTopics() throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Topic> topics;
        try{
            Criteria criteria = session.createCriteria(Topic.class);
            topics = criteria.list();
            session.getTransaction().commit();
        }catch (HibernateException e){
            throw new DAOException(e);
        }
        return topics;
    }

    @Override
    public void updateTopic(Topic topic) throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        session.beginTransaction();
        Topic existingTopic = (Topic) session.get(Topic.class, topic.getId());
        existingTopic.setName(topic.getName());
        try {
            session.save(existingTopic);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DAOException (e);
        }
    }

    @Override
    public void deleteTopic(Long id) throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Topic topic = (Topic) session.get(Topic.class, id);
            session.delete(topic);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DAOException (e);
        }
    }

    @Override
    public Topic findTopicById(Long id) throws DAOException {
        Session session = HibernateUtil.createSessionFactory().getCurrentSession();
        Topic topic;
        try{
            session.beginTransaction();
            topic = (Topic) session.get(Topic.class, id);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DAOException (e);
        }
        return topic;
    }
}
