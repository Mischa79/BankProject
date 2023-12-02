package com.bankapp.app.mapper;

import com.bankapp.app.dto.TransactionTestDto;
import com.bankapp.app.entity.Product;
import com.bankapp.app.entity.Transaction;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionTestMapper {

    @Mappings({
            @Mapping(source = "transaction.id", target = "id"),
            @Mapping(target = "name", ignore = true),
            @Mapping(target = "productLimit", ignore = true),
            @Mapping(target = "balance", ignore = true)
    })
    TransactionTestDto toDto(Transaction transaction);

    default String mapProductListToName(List<Product> productList) {
        return productList != null && !productList.isEmpty() ? productList.get(0).getName() : null;
    }

    default String mapProductListToProductLimit(List<Product> productList) {
        return productList != null && !productList.isEmpty() ? String.valueOf(productList.get(0).getProductLimit()) : null;
    }

    @AfterMapping
    default void mapProductListToDto(@MappingTarget TransactionTestDto dto, Transaction transaction) {
        dto.setName(mapProductListToName(transaction.getProductList()));
        dto.setProductLimit(mapProductListToProductLimit(transaction.getProductList()));
    }
}
