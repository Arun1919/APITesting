package com.herokuapp.flows;

import com.herokuapp.endpoints.models.requests.LoginCred;
import com.herokuapp.endpoints.models.responses.LoginResponse;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginFlow {

    public Header loginAuth(LoginCred loginCred ){

        RestAssured.baseURI = "https://restful-booker.herokuapp.com/auth";

        RequestSpecification requestSpecification = RestAssured.given();

        Response autResponse = requestSpecification.header("Content-Type", "application/json")
                .body(loginCred)
                .post();

        LoginResponse loginResponse = autResponse.as(LoginResponse.class);
        loginResponse.verifyStatusCode(autResponse.getStatusCode());

        String loginResponseToken = loginResponse.getToken();

       return new Header("Cookie",String.format("token=%s",loginResponseToken));

    }
}
