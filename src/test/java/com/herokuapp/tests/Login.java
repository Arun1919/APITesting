package com.herokuapp.tests;

import io.restassured.http.Header;
import org.testng.annotations.Test;
import com.herokuapp.flows.LoginFlow;
import com.herokuapp.endpoints.models.requests.LoginCred;

public class Login {

    @Test
    public void makeLogin() {

        LoginFlow loginFlow = new LoginFlow();
        Header header = loginFlow.loginAuth(new LoginCred("A","B"));

    }


}
