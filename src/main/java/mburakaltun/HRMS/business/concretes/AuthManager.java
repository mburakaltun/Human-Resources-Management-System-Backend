package mburakaltun.HRMS.business.concretes;

import mburakaltun.HRMS.business.abstracts.AuthService;
import mburakaltun.HRMS.business.abstracts.EmployerService;
import mburakaltun.HRMS.business.abstracts.JobSeekerService;
import mburakaltun.HRMS.core.results.DataResult;
import mburakaltun.HRMS.core.results.ErrorDataResult;
import mburakaltun.HRMS.core.results.SuccessDataResult;
import mburakaltun.HRMS.models.DTOs.EmployerRegisterDTO;
import mburakaltun.HRMS.models.DTOs.JobSeekerRegisterDTO;
import mburakaltun.HRMS.models.entities.Employer;
import mburakaltun.HRMS.models.entities.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {

    JobSeekerService jobSeekerService;
    EmployerService employerService;

    @Autowired
    public AuthManager(JobSeekerService jobSeekerService, EmployerService employerService) {
        this.jobSeekerService = jobSeekerService;
        this.employerService = employerService;
    }

    @Override
    public DataResult<JobSeeker> registerJobSeeker(JobSeekerRegisterDTO jobSeekerRegisterDTO) {
        if(!isIdNoValid(jobSeekerRegisterDTO)) {
            return new ErrorDataResult<>(null, "This identity number is already used.");
        }
        if(!isEmailValid(jobSeekerRegisterDTO)) {
            return new ErrorDataResult<>(null,"This email is already used.");
        }
        if(!isPasswordValid(jobSeekerRegisterDTO)) {
            return new ErrorDataResult<>(null,"Passwords do not match!");
        }
        JobSeeker jobSeeker = new JobSeeker(
                jobSeekerRegisterDTO.getName(),
                jobSeekerRegisterDTO.getSurname(),
                jobSeekerRegisterDTO.getIdNo(),
                jobSeekerRegisterDTO.getBirthdate(),
                jobSeekerRegisterDTO.getEmail(),
                jobSeekerRegisterDTO.getPassword()
        );
        jobSeekerService.add(jobSeeker);
        return new SuccessDataResult<>(jobSeeker, "Job Seeker successfully registered.");
    }

    public DataResult<Employer> registerEmployer(EmployerRegisterDTO employerRegisterDTO) {
        if(!isEmailWebsiteEndpointMatch(employerRegisterDTO)) {
            return new ErrorDataResult<>(null, "Website endpoint does not match with email endpoint");
        }
        if(!isEmailValid(employerRegisterDTO)) {
            return new ErrorDataResult<>(null,"This email is already used.");
        }
        Employer employer = new Employer(
                employerRegisterDTO.getCompanyName(),
                employerRegisterDTO.getCompanyEmail(),
                employerRegisterDTO.getCompanyWebsite(),
                employerRegisterDTO.getPhoneNumber(),
                employerRegisterDTO.getPassword()
        );
        employerService.add(employer);
        return new SuccessDataResult<>(employer, "Employer successfully registered.");

    }

    private boolean isIdNoValid(JobSeekerRegisterDTO jobSeekerRegisterDTO) {
        if(jobSeekerService.getByIdNo(jobSeekerRegisterDTO.getIdNo()).getData() != null) {
            return false;
        }
        return true;
    }

    private boolean isEmailValid(JobSeekerRegisterDTO jobSeekerRegisterDTO) {
        if(jobSeekerService.getByEmail(jobSeekerRegisterDTO.getEmail()).getData() != null) {
            return false;
        }
        return true;
    }

    private boolean isPasswordValid(JobSeekerRegisterDTO jobSeekerRegisterDTO) {
        if(jobSeekerRegisterDTO.getPassword().equals(jobSeekerRegisterDTO.getReenteredPassword())) {
            return true;
        }
        return false;
    }

    private boolean isEmailWebsiteEndpointMatch(EmployerRegisterDTO employerRegisterDTO) {
        String emailEndpoint = employerRegisterDTO.getCompanyEmail().split("@")[1];
        String[] websiteSplitsByDot = employerRegisterDTO.getCompanyWebsite().split("\\.");
        String websiteEndpoint = websiteSplitsByDot[1] + "." + websiteSplitsByDot[2];

        if(emailEndpoint.equals(websiteEndpoint)) {
            return true;
        }
        return false;
    }

    private boolean isEmailValid(EmployerRegisterDTO employerRegisterDTO) {
        if(employerService.getByCompanyEmail(employerRegisterDTO.getCompanyEmail()).getData() != null) {
            return false;
        }
        return true;
    }
}
