package mburakaltun.HRMS.api.controllers;

import mburakaltun.HRMS.business.abstracts.AuthService;
import mburakaltun.HRMS.business.abstracts.PersonalService;
import mburakaltun.HRMS.core.results.DataResult;
import mburakaltun.HRMS.models.DTOs.EmployerRegisterDTO;
import mburakaltun.HRMS.models.DTOs.JobSeekerRegisterDTO;
import mburakaltun.HRMS.models.entities.Employer;
import mburakaltun.HRMS.models.entities.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    private PersonalService personalService;

    @Autowired
    public AuthController(AuthService authService, PersonalService personalService) {
        this.authService = authService;
        this.personalService = personalService;
    }

    @PostMapping("/register/jobseeker")
    public DataResult<JobSeeker> registerJobSeeker(JobSeekerRegisterDTO jobSeekerRegisterDTO) {
        return authService.registerJobSeeker(jobSeekerRegisterDTO);
    }

    @PostMapping("/register/employer")
    public DataResult<Employer> registerEmployer(EmployerRegisterDTO employerRegisterDTO) {
        return authService.registerEmployer(employerRegisterDTO);
    }
}
