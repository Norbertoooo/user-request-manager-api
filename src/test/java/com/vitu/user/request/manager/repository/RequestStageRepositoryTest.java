package com.vitu.user.request.manager.repository;

import com.vitu.user.request.manager.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static com.vitu.user.request.manager.AbstractTest.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DataJpaTest
@ActiveProfiles("test")
class RequestStageRepositoryTest {

    @Autowired
    RequestStageRepository requestStageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RequestRepository requestRepository;

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
        requestRepository.deleteAll();
        requestStageRepository.deleteAll();
    }

    @Test
    void findByRequest_Id() {
        User user = createUser(NAME, PASSWORD, EMAIL, Role.SIMPLE);
        Request request = createRequest("description", "subject", user, RequestState.OPEN);
        RequestStage requestStage = createRequestStage("description", user, RequestState.OPEN, request);
        userRepository.save(user);
        Request save = requestRepository.save(request);
        log.info("{}", save);
        requestStageRepository.save(requestStage);

        List<RequestStage> requestStages = requestStageRepository.findByRequest_Id(3L);

        assertEquals(1, requestStages.size());

    }
}