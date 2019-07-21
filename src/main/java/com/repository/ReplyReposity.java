package com.repository;

import com.entity.Reply;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface ReplyReposity {

    @Select( "select * from reply where topicid=#{topic.tid} order by time DESC")
    @Results( id="replyResult",value={
            @Result(id=true,column = "rid",property = "rid"),
            @Result(column = "context",property = "context"),
            @Result(column = "time",property = "time"),
            @Result(column = "userid",property = "user.id"),
            @Result(column = "topicid",property = "topic.tid")
    })
    public List<Reply> selectreplyBytid(int id);




    @Select("select * from reply where userid=#{user.id} order by time DESC")
    public List<Reply> selectreplyByuid(int id);

    @Delete("delete from reply where rid=#{rid}")
    public  int deleteByrid(int id);

    @Insert("insert into reply(context,time,userid,topicid) values(#{context},#{time},#{user.id},#{topic.tid})")
    public int insertReply(Reply reply);

}
