package com.piloto.todo.basic.auth;

public class AuthenticationBean {

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public AuthenticationBean(String message) {
        this.message = message;
    }

    private String message;
}
