package com.bankapp.app.mapper;

import com.bankapp.app.dto.ClientTestDto;
import com.bankapp.app.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ClientTestMapper {

    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "manager.firstName", target = "firstName")
    @Mapping(source = "manager.lastName", target = "lastName")
    ClientTestDto toDto(Client client);

    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "firstName", target = "manager.firstName")
    @Mapping(source = "lastName", target = "manager.lastName")
    Client toEntity(ClientTestDto clientTestDto);
}
