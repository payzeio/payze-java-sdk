package io.payze.sdk.responses;

import io.payze.sdk.Transaction;
import io.payze.sdk.responses.base.ApiResponse;

public class PayWithCardResponse implements ApiResponse {
    public String transactionId;
    public Transaction transactionInfo;
}
