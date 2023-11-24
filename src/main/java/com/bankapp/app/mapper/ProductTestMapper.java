package com.bankapp.app.mapper;

import com.bankapp.app.dto.ProductTestDto;
import com.bankapp.app.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductTestMapper {

    @Mapping(source = "product.name", target = "name")
    @Mapping(source = "product.transaction.description", target = "description")
    @Mapping(source = "product.client.address", target = "address")
    @Mapping(source = "product.client.phone", target = "phone")
    ProductTestDto toDto(Product product);

    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.description", target = "transaction.description")
    @Mapping(source = "dto.address", target = "client.address")
    @Mapping(source = "dto.phone", target = "client.phone")
    Product toEntity(ProductTestDto dto);

    @Mapping(source = "product.name", target = "name")
    @Mapping(source = "product.transaction.description", target = "description")
    @Mapping(source = "product.client.address", target = "address")
    @Mapping(source = "product.client.phone", target = "phone")
    List<ProductTestDto> toDtoList(List<Product> productList);

    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.description", target = "transaction.description")
    @Mapping(source = "dto.address", target = "client.address")
    @Mapping(source = "dto.phone", target = "client.phone")
    Product updateFromDto(ProductTestDto dto, @MappingTarget Product existingProduct);
}
