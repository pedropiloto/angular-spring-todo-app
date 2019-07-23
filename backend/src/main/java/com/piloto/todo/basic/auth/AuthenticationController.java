package com.piloto.todo.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class AuthenticationController {

    @GetMapping(path="/basicauth")
    public AuthenticationBean authenticationBean(){
        return new AuthenticationBean("Authenticated");
    }

}
