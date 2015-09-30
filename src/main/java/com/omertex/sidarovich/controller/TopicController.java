package com.omertex.sidarovich.controller;

import com.omertex.sidarovich.bean.Topic;
import com.omertex.sidarovich.bean.TopicList;
import com.omertex.sidarovich.exception.ServiceException;
import com.omertex.sidarovich.service.TopicService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ilona on 26.09.15.
 */
@RestController
public class TopicController {
    private static final Logger LOG = Logger.getLogger(InquireController.class);
    @Autowired
    TopicService topicService;

    @RequestMapping( value="/topics", method = RequestMethod.GET, produces = "application/xml")
    public TopicList  getTopics ( ){
        List<Topic> topics;
        TopicList topicList=null;
        try {
            topics=topicService.findAllTopics();
            topicList = new TopicList(topics);
        } catch (ServiceException e) {
            LOG.error(e);
        }
        return topicList;
    }
}
