package com.pms.pmsfororg.repository;

import com.pms.pmsfororg.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ZoneRepository extends JpaRepository<Zone, Long> {

    Optional<Zone> findByZoneName(String zoneName);
}
