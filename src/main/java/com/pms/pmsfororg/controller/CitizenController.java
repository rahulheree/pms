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
    public CitizenResponseDTO createCitizen(@Valid @RequestBody CitizenRequestDTO dto) {
        return citizenService.createCitizen(dto);
    }

    @GetMapping
    public List<CitizenResponseDTO> getAllCitizens() {
        return citizenService.getAllCitizens();
    }

    @GetMapping("/{id}")
    public CitizenResponseDTO getCitizenById(@PathVariable Long id) {
        return citizenService.getCitizenById(id);
    }

    @PutMapping("/{id}")
    public CitizenResponseDTO updateCitizen(@PathVariable Long id,
                                            @Valid @RequestBody CitizenRequestDTO dto) {
        return citizenService.updateCitizen(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteCitizen(@PathVariable Long id) {
        citizenService.deleteCitizen(id);
        return "Citizen Deleted Successfully";
    }
}