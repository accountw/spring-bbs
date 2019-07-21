package com.repository;


import com.entity.User;
import org.apache.ibatis.annotations.*;


import java.util.List;


public interface UserRepository  {




        @Insert("insert into user(username,age,password,ban) values(#{username},#{age},#{password},#{ban})")
        public int insertUser(User user);

        @Select("select * from user")
        @Results(id="userResult",value={
                @Result(id=true,column = "id",property = "id"),
        })
        public List<User> findAll();

        @Select(" select id,username,age,password from user where username=#{username}")
        public User selectUserbyUsername(String username);




        @Update("update user set password=#{password} where username=#{username}")
        public int updatePassword(String password,String username);

        @Select(" select id,username,age,password from user where id=#{id}")
        public  User selectUserbyId(int id);



        @Update("update user set username=#{username},password=#{password},age=#{age}  where id=#{id}")
        public int updateuser(User user);





}
