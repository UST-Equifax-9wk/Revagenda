package com.revature.Revagenda.repositories;

import com.revature.Revagenda.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired //field autowiring is okay for unit tests
    UserRepository sut;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void test() {
        User testUser = new User(1, "test", "user", "testuser");
        sut.save(testUser);
        Assertions.assertEquals(entityManager.find(User.class, testUser.getUserId()), testUser);
    }
}
