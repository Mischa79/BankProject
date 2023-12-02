package com.bankapp.app.service.util;


import com.bankapp.app.entity.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction getTransactionById(String id);

    List<Transaction> getAllTransactions();
}
