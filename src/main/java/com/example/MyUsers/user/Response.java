package com.example.MyUsers.user;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private String statusMessage;
    private User user;

    public Response(String statusMessage,User user) {
        this.statusMessage = statusMessage;
        this.user = user;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public User getUser() {
        return user;
    }
}
