package com.bankapp.app.controller;

import com.bankapp.app.entity.Agreement;
import com.bankapp.app.service.util.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agreement")
@RequiredArgsConstructor
public class AgreementController {
    private final AgreementService agreementService;

    @GetMapping("/{id}")
    public Agreement getAgreementById(@PathVariable("id")String id){
        return agreementService.getAgreementById(id);
    }
}
