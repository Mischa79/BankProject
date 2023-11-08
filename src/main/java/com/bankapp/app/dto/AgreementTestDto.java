package com.bankapp.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AgreementTestDto {

    //Agreement
    private String createAt;
    private String updateAt;

    //Client
    private String firstName;
    private String lastName;

    //Manager
    private String id;
    private String status;

}
