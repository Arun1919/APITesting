package restfulBroker.requests;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.*;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class LoginCred {

    private String username = "admin";
    private String password = "password123";


}
