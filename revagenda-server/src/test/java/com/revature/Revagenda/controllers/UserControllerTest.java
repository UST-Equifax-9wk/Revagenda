package com.revature.Revagenda.controllers;

import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void test() throws Exception {
        //arrange
        Integer userId = 1;
        User testUser = new User(userId, "test", "user", "testuser");
        when(userService.findByUserId(userId)).thenReturn(testUser);

        //act & assert
        this.mockMvc.perform(get("/users/" + userId)).andDo(print()).andExpect(status().isOk());

    }
}
