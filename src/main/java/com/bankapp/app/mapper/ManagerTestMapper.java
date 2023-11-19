package com.bankapp.app.mapper;

import com.bankapp.app.dto.ManagerTestDto;
import com.bankapp.app.entity.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ManagerTestMapper {
    ManagerTestMapper INSTANCE = Mappers.getMapper(ManagerTestMapper.class);

    ManagerTestDto toDto(Manager manager);

    Manager toEntity(ManagerTestDto managerDto);
}
