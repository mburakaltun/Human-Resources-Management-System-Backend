package mburakaltun.HRMS.business.abstracts;

import mburakaltun.HRMS.core.results.DataResult;
import mburakaltun.HRMS.core.results.Result;
import mburakaltun.HRMS.models.entities.JobSeeker;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface JobSeekerService {
    public DataResult<List<JobSeeker>> getAll();
    public Result add(JobSeeker jobSeeker);
    public DataResult<JobSeeker> getByEmail(String email);
    public DataResult<JobSeeker> getByIdNo(String idNo);
}
