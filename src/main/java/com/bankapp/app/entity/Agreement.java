package com.bankapp.app.entity;

import com.bankapp.app.entity.enums.AgreementStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
@Entity
@Table(name = "agreements")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agreement {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "product_id")
    private int productId;

    @Column(name ="account_id")
    private int accountId;

    @Column(name = "interest_date")
    private BigDecimal interestRate;

    @Column(name = "status")
    private AgreementStatus status;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "update_at")
    private Timestamp updateAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agreement agreement)) return false;
        return id == agreement.id && productId == agreement.productId && accountId == agreement.accountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, accountId);
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "id=" + id +
                ", productId=" + productId +
                ", accountId=" + accountId +
                ", interestRate=" + interestRate +
                ", status=" + status +
                ", sum=" + sum +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
