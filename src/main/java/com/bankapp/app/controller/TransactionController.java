package com.bankapp.app.controller;

import com.bankapp.app.dto.ProductTestDto;
import com.bankapp.app.dto.TransactionTestDto;
import com.bankapp.app.entity.Transaction;
import com.bankapp.app.mapper.TransactionTestMapper;
import com.bankapp.app.service.impl.TransactionNotFoundException;
import com.bankapp.app.service.util.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionTestMapper transactionTestMapper;

    @GetMapping("/{id}")
    public ResponseEntity<TransactionTestDto> getTransactionById(@PathVariable int id) {
        Transaction transaction = transactionService.getTransactionById(String.valueOf(id));
        if (transaction != null) {
            TransactionTestDto transactionTestDto = transactionTestMapper.toDto(transaction);
            return ResponseEntity.ok(transactionTestDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }
}
