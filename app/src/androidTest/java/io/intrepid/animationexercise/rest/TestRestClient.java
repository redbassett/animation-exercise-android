package io.intrepid.animationexercise.rest;

import io.intrepid.animationexercise.rules.MockServerRule;

public class TestRestClient {
    public static RestApi getRestApi(MockServerRule mockServer) {
        return RetrofitClient.getTestApi(mockServer.getServerUrl());
    }
}
