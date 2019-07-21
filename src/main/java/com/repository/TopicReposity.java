package com.repository;

import com.entity.Topic;

import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface TopicReposity {


    @Insert("insert into topic(title,context,ftime,userid) values(#{title},#{context},#{ftime},#{user.id})")
    public int insertTopic(Topic topic);


    @Select( "select * from topic where userid=#{uid} ORDER BY ftime DESC")
    public List<Topic> selectTopicByuid(int uid);

    @Select( "select * from topic ORDER BY ftime DESC")
    @Results(id="topicResult",value={
            @Result(id=true,column = "tid",property = "tid"),
            @Result(column = "title",property = "title"),
            @Result(column = "context",property = "context"),
            @Result(column = "ftime",property = "ftime"),
            @Result(column = "ltime",property = "ltime"),
            @Result(column = "userid",property = "user.id"),
    })
    public List<Topic> selectAll();


    @Delete("delete from topic where tid=#{tid}")
    public int deleteByid(int tid);


    @Select("select * from topic where uid=#{user.id}")
    public  List<Topic> selectByuserid(int id);

    @Select("select * from topic where tid=#{tid}")
    public  Topic selectTopicByid(int tid);

    @Update("update topic set ltime=#{date} where tid=#{tid}")
    public int updateSetLtime(Date date,int tid);


}
