package mburakaltun.HRMS.business.abstracts;

import mburakaltun.HRMS.core.results.DataResult;
import mburakaltun.HRMS.models.DTOs.EmployerRegisterDTO;
import mburakaltun.HRMS.models.DTOs.JobSeekerRegisterDTO;
import mburakaltun.HRMS.models.entities.Employer;
import mburakaltun.HRMS.models.entities.JobSeeker;

public interface AuthService {
    public DataResult<JobSeeker> registerJobSeeker(JobSeekerRegisterDTO jobSeekerRegisterDTO);
    public DataResult<Employer> registerEmployer(EmployerRegisterDTO employerRegisterDTO);
}
