package com.pms.pmsfororg.service;

import com.pms.pmsfororg.dto.WardRequestDTO;
import com.pms.pmsfororg.dto.WardResponseDTO;
import com.pms.pmsfororg.entity.Ward;
import com.pms.pmsfororg.entity.Zone;
import com.pms.pmsfororg.exception.ResourceNotFoundException;
import com.pms.pmsfororg.mapper.WardMapper;
import com.pms.pmsfororg.repository.WardRepository;
import com.pms.pmsfororg.repository.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardService {

    private final WardRepository wardRepository;
    private final ZoneRepository zoneRepository;

    public WardService(WardRepository wardRepository,
                       ZoneRepository zoneRepository) {
        this.wardRepository = wardRepository;
        this.zoneRepository = zoneRepository;
    }

    public WardResponseDTO create(WardRequestDTO dto) {

        Zone zone = zoneRepository.findById(dto.getZoneId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Zone Not Found"));

        Ward ward = WardMapper.toEntity(dto);
        ward.setZone(zone);

        return WardMapper.toDTO(wardRepository.save(ward));
    }

    public List<WardResponseDTO> getAll() {
        return wardRepository.findAll()
                .stream()
                .map(WardMapper::toDTO)
                .toList();
    }

    public WardResponseDTO getById(Long id) {

        Ward ward = wardRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ward Not Found"));

        return WardMapper.toDTO(ward);
    }

    public WardResponseDTO update(Long id, WardRequestDTO dto) {

        Ward ward = wardRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ward Not Found"));

        Zone zone = zoneRepository.findById(dto.getZoneId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Zone Not Found"));

        ward.setWardNo(dto.getWardNo());
        ward.setWardName(dto.getWardName());
        ward.setCouncillorName(dto.getCouncillorName());
        ward.setZone(zone);

        return WardMapper.toDTO(wardRepository.save(ward));
    }

    public void delete(Long id) {

        if (!wardRepository.existsById(id)) {
            throw new ResourceNotFoundException("Ward Not Found");
        }

        wardRepository.deleteById(id);
    }
}