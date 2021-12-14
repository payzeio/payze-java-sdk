package io.payze.sdk.abstractions;

import io.payze.sdk.requests.*;
import io.payze.sdk.responses.*;

import java.io.IOException;

public interface PayzeGateway {
    JustPayResponse justPay(JustPayRequest justPayRequest) throws IOException;

    AddCardResponse addCard(AddCardRequest addCardRequest) throws IOException;

    PayWithCardResponse payWithCard(PayWithCardRequest payWithCardRequest) throws IOException;

    GetTransactionInformationResponse getTransactionInformation(GetTransactionInformationRequest getTransactionInformationRequest) throws IOException;

    RefundTransactionResponse refundTransaction(RefundTransactionRequest refundTransactionRequest) throws IOException;

    CommitTransactionResponse commitTransaction(CommitTransactionRequest commitTransactionRequest) throws IOException;
}
