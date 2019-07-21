package com.controller;


import com.entity.User;
import com.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

@Controller
public class UserController {

    @Resource
    private UserService userService;



    @RequestMapping("/userlogin")
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              ModelAndView mv,
                              HttpSession session) {

        User user = userService.selectUserbyUsername(username);



        if (user != null) {
            if (user.getPassword().equals(password)) {
                session.setAttribute("id", user.getId());
                session.setAttribute("name", user.getUsername());
                mv.setViewName("redirect:/");
                return mv;
            }
        }
        String errorMsg = "密码或用户名错误，请重新登录";

        mv.addObject("errorMsg", errorMsg);
        mv.setViewName("login/login");
        return mv;
    }

    @RequestMapping("/userregister")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("age") int age,
                           Model model,
                           RedirectAttributes redirectAttributes) {

        User u=userService.selectUserbyUsername(username);
        if (u!=null){
            model.addAttribute("msg","用户名已被注册");
            return "login/register";
        }
        User user = new User(username, age, password);
        user.setBan(1);

        int i = userService.insertUser(user);
        if(i!=0){
            redirectAttributes.addAttribute("username",username);
            redirectAttributes.addAttribute("password",password);
            return "redirect:/userlogin";

        }
        model.addAttribute("msg","注册失败，请重新注册");
        return "login/register";

    }

    @RequestMapping("/userset")
    public  String userset(Model model,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("age") int age,
                           HttpSession session){
        User user=new User(username,age,password);
        User u=userService.selectUserbyUsername(username);
        int id=(int)session.getAttribute("id");
        if (u!=null){
            model.addAttribute("msg","用户名已被注册");
            return "/main/user";
        }
        user.setId(id);
        int x=userService.updateuser(user);
        if (x==0){
            model.addAttribute("msg","用户名已被注册");
            return "/main/user";
        }
        return "redirect:/zhuye";


    }


}
