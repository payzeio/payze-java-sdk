package io.payze.sdk;

import com.google.gson.Gson;
import io.payze.sdk.requests.*;
import io.payze.sdk.requests.base.RequestBase;
import io.payze.sdk.responses.*;
import io.payze.sdk.responses.base.ApiResponse;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

public class PayzeGateway implements io.payze.sdk.abstractions.PayzeGateway {

    private final ApiKey apiKey;
    private final Gson gson;

    public PayzeGateway(ApiKey apiKey) {
        this.apiKey = apiKey;
        this.gson = new Gson();
    }

    ApiResponse makePayment(RequestBase requestBase) throws IOException {
        requestBase.apiKey = apiKey.ApiKey;
        requestBase.apiSecret = apiKey.ApiSecret;

        MediaType JSON
                = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://payze.io/api/v1")
                .post(RequestBody.create(gson.toJson(requestBase), JSON))
                .build();

        String response = Objects.requireNonNull(client.newCall(request).execute().body()).string();

        JSONObject json = new JSONObject(response);
        response = json.getJSONObject("response").toString();

        Gson gson = new Gson();

        ApiResponse result;

        if (requestBase.getMethod().equals(RequestType.justPay.name())) {
            result = gson.fromJson(response, JustPayResponse.class);
        }
        else if (requestBase.getMethod().equals(RequestType.addCard.name())) {
            result = gson.fromJson(response, AddCardResponse.class);
        }
        else if (requestBase.getMethod().equals(RequestType.payWithCard.name())) {
            result = gson.fromJson(response, PayWithCardResponse.class);
        }
        else if (requestBase.getMethod().equals(RequestType.commit.name())) {
            result = gson.fromJson(response, CommitTransactionResponse.class);
        }
        else if (requestBase.getMethod().equals(RequestType.getBalance.name())) {
            result = gson.fromJson(response, GetMerchantBalanceResponse.class);
        }
        else if (requestBase.getMethod().equals(RequestType.getTransactionInfo.name())) {
            result = gson.fromJson(response, GetTransactionInformationResponse.class);
        }
        else {
            result = null;
        }

        return result;
    }

    @Override
    public JustPayResponse justPay(JustPayRequest justPayRequest) throws IOException {
        RequestBase requestBase = new RequestBase(RequestType.justPay.name());
        requestBase.data = justPayRequest;
        return (JustPayResponse) makePayment(requestBase);
    }

    @Override
    public AddCardResponse addCard(AddCardRequest addCardRequest) throws IOException {
        RequestBase requestBase = new RequestBase(RequestType.addCard.name());
        requestBase.data = addCardRequest;
        return (AddCardResponse) makePayment(requestBase);
    }

    @Override
    public PayWithCardResponse payWithCard(PayWithCardRequest payWithCardRequest) throws IOException {
        RequestBase requestBase = new RequestBase(RequestType.payWithCard.name());
        requestBase.data = payWithCardRequest;
        return (PayWithCardResponse) makePayment(requestBase);
    }

    @Override
    public GetTransactionInformationResponse getTransactionInformation(GetTransactionInformationRequest getTransactionInformationRequest) throws IOException {
        RequestBase requestBase = new RequestBase(RequestType.getTransactionInfo.name());
        requestBase.data = getTransactionInformationRequest;
        return (GetTransactionInformationResponse) makePayment(requestBase);
    }

    @Override
    public RefundTransactionResponse refundTransaction(RefundTransactionRequest refundTransactionRequest) throws IOException {
        RequestBase requestBase = new RequestBase(RequestType.refund.name());
        requestBase.data = refundTransactionRequest;
        return (RefundTransactionResponse) makePayment(requestBase);
    }

    @Override
    public CommitTransactionResponse commitTransaction(CommitTransactionRequest commitTransactionRequest) throws IOException {
        RequestBase requestBase = new RequestBase(RequestType.commit.name());
        requestBase.data = commitTransactionRequest;
        return (CommitTransactionResponse) makePayment(requestBase);
    }
}
