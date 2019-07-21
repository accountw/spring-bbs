package com.service;

import com.entity.Reply;
import com.repository.ReplyReposity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class ReplyService {


    @Resource
    ReplyReposity replyReposity;


    public List<Reply> selectbyTid(int tid){
        return replyReposity.selectreplyBytid(tid);
    }

    public  int insertReply(Reply reply){
        return replyReposity.insertReply(reply);
    }
    public List<Reply> selectbyuid(int uid){
        return replyReposity.selectreplyByuid(uid);
    }
    public int deletereplybyrid(int uid){
        return  replyReposity.deleteByrid(uid);
    }
}
