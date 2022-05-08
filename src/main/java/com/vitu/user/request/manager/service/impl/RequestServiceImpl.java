package com.vitu.user.request.manager.service.impl;

import com.vitu.user.request.manager.domain.Request;
import com.vitu.user.request.manager.domain.RequestState;
import com.vitu.user.request.manager.exception.NotFoundException;
import com.vitu.user.request.manager.repository.RequestRepository;
import com.vitu.user.request.manager.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;

    @Override
    public Request save(Request request) {
        request.setCreationDate(LocalDateTime.now());
        request.setState(RequestState.OPEN);
        return requestRepository.save(request);
    }

    @Override
    public Request update(Request request) {
        log.info("Updating request: {}", request);

        return requestRepository.save(request);
    }

    @Override
    public void updateState(Long id, RequestState requestState) {
        requestRepository.updateStatus(id, requestState.name());
    }

    @Override
    public List<Request> findAll() {
        log.info("Finding all request");
        return requestRepository.findAll();
    }

    @Override
    public Request getById(Long id) {
        log.info("Finding request for id: {}", id);
        return requestRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Request not found for id: " + id));
    }

    @Override
    public List<Request> getByUserId(Long id) {
        log.info("Finding all request for user id: {}", id);
        return requestRepository.findByUser_Id(id);
    }
}
