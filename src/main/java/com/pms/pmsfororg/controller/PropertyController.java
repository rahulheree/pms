package com.pms.pmsfororg.controller;

import com.pms.pmsfororg.dto.PropertyRequestDTO;
import com.pms.pmsfororg.dto.PropertyResponseDTO;
import com.pms.pmsfororg.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public PropertyResponseDTO create(@Valid @RequestBody PropertyRequestDTO dto) {
        return propertyService.create(dto);
    }

    @GetMapping
    public List<PropertyResponseDTO> getAll() {
        return propertyService.getAll();
    }

    @GetMapping("/{id}")
    public PropertyResponseDTO getById(@PathVariable Long id) {
        return propertyService.getById(id);
    }

    @PutMapping("/{id}")
    public PropertyResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody PropertyRequestDTO dto) {
        return propertyService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        propertyService.delete(id);
        return "Property deleted successfully";
    }
}
