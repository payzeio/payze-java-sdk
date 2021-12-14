package io.payze.sdk.requests;

import io.payze.sdk.abstractions.ApiRequest;

public class GetTransactionInformationRequest implements ApiRequest {
    @Override
    public String getMethod() {
        return "getTransactionInfo";
    }

    public String transactionId;
}
