package com.ziumks.iot.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

public class Post {

    @Id
    @GeneratedValue
    private  Long id;
    private  Long authorId;
    private String title;
    private String description;
    private String content;
    private Date date;

    public Post(Long id, Long authorId, String title, String description, String content, Date date) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.description = description;
        this.content = content;
        this.date = date;
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
