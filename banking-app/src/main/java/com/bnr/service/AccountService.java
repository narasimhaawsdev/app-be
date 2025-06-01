package com.bnr.service;


import com.bnr.model.Account;
import com.bnr.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repo;

    public Account createAccount(Account account) {
        repo.addAccount(account);
        return account;
    }

    public Optional<Account> closeAccount(String accountId) {
        Optional<Account> accountOpt = repo.findAccountById(accountId);
        accountOpt.ifPresent(acc -> acc.setClosed(true));
        return accountOpt;
    }

    public Optional<Account> getAccountSummary(String accountId) {
        return repo.findAccountById(accountId);
    }

    public List<String> getAccountTypes() {
        return Arrays.asList("SAVINGS", "CURRENT", "LOAN");
    }

    public double calculateAccountFees(String accountId) {
        Optional<Account> acc = repo.findAccountById(accountId);
        return acc.map(a -> {
            switch (a.getType()) {
                case "SAVINGS": return 100.0;
                case "CURRENT": return 250.0;
                case "LOAN": return 500.0;
                default: return 0.0;
            }
        }).orElse(0.0);
    }
}