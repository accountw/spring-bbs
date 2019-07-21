package com.service;

import com.entity.Topic;

import com.repository.TopicReposity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;


@Service
public class TopicService {

    @Resource
    private  TopicReposity topicReposity;


    public  int insertTopic(Topic topic){

        return  topicReposity.insertTopic(topic);
    }


    public List<Topic> selectAll() {
        return topicReposity.selectAll();
    }

    public  Topic selectTopicByid(int tid){
        return topicReposity.selectTopicByid(tid);
    }
    public  int updateSetLtime(Date date,int tid){
        return topicReposity.updateSetLtime(date,tid);
    }


    public List<Topic> selectTopicByuid(int uid){
        return topicReposity.selectTopicByuid(uid);
    }
    public int deletebytid(int tid){
        return  topicReposity.deleteByid(tid);
    }

}
