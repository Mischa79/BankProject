package com.bankapp.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AccountTestDto {

    //Account
    private String name;

    //Agreement
    private String interestRate;
    private String sum;

    //Client
    private String taxCode;
    private String email;

}
