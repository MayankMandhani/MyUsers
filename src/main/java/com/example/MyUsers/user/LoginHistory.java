package com.example.MyUsers.user;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "login_history")
public class LoginHistory {
    private @Id @GeneratedValue long id;
    private @NotBlank String email;
    private @NotBlank String time;

    public LoginHistory() {
    }
    public LoginHistory(@NotBlank String email,@NotBlank String time) {
        this.email=email;
        this.time = time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }
}
