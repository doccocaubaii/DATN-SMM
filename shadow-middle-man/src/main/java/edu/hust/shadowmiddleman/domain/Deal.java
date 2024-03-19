package edu.hust.shadowmiddleman.domain;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Deal {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "agent_id")
    private Integer agentId;
    @Basic
    @Column(name = "middle_man_id")
    private Integer middleManId;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "estimated_amount")
    private Double estimatedAmount;
    @Basic
    @Column(name = "final_amount")
    private Double finalAmount;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getMiddleManId() {
        return middleManId;
    }

    public void setMiddleManId(Integer middleManId) {
        this.middleManId = middleManId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getEstimatedAmount() {
        return estimatedAmount;
    }

    public void setEstimatedAmount(Double estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
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
        Deal deal = (Deal) o;
        return id == deal.id && Objects.equals(agentId, deal.agentId) && Objects.equals(middleManId, deal.middleManId) && Objects.equals(status, deal.status) && Objects.equals(estimatedAmount, deal.estimatedAmount) && Objects.equals(finalAmount, deal.finalAmount) && Objects.equals(createdAt, deal.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agentId, middleManId, status, estimatedAmount, finalAmount, createdAt);
    }
}
