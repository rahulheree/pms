package com.pms.pmsfororg.service;

import com.pms.pmsfororg.dto.ComplaintRequestDTO;
import com.pms.pmsfororg.dto.ComplaintResponseDTO;
import com.pms.pmsfororg.entity.Citizen;
import com.pms.pmsfororg.entity.Complaint;
import com.pms.pmsfororg.entity.Ward;
import com.pms.pmsfororg.exception.ResourceNotFoundException;
import com.pms.pmsfororg.mapper.ComplaintMapper;
import com.pms.pmsfororg.repository.CitizenRepository;
import com.pms.pmsfororg.repository.ComplaintRepository;
import com.pms.pmsfororg.repository.WardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final CitizenRepository citizenRepository;
    private final WardRepository wardRepository;

    public ComplaintService(ComplaintRepository complaintRepository,
                            CitizenRepository citizenRepository,
                            WardRepository wardRepository) {
        this.complaintRepository = complaintRepository;
        this.citizenRepository = citizenRepository;
        this.wardRepository = wardRepository;
    }

    public ComplaintResponseDTO create(ComplaintRequestDTO dto) {

        Citizen citizen = citizenRepository.findById(dto.getCitizenId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Citizen Not Found"));

        Ward ward = wardRepository.findById(dto.getWardId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ward Not Found"));

        Complaint complaint = ComplaintMapper.toEntity(dto);
        complaint.setCitizen(citizen);
        complaint.setWard(ward);

        return ComplaintMapper.toDTO(
                complaintRepository.save(complaint)
        );
    }

    public List<ComplaintResponseDTO> getAll() {

        return complaintRepository.findAll()
                .stream()
                .map(ComplaintMapper::toDTO)
                .toList();
    }

    public ComplaintResponseDTO getById(Long id) {

        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Complaint Not Found"));

        return ComplaintMapper.toDTO(complaint);
    }

    public List<ComplaintResponseDTO> getByStatus(String status) {

        return complaintRepository.findByStatus(status)
                .stream()
                .map(ComplaintMapper::toDTO)
                .toList();
    }

    public ComplaintResponseDTO update(
            Long id,
            ComplaintRequestDTO dto) {

        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Complaint Not Found"));

        Citizen citizen = citizenRepository.findById(dto.getCitizenId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Citizen Not Found"));

        Ward ward = wardRepository.findById(dto.getWardId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ward Not Found"));

        complaint.setSubject(dto.getSubject());
        complaint.setDescription(dto.getDescription());
        complaint.setCategory(dto.getCategory());
        complaint.setStatus(dto.getStatus());
        complaint.setCitizen(citizen);
        complaint.setWard(ward);

        return ComplaintMapper.toDTO(
                complaintRepository.save(complaint)
        );
    }

    public void delete(Long id) {

        if (!complaintRepository.existsById(id)) {
            throw new ResourceNotFoundException("Complaint Not Found");
        }

        complaintRepository.deleteById(id);
    }
}
