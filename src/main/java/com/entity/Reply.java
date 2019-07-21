package com.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Reply")
public class Reply {

    @Id
    @Column(name="rid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int rid;

    @Column(name="context",length = 255)
    private String context;
    @Column(name="time")
    private Date time;


    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name="userid")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name="topicid")
    private Topic topic;


    public Reply(String context, Date time, User user, Topic topic) {
        this.context = context;
        this.time = time;
        this.user = user;
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Reply() {
        super();
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }



    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rid=" + rid +
                ", context='" + context + '\'' +
                ", time=" + time +
                ", user=" + user +
                ", topic=" + topic +
                '}';
    }
}
