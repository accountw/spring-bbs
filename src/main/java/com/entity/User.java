package com.entity;




import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="user")
public class User {
    private  static  final long serialVersionUID=125242L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  int id;

    @Column(name="username" ,length=20)
    private  String username;
    @Column(name="age",length = 2)
    private  int age;
    @Column(name="password",length = 20)
    private String password;

    @Column(name="ban")
    private int ban;



    public int getBan() {
        return ban;
    }

    public void setBan(int ban) {
        this.ban = ban;
    }

    @OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy = "user")
    private Set<Reply> replies=new HashSet<>();


    @OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy = "user")
    private Set<Topic> topics=new HashSet<>();

    public Set<Reply> getReplies() {
        return replies;
    }

    public void setReplies(Set<Reply> replies) {
        this.replies = replies;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    public User() {
        super();
    }

    public User(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addTopic(Topic topic){
        topic.setUser(this);
        this.topics.add(topic);
    }

    public void addReplies(Reply reply){
        reply.setUser(this);
        this.replies.add(reply);
    }
}
