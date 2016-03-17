package controller.rest;

import model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.FileHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple rest controller
 */
@RestController
@RequestMapping("rest/users")
public class UserController {

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> allUsers() {
        List u = new ArrayList<User>();
        u.add(new User("test user", "test username", "test password"));
        return u;
    }

}
