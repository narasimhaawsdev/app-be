package com.bnr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String id;
    private String customerId;
    private double balance;
    private String type; // SAVINGS, CURRENT, LOAN
    private boolean closed;
}