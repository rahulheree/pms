package com.pms.pmsfororg.controller;

import com.pms.pmsfororg.dto.ZoneRequestDTO;
import com.pms.pmsfororg.dto.ZoneResponseDTO;
import com.pms.pmsfororg.service.ZoneService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zones")
public class ZoneController {

    private final ZoneService zoneService;

    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @PostMapping
    public ZoneResponseDTO create(@Valid @RequestBody ZoneRequestDTO dto) {
        return zoneService.create(dto);
    }

    @GetMapping
    public List<ZoneResponseDTO> getAll() {
        return zoneService.getAll();
    }

    @GetMapping("/{id}")
    public ZoneResponseDTO getById(@PathVariable Long id) {
        return zoneService.getById(id);
    }

    @PutMapping("/{id}")
    public ZoneResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody ZoneRequestDTO dto) {
        return zoneService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        zoneService.delete(id);
        return "Zone deleted successfully";
    }
}
