package com.vitu.user.request.manager;

import com.vitu.user.request.manager.domain.*;

import java.time.LocalDateTime;

public abstract class AbstractTest {

    public static final String NAME = "vitor";
    public static final String PASSWORD = "password";

    public static final String EMAIL = "vitor@gmail.com";

    public static User createUser(String name, String password, String email, Role role) {
        return User.builder()
                .name(name)
                .password(password)
                .email(email)
                .role(role)
                .build();

    }

    public static Request createRequest(String description, String subject, User user, RequestState requestState) {
        return Request.builder()
                .description(description)
                .user(user)
                .subject(subject)
                .state(requestState)
                .creationDate(LocalDateTime.of(2022, 1, 1, 12, 12))
                .build();

    }

    public static RequestStage createRequestStage(String description, User user, RequestState requestState,
                                                  Request request) {
        return RequestStage.builder()
                .realizationDate(LocalDateTime.of(2022, 1, 1, 12, 12))
                .request(request)
                .description(description)
                .user(user)
                .state(requestState)
                .build();

    }
}
