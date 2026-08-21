package com.pms.pmsfororg.mapper;

import com.pms.pmsfororg.dto.ComplaintRequestDTO;
import com.pms.pmsfororg.dto.ComplaintResponseDTO;
import com.pms.pmsfororg.entity.Complaint;

public final class ComplaintMapper {

    private ComplaintMapper() {}

    public static Complaint toEntity(ComplaintRequestDTO dto) {
        Complaint complaint = new Complaint();

        complaint.setSubject(dto.getSubject());
        complaint.setDescription(dto.getDescription());
        complaint.setCategory(dto.getCategory());
        complaint.setStatus(dto.getStatus());

        return complaint;
    }

    public static ComplaintResponseDTO toDTO(Complaint complaint) {
        ComplaintResponseDTO dto = new ComplaintResponseDTO();

        dto.setId(complaint.getId());
        dto.setSubject(complaint.getSubject());
        dto.setDescription(complaint.getDescription());
        dto.setCategory(complaint.getCategory());
        dto.setStatus(complaint.getStatus());
        dto.setCreatedAt(complaint.getCreatedAt());
        dto.setUpdatedAt(complaint.getUpdatedAt());

        if (complaint.getCitizen() != null) {
            dto.setCitizenId(complaint.getCitizen().getId());
            dto.setCitizenName(complaint.getCitizen().getFullName());
        }

        if (complaint.getWard() != null) {
            dto.setWardId(complaint.getWard().getId());
            dto.setWardNo(complaint.getWard().getWardNo());
        }

        return dto;
    }
}
