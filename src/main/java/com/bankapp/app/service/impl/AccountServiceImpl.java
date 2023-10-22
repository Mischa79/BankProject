package com.bankapp.app.service.impl;

import com.bankapp.app.dto.AccountTestDto;
import com.bankapp.app.entity.Account;
import com.bankapp.app.mapper.AccountTestMapper;
import com.bankapp.app.repository.AccountRepository;
import com.bankapp.app.service.util.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountTestMapper accountTestMapper;


    @Override
    public Account getAccountById(String id) {

        int accountId = Integer.parseInt(id);
        return accountRepository.findById(accountId).orElse(null);
    }

    @Override
    public AccountTestDto getAccountTestDto(String id) {
        return accountTestMapper.toDto(accountRepository.getAccountById(Integer.valueOf(Integer.toString(Integer.parseInt(id)))));
    }
}
