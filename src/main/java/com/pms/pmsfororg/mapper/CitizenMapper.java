package com.pms.pmsfororg.mapper;

import com.pms.pmsfororg.dto.CitizenRequestDTO;
import com.pms.pmsfororg.dto.CitizenResponseDTO;
import com.pms.pmsfororg.entity.Citizen;

public final class CitizenMapper {

    private CitizenMapper() {}

    public static Citizen toEntity(CitizenRequestDTO dto) {
        Citizen citizen = new Citizen();

        citizen.setFullName(dto.getFullName());
        citizen.setEmail(dto.getEmail());
        citizen.setPhone(dto.getPhone());
        citizen.setGender(dto.getGender());
        citizen.setDateOfBirth(dto.getDateOfBirth());
        citizen.setAddress(dto.getAddress());

        return citizen;
    }

    public static CitizenResponseDTO toDTO(Citizen citizen) {
        CitizenResponseDTO dto = new CitizenResponseDTO();

        dto.setId(citizen.getId());
        dto.setFullName(citizen.getFullName());
        dto.setEmail(citizen.getEmail());
        dto.setPhone(citizen.getPhone());
        dto.setGender(citizen.getGender());
        dto.setDateOfBirth(citizen.getDateOfBirth());
        dto.setAddress(citizen.getAddress());
        dto.setCreatedAt(citizen.getCreatedAt());
        dto.setUpdatedAt(citizen.getUpdatedAt());

        if (citizen.getWard() != null) {
            dto.setWardId(citizen.getWard().getId());
            dto.setWardNo(citizen.getWard().getWardNo());
            dto.setWardName(citizen.getWard().getWardName());
        }

        return dto;
    }
}