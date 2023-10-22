package com.bankapp.app.service.util;

import com.bankapp.app.dto.AccountTestDto;
import com.bankapp.app.entity.Account;

public interface AccountService {
    Account getAccountById(String id);

    AccountTestDto getAccountTestDto(String id);
}
