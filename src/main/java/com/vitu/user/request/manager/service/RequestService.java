package com.vitu.user.request.manager.service;

import com.vitu.user.request.manager.domain.Request;
import com.vitu.user.request.manager.domain.RequestState;

import java.util.List;

public interface RequestService {

    Request save(Request request);

    Request update(Request request);

    void updateState(Long id, RequestState requestState);

    List<Request> findAll();

    Request getById(Long id);

    List<Request> getByUserId(Long id);
}
