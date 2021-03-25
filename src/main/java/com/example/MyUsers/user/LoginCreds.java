package com.example.MyUsers.user;

public class LoginCreds {
    String email,password;
    public LoginCreds(String email, String password){
        this.email=email;
        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
