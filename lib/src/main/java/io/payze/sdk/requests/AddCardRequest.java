package io.payze.sdk.requests;
import io.payze.sdk.abstractions.ApiRequest;

public class AddCardRequest implements ApiRequest {
    public String getMethod() {
        return "addCard";
    }

    public String callbackUrl;
    public String callbackErrorUrl;
}
