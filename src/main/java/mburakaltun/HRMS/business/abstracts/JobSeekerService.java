package mburakaltun.HRMS.business.abstracts;

import mburakaltun.HRMS.core.DataResult;
import mburakaltun.HRMS.core.Result;
import mburakaltun.HRMS.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {
    public DataResult<List<JobSeeker>> getAll();
    public Result add(JobSeeker jobSeeker);
    public DataResult<JobSeeker> getByEmail(String email);
    public DataResult<JobSeeker> getByIdNo(String idNo);
}
