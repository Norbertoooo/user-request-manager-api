package com.vitu.user.request.manager.repository;

import com.vitu.user.request.manager.domain.Role;
import com.vitu.user.request.manager.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static com.vitu.user.request.manager.AbstractTest.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void findByEmailAndPassword() {
        User user = createUser(NAME, PASSWORD, EMAIL, Role.SIMPLE);

        testEntityManager.persist(user);

        Optional<User> userOptional = userRepository.findByEmailAndPassword(EMAIL, PASSWORD);

        assertTrue(userOptional.isPresent());
        assertNotNull(userOptional.get().getId());
        assertEquals(user.getName(), userOptional.get().getName());
        assertEquals(user.getEmail(), userOptional.get().getEmail());
        assertEquals(user.getPassword(), userOptional.get().getPassword());
        assertEquals(user.getRole(), userOptional.get().getRole());
    }
}