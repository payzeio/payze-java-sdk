package io.payze.sdk.responses;

import io.payze.sdk.Transaction;
import io.payze.sdk.responses.base.ApiResponse;

public class RefundTransactionResponse implements ApiResponse {
    public boolean success;
    public Transaction transaction;
}
