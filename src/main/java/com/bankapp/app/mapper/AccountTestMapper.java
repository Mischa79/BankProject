package com.bankapp.app.mapper;

import com.bankapp.app.dto.AccountTestDto;
import com.bankapp.app.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountTestMapper {
    @Mapping(source = "name", target = "name" )
    @Mapping(source = "agreement.interestRate", target = "interestRate" )
    @Mapping(source = "agreement.sum", target = "sum" )
    @Mapping(source = "client.taxCode", target = "taxCode" )
    @Mapping(source = "client.email", target = "email")
    AccountTestDto toDto(Account account);

}
