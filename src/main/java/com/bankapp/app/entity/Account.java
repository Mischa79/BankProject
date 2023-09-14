package com.bankapp.app.entity;

import com.bankapp.app.entity.enums.AccountStatus;
import com.bankapp.app.entity.enums.AccountType;
import com.bankapp.app.entity.enums.CurrencyCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "client_id")
    private int clientId;

    @Column(name = "name")
    private String name;

    @Column(name = "currenc_code")
    private CurrencyCode currencyCode;

    @Column(name = "account_status")
    private AccountStatus accountStatus;

    @Column(name = "type")
    private AccountType type;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "update_at")
    private Timestamp updateAt;

    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY,
    orphanRemoval = true, cascade = {MERGE, PERSIST, REFRESH})
    private List<Agreement> agreementList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return id == account.id && clientId == account.clientId && Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, name);


    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", name='" + name + '\'' +
                ", currencyCode=" + currencyCode +
                ", accountStatus=" + accountStatus +
                ", type=" + type +
                ", balance=" + balance +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }

}
