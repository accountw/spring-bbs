package com.controller;


import com.entity.Reply;
import com.entity.Topic;
import com.service.ReplyService;
import com.service.TopicService;
import com.service.UserService;
import org.hibernate.annotations.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {


    @Autowired
    TopicService topicService;

    @Autowired
    UserService userService;

    @Autowired
    ReplyService replyService;

    @RequestMapping("/")
    public String index(Model model) {

        List<Topic> topicList = topicService.selectAll();
        List<Topic> topises = new ArrayList<Topic>();
        for (Topic topic : topicList) {
            topic.setUser(userService.selectUserbyId(topic.getUser().getId()));
            topises.add(topic);
        }
        model.addAttribute("topices", topises);
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login/login";
    }


    @RequestMapping("/register")
    public String toregister(Model model) {
        return "login/register";
    }

    @RequestMapping("/tobbc")
    public String tobbc(Model model) {
        return "main/tobbc";
    }

    @RequestMapping("/zhuxiao")
    public String zhuxiao(HttpSession session, Model model) {
        session.removeAttribute("id");
        session.removeAttribute("name");
        return "redirect:/";
    }

    @RequestMapping("/zhuye")
    public String zhuye(Model model, HttpSession session) {
        int uid = (int) session.getAttribute("id");

        List<Topic> topicList = topicService.selectTopicByuid(uid);
        List<Topic> topises = new ArrayList<Topic>();
        if(topicList==null){
            model.addAttribute("topices", topises);
            return "main/topic";
        }
        for (Topic topic : topicList) {
            topic.setUser(userService.selectUserbyId(uid));
            topises.add(topic);
        }
        model.addAttribute("topices", topises);
        return "main/topic";
    }

    @RequestMapping("/replyself")
    public String rep(Model model,
                      HttpSession session){


        int uid=(int)session.getAttribute("id");

        List<Reply> replyList = replyService.selectbyuid(uid);
        List<Reply> replies = new ArrayList<Reply>();
        if(replyList==null){
            model.addAttribute("replies", replies);
            return "main/topic";
        }

        for (Reply reply : replyList) {
            reply.setUser(userService.selectUserbyId(uid));
            replies.add(reply);
        }
        model.addAttribute("replies",replies);
        return "main/reply";
    }
    @RequestMapping("/usersel")
    public String touser(Model model){
        return "main/user";
    }

}
