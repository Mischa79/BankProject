package com.bankapp.app.controller;

import com.bankapp.app.dto.AccountTestDto;
import com.bankapp.app.service.util.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class AccountTestController {

    @Autowired
    private final AccountService accountService;

    @GetMapping("/{id}")
    public AccountTestDto getAccountTestDtoById(@PathVariable("id") String id) {
        return accountService.getAccountTestDto(id);
    }

}
