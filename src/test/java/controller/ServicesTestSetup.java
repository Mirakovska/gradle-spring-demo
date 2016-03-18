package controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import service.UserService;
import webConfig.MVCDispatcher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MVCDispatcher.class)
@WebAppConfiguration
@Configuration
@Ignore
public class ServicesTestSetup {

    @Autowired
    private WebApplicationContext context;

    protected MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Bean
    UserService getUserService() {
        return Mockito.mock(UserService.class);
    }
}
