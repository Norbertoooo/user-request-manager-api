package com.vitu.user.request.manager.repository;

import com.vitu.user.request.manager.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findByUser_Id(Long id);

    @Modifying
    @Transactional
    @Query(value = "update request set state = ?2 where id = ?1", nativeQuery = true)
    int updateStatus(Long id, String state);
}