package com.Test;

import com.entity.Topic;
import com.service.TopicService;

import java.util.List;

public class test {

    public void main(String[] args){
        TopicService topicService=new TopicService();
        List<Topic> topics = topicService.selectAll();
        for (Topic topic : topics) {
            System.out.println(topic);
        }
    }
}
