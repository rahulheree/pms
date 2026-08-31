// package com.pms.pmsfororg.service;

// import com.pms.pmsfororg.dto.CitizenDashboardDTO;
// import com.pms.pmsfororg.entity.Citizen;
// import com.pms.pmsfororg.exception.ResourceNotFoundException;
// import com.pms.pmsfororg.repository.CitizenRepository;
// import com.pms.pmsfororg.repository.ComplaintRepository;
// import com.pms.pmsfororg.repository.PropertyRepository;
// import com.pms.pmsfororg.repository.PropertyTaxRepository;
// import com.pms.pmsfororg.repository.WaterBillRepository;
// import org.springframework.stereotype.Service;

// @Service
// public class DashboardService {

//     private final CitizenRepository citizenRepository;
//     private final PropertyRepository propertyRepository;
//     private final PropertyTaxRepository propertyTaxRepository;
//     private final WaterBillRepository waterBillRepository;
//     private final ComplaintRepository complaintRepository;

//     public DashboardService(
//             CitizenRepository citizenRepository,
//             PropertyRepository propertyRepository,
//             PropertyTaxRepository propertyTaxRepository,
//             WaterBillRepository waterBillRepository,
//             ComplaintRepository complaintRepository) {

//         this.citizenRepository = citizenRepository;
//         this.propertyRepository = propertyRepository;
//         this.propertyTaxRepository = propertyTaxRepository;
//         this.waterBillRepository = waterBillRepository;
//         this.complaintRepository = complaintRepository;
//     }

//     public CitizenDashboardDTO getDashboard(String username) {

//         Citizen citizen = citizenRepository
//                 .findByEmail(username)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException(
//                                 "Citizen Not Found"
//                         ));

//         CitizenDashboardDTO dashboard =
//                 new CitizenDashboardDTO();

//         dashboard.setCitizenId(citizen.getId());
//         dashboard.setCitizenName(citizen.getFullName());
//         dashboard.setEmail(citizen.getEmail());

//         dashboard.setProperties(
//                 propertyRepository.findByOwnerId(citizen.getId())
//                         .stream()
//                         .map(com.pms.pmsfororg.mapper.PropertyMapper::toDTO)
//                         .toList()
//         );

//         dashboard.setPropertyTaxes(
//                 propertyTaxRepository.findByCitizenId(citizen.getId())
//                         .stream()
//                         .map(com.pms.pmsfororg.mapper.PropertyTaxMapper::toDTO)
//                         .toList()
//         );

//         dashboard.setWaterBills(
//                 waterBillRepository.findByCitizenId(citizen.getId())
//                         .stream()
//                         .map(com.pms.pmsfororg.mapper.WaterBillMapper::toDTO)
//                         .toList()
//         );

//         dashboard.setComplaints(
//                 complaintRepository.findByCitizenId(citizen.getId())
//                         .stream()
//                         .map(com.pms.pmsfororg.mapper.ComplaintMapper::toDTO)
//                         .toList()
//         );

//         return dashboard;
//     }
// }


package com.pms.pmsfororg.service;

import com.pms.pmsfororg.dto.CitizenDashboardDTO;
import com.pms.pmsfororg.entity.Citizen;
import com.pms.pmsfororg.exception.ResourceNotFoundException;
import com.pms.pmsfororg.repository.CitizenRepository;
import com.pms.pmsfororg.repository.ComplaintRepository;
import com.pms.pmsfororg.repository.PropertyRepository;
import com.pms.pmsfororg.repository.PropertyTaxRepository;
import com.pms.pmsfororg.repository.WaterBillRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final CitizenRepository citizenRepository;
    private final PropertyRepository propertyRepository;
    private final PropertyTaxRepository propertyTaxRepository;
    private final WaterBillRepository waterBillRepository;
    private final ComplaintRepository complaintRepository;

    public DashboardService(
            CitizenRepository citizenRepository,
            PropertyRepository propertyRepository,
            PropertyTaxRepository propertyTaxRepository,
            WaterBillRepository waterBillRepository,
            ComplaintRepository complaintRepository) {

        this.citizenRepository = citizenRepository;
        this.propertyRepository = propertyRepository;
        this.propertyTaxRepository = propertyTaxRepository;
        this.waterBillRepository = waterBillRepository;
        this.complaintRepository = complaintRepository;
    }

    public CitizenDashboardDTO getDashboard(Long citizenId) {

        Citizen citizen = citizenRepository.findById(citizenId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Citizen Not Found"
                        ));

        CitizenDashboardDTO dashboard =
                new CitizenDashboardDTO();

        dashboard.setCitizenId(citizen.getId());
        dashboard.setCitizenName(citizen.getFullName());
        dashboard.setEmail(citizen.getEmail());

        dashboard.setProperties(
                propertyRepository.findByOwnerId(citizenId)
                        .stream()
                        .map(com.pms.pmsfororg.mapper.PropertyMapper::toDTO)
                        .toList()
        );

        dashboard.setPropertyTaxes(
                propertyTaxRepository.findByCitizenId(citizenId)
                        .stream()
                        .map(com.pms.pmsfororg.mapper.PropertyTaxMapper::toDTO)
                        .toList()
        );

        dashboard.setWaterBills(
                waterBillRepository.findByCitizenId(citizenId)
                        .stream()
                        .map(com.pms.pmsfororg.mapper.WaterBillMapper::toDTO)
                        .toList()
        );

        dashboard.setComplaints(
                complaintRepository.findByCitizenId(citizenId)
                        .stream()
                        .map(com.pms.pmsfororg.mapper.ComplaintMapper::toDTO)
                        .toList()
        );

        return dashboard;
    }
}