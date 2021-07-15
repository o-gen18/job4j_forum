package ru.job4j.forum;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.data.repository.util.ClassUtils.hasProperty;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControlTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void whenLoginShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void whenLoginFailReturnDefaultMessageAndErrorMessageIsWarning() throws Exception {
        this.mockMvc.perform(get("/login")
        .param("error", "true"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute(
                        "errorMessage", Matchers.equalTo("Username or password is incorrect!")))
                .andExpect(view().name("login"));
    }

    @Test
    @WithMockUser
    public void whenLogoutReturnDefaultMessageAndErrorMessageIsLogoutSuccess() throws Exception {
        this.mockMvc.perform(get("/login")
                .param("logout", "true"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute(
                        "errorMessage", Matchers.equalTo("You have been successfully logged out!")))
                .andExpect(view().name("login"));
    }
}
