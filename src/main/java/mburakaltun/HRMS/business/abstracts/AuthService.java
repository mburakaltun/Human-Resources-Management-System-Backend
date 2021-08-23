package mburakaltun.HRMS.business.abstracts;

import mburakaltun.HRMS.core.DataResult;
import mburakaltun.HRMS.entities.DTOs.EmployerRegisterDTO;
import mburakaltun.HRMS.entities.DTOs.JobSeekerRegisterDTO;
import mburakaltun.HRMS.entities.concretes.Employer;
import mburakaltun.HRMS.entities.concretes.JobSeeker;

public interface AuthService {
    public DataResult<JobSeeker> registerJobSeeker(JobSeekerRegisterDTO jobSeekerRegisterDTO);
    public DataResult<Employer> registerEmployer(EmployerRegisterDTO employerRegisterDTO);
}
