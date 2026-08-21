package com.pms.pmsfororg.controller;

import com.pms.pmsfororg.dto.ComplaintRequestDTO;
import com.pms.pmsfororg.dto.ComplaintResponseDTO;
import com.pms.pmsfororg.service.ComplaintService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping
    public ComplaintResponseDTO create(@Valid @RequestBody ComplaintRequestDTO dto) {
        return complaintService.create(dto);
    }

    @GetMapping
    public List<ComplaintResponseDTO> getAll() {
        return complaintService.getAll();
    }

    @GetMapping("/{id}")
    public ComplaintResponseDTO getById(@PathVariable Long id) {
        return complaintService.getById(id);
    }

    @GetMapping("/status/{status}")
    public List<ComplaintResponseDTO> getByStatus(@PathVariable String status) {
        return complaintService.getByStatus(status);
    }

    @PutMapping("/{id}")
    public ComplaintResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody ComplaintRequestDTO dto) {
        return complaintService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        complaintService.delete(id);
        return "Complaint deleted successfully";
    }
}
