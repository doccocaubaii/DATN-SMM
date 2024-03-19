package edu.hust.shadowmiddleman.domain;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Chat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "user_id_1")
    private Integer userId1;
    @Basic
    @Column(name = "user_id_2")
    private Integer userId2;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "type")
    private Integer type;
    @Basic
    @Column(name = "create_at")
    private Timestamp createAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId1() {
        return userId1;
    }

    public void setUserId1(Integer userId1) {
        this.userId1 = userId1;
    }

    public Integer getUserId2() {
        return userId2;
    }

    public void setUserId2(Integer userId2) {
        this.userId2 = userId2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return id == chat.id && Objects.equals(userId1, chat.userId1) && Objects.equals(userId2, chat.userId2) && Objects.equals(content, chat.content) && Objects.equals(type, chat.type) && Objects.equals(createAt, chat.createAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId1, userId2, content, type, createAt);
    }
}
