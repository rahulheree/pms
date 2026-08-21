package com.pms.pmsfororg.service;

import com.pms.pmsfororg.dto.ZoneRequestDTO;
import com.pms.pmsfororg.dto.ZoneResponseDTO;
import com.pms.pmsfororg.entity.Zone;
import com.pms.pmsfororg.exception.ResourceNotFoundException;
import com.pms.pmsfororg.mapper.ZoneMapper;
import com.pms.pmsfororg.repository.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {

    private final ZoneRepository zoneRepository;

    public ZoneService(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    public ZoneResponseDTO create(ZoneRequestDTO dto) {
        Zone zone = ZoneMapper.toEntity(dto);
        return ZoneMapper.toDTO(zoneRepository.save(zone));
    }

    public List<ZoneResponseDTO> getAll() {
        return zoneRepository.findAll()
                .stream()
                .map(ZoneMapper::toDTO)
                .toList();
    }

    public ZoneResponseDTO getById(Long id) {
        Zone zone = zoneRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Zone Not Found"));

        return ZoneMapper.toDTO(zone);
    }

    public ZoneResponseDTO update(Long id, ZoneRequestDTO dto) {
        Zone zone = zoneRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Zone Not Found"));

        zone.setZoneName(dto.getZoneName());

        return ZoneMapper.toDTO(zoneRepository.save(zone));
    }

    public void delete(Long id) {
        if (!zoneRepository.existsById(id)) {
            throw new ResourceNotFoundException("Zone Not Found");
        }

        zoneRepository.deleteById(id);
    }
}
