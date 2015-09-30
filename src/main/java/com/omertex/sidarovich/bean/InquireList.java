package com.omertex.sidarovich.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by ilona on 27.09.15.
 */
@XmlRootElement
public class InquireList {
    private List<Inquiry> inquiries;
    public InquireList() {}

    public InquireList(List<Inquiry> inquiries) {
        this.inquiries = inquiries;
    }

    @XmlElement(name="inquiry")
    public List<Inquiry> getInquiries() {
        return inquiries;
    }

    public void setInquiries(List<Inquiry> inquiries) {
        this.inquiries = inquiries;
    }
}
