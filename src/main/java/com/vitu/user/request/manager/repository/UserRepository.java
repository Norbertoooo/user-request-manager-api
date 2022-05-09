package com.vitu.user.request.manager.repository;

import com.vitu.user.request.manager.domain.Role;
import com.vitu.user.request.manager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndPassword(String email, String password);

    @Modifying
    @Transactional
    @Query(value = "update users set perfil = ?2 where id = ?1", nativeQuery = true)
    int updateRole(Long id, Role role);

}