package com.example.MyUsers.user;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "users")
public class User {
    private @Id @GeneratedValue long id;
    private @NotBlank String firstName;
    private @NotBlank String email;
    private @NotBlank String lastName;
    private @NotBlank String dob;
    private @NotBlank String place;
    private @NotBlank String password;
    private @NotBlank boolean loggedIn;
    public User() {
    }
    public User(@NotBlank String email,@NotBlank String firstName,@NotBlank String lastName,@NotBlank String dob,@NotBlank String place,
                @NotBlank String password) {
        this.email=email;
        this.firstName = firstName;
        this.lastName=lastName;
        this.dob=dob;
        this.place=place;
        this.password = password;
        this.loggedIn = false;
    }
    public long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, email, password,
                loggedIn);
    }
    @Override
    public String toString() {
        return "User{" +
                ", Name='" + firstName + " " + lastName + '\'' +
                ", DOB='" + dob + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
