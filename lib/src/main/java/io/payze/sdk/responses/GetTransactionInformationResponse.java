package io.payze.sdk.responses;

import io.payze.sdk.enums.PaymentStatus;
import io.payze.sdk.responses.base.ApiResponse;

import java.math.BigDecimal;
import java.util.Date;

public class GetTransactionInformationResponse implements ApiResponse {

    public BigDecimal amount;
    public String log ;
    public BigDecimal finalAmount ;
    public boolean getCanBeCommitted ;
    public io.payze.sdk.enums.Currency currency ;
    public BigDecimal commission ;
    public boolean refundable ;
    public BigDecimal refunded ;
    public boolean hasSplit ;
    public String transactionId ;
    public PaymentStatus status ;
    public Date createDate ;
}
