package com.pms.pmsfororg.mapper;

import com.pms.pmsfororg.dto.WaterBillRequestDTO;
import com.pms.pmsfororg.dto.WaterBillResponseDTO;
import com.pms.pmsfororg.entity.WaterBill;

public final class WaterBillMapper {

    private WaterBillMapper() {}

    public static WaterBill toEntity(WaterBillRequestDTO dto) {
        WaterBill bill = new WaterBill();

        bill.setBillNumber(dto.getBillNumber());
        bill.setAmount(dto.getAmount());
        bill.setBillingDate(dto.getBillingDate());
        bill.setDueDate(dto.getDueDate());
        bill.setStatus(dto.getStatus());

        return bill;
    }

    public static WaterBillResponseDTO toDTO(WaterBill bill) {
        WaterBillResponseDTO dto = new WaterBillResponseDTO();

        dto.setId(bill.getId());
        dto.setBillNumber(bill.getBillNumber());
        dto.setAmount(bill.getAmount());
        dto.setBillingDate(bill.getBillingDate());
        dto.setDueDate(bill.getDueDate());
        dto.setStatus(bill.getStatus());
        dto.setCreatedAt(bill.getCreatedAt());
        dto.setUpdatedAt(bill.getUpdatedAt());

        if (bill.getCitizen() != null) {
            dto.setCitizenId(bill.getCitizen().getId());
            dto.setCitizenName(bill.getCitizen().getFullName());
        }

        return dto;
    }
}
