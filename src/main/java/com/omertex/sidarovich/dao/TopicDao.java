package com.omertex.sidarovich.dao;

import com.omertex.sidarovich.bean.Topic;
import com.omertex.sidarovich.exception.DAOException;

import java.util.List;

/**
 * Created by ilona on 25.09.15.
 */
public interface TopicDao {
    public void createTopic(Topic topic) throws DAOException;
    public List<Topic> findAllTopics() throws DAOException;
    public void updateTopic(Topic topic) throws DAOException;
    public void deleteTopic(Long id) throws DAOException;
    public Topic findTopicById(Long id) throws DAOException;
}
