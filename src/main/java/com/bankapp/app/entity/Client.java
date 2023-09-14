package com.bankapp.app.entity;

import com.bankapp.app.entity.enums.ClientStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;
@Entity
@Table(name ="clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "manager_id")
    private int managerId;

    @Column(name = "status")
    private ClientStatus status;

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "update_at")
    private Timestamp updateAt;

    @ManyToMany(mappedBy = "client", fetch = FetchType.LAZY)
            @JoinColumn(name = "manager_id")

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return id == client.id && managerId == client.managerId && status == client.status && Objects.equals(taxCode, client.taxCode) && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(email, client.email) && Objects.equals(address, client.address) && Objects.equals(phone, client.phone) && Objects.equals(createAt, client.createAt) && Objects.equals(updateAt, client.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, managerId, status, taxCode, firstName, lastName, email, address, phone, createAt, updateAt);
    }
}
