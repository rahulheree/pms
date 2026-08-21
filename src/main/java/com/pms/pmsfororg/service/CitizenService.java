package com.pms.pmsfororg.service;

import com.pms.pmsfororg.dto.CitizenRequestDTO;
import com.pms.pmsfororg.dto.CitizenResponseDTO;
import com.pms.pmsfororg.entity.Citizen;
import com.pms.pmsfororg.entity.Ward;
import com.pms.pmsfororg.exception.ResourceNotFoundException;
import com.pms.pmsfororg.mapper.CitizenMapper;
import com.pms.pmsfororg.repository.CitizenRepository;
import com.pms.pmsfororg.repository.WardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {

    private final CitizenRepository citizenRepository;
    private final WardRepository wardRepository;

    public CitizenService(CitizenRepository citizenRepository,
                          WardRepository wardRepository) {
        this.citizenRepository = citizenRepository;
        this.wardRepository = wardRepository;
    }

    public CitizenResponseDTO create(CitizenRequestDTO dto) {

        Ward ward = wardRepository.findById(dto.getWardId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ward Not Found"));

        Citizen citizen = CitizenMapper.toEntity(dto);
        citizen.setWard(ward);

        return CitizenMapper.toDTO(citizenRepository.save(citizen));
    }

    public List<CitizenResponseDTO> getAll() {

        return citizenRepository.findAll()
                .stream()
                .map(CitizenMapper::toDTO)
                .toList();
    }

    public CitizenResponseDTO getById(Long id) {

        Citizen citizen = citizenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Citizen Not Found"));

        return CitizenMapper.toDTO(citizen);
    }

    public CitizenResponseDTO getByEmail(String email) {

        Citizen citizen = citizenRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Citizen Not Found"));

        return CitizenMapper.toDTO(citizen);
    }

    public List<CitizenResponseDTO> getByWard(Long wardId) {

        if (!wardRepository.existsById(wardId)) {
            throw new ResourceNotFoundException("Ward Not Found");
        }

        return citizenRepository.findByWardId(wardId)
                .stream()
                .map(CitizenMapper::toDTO)
                .toList();
    }

    public CitizenResponseDTO update(Long id, CitizenRequestDTO dto) {

        Citizen citizen = citizenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Citizen Not Found"));

        Ward ward = wardRepository.findById(dto.getWardId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ward Not Found"));

        citizen.setFullName(dto.getFullName());
        citizen.setEmail(dto.getEmail());
        citizen.setPhone(dto.getPhone());
        citizen.setGender(dto.getGender());
        citizen.setDateOfBirth(dto.getDateOfBirth());
        citizen.setAddress(dto.getAddress());
        citizen.setWard(ward);

        return CitizenMapper.toDTO(citizenRepository.save(citizen));
    }

    public void delete(Long id) {

        if (!citizenRepository.existsById(id)) {
            throw new ResourceNotFoundException("Citizen Not Found");
        }

        citizenRepository.deleteById(id);
    }
}
