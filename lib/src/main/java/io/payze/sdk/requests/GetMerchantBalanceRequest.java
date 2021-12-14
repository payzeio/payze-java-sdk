package io.payze.sdk.requests;

import io.payze.sdk.abstractions.ApiRequest;

public class GetMerchantBalanceRequest implements ApiRequest {
    @Override
    public String getMethod() {
        return "getBalance";
    }


}
