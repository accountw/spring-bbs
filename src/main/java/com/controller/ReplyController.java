package com.controller;


import com.entity.Reply;
import com.entity.Topic;
import com.entity.User;
import com.service.ReplyService;
import com.service.TopicService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ReplyController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private UserService userService;


    @RequestMapping("/reply")
    public String addreply(
            @RequestParam("id") int id,
            @RequestParam("tid") int tid,
            @RequestParam("context") String context) {
        Date date = new Date();
        User user = userService.selectUserbyId(id);
        int x=topicService.updateSetLtime(date,tid);
        Topic topic = topicService.selectTopicByid(tid);
        Reply reply = new Reply(context, date, user, topic);
        int m = replyService.insertReply(reply);
        return   "redirect:/topic/topic?id="+ tid+"";
    }

    @RequestMapping("/deletereply")
    public  String deletereply(Model model,
                               @RequestParam("id") int rid){
        int t=replyService.deletereplybyrid(rid);
        return "redirect:/replyself";
    }
}
