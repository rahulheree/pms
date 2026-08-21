package com.pms.pmsfororg.repository;

import com.pms.pmsfororg.entity.PropertyTax;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PropertyTaxRepository extends JpaRepository<PropertyTax, Long> {

    Optional<PropertyTax> findByTaxNumber(String taxNumber);

    List<PropertyTax> findByCitizenId(Long citizenId);

    List<PropertyTax> findByPropertyId(Long propertyId);

    List<PropertyTax> findByStatus(String status);

    List<PropertyTax> findByTaxYear(Integer taxYear);
}
