package com.pms.pmsfororg.controller;

import com.pms.pmsfororg.dto.WaterBillRequestDTO;
import com.pms.pmsfororg.dto.WaterBillResponseDTO;
import com.pms.pmsfororg.service.WaterBillService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/water-bills")
public class WaterBillController {

    private final WaterBillService waterBillService;

    public WaterBillController(WaterBillService waterBillService) {
        this.waterBillService = waterBillService;
    }

    @PostMapping
    public WaterBillResponseDTO create(@Valid @RequestBody WaterBillRequestDTO dto) {
        return waterBillService.create(dto);
    }

    @GetMapping
    public List<WaterBillResponseDTO> getAll() {
        return waterBillService.getAll();
    }

    @GetMapping("/{id}")
    public WaterBillResponseDTO getById(@PathVariable Long id) {
        return waterBillService.getById(id);
    }

    @GetMapping("/citizen/{citizenId}")
    public List<WaterBillResponseDTO> getByCitizen(@PathVariable Long citizenId) {
        return waterBillService.getByCitizen(citizenId);
    }

    @GetMapping("/status/{status}")
    public List<WaterBillResponseDTO> getByStatus(@PathVariable String status) {
        return waterBillService.getByStatus(status);
    }

    @PutMapping("/{id}")
    public WaterBillResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody WaterBillRequestDTO dto) {
        return waterBillService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        waterBillService.delete(id);
        return "Water bill deleted successfully";
    }
}
