package restfulBroker.endPoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import restfulBroker.ScenarioContext;
import restfulBroker.requests.LoginCred;
import restfulBroker.responses.LoginResponse;
import restfulBroker.utils.Context;

public class Login extends ScenarioContext {

    @Test
    public void makeLogin() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com/auth";

        RequestSpecification requestSpecification = RestAssured.given();

        LoginCred loginCred = new LoginCred();

        Response autResponse = requestSpecification.header("Content-Type", "application/json")
                .body(loginCred)
                .post();

        LoginResponse loginResponse = autResponse.as(LoginResponse.class);
        loginResponse.verifyStatusCode(autResponse.getStatusCode());

        String loginResponseToken = loginResponse.getToken();
        setContext(Context.TOKEN, loginResponseToken);

        Object context = getContext(Context.TOKEN);
        System.out.print(context);

    }


}
