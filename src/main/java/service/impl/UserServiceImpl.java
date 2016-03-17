package service.impl;

import model.User;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAll() {
        List usersList = new ArrayList<User>();
        String name = "test user";
        String username = "test username";
        String password = "test password";
        usersList.add(new User(name, username, password));
        usersList.add(new User(name+" 1", username +" 1", password + " 1"));
        return usersList;
    }
}
