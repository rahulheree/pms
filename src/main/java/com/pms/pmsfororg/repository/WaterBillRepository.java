package com.pms.pmsfororg.repository;

import com.pms.pmsfororg.entity.WaterBill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WaterBillRepository extends JpaRepository<WaterBill, Long> {

    Optional<WaterBill> findByBillNumber(String billNumber);

    List<WaterBill> findByCitizenId(Long citizenId);

    List<WaterBill> findByStatus(String status);
}
