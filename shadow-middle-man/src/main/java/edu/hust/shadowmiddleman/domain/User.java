package edu.hust.shadowmiddleman.domain;

import edu.hust.shadowmiddleman.dto.account.RegisterDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
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
    private Double balance;
    @Basic
    @Column(name = "role")
    private String role;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "status")
    private Integer status; // 0 là không hoạt động, 1 là hoạt động
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(fullname, user.fullname) && Objects.equals(avatarUrl, user.avatarUrl) && Objects.equals(accountNumber, user.accountNumber) && Objects.equals(balance, user.balance) && Objects.equals(role, user.role) && Objects.equals(password, user.password) && Objects.equals(status, user.status) && Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, fullname, avatarUrl, accountNumber, balance, role, password, status, createdAt);
    }
}
