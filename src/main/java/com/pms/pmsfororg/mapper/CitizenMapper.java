package com.pms.pmsfororg.mapper;

import com.pms.pmsfororg.dto.CitizenRequestDTO;
import com.pms.pmsfororg.dto.CitizenResponseDTO;
import com.pms.pmsfororg.entity.Citizen;

public class CitizenMapper {

    public static Citizen toEntity(CitizenRequestDTO dto) {

        Citizen citizen = new Citizen();

        citizen.setFullName(dto.getFullName());
        citizen.setEmail(dto.getEmail());
        citizen.setPhone(dto.getPhone());
        citizen.setGender(dto.getGender());
        citizen.setDateOfBirth(dto.getDateOfBirth());
        citizen.setAddress(dto.getAddress());
        citizen.setWardNo(dto.getWardNo());
        citizen.setZone(dto.getZone());

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
        dto.setWardNo(citizen.getWardNo());
        dto.setZone(citizen.getZone());
        dto.setCreatedAt(citizen.getCreatedAt());

        return dto;
    }
}