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




import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/topic")
public class TopicController {


    @Autowired
    private TopicService topicService;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private UserService userService;




    @RequestMapping("/topic")
    public String totopic(Model model,@RequestParam("id") int tid) {
        Topic topic = topicService.selectTopicByid(tid);
        model.addAttribute("topic", topic);

        List<Reply> replyList = replyService.selectbyTid(tid);
        List<Reply> replies = new ArrayList<Reply>();
        for (Reply reply : replyList) {
            reply.setUser(userService.selectUserbyId(reply.getUser().getId()));
            replies.add(reply);
        }
        model.addAttribute("replies", replies);
        return "/main/main";
    }

    @RequestMapping("/gettopic")
    public String gettopic(Model model,@RequestParam("title")String title,
                           @RequestParam("context") String context,
                           @RequestParam("id") String uid){

        int id=Integer.parseInt(uid);
        User user=new User();
        Date date=new Date();
        user.setId(id);
        Topic topic=new Topic(title,context,date,user);
        int t=topicService.insertTopic(topic);
        return "redirect:/";
    }
    @RequestMapping("/delete")
    public String delete(Model model,
                         @RequestParam("id") int tid){
        int i=topicService.deletebytid(tid);
        return "redirect:/zhuye";

    }

}
