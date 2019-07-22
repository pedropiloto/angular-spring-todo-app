package com.piloto.todo.helloworld;

import com.piloto.todo.helloworld.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class HelloWorldController {

    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

}
