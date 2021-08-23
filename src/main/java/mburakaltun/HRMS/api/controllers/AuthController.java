package mburakaltun.HRMS.api.controllers;

import mburakaltun.HRMS.business.abstracts.AuthService;
import mburakaltun.HRMS.core.DataResult;
import mburakaltun.HRMS.entities.DTOs.EmployerRegisterDTO;
import mburakaltun.HRMS.entities.DTOs.JobSeekerRegisterDTO;
import mburakaltun.HRMS.entities.concretes.Employer;
import mburakaltun.HRMS.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
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
