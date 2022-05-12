package com.vitu.user.request.manager.web;

import com.vitu.user.request.manager.domain.Role;
import com.vitu.user.request.manager.domain.User;
import com.vitu.user.request.manager.service.UserService;
import com.vitu.user.request.manager.web.dto.UserDto;
import com.vitu.user.request.manager.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<User>> getAll(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size) {
        Page<User> users = userService.findAll(page, size);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(UserMapper.toDto(user));
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody @Valid UserDto userDto) {
        log.info("Receive request to create new user: {}", userDto);
        User user = userService.save(UserMapper.toDomain(userDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toDto(user));
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody @Valid UserDto userDto) {
        User user = userService.update(UserMapper.toDomain(userDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toDto(user));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid UserDto userDto) {
        User user = userService.getByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toDto(user));
    }

    @PatchMapping("/{id}/role/{role}")
    public ResponseEntity<UserDto> updateRole(@PathVariable Long id, @PathVariable Role role) {
        User user = userService.updateRole(id, role);
        return ResponseEntity.ok().body(UserMapper.toDto(user));
    }

}
