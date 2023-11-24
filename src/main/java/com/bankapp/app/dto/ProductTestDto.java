package com.bankapp.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductTestDto {
    //Product
    private String name;

    //Transaction
    private String description;

    //Client
    private String address;
    private String phone;
}
