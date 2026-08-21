package com.pms.pmsfororg.repository;

import com.pms.pmsfororg.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    Optional<Citizen> findByEmail(String email);

    List<Citizen> findByWardId(Long wardId);

    List<Citizen> findByWardWardNo(Integer wardNo);
}
