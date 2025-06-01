package com.bnr.repository;


import com.bnr.model.Account;
import com.bnr.model.Customer;
import com.bnr.model.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MockDataRepository {

    private final List<Account> accounts = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();
    private final List<Transaction> transactions = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Add mock customers
        customers.add(new Customer("C001", "Alice", "Mumbai", true));
        customers.add(new Customer("C002", "Bob", "Delhi", true));
        customers.add(new Customer("C003", "Charlie", "Mumbai", false));


        accounts.add(new Account("A001", "C001", 150000.0, "SAVINGS", true));
        accounts.add(new Account("A002", "C002", 200000.0, "CURRENT", true));
        accounts.add(new Account("A003", "C001", 30000.0, "LOAN", true));


        // Add mock transactions
        transactions.add(new Transaction("T001", "A001", 120000.0, LocalDateTime.now().minusDays(2)));
        transactions.add(new Transaction("T002", "A002", 50000.0, LocalDateTime.now().minusDays(1)));
        transactions.add(new Transaction("T003", "A003", 200000.0, LocalDateTime.now()));
    }

    public List<Account> getAccounts() { return accounts; }
    public List<Customer> getCustomers() { return customers; }
    public List<Transaction> getTransactions() { return transactions; }

    public Optional<Customer> findCustomerById(String id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public List<Account> getAccountsByCustomerId(String customerId) {
        return accounts.stream().filter(a -> a.getCustomerId().equals(customerId)).collect(Collectors.toList());
    }

    public List<Transaction> getTransactionsByAccountId(String accountId) {
        return transactions.stream().filter(t -> t.getAccountId().equals(accountId)).collect(Collectors.toList());
    }
}