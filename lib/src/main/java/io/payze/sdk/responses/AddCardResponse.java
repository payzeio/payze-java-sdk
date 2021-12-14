package io.payze.sdk.responses;

import io.payze.sdk.responses.base.ApiResponse;

public class AddCardResponse implements ApiResponse {
    public String cardId;
    public String transactionUrl;
    public String transactionId;
}
