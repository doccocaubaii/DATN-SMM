package edu.hust.shadowmiddleman.domain;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "img_urls")
    private String imgUrls;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "body")
    private String body;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && Objects.equals(imgUrls, post.imgUrls) && Objects.equals(title, post.title) && Objects.equals(body, post.body) && Objects.equals(userId, post.userId) && Objects.equals(status, post.status) && Objects.equals(createdAt, post.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imgUrls, title, body, userId, status, createdAt);
    }
}
