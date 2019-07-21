package com.service;

import com.entity.User;
import com.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;


    public int insertUser(User user){
        int x=userRepository.insertUser(user);
        return x;
    }

    public User selectUserbyUsername(String username){
        return userRepository.selectUserbyUsername(username);
    }
    public  int updateuser(User user){


        return userRepository.updateuser(user);
    }

    public User selectUserbyId(int id){
        return userRepository.selectUserbyId(id);
    }



}
