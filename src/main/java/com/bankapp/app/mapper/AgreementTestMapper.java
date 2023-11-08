package com.bankapp.app.mapper;

import com.bankapp.app.dto.AgreementTestDto;
import com.bankapp.app.entity.Agreement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AgreementTestMapper {
    @Mapping(source = "createAt", target = "createAt")
    @Mapping(source = "updateAt", target = "updateAt")
    @Mapping(source = "account.client.firstName", target = "firstName")
    @Mapping(source = "account.client.lastName", target = "lastName")
    @Mapping(source = "account.client.manager.id", target = "id")
    @Mapping(source = "account.client.manager.status", target = "status")
    AgreementTestDto toDto(Agreement agreement);
}
