package com.bankapp.app.dto;

import com.bankapp.app.entity.enums.ProductStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ClientTestDto {
    //Client
    private String address;
    private String phone;

   //Manager
   private String firstName;
    private String lastName;

}
