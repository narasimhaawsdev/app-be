package com.bnr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Transaction {

    private String id;
    private String accountId;
    private double amount;
    private LocalDateTime date;
}
