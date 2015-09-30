//package com.omertex.sidarovich;
//
//import com.omertex.sidarovich.bean.Attribute;
//
//import com.omertex.sidarovich.bean.Inquiry;
//import com.omertex.sidarovich.bean.Topic;
//import com.omertex.sidarovich.dao.InquireDao;
//import com.omertex.sidarovich.dao.TopicDao;
//import com.omertex.sidarovich.dao.impl.InquireDaoImpl;
//import com.omertex.sidarovich.dao.impl.TopicDaoImpl;
//import com.omertex.sidarovich.exception.DAOException;
//import com.omertex.sidarovich.service.InquireService;
//
///**
//* Created by ilona on 27.09.15.
//*/
//public class Main {
//
//    public static void main(String[] args) {
//        InquireDao inquireDao = new InquireDaoImpl();
//        TopicDao topicDao = new TopicDaoImpl();
//        InquireService inquireService = new InquireService();
//
//
//            // Inquire inquire = new Inquire(topic, "no connection", "Petr");
//            //inquireDao.createInquire(inquire);
//           // List<Inquiry> inquires = null;
//            try {
//
//                Topic topic = topicDao.findTopicById(5L);
//                Inquiry inquiry= new Inquiry(topic, "no connection", "Tom");
//                inquireDao.createInquire(inquiry);
////                System.out.println(inquire);
////                for (Attribute attribute : inquire.getAttributes()) {
////                    System.out.println("nirvana" + attribute);
////                }
//
//            } catch (DAOException e) {
//                e.printStackTrace();
//
////            for (Inquire inquire1: inquires){
////                System.out.println("nirvana");
////                System.out.println(inquire1.toString());
////            }
//
//
//            }
//        }
//    }