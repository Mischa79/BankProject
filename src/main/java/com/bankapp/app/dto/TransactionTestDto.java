package com.bankapp.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TransactionTestDto {

    //Transaction
    private String id;

    //Product
    private String name;
    private String productLimit;

    //Account
    private Double balance;
}
