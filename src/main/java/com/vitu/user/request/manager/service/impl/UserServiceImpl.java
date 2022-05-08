package com.vitu.user.request.manager.service.impl;

import com.vitu.user.request.manager.domain.User;
import com.vitu.user.request.manager.exception.NotFoundException;
import com.vitu.user.request.manager.repository.UserRepository;
import com.vitu.user.request.manager.service.UserService;
import com.vitu.user.request.manager.util.HashUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        log.info("saving user: {}", user);
        user.setPassword(HashUtil.getSecureHash(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User update(User user) throws NoSuchElementException {
        log.info("updating user: {}", user);
        if (Boolean.FALSE.equals(existById(user.getId()))) {
            throw new NoSuchElementException();
        }
        user.setPassword(HashUtil.getSecureHash(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Page<User> findAll(int page, int size) {
        log.info("Finding all users");
        return userRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public User getById(Long id) {
        log.info("Finding user by id: {}", id);
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found for id: " + id));
    }

    @Override
    public Boolean existById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        password = (HashUtil.getSecureHash(password));

        log.info("Finding user by email and password: {}, {}", email, password);
        return userRepository.findByEmailAndPassword(email, password)
                .orElseThrow();
    }
}
