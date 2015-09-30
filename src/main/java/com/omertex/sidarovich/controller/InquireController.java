package com.omertex.sidarovich.controller;

import com.omertex.sidarovich.bean.Inquiry;
import com.omertex.sidarovich.bean.InquireList;
import com.omertex.sidarovich.exception.ServiceException;
import com.omertex.sidarovich.service.InquireService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ilona on 24.09.15.
 */

@RestController
public class InquireController {
    private static final Logger LOG = Logger.getLogger(InquireController.class);
    @Autowired
    InquireService inquireService;


    @RequestMapping( value="/customers/{costumerName}/inquiries/{inquiryId}", method = RequestMethod.GET, produces = "application/xml")
    public Inquiry getInquire ( @PathVariable String inquiryId, @PathVariable String costumerName){
        Inquiry inquiry =null;
        List<Inquiry> inquiries;
        try {
            inquiries =inquireService.findInquiresByCostumer(costumerName);
            InquireList inquireList = new InquireList(inquiries);
        } catch (ServiceException e) {
            LOG.error(e);
        }
        try {
            inquiry = inquireService.findInquireById(Long.parseLong(inquiryId));
        } catch (ServiceException e) {
            LOG.error(e);
        }
        return inquiry;
    }

    @RequestMapping( value="/costumers/{costumerName}/inquiries", method = RequestMethod.GET, produces = "application/xml")
    public InquireList getInquireByCostumer ( @PathVariable String costumerName){
        List<Inquiry> inquiries;
        InquireList inquireList = null;
        try {
            inquiries =inquireService.findInquiresByCostumer(costumerName);
            inquireList = new InquireList(inquiries);
        } catch (ServiceException e) {
            LOG.error(e);
        }
        return inquireList;
    }


   @RequestMapping(value = "/inquiries/{inquiryId}", method = RequestMethod.GET, produces = "application/xml")
    public Inquiry getInquire(@PathVariable String inquiryId) {
        Inquiry inquiry =null;
        try {
            inquiry = inquireService.findInquireById(Long.parseLong(inquiryId));
        } catch (ServiceException e) {
            LOG.error(e);
        }
        return inquiry;
    }

    @RequestMapping(value = "/customers/{customerName}/inquiries/{inquiryId}", method = RequestMethod.DELETE)
    public String deleteInquire(@PathVariable String customerName, @PathVariable String inquiryId) {
        Inquiry inquiry =null;
        try {
            inquireService.deleteInquire(Long.parseLong(inquiryId));
        } catch (ServiceException e) {
            LOG.error(e);
        }
        return "deleted";
    }

    @RequestMapping(value = "/customers/{customerName}/inquiries/{inquiryId}", method = RequestMethod.PUT,  produces = "application/xml", consumes ="application/xml")
    public Inquiry updateInquire(@PathVariable String customerName, @PathVariable String inquiryId, @RequestBody Inquiry inquiry) {
        try {
            inquireService.updateInquire(inquiry, Long.parseLong(inquiryId));
        } catch (ServiceException e) {
            LOG.error(e);
        }
        return inquiry;
    }


    @RequestMapping(value = "/customers/{customerName}/inquiries", method = RequestMethod.POST, produces = "application/xml", consumes ="application/xml")
    public Inquiry postInquire(@PathVariable String customerName, @RequestBody Inquiry inquiry) {
        try {
            inquireService.createInquire(inquiry);
        } catch (ServiceException e) {
            LOG.error(e);
        }
        return inquiry;
    }
}
