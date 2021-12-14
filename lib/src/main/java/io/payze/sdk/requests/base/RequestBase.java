package io.payze.sdk.requests.base;

import io.payze.sdk.abstractions.ApiRequest;

public class RequestBase {

    public RequestBase(String method) {
        this.method = method;
    }

    private final String method;

    public String apiKey;
    public String apiSecret;
    public ApiRequest data;
    public String getMethod()
    {
        return this.method;
    }
}
