package com.vitu.user.request.manager.web;

import com.vitu.user.request.manager.domain.RequestStage;
import com.vitu.user.request.manager.service.RequestStageService;
import com.vitu.user.request.manager.web.dto.RequestStageDto;
import com.vitu.user.request.manager.web.mapper.RequestStageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/request-stage")
public class RequestStageController {

    private final RequestStageService requestStageService;

    @GetMapping("/{id}")
    public ResponseEntity<RequestStageDto> getById(@PathVariable Long id) {
        RequestStage requestStage = requestStageService.getById(id);
        return ResponseEntity.ok(RequestStageMapper.toDto(requestStage));
    }

    @GetMapping
    public ResponseEntity<List<RequestStageDto>> getAll() {
        List<RequestStage> requestStage = requestStageService.findAll();
        return ResponseEntity.ok(RequestStageMapper.toDto(requestStage));
    }

    @PostMapping
    public ResponseEntity<RequestStageDto> create(@RequestBody RequestStageDto requestDto) {
        RequestStage requestStage = requestStageService.save(RequestStageMapper.toDomain(requestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(RequestStageMapper.toDto(requestStage));
    }

    @GetMapping("/request/{id}")
    public ResponseEntity<List<RequestStageDto>> getByRequestId(@PathVariable Long id) {
        List<RequestStage> requestStages = requestStageService.getByRequestId(id);
        return ResponseEntity.ok(RequestStageMapper.toDto(requestStages));
    }
}
