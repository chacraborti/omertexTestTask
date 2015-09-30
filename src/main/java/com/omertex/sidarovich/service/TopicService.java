package com.omertex.sidarovich.service;

import com.omertex.sidarovich.bean.Topic;
import com.omertex.sidarovich.dao.TopicDao;
import com.omertex.sidarovich.exception.DAOException;
import com.omertex.sidarovich.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ilona on 25.09.15.
 */
@Service
public class TopicService {
    @Autowired
    TopicDao topicDao;

    public void createTopic(Topic topic) throws ServiceException {
        try {
            topicDao.createTopic(topic);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


    public List<Topic> findAllTopics() throws ServiceException {
        List<Topic> topics;
        try {
            topics=topicDao.findAllTopics();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return topics;
    }


    public void updateTopic(Topic topic) throws ServiceException {
        try {
            topicDao.updateTopic(topic);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


    public void deleteTopic(Long id) throws ServiceException {
        try {
            topicDao.deleteTopic(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


    public Topic findTopicById(Long id) throws ServiceException{
        Topic topic;
        try {
            topic=topicDao.findTopicById(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return topic;
    }
}
