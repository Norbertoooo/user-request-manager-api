package com.vitu.user.request.manager.repository;

import com.vitu.user.request.manager.domain.Request;
import com.vitu.user.request.manager.domain.RequestState;
import com.vitu.user.request.manager.domain.Role;
import com.vitu.user.request.manager.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static com.vitu.user.request.manager.AbstractTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
class RequestRepositoryTest {

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    UserRepository userRepository;

    @AfterEach
    void setUp() {
        userRepository.deleteAll();
        requestRepository.deleteAll();
    }

    @Test
    void findByUser_Id() {
        User userOne = createUser(NAME, PASSWORD, EMAIL, Role.SIMPLE);
        User userTwo = createUser("userTwo", PASSWORD, "userTwo@gmail.com", Role.SIMPLE);
        Request request = createRequest("description", "subject", userOne, RequestState.OPEN);
        userRepository.saveAll(List.of(userOne, userTwo));
        requestRepository.save(request);

        List<Request> requests = requestRepository.findByUser_Id(1L);

        assertNotNull(requests.get(0).getId());
        assertEquals(1, requests.size());
        assertEquals(request, requests.get(0));
    }

    @Test
    void updateStatus() {
        Request request = createRequest("description", "subject", null, RequestState.OPEN);
        requestRepository.save(request);

        int effectedRows = requestRepository.updateStatus(1L, RequestState.CLOSED.name());

        assertEquals(1, effectedRows);
    }
}