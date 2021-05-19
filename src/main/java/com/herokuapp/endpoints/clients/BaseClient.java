package com.herokuapp.endpoints.clients;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseClient {

    protected String baseUri;

    public BaseClient(String baseUri){
        this.baseUri = baseUri;
    }

    protected Response get(String path){

        //Request object
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(String.valueOf(Paths.get(baseUri,path)));

        return response;
    }

    protected <Request> Response post(Request requestBody){
        return post(requestBody, new Header("",""));

    }

    protected <Request> Response post(Request requestBody,Header... headers){
        List<Header> requestHeaders = Arrays.asList(headers);
        ArrayList<Header> arrayList = new ArrayList<>();
        arrayList.addAll(getDefaultHeaders());
        arrayList.addAll(requestHeaders);
        return post(requestBody,new Headers(arrayList));
    }

    protected <Request> Response post(Request requestBody, Headers headers){

        Response response = buildRequestBody(requestBody, headers)
                .post(baseUri);

        return response;
    }

    protected <Request> Response put(String path,Request requestBody){
        return put(path,requestBody, new Header("",""));

    }

    protected <Request> Response put(String path,Request requestBody,Header... headers){
        List<Header> requestHeaders = Arrays.asList(headers);
        ArrayList<Header> arrayList = new ArrayList<>();
        arrayList.addAll(getDefaultHeaders());
        arrayList.addAll(requestHeaders);
        return put(path,requestBody,new Headers(arrayList));
    }

    protected <Request> Response put(String path,Request requestBody, Headers headers){


        RequestSpecification requestSpecification = buildRequestBody(requestBody, headers);
        Response response = requestSpecification
                .put(String.valueOf(Paths.get(baseUri,path)));

        return response;
    }

    private <Request> RequestSpecification buildRequestBody(Request requestBody, Headers headers){

        RequestSpecification requestBodySpecification = RestAssured.given();
        return requestBodySpecification.headers(headers).body(requestBody);
    }


    private List<Header> getDefaultHeaders(){

        return Arrays.asList(new Header(  "Content-Type","application/json"),
                new Header("Accept", "application/json"));

    }

}
