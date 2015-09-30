package com.omertex.sidarovich.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by ilona on 27.09.15.
 */
@XmlRootElement
public class TopicList {
    private List<Topic> topics;
    public TopicList() {}

    public TopicList(List<Topic> topics) {
        this.topics = topics;
    }

    @XmlElement(name="topic")
    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
