package io.payze.sdk.requests;

import io.payze.sdk.Split;
import io.payze.sdk.abstractions.ApiRequest;
import io.payze.sdk.enums.Currency;

import java.math.BigDecimal;
import java.util.List;

public class PayWithCardRequest implements ApiRequest {
    @Override
    public String getMethod() {
        return "payWithCard";
    }

    public BigDecimal amount;
    public Currency currency;
    public String cardToken;
    public boolean preauthorize;
    public List<Split> splits;
}
