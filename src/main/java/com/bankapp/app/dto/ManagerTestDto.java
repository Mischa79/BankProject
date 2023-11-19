package com.bankapp.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ManagerTestDto {
    //Manager
    private String firstName;
    private String lastName;

    //Product
    private String name;

    //Transaction
    private String description;
}
