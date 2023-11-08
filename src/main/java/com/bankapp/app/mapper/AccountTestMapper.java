package com.bankapp.app.mapper;

import com.bankapp.app.dto.AccountTestDto;
import com.bankapp.app.entity.Account;
import com.bankapp.app.entity.Agreement;
import org.mapstruct.*;
import java.util.List;


@Mapper(componentModel = "spring")
public interface AccountTestMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "agreements", target = "interestRate", qualifiedByName = "mapAgreementInterestRate")
    @Mapping(source = "agreements", target = "sum", qualifiedByName = "mapAgreementSum")
    @Mapping(source = "client.taxCode", target = "taxCode")
    @Mapping(source = "client.email", target = "email")
    AccountTestDto toDto(Account account);

    List<AccountTestDto> toDtoList(List<Account> accounts);

    @Named("mapAgreementInterestRate")
    default String mapAgreementInterestRate(List<Agreement> agreements) {
        double interestRateSum = agreements.stream()
                .mapToDouble(Agreement::getInterestRate)
                .sum();
        return Double.toString(interestRateSum);
    }

    @Named("mapAgreementSum")
    default String mapAgreementSum(List<Agreement> agreements) {
        double sum = agreements.stream()
                .mapToDouble(Agreement::getSum)
                .sum();
        return Double.toString(sum);
    }
}







