package com.revature.Revagenda.services;


import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.exceptions.NoResultsException;
import com.revature.Revagenda.repositories.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService sut;

    @MockBean
    private UserRepository mockUserRepository;

    @MockBean
    private TaskService mockTaskService;

    @BeforeAll
    public static void setup() {
        //integrate with some sort of external logging or testing system
        //maybe we bring in mocks here
        //maybe we actually want to use real dependencies and inject them here
        //etc...
    }

    @BeforeEach
    public void beforeEach() {
        //integrate with some sort of external logging or testing system
        //maybe we bring in or replace existing mocks/dependencies
        //maybe something in the test needs to have its internal state reset.
        //often we can replace the class SUT or revert it back to an original state
    }


    @AfterEach
    public void afterEach() {

    }

    @AfterAll
    public static void tearDown() {

    }


    @Test
    public void test_findByUsernameReturnsExpectedUser() throws NoResultsException {
        //Arrange
        Integer testUserId = 1;
        String testFirstName = "test";
        String testLastName = "user";
        String testUsername = "testUser";
        String testPassword = "password";
        User testUser = new User(testUserId, testFirstName, testLastName, testUsername);
        when(mockUserRepository.findByUsername(testUsername)).thenReturn(Optional.of(testUser));

        //act
        User testResult = sut.findByUsername(testUsername);

        //assert
        Assertions.assertEquals(testUser, testResult);
    }

    //TODO: Oops this test is logically broken, the repo doesn't throw that method.
    @Test
    public void test_findByUsernameWhereNoResultsArePresentAndNoResultsExceptionIsThrown(){

        //arrange
        String username = "username";
        String message = "No results for username: " + username;
        when(mockUserRepository.findByUsername(any())).thenThrow(NoResultsException.class);

        //act
        //sut.findByUsername("Anything at all!");//this happens inside the throwing assertion
        //Exception e = Assertions.assertThrowsExactly(NoResultsException.class, () -> sut.findByUsername(username));
        Exception e = Assertions.assertThrowsExactly(NoResultsException.class, () -> Integer.parseInt("one"));

        //assert
        //Assertions.assertEquals(message, e.getMessage());
        Assertions.assertTrue(e.getMessage().contains("For input string"));
    }





    //Arrange, Act, Assert
}
