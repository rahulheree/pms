package com.pms.pmsfororg.mapper;

import com.pms.pmsfororg.dto.WardRequestDTO;
import com.pms.pmsfororg.dto.WardResponseDTO;
import com.pms.pmsfororg.entity.Ward;

public final class WardMapper {

    private WardMapper() {}

    public static Ward toEntity(WardRequestDTO dto) {
        Ward ward = new Ward();

        ward.setWardNo(dto.getWardNo());
        ward.setWardName(dto.getWardName());
        ward.setCouncillorName(dto.getCouncillorName());

        return ward;
    }

    public static WardResponseDTO toDTO(Ward ward) {
        WardResponseDTO dto = new WardResponseDTO();

        dto.setId(ward.getId());
        dto.setWardNo(ward.getWardNo());
        dto.setWardName(ward.getWardName());
        dto.setCouncillorName(ward.getCouncillorName());

        if (ward.getZone() != null) {
            dto.setZoneId(ward.getZone().getId());
            dto.setZoneName(ward.getZone().getZoneName());
        }

        return dto;
    }
}
