package com.pms.pmsfororg.repository;

import com.pms.pmsfororg.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WardRepository extends JpaRepository<Ward, Long> {

    Optional<Ward> findByWardNo(Integer wardNo);

    List<Ward> findByZoneId(Long zoneId);
}
