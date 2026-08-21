package com.pms.pmsfororg.mapper;

import com.pms.pmsfororg.dto.PropertyRequestDTO;
import com.pms.pmsfororg.dto.PropertyResponseDTO;
import com.pms.pmsfororg.entity.Property;

public final class PropertyMapper {

    private PropertyMapper() {}

    public static Property toEntity(PropertyRequestDTO dto) {
        Property property = new Property();

        property.setPropertyNumber(dto.getPropertyNumber());
        property.setPropertyType(dto.getPropertyType());
        property.setArea(dto.getArea());
        property.setAddress(dto.getAddress());

        return property;
    }

    public static PropertyResponseDTO toDTO(Property property) {
        PropertyResponseDTO dto = new PropertyResponseDTO();

        dto.setId(property.getId());
        dto.setPropertyNumber(property.getPropertyNumber());
        dto.setPropertyType(property.getPropertyType());
        dto.setArea(property.getArea());
        dto.setAddress(property.getAddress());
        dto.setCreatedAt(property.getCreatedAt());
        dto.setUpdatedAt(property.getUpdatedAt());

        if (property.getOwner() != null) {
            dto.setOwnerId(property.getOwner().getId());
            dto.setOwnerName(property.getOwner().getFullName());
        }

        if (property.getWard() != null) {
            dto.setWardId(property.getWard().getId());
            dto.setWardNo(property.getWard().getWardNo());
        }

        return dto;
    }
}
