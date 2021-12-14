package io.payze.sdk.responses;

import io.payze.sdk.responses.base.ApiResponse;

import java.math.BigDecimal;

public class GetMerchantBalanceResponse implements ApiResponse {
    public BigDecimal availableForCashOutUsd;
    public BigDecimal amountProcessedUsd;
    public BigDecimal amountProcessed;
    public BigDecimal availableForCashOut;
}
