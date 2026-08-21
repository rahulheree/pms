package com.pms.pmsfororg.repository;

import com.pms.pmsfororg.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    Optional<Property> findByPropertyNumber(String propertyNumber);

    List<Property> findByOwnerId(Long citizenId);

    List<Property> findByWardId(Long wardId);
}
