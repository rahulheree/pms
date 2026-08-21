package com.pms.pmsfororg.controller;

import com.pms.pmsfororg.dto.CitizenRequestDTO;
import com.pms.pmsfororg.dto.CitizenResponseDTO;
import com.pms.pmsfororg.service.CitizenService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizens")
public class CitizenController {

    private final CitizenService citizenService;

    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @PostMapping
    public CitizenResponseDTO create(@Valid @RequestBody CitizenRequestDTO dto) {
        return citizenService.create(dto);
    }

    @GetMapping
    public List<CitizenResponseDTO> getAll() {
        return citizenService.getAll();
    }

    @GetMapping("/{id}")
    public CitizenResponseDTO getById(@PathVariable Long id) {
        return citizenService.getById(id);
    }

    @GetMapping("/email/{email}")
    public CitizenResponseDTO getByEmail(@PathVariable String email) {
        return citizenService.getByEmail(email);
    }

    @GetMapping("/ward/{wardId}")
    public List<CitizenResponseDTO> getByWard(@PathVariable Long wardId) {
        return citizenService.getByWard(wardId);
    }

    @PutMapping("/{id}")
    public CitizenResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody CitizenRequestDTO dto) {
        return citizenService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        citizenService.delete(id);
        return "Citizen deleted successfully";
    }
}