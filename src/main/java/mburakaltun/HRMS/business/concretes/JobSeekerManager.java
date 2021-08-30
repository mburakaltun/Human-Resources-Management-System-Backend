package mburakaltun.HRMS.business.concretes;

import mburakaltun.HRMS.business.abstracts.JobSeekerService;
import mburakaltun.HRMS.core.results.DataResult;
import mburakaltun.HRMS.core.results.Result;
import mburakaltun.HRMS.core.results.SuccessDataResult;
import mburakaltun.HRMS.core.results.SuccessResult;
import mburakaltun.HRMS.dataAccess.JobSeekerDAO;
import mburakaltun.HRMS.models.entities.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDAO jobSeekerDAO;

    @Autowired
    public JobSeekerManager(JobSeekerDAO jobSeekerDAO) {
        this.jobSeekerDAO = jobSeekerDAO;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(jobSeekerDAO.findAll(), "Job Seekers listed successfully");
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        jobSeekerDAO.saveAndFlush(jobSeeker);
        return new SuccessResult("Job Seeker successfully added to the system.");
    }

    @Override
    public DataResult<JobSeeker> getByEmail(String email) {
        return new SuccessDataResult<>(jobSeekerDAO.findByEmail(email));
    }

    @Override
    public DataResult<JobSeeker> getByIdNo(String idNo) {
        return new SuccessDataResult<>(jobSeekerDAO.findByIdNo(idNo));
    }
}
