package com.omertex.sidarovich.bean;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ilona on 24.09.15.
 */
@Component
@Entity
@Table(name = ("INQUIRY"))
@XmlRootElement
public class Inquiry {
    @Id
    @Column(name = ("ID_INQUIRY"))
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = ("DESCRIPTION"))
    private String description;
    @Column(name = ("CREATE_DATE"))
    private Date createDate;
    @Column(name = ("COSTUMER_NAME"))
    private String costumerName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name=("ID_TOPIC"))
    private Topic topic;
    @OneToMany(mappedBy = "inquiry")
    private Set<Attribute> attributes = new HashSet<Attribute>(0);


    public Inquiry() {
    }

    public Inquiry(Topic topic, String description, String costumerName) {
        this.topic = topic;
        this.description = description;
        this.costumerName = costumerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Set<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inquiry)) return false;

        Inquiry inquiry = (Inquiry) o;

        if (costumerName != null ? !costumerName.equals(inquiry.costumerName) : inquiry.costumerName != null)
            return false;
        if (createDate != null ? !createDate.equals(inquiry.createDate) : inquiry.createDate != null) return false;
        if (description != null ? !description.equals(inquiry.description) : inquiry.description != null) return false;
        if (id != null ? !id.equals(inquiry.id) : inquiry.id != null) return false;
        if (topic != null ? !topic.equals(inquiry.topic) : inquiry.topic != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (costumerName != null ? costumerName.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        return result;
    }
}
