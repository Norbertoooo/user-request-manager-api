package com.vitu.user.request.manager.repository;

import com.vitu.user.request.manager.domain.RequestStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestStageRepository extends JpaRepository<RequestStage, Long> {
    List<RequestStage> findByRequest_Id(Long id);
}