package com.herokuapp.endpoints.models.requests;

import lombok.*;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class LoginCred {

    private String username = "admin";
    private String password = "password123";


}
