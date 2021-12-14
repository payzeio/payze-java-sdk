///*
// * This Java source file was generated by the Gradle 'init' task.
// */
//package io.payze.sdk;
//
//import io.payze.sdk.enums.Currency;
//import io.payze.sdk.requests.*;
//import io.payze.sdk.responses.*;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//
//import static org.junit.Assert.assertNotNull;
//
//public class LibraryTest {
//    // Create a EnvironmentVariables.java class with static properties to test
//    String apiKeyString = EnvironmentVariables.apiKey;
//    String apiSecretString = EnvironmentVariables.apiSecret;
//
//    String cardToken;
//    String splitIban1 = EnvironmentVariables.splitIban1;
//    String splitIban2 = EnvironmentVariables.splitIban2;
//
//    String transactionId = "";
//
//    ApiKey apiKey = new ApiKey(apiKeyString, apiSecretString);
//    PayzeGateway payment = new PayzeGateway(apiKey);
//
//    @Test public void testJustPay() throws IOException {
//        JustPayRequest justPayRequest = new JustPayRequest();
//        justPayRequest.amount = new BigDecimal("1");
//        justPayRequest.currency = Currency.GEL;
//
//        JustPayResponse response = payment.justPay(justPayRequest);
//
//        assertNotNull(response.transactionId);
//        assertNotNull(response.transactionUrl);
//    }
//
//    @Test public void testJustPayAndSplit() throws IOException {
//        JustPayRequest justPayRequest = new JustPayRequest();
//        Split split1 = new Split();
//        Split split2 = new Split();
//
//        split1.amount = new BigDecimal("1");
//        split1.iban = splitIban1;
//
//        split2.amount = new BigDecimal("1");
//        split2.iban = splitIban2;
//
//        justPayRequest.amount = new BigDecimal("2");
//        justPayRequest.currency = Currency.GEL;
//        justPayRequest.splits = new ArrayList<>();
//        justPayRequest.splits.add(split1);
//        justPayRequest.splits.add(split2);
//
//        JustPayResponse response = payment.justPay(justPayRequest);
//
//        assertNotNull(response.transactionId);
//        assertNotNull(response.transactionUrl);
//    }
//
//
//    @Test public void testAddCard() throws IOException {
//        AddCardRequest addCardRequest = new AddCardRequest();
//        addCardRequest.callbackUrl = "https://example.com";
//        addCardRequest.callbackErrorUrl = "https://example.com?error=true";
//
//        AddCardResponse response = payment.addCard(addCardRequest);
//
//        assertNotNull(response.cardId);
//        assertNotNull(response.transactionId);
//        assertNotNull(response.transactionUrl);
//
//        this.cardToken = response.cardId;
//    }
//
//    @Test public void testPayWithCard() throws IOException {
//        PayWithCardRequest payWithCard = new PayWithCardRequest();
//        payWithCard.currency = Currency.GEL;
//        payWithCard.cardToken = "mock_card_token";
//
//        PayWithCardResponse response = payment.payWithCard(payWithCard);
//
//        assertNotNull(response.transactionId);
//        assertNotNull(response.transactionInfo);
//    }
//
//    @Test public void testPayWithCardAndSplit() throws IOException {
//        PayWithCardRequest addCardRequest = new PayWithCardRequest();
//        addCardRequest.cardToken = cardToken;
//        addCardRequest.amount = new BigDecimal("3");
//        addCardRequest.currency = Currency.GEL;
//
//        Split split1 = new Split();
//        Split split2 = new Split();
//
//        split1.amount = new BigDecimal("1");
//        split1.iban = splitIban1;
//
//        split2.amount = new BigDecimal("1");
//        split2.iban = splitIban2;
//
//        PayWithCardResponse response = payment.payWithCard(addCardRequest);
//
//        assertNotNull(response.transactionId);
//        assertNotNull(response.transactionInfo);
//    }
//
//    @Test public void testGetTransactionInformation() throws IOException {
//        GetTransactionInformationRequest getTransactionInformationRequest = new GetTransactionInformationRequest();
//        getTransactionInformationRequest.transactionId = transactionId;
//
//        GetTransactionInformationResponse response = payment.getTransactionInformation(getTransactionInformationRequest);
//
//        assertNotNull(response.transactionId);
//        assertNotNull(response.currency);
//        assertNotNull(response.amount);
//        assertNotNull(response.commission);
//        assertNotNull(response.finalAmount);
//        assertNotNull(response.createDate);
//    }
//
//    @Test public void testRefundTransaction() throws IOException {
//        RefundTransactionRequest refundTransactionRequest = new RefundTransactionRequest();
//        refundTransactionRequest.transactionId = transactionId;
//        refundTransactionRequest.amount = new BigDecimal("1");
//
//        RefundTransactionResponse response = payment.refundTransaction(refundTransactionRequest);
//
//        assertNotNull(response.transaction);
//    }
//
//    @Test public void testCommitTransaction() throws IOException {
//        CommitTransactionRequest commitTransactionRequest = new CommitTransactionRequest();
//
//        commitTransactionRequest.transactionId = transactionId;
//        commitTransactionRequest.amount = new BigDecimal("1");
//
//        CommitTransactionResponse response = payment.commitTransaction(commitTransactionRequest);
//
//        assertNotNull(response.transactionId);
//        assertNotNull(response.amount);
//    }
//}