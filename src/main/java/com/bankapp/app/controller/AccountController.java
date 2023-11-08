package com.bankapp.app.controller;

import com.bankapp.app.dto.AccountTestDto;
import com.bankapp.app.entity.Account;
import com.bankapp.app.service.util.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable("id") String id){
        return accountService.getAccountById(id);

    }
    @GetMapping("/all")
    public List<AccountTestDto> findAll(){
        return accountService.findAll();
    }
}
