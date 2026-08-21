package com.pms.pmsfororg.mapper;

import com.pms.pmsfororg.dto.ZoneRequestDTO;
import com.pms.pmsfororg.dto.ZoneResponseDTO;
import com.pms.pmsfororg.entity.Zone;

public final class ZoneMapper {

    private ZoneMapper() {}

    public static Zone toEntity(ZoneRequestDTO dto) {
        Zone zone = new Zone();
        zone.setZoneName(dto.getZoneName());
        return zone;
    }

    public static ZoneResponseDTO toDTO(Zone zone) {
        ZoneResponseDTO dto = new ZoneResponseDTO();

        dto.setId(zone.getId());
        dto.setZoneName(zone.getZoneName());

        return dto;
    }
}
