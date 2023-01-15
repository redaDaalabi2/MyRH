package com.myrh.utils;

public interface Enum {
    enum role {COMPANY, AGENT}
    enum status {Pending, Accepted, Rejected}
    enum transactionType {Transfer, Withdrawal, Deposit, OnlinePayment, BillPayment}
    enum accType {Standard, Professional}
    enum bills {Phone, Water, Electricity}
    enum dotationType {National, International}
}
