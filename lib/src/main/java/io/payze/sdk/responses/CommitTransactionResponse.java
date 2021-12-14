package io.payze.sdk.responses;

import io.payze.sdk.responses.base.ApiResponse;

import java.math.BigDecimal;

public class CommitTransactionResponse implements ApiResponse {

    public String transactionId;
    public BigDecimal amount;
}
