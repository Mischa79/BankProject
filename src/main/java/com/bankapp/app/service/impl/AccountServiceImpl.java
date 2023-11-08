package com.bankapp.app.service.impl;

import com.bankapp.app.dto.AccountTestDto;
import com.bankapp.app.entity.Account;
import com.bankapp.app.mapper.AccountTestMapper;
import com.bankapp.app.repository.AccountRepository;
import com.bankapp.app.service.util.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountTestMapper accountTestMapper;


    @Override
    @Transactional
    public Account getAccountById(String id) {
        int accountId = Integer.parseInt(id);
        return accountRepository.findById(accountId).orElse(null);
    }
    public AccountTestDto getAccounttestDto(String id){

        int accountId = Integer.parseInt(id);
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        Account account = accountOptional.orElseThrow(() -> new NoSuchElementException("Account not found!"));

       return accountTestMapper.toDto(account);
    }

    @Override
    public List<AccountTestDto> findAll() {
        List<Account> accounts = accountRepository.findAll();
        return accountTestMapper.toDtoList(accounts);
    }

    @Override
    public Account getById(String id) {
        int accountId = Integer.parseInt(id);
        return accountRepository.getReferenceById(accountId);
    }


}
