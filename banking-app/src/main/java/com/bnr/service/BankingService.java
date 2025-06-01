package com.bnr.service;


import com.bnr.model.Account;
import com.bnr.model.Customer;
import com.bnr.model.Transaction;
import com.bnr.repository.MockDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankingService {

    @Autowired
    private MockDataRepository repo;

    public double getTotalBankBalance() {
        return repo.getAccounts().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

    public List<Customer> getTopCustomers(int limit) {
        return repo.getAccounts().stream()
                .collect(Collectors.groupingBy(Account::getCustomerId,
                        Collectors.summingDouble(Account::getBalance)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(limit)
                .map(entry -> repo.findCustomerById(entry.getKey()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public Map<String, Long> getCustomersPerCity() {
        return repo.getCustomers().stream()
                .collect(Collectors.groupingBy(Customer::getCity, Collectors.counting()));
    }

    public List<Transaction> getSuspiciousTransactions(double threshold) {
        return repo.getTransactions().stream()
                .filter(txn -> txn.getAmount() > threshold)
                .collect(Collectors.toList());
    }

    public List<Account> getAccountsByCustomer(String customerId) {
        return repo.getAccountsByCustomerId(customerId);
    }

    public List<Transaction> getTransactionsByAccount(String accountId) {
        return repo.getTransactionsByAccountId(accountId);
    }

    public Optional<Customer> getCustomerById(String id) {
        return repo.findCustomerById(id);
    }
}