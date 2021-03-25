package com.example.MyUsers.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LoginHistoryRepository loginHistoryRepository;
    @PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody User newUser) {
        List<User> users = userRepository.findAll();
        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            System.out.println("Registered user: " + newUser.toString());
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        userRepository.save(newUser);
        return Status.SUCCESS;
    }
    @PostMapping("/users/login")
    public Response loginUser(@Valid @RequestBody LoginCreds user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.getEmail().equals(user.getEmail())&&(other.getPassword().equals(user.getPassword()))) {
                other.setLoggedIn(true);
                userRepository.save(other);
                LoginHistory loginHistory=new LoginHistory(other.getEmail(), DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));
                loginHistoryRepository.save(loginHistory);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                Date date=null;
                try {
                    date=simpleDateFormat.parse(other.getDob());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
                String newDob=dateFormat.format(date);
                other.setDob(newDob);
                Response response=new Response("Successfully logged in.",other);
                return response;
            }
        }
        System.out.println("User not registered or invalid credentials.");

        Response response=new Response("User not registered or invalid credentials.",null);
        return response;
    }

    @PostMapping("/login_history")
    public List<LoginHistory> loginHistories(){
        List<LoginHistory> loginHistories=loginHistoryRepository.findAll();
        Collections.sort(loginHistories,new SortByTime());
        return loginHistories;
    }

    @PostMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        User cur=null;
        for (User other : users) {
            if (other.equals(user)) {
                cur=other;
            }
        }
        if(cur!=null){
            cur.setLoggedIn(false);
            userRepository.save(cur);
            return  Status.SUCCESS;
        }
        return Status.FAILURE;
    }

    class SortByTime implements Comparator<LoginHistory> {
        // Used for sorting in ascending order of
        // roll number
        public int compare(LoginHistory a, LoginHistory b)
        {
            return a.getTime().compareTo(b.getTime());
        }
    }
}
