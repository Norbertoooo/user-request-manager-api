package com.vitu.user.request.manager.repository;

import com.vitu.user.request.manager.domain.Request;
import com.vitu.user.request.manager.domain.RequestState;
import com.vitu.user.request.manager.domain.Role;
import com.vitu.user.request.manager.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static com.vitu.user.request.manager.AbstractTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(1)
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
    @Order(2)
    void updateStatus() {
        User userOne = createUser(NAME, PASSWORD, EMAIL, Role.SIMPLE);
        User save = userRepository.save(userOne);
        Request request = createRequest("description", "subject", save, RequestState.OPEN);
        Request savedRequest = requestRepository.save(request);
        log.info("{}", savedRequest);

        int effectedRows = requestRepository.updateStatus(2L, RequestState.CLOSED.name());

        assertEquals(1, effectedRows);
    }
}