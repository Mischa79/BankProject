package com.bankapp.app.service.util;

import com.bankapp.app.dto.AccountTestDto;
import com.bankapp.app.entity.Account;

import java.util.List;


public interface AccountService {
    Account getAccountById(String id);
    AccountTestDto getAccounttestDto(String id);
    List<AccountTestDto> findAll();
    Account getById(String id);


}
