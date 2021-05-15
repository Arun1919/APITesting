package restfulBroker.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;


@Getter @Setter @Builder
public class LoginResponse {

    private String token;


    public void verifyStatusCode(int statusCode){

        Assert.assertEquals(statusCode,200);
    }

    public void getAuthToken(String token){

        System.out.println(token);
    }

}
