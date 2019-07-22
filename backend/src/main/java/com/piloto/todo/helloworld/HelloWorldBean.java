package com.piloto.todo.helloworld;

public class HelloWorldBean {

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public HelloWorldBean(String message) {
        this.message = message;
    }

    private String message;
}
