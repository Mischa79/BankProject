package com.bankapp.app.entity;

import com.bankapp.app.entity.enums.AgreementStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.Objects;

import static jakarta.persistence.CascadeType.*;


@Entity
@Table(name = "agreements")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agreement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "interest_rate")
    private Double interestRate;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private AgreementStatus status;

    @Column(name = "sum")
    private Double sum;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "update_at")
    private Timestamp updateAt;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "product_id")
   private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agreement agreement)) return false;
        return id == agreement.id && Objects.equals(interestRate, agreement.interestRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, interestRate);
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "id=" + id +
                ", interestRate=" + interestRate +
                ", status=" + status +
                ", sum=" + sum +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", product=" + product +
                ", account=" + account +
                '}';
    }

}
