package io.payze.sdk.requests;

import io.payze.sdk.abstractions.ApiRequest;

import java.math.BigDecimal;

public class RefundTransactionRequest implements ApiRequest {
    @Override
    public String getMethod() {
        return "refund";
    }

    public String transactionId;
    public BigDecimal amount;
}
