package com.pms.pmsfororg.service;

import com.pms.pmsfororg.dto.PropertyRequestDTO;
import com.pms.pmsfororg.dto.PropertyResponseDTO;
import com.pms.pmsfororg.entity.Citizen;
import com.pms.pmsfororg.entity.Property;
import com.pms.pmsfororg.entity.Ward;
import com.pms.pmsfororg.exception.ResourceNotFoundException;
import com.pms.pmsfororg.mapper.PropertyMapper;
import com.pms.pmsfororg.repository.CitizenRepository;
import com.pms.pmsfororg.repository.PropertyRepository;
import com.pms.pmsfororg.repository.WardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;
    private final CitizenRepository citizenRepository;
    private final WardRepository wardRepository;

    public PropertyService(PropertyRepository propertyRepository,
                           CitizenRepository citizenRepository,
                           WardRepository wardRepository) {
        this.propertyRepository = propertyRepository;
        this.citizenRepository = citizenRepository;
        this.wardRepository = wardRepository;
    }

    public PropertyResponseDTO create(PropertyRequestDTO dto) {

        Citizen owner = citizenRepository.findById(dto.getOwnerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Citizen Not Found"));

        Ward ward = wardRepository.findById(dto.getWardId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ward Not Found"));

        Property property = PropertyMapper.toEntity(dto);
        property.setOwner(owner);
        property.setWard(ward);

        return PropertyMapper.toDTO(propertyRepository.save(property));
    }

    public List<PropertyResponseDTO> getAll() {

        return propertyRepository.findAll()
                .stream()
                .map(PropertyMapper::toDTO)
                .toList();
    }

    public PropertyResponseDTO getById(Long id) {

        Property property = propertyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Property Not Found"));

        return PropertyMapper.toDTO(property);
    }

    public PropertyResponseDTO update(Long id, PropertyRequestDTO dto) {

        Property property = propertyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Property Not Found"));

        Citizen owner = citizenRepository.findById(dto.getOwnerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Citizen Not Found"));

        Ward ward = wardRepository.findById(dto.getWardId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ward Not Found"));

        property.setPropertyNumber(dto.getPropertyNumber());
        property.setPropertyType(dto.getPropertyType());
        property.setArea(dto.getArea());
        property.setAddress(dto.getAddress());
        property.setOwner(owner);
        property.setWard(ward);

        return PropertyMapper.toDTO(propertyRepository.save(property));
    }

    public void delete(Long id) {

        if (!propertyRepository.existsById(id)) {
            throw new ResourceNotFoundException("Property Not Found");
        }

        propertyRepository.deleteById(id);
    }
}