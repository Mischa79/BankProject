package com.bankapp.app.entity;

import com.bankapp.app.entity.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "products" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "manager_id")
    private int managerId;

    @Column(name = "product_limit")
    private Integer productLimit;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private ProductStatus status;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "create_ad")
    private Timestamp createdAt;

    @Column(name = "update_at")
    private Timestamp updateAt;

    @OneToOne(cascade = {MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "id",referencedColumnName = "product_id")
    private Product product;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return id == product.id && managerId == product.managerId && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, managerId, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", managerId=" + managerId +
                ", productLimit=" + productLimit +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", currencyCode='" + currencyCode + '\'' +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
