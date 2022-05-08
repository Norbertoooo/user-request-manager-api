package com.vitu.user.request.manager.service;

import com.vitu.user.request.manager.domain.User;
import org.springframework.data.domain.Page;

import java.util.NoSuchElementException;

public interface UserService {

    User save(User user);

    User update(User user) throws NoSuchElementException;

    Page<User> findAll(int page, int size);

    User getById(Long id);

    Boolean existById(Long id);

    User getByEmailAndPassword(String email, String password);

}
