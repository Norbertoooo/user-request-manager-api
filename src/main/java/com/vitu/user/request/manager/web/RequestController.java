package com.vitu.user.request.manager.web;

import com.vitu.user.request.manager.domain.Request;
import com.vitu.user.request.manager.service.RequestService;
import com.vitu.user.request.manager.web.dto.RequestDto;
import com.vitu.user.request.manager.web.mapper.RequestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/request")
public class RequestController {

    private final RequestService requestService;

    @GetMapping
    public ResponseEntity<List<RequestDto>> getAll() {
        List<Request> requests = requestService.findAll();
        return ResponseEntity.ok(RequestMapper.toDto(requests));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestDto> getById(@PathVariable Long id) {
        Request request = requestService.getById(id);
        return ResponseEntity.ok(RequestMapper.toDto(request));
    }

    @PostMapping
    public ResponseEntity<RequestDto> create(@RequestBody RequestDto requestDto) {
        Request request = requestService.save(RequestMapper.toDomain(requestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(RequestMapper.toDto(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequestDto> update(@PathVariable Long id, @RequestBody RequestDto requestDto) {
        Request request = requestService.update(RequestMapper.toDomain(requestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(RequestMapper.toDto(request));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<RequestDto>> getByUserId(@PathVariable Long id) {
        List<Request> requests = requestService.getByUserId(id);
        return ResponseEntity.ok(RequestMapper.toDto(requests));
    }


}
