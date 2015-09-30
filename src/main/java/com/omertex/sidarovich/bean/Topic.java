package com.omertex.sidarovich.bean;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ilona on 24.09.15.
 */
@Component
@Entity
@Table(name = ("TOPIC"))
@XmlRootElement
public class Topic {
    @Id
    @Column(name = ("ID_TOPIC"))
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = ("NAME"))
    private String name;
    @OneToMany(mappedBy = "topic")

    private Set<Inquiry> inquiries = new HashSet<Inquiry>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Inquiry> getInquiries() {
        return inquiries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Topic)) return false;

        Topic topic = (Topic) o;

        if (id != null ? !id.equals(topic.id) : topic.id != null) return false;
        if (name != null ? !name.equals(topic.name) : topic.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
