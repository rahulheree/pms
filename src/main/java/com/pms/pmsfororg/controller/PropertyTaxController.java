package com.pms.pmsfororg.controller;

import com.pms.pmsfororg.dto.PropertyTaxRequestDTO;
import com.pms.pmsfororg.dto.PropertyTaxResponseDTO;
import com.pms.pmsfororg.service.PropertyTaxService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property-taxes")
public class PropertyTaxController {

    private final PropertyTaxService propertyTaxService;

    public PropertyTaxController(PropertyTaxService propertyTaxService) {
        this.propertyTaxService = propertyTaxService;
    }

    @PostMapping
    public PropertyTaxResponseDTO create(
            @Valid @RequestBody PropertyTaxRequestDTO dto) {
        return propertyTaxService.create(dto);
    }

    @GetMapping
    public List<PropertyTaxResponseDTO> getAll() {
        return propertyTaxService.getAll();
    }

    @GetMapping("/{id}")
    public PropertyTaxResponseDTO getById(@PathVariable Long id) {
        return propertyTaxService.getById(id);
    }

    @GetMapping("/citizen/{citizenId}")
    public List<PropertyTaxResponseDTO> getByCitizen(
            @PathVariable Long citizenId) {
        return propertyTaxService.getByCitizen(citizenId);
    }

    @GetMapping("/status/{status}")
    public List<PropertyTaxResponseDTO> getByStatus(
            @PathVariable String status) {
        return propertyTaxService.getByStatus(status);
    }

    @PutMapping("/{id}")
    public PropertyTaxResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody PropertyTaxRequestDTO dto) {
        return propertyTaxService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        propertyTaxService.delete(id);
        return "Property tax deleted successfully";
    }
}