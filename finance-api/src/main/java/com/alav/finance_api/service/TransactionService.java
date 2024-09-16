package com.alav.finance_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.alav.finance_api.model.Transaction;
import com.alav.finance_api.model.Transaction.TransactionType;
import com.alav.finance_api.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Page<Transaction> getAllTransactionsPaged(int page, int size) {
        return transactionRepository.findAll(PageRequest.of(page,size));
    }

    public Page<Transaction> getTransactionsByType (TransactionType type, int page, int size) {
        return transactionRepository.findByType(type, PageRequest.of(page, size));
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

}
