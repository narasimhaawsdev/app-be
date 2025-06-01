package com.bnr.controller;


import com.bnr.model.Account;
import com.bnr.model.Customer;
import com.bnr.model.Transaction;
import com.bnr.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/banking")
public class BankingController {

    @Autowired
    private BankingService service;

    @GetMapping("/total-balance")
    public ResponseEntity<Double> totalBalance() {
        return ResponseEntity.ok(service.getTotalBankBalance());
    }

    @GetMapping("/top-customers")
    public ResponseEntity<List<Customer>> topCustomers(
            @RequestParam(defaultValue = "3") int limit) {
        return ResponseEntity.ok(service.getTopCustomers(limit));
    }

    @GetMapping("/customers-per-city")
    public ResponseEntity<Map<String, Long>> customersPerCity() {
        return ResponseEntity.ok(service.getCustomersPerCity());
    }

    @GetMapping("/suspicious-transactions")
    public ResponseEntity<List<Transaction>> suspiciousTxns(
            @RequestParam(defaultValue = "100000") double threshold) {
        return ResponseEntity.ok(service.getSuspiciousTransactions(threshold));
    }

    @GetMapping("/customers/{customerId}/accounts")
    public ResponseEntity<List<Account>> getAccountsByCustomer(@PathVariable String customerId) {
        return ResponseEntity.ok(service.getAccountsByCustomer(customerId));
    }

    @GetMapping("/accounts/{accountId}/transactions")
    public ResponseEntity<List<Transaction>> getTransactionsByAccount(@PathVariable String accountId) {
        return ResponseEntity.ok(service.getTransactionsByAccount(accountId));
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable String customerId) {
        return service.getCustomerById(customerId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

