package com.vitu.user.request.manager.service.impl;

import com.vitu.user.request.manager.domain.RequestStage;
import com.vitu.user.request.manager.exception.NotFoundException;
import com.vitu.user.request.manager.repository.RequestStageRepository;
import com.vitu.user.request.manager.service.RequestService;
import com.vitu.user.request.manager.service.RequestStageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequestStageServiceImpl implements RequestStageService {

    private final RequestStageRepository requestStageRepository;
    private final RequestService requestService;

    @Override
    public RequestStage save(RequestStage requestStage) {
        requestStage.setRealizationDate(LocalDateTime.now());
        RequestStage createdRequestStage = requestStageRepository.save(requestStage);
        requestService.updateState(createdRequestStage.getRequest().getId(), createdRequestStage.getState());
        return createdRequestStage;
    }

    @Override
    public RequestStage update(RequestStage requestStage) {
        return null;
    }

    @Override
    public List<RequestStage> findAll() {
        return requestStageRepository.findAll();
    }

    @Override
    public RequestStage getById(Long id) {
        return requestStageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Request stage not found for id: " + id));
    }

    @Override
    public List<RequestStage> getByRequestId(Long id) {
        return requestStageRepository.findByRequest_Id(id);
    }
}
