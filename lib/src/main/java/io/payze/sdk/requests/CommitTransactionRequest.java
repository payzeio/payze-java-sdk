package io.payze.sdk.requests;

import io.payze.sdk.RequestType;
import io.payze.sdk.abstractions.ApiRequest;

import java.math.BigDecimal;

public class CommitTransactionRequest implements ApiRequest {
    @Override
    public String getMethod() {
        return RequestType.commit.toString();
    }

    public String transactionId;
    public BigDecimal amount;
}
