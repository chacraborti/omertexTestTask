package com.omertex.sidarovich.bean;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by ilona on 24.09.15.
 */
@Component
@Entity
@Table(name = ("ATTRIBUTE"))
@XmlRootElement
public class Attribute {
    @Id
    @Column(name = ("ID_ATTRIBUTE"))
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = ("NAME"))
    private String name;
    @Column(name = ("VALUE"))
    private String value;

    @ManyToOne
    @JoinColumn(name=("ID_INQUIRE"))
    private Inquiry inquiry;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setInquiry(Inquiry inquiry) {
        this.inquiry = inquiry;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", inquiry=" + inquiry +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attribute)) return false;

        Attribute attribute = (Attribute) o;

        if (id != null ? !id.equals(attribute.id) : attribute.id != null) return false;
        if (inquiry != null ? !inquiry.equals(attribute.inquiry) : attribute.inquiry != null) return false;
        if (name != null ? !name.equals(attribute.name) : attribute.name != null) return false;
        if (value != null ? !value.equals(attribute.value) : attribute.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (inquiry != null ? inquiry.hashCode() : 0);
        return result;
    }
}
