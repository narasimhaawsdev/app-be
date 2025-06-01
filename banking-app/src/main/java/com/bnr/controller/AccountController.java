package com.bnr.controller;


import com.bnr.model.Account;
import com.bnr.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banking/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(service.createAccount(account));
    }

    @PutMapping("/{accountId}/close")
    public ResponseEntity<?> closeAccount(@PathVariable String accountId) {
        return service.closeAccount(accountId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{accountId}/summary")
    public ResponseEntity<?> getAccountSummary(@PathVariable String accountId) {
        return service.getAccountSummary(accountId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/types")
    public ResponseEntity<List<String>> getAccountTypes() {
        return ResponseEntity.ok(service.getAccountTypes());
    }

    @GetMapping("/{accountId}/fees")
    public ResponseEntity<Double> calculateFees(@PathVariable String accountId) {
        return ResponseEntity.ok(service.calculateAccountFees(accountId));
    }
}
