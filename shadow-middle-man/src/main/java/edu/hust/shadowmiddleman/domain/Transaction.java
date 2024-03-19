package edu.hust.shadowmiddleman.domain;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Transaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "deal_id")
    private Integer dealId;
    @Basic
    @Column(name = "from_user_id")
    private Integer fromUserId;
    @Basic
    @Column(name = "to_user_id")
    private Integer toUserId;
    @Basic
    @Column(name = "amount")
    private Double amount;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "create_at")
    private Timestamp createAt;
    @Basic
    @Column(name = "create_by")
    private String createBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && Objects.equals(dealId, that.dealId) && Objects.equals(fromUserId, that.fromUserId) && Objects.equals(toUserId, that.toUserId) && Objects.equals(amount, that.amount) && Objects.equals(status, that.status) && Objects.equals(createAt, that.createAt) && Objects.equals(createBy, that.createBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dealId, fromUserId, toUserId, amount, status, createAt, createBy);
    }
}
