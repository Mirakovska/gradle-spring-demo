package controller.rest;

import controller.ServicesTestSetup;
import model.User;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import service.UserService;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends ServicesTestSetup{

    @Autowired
    UserService userService;

    @Test
    public void shouldReturnJsonWithAllUsers() throws Exception {
        Mockito.when(userService.getAll()).thenReturn(new ArrayList<User>());
        mockMvc.perform(get("/rest/users/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
