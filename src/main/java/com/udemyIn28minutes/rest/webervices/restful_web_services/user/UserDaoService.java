package com.udemyIn28minutes.rest.webervices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    //TODO:
    // JPA/Hibernate > Databese
    // UserDaoService > Static List

    private static int userCounter = 0;

    private static List<User> users = new ArrayList<User>();

    static {
        users.add(new User(++userCounter, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCounter, "Eva", LocalDate.now().minusYears(25)));
        users.add(new User(++userCounter, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> getUsers() {
        return users;
    }

    public User addUser(User user) {
        user.setId(++userCounter);
        users.add(user);
        return user;
    }



    public User getUser(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteUserById(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}

