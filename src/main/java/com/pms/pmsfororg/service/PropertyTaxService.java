package com.pms.pmsfororg.service;

import com.pms.pmsfororg.dto.PropertyTaxRequestDTO;
import com.pms.pmsfororg.dto.PropertyTaxResponseDTO;
import com.pms.pmsfororg.entity.Citizen;
import com.pms.pmsfororg.entity.Property;
import com.pms.pmsfororg.entity.PropertyTax;
import com.pms.pmsfororg.exception.ResourceNotFoundException;
import com.pms.pmsfororg.mapper.PropertyTaxMapper;
import com.pms.pmsfororg.repository.CitizenRepository;
import com.pms.pmsfororg.repository.PropertyRepository;
import com.pms.pmsfororg.repository.PropertyTaxRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyTaxService {

    private final PropertyTaxRepository propertyTaxRepository;
    private final CitizenRepository citizenRepository;
    private final PropertyRepository propertyRepository;

    public PropertyTaxService(PropertyTaxRepository propertyTaxRepository,
                              CitizenRepository citizenRepository,
                              PropertyRepository propertyRepository) {
        this.propertyTaxRepository = propertyTaxRepository;
        this.citizenRepository = citizenRepository;
        this.propertyRepository = propertyRepository;
    }

    public PropertyTaxResponseDTO create(PropertyTaxRequestDTO dto) {

        Citizen citizen = citizenRepository.findById(dto.getCitizenId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Citizen Not Found"));

        Property property = propertyRepository.findById(dto.getPropertyId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Property Not Found"));

        PropertyTax tax = PropertyTaxMapper.toEntity(dto);
        tax.setCitizen(citizen);
        tax.setProperty(property);

        return PropertyTaxMapper.toDTO(
                propertyTaxRepository.save(tax)
        );
    }

    public List<PropertyTaxResponseDTO> getAll() {

        return propertyTaxRepository.findAll()
                .stream()
                .map(PropertyTaxMapper::toDTO)
                .toList();
    }

    public PropertyTaxResponseDTO getById(Long id) {

        PropertyTax tax = propertyTaxRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Property Tax Not Found"));

        return PropertyTaxMapper.toDTO(tax);
    }

    public List<PropertyTaxResponseDTO> getByCitizen(Long citizenId) {

        if (!citizenRepository.existsById(citizenId)) {
            throw new ResourceNotFoundException("Citizen Not Found");
        }

        return propertyTaxRepository.findByCitizenId(citizenId)
                .stream()
                .map(PropertyTaxMapper::toDTO)
                .toList();
    }

    public List<PropertyTaxResponseDTO> getByStatus(String status) {

        return propertyTaxRepository.findByStatus(status)
                .stream()
                .map(PropertyTaxMapper::toDTO)
                .toList();
    }

    public PropertyTaxResponseDTO update(
            Long id,
            PropertyTaxRequestDTO dto) {

        PropertyTax tax = propertyTaxRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Property Tax Not Found"));

        Citizen citizen = citizenRepository.findById(dto.getCitizenId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Citizen Not Found"));

        Property property = propertyRepository.findById(dto.getPropertyId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Property Not Found"));

        tax.setTaxNumber(dto.getTaxNumber());
        tax.setAmount(dto.getAmount());
        tax.setTaxYear(dto.getTaxYear());
        tax.setDueDate(dto.getDueDate());
        tax.setStatus(dto.getStatus());
        tax.setCitizen(citizen);
        tax.setProperty(property);

        return PropertyTaxMapper.toDTO(
                propertyTaxRepository.save(tax)
        );
    }

    public void delete(Long id) {

        if (!propertyTaxRepository.existsById(id)) {
            throw new ResourceNotFoundException("Property Tax Not Found");
        }

        propertyTaxRepository.deleteById(id);
    }
}