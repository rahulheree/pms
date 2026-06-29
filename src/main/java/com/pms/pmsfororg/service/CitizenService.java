package com.pms.pmsfororg.service;

import com.pms.pmsfororg.dto.CitizenRequestDTO;
import com.pms.pmsfororg.dto.CitizenResponseDTO;
import com.pms.pmsfororg.entity.Citizen;
import com.pms.pmsfororg.mapper.CitizenMapper;
import com.pms.pmsfororg.repository.CitizenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitizenService {

    private final CitizenRepository citizenRepository;

    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    public CitizenResponseDTO createCitizen(CitizenRequestDTO dto) {

        Citizen citizen = CitizenMapper.toEntity(dto);

        Citizen savedCitizen = citizenRepository.save(citizen);

        return CitizenMapper.toDTO(savedCitizen);
    }

    public List<CitizenResponseDTO> getAllCitizens() {

        return citizenRepository.findAll()
                .stream()
                .map(CitizenMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CitizenResponseDTO getCitizenById(Long id) {

        Citizen citizen = citizenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Citizen Not Found"));

        return CitizenMapper.toDTO(citizen);
    }

    public CitizenResponseDTO updateCitizen(Long id, CitizenRequestDTO dto) {

        Citizen citizen = citizenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Citizen Not Found"));

        citizen.setFullName(dto.getFullName());
        citizen.setEmail(dto.getEmail());
        citizen.setPhone(dto.getPhone());
        citizen.setGender(dto.getGender());
        citizen.setDateOfBirth(dto.getDateOfBirth());
        citizen.setAddress(dto.getAddress());
        citizen.setWardNo(dto.getWardNo());
        citizen.setZone(dto.getZone());

        Citizen updatedCitizen = citizenRepository.save(citizen);

        return CitizenMapper.toDTO(updatedCitizen);
    }

    public void deleteCitizen(Long id) {

        citizenRepository.deleteById(id);
    }
}