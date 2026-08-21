package com.pms.pmsfororg.mapper;

import com.pms.pmsfororg.dto.PropertyTaxRequestDTO;
import com.pms.pmsfororg.dto.PropertyTaxResponseDTO;
import com.pms.pmsfororg.entity.PropertyTax;

public final class PropertyTaxMapper {

    private PropertyTaxMapper() {}

    public static PropertyTax toEntity(PropertyTaxRequestDTO dto) {
        PropertyTax tax = new PropertyTax();

        tax.setTaxNumber(dto.getTaxNumber());
        tax.setAmount(dto.getAmount());
        tax.setTaxYear(dto.getTaxYear());
        tax.setDueDate(dto.getDueDate());
        tax.setStatus(dto.getStatus());

        return tax;
    }

    public static PropertyTaxResponseDTO toDTO(PropertyTax tax) {
        PropertyTaxResponseDTO dto = new PropertyTaxResponseDTO();

        dto.setId(tax.getId());
        dto.setTaxNumber(tax.getTaxNumber());
        dto.setAmount(tax.getAmount());
        dto.setTaxYear(tax.getTaxYear());
        dto.setDueDate(tax.getDueDate());
        dto.setStatus(tax.getStatus());
        dto.setCreatedAt(tax.getCreatedAt());
        dto.setUpdatedAt(tax.getUpdatedAt());

        if (tax.getCitizen() != null) {
            dto.setCitizenId(tax.getCitizen().getId());
            dto.setCitizenName(tax.getCitizen().getFullName());
        }

        if (tax.getProperty() != null) {
            dto.setPropertyId(tax.getProperty().getId());
            dto.setPropertyNumber(tax.getProperty().getPropertyNumber());
        }

        return dto;
    }
}
