package com.pms.pmsfororg.service;

import com.pms.pmsfororg.dto.WaterBillRequestDTO;
import com.pms.pmsfororg.dto.WaterBillResponseDTO;
import com.pms.pmsfororg.entity.Citizen;
import com.pms.pmsfororg.entity.WaterBill;
import com.pms.pmsfororg.exception.ResourceNotFoundException;
import com.pms.pmsfororg.mapper.WaterBillMapper;
import com.pms.pmsfororg.repository.CitizenRepository;
import com.pms.pmsfororg.repository.WaterBillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterBillService {

    private final WaterBillRepository waterBillRepository;
    private final CitizenRepository citizenRepository;

    public WaterBillService(WaterBillRepository waterBillRepository,
                            CitizenRepository citizenRepository) {
        this.waterBillRepository = waterBillRepository;
        this.citizenRepository = citizenRepository;
    }

    public WaterBillResponseDTO create(WaterBillRequestDTO dto) {

        Citizen citizen = citizenRepository.findById(dto.getCitizenId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Citizen Not Found"));

        WaterBill bill = WaterBillMapper.toEntity(dto);
        bill.setCitizen(citizen);

        return WaterBillMapper.toDTO(
                waterBillRepository.save(bill)
        );
    }

    public List<WaterBillResponseDTO> getAll() {

        return waterBillRepository.findAll()
                .stream()
                .map(WaterBillMapper::toDTO)
                .toList();
    }

    public WaterBillResponseDTO getById(Long id) {

        WaterBill bill = waterBillRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Water Bill Not Found"));

        return WaterBillMapper.toDTO(bill);
    }

    public List<WaterBillResponseDTO> getByCitizen(Long citizenId) {

        if (!citizenRepository.existsById(citizenId)) {
            throw new ResourceNotFoundException("Citizen Not Found");
        }

        return waterBillRepository.findByCitizenId(citizenId)
                .stream()
                .map(WaterBillMapper::toDTO)
                .toList();
    }

    public List<WaterBillResponseDTO> getByStatus(String status) {

        return waterBillRepository.findByStatus(status)
                .stream()
                .map(WaterBillMapper::toDTO)
                .toList();
    }

    public WaterBillResponseDTO update(
            Long id,
            WaterBillRequestDTO dto) {

        WaterBill bill = waterBillRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Water Bill Not Found"));

        Citizen citizen = citizenRepository.findById(dto.getCitizenId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Citizen Not Found"));

        bill.setBillNumber(dto.getBillNumber());
        bill.setAmount(dto.getAmount());
        bill.setBillingDate(dto.getBillingDate());
        bill.setDueDate(dto.getDueDate());
        bill.setStatus(dto.getStatus());
        bill.setCitizen(citizen);

        return WaterBillMapper.toDTO(
                waterBillRepository.save(bill)
        );
    }

    public void delete(Long id) {

        if (!waterBillRepository.existsById(id)) {
            throw new ResourceNotFoundException("Water Bill Not Found");
        }

        waterBillRepository.deleteById(id);
    }
}