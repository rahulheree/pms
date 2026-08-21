package com.pms.pmsfororg.repository;

import com.pms.pmsfororg.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    List<Complaint> findByCitizenId(Long citizenId);

    List<Complaint> findByWardId(Long wardId);

    List<Complaint> findByStatus(String status);

    List<Complaint> findByCategory(String category);
}