package com.pms.pmsfororg.controller;

import com.pms.pmsfororg.dto.WardRequestDTO;
import com.pms.pmsfororg.dto.WardResponseDTO;
import com.pms.pmsfororg.service.WardService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wards")
public class WardController {

    private final WardService wardService;

    public WardController(WardService wardService) {
        this.wardService = wardService;
    }

    @PostMapping
    public WardResponseDTO create(@Valid @RequestBody WardRequestDTO dto) {
        return wardService.create(dto);
    }

    @GetMapping
    public List<WardResponseDTO> getAll() {
        return wardService.getAll();
    }

    @GetMapping("/{id}")
    public WardResponseDTO getById(@PathVariable Long id) {
        return wardService.getById(id);
    }

    @PutMapping("/{id}")
    public WardResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody WardRequestDTO dto) {
        return wardService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        wardService.delete(id);
        return "Ward deleted successfully";
    }
}