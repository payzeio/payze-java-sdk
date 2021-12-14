package io.payze.sdk;

import io.payze.sdk.enums.PaymentStatus;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    public String CardMask;

    public BigDecimal Amount;

    public boolean GetCanBeCommitted;

    public String ResultCode;

    public String TransactionId;

    public Date CommitDate;

    public BigDecimal FinalAmount;

    public io.payze.sdk.enums.Currency Currency;

    public BigDecimal Commission;

    public boolean Refundable;

    public BigDecimal Refunded;

    public PaymentStatus Status;

    public Date CreateDate;
}
