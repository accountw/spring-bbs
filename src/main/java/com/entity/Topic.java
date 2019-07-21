package com.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="topic")
public class Topic {

    private  static  final long serialVersionUID=1235486L;

    @Id
    @Column(name="tid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;



    @Column(name="title",length = 50,nullable = false)
    private  String title;

    @Column(name="context" ,length=50)
    private String context;

    @Column(name="ftime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ftime;

    @Column(name="ltime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ltime;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name="userid")
    private User user;


    @OneToMany(fetch=FetchType.LAZY,cascade={CascadeType.ALL},mappedBy = "topic")
    private Set<Reply> replies=new HashSet<>();


    public Topic( String title, String context, Date ftime, Date ltime) {
        this.title = title;
        this.context = context;
        this.ftime = ftime;
        this.ltime = ltime;
    }

    public Set<Reply> getReplies() {
        return replies;
    }

    public void setReplies(Set<Reply> replies) {
        this.replies = replies;
    }

    public Topic(String title, String context, Date ftime, User user) {
        this.title = title;
        this.context = context;
        this.ftime = ftime;
        this.user = user;
    }

    public Date getLtime() {
        return ltime;
    }

    public void setLtime(Date ltime) {
        this.ltime = ltime;
    }

    public Topic() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getFtime() {
        return ftime;
    }

    public void setFtime(Date time) {
        this.ftime = time;
    }

    public void addReplies(Reply reply){
        reply.setTopic(this);
        this.replies.add(reply);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "tid=" + tid +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", ftime=" + ftime +
                ", ltime=" + ltime +
                ", user=" + user +
                ", replies=" + replies +
                '}';
    }
}
