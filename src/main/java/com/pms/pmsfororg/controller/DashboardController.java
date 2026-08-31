// package com.pms.pmsfororg.controller;

// import com.pms.pmsfororg.dto.CitizenDashboardDTO;
// import com.pms.pmsfororg.service.DashboardService;
// import org.springframework.security.core.Authentication;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/dashboard")
// public class DashboardController {

//     private final DashboardService dashboardService;

//     public DashboardController(DashboardService dashboardService) {
//         this.dashboardService = dashboardService;
//     }

//     @GetMapping("/me")
//     public CitizenDashboardDTO getMyDashboard(
//             Authentication authentication) {

//         return dashboardService.getDashboard(
//                 authentication.getName()
//         );
//     }
// }


package com.pms.pmsfororg.controller;

import com.pms.pmsfororg.dto.CitizenDashboardDTO;
import com.pms.pmsfororg.service.DashboardService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
@SecurityRequirement(name = "bearerAuth")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/me")
    public CitizenDashboardDTO getMyDashboard(
            Authentication authentication) {

        Long citizenId = Long.parseLong(authentication.getName());

        return dashboardService.getDashboard(citizenId);
    }
}