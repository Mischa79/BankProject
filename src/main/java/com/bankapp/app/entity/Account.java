package com.bankapp.app.entity;

import com.bankapp.app.entity.enums.AccountStatus;
import com.bankapp.app.entity.enums.AccountType;
import com.bankapp.app.entity.enums.CurrencyCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private AccountType type;

    @Column(name = "account_status")
    @Enumerated(EnumType.ORDINAL)
    private AccountStatus accountStatus;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "currency_code")
    @Enumerated(EnumType.ORDINAL)
    private CurrencyCode currencyCode;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "update_at")
    private Timestamp updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY,
   orphanRemoval = true, cascade = {MERGE,PERSIST,REFRESH})
    private List<Agreement> agreements;

    @OneToMany(mappedBy = "debitAccountId", fetch = FetchType.LAZY,
    orphanRemoval = true, cascade = {MERGE,PERSIST,REFRESH})
    private Set<Transaction> debitTransaction;

    @OneToMany(mappedBy = "creditAccountId",fetch = FetchType.LAZY,
    orphanRemoval = true, cascade = {MERGE,PERSIST,REFRESH})
    private Set<Transaction> creditTransaction;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return id == account.id && Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", accountStatus=" + accountStatus +
                ", balance=" + balance +
                ", currencyCode=" + currencyCode +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", client=" + client +
                ", agreements=" + agreements +
                ", debitTransaction=" + debitTransaction +
                ", creditTransaction=" + creditTransaction +
                '}';
    }
}
