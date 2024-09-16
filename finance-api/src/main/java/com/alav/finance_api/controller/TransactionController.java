package com.alav.finance_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alav.finance_api.model.Transaction;
import com.alav.finance_api.model.Transaction.TransactionType;
import com.alav.finance_api.service.TransactionService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public Page<Transaction> getAllTransactionsPaged(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
            return transactionService.getAllTransactionsPaged(page,size);
        }
    

    @GetMapping("/filter")
    public Page<Transaction> getTransactionsByType(
        @RequestParam TransactionType type,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
            return transactionService.getTransactionsByType(type,page,size);
        }

    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@Valid @RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.addTransaction(transaction);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction (@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    

}
