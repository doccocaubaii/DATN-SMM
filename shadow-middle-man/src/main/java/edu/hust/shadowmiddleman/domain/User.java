package edu.hust.shadowmiddleman.domain;

import edu.hust.shadowmiddleman.common.enumpackage.RoleEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "fullname")
    private String fullname;
    @Basic
    @Column(name = "avatar_url")
    private String avatarUrl;
    @Basic
    @Column(name = "account_number")
    private String accountNumber;
    @Basic
    @Column(name = "balance")
    private Double balance = 0d;
    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role = RoleEnum.SALE;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "status")
    private Integer status = 1; // 0 là không hoạt động, 1 là hoạt động
    @Basic
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(fullname, user.fullname) && Objects.equals(avatarUrl, user.avatarUrl) && Objects.equals(accountNumber, user.accountNumber) && Objects.equals(balance, user.balance) && Objects.equals(role, user.role) && Objects.equals(password, user.password) && Objects.equals(status, user.status) && Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, fullname, avatarUrl, accountNumber, balance, role, password, status, createdAt);
    }
}
