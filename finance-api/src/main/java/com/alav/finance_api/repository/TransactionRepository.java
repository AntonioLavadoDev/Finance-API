package com.alav.finance_api.repository;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alav.finance_api.model.Transaction;
import com.alav.finance_api.model.Transaction.TransactionType;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findByType(TransactionType type, Pageable pageable);

    
} 
