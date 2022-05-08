package com.vitu.user.request.manager.service;

import com.vitu.user.request.manager.domain.RequestStage;

import java.util.List;

public interface RequestStageService {

    RequestStage save(RequestStage requestStage);

    RequestStage update(RequestStage requestStage);

    List<RequestStage> findAll();

    RequestStage getById(Long id);

    List<RequestStage> getByRequestId(Long id);
}
