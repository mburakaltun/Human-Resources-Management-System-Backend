package mburakaltun.HRMS.business.concretes;

import mburakaltun.HRMS.business.abstracts.JobTitleService;
import mburakaltun.HRMS.core.results.*;
import mburakaltun.HRMS.dataAccess.JobTitleDAO;
import mburakaltun.HRMS.models.entities.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDAO jobTitleDAO;

    @Autowired
    public JobTitleManager(JobTitleDAO jobTitleDao) {
        this.jobTitleDAO = jobTitleDao;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>(jobTitleDAO.findAll()," Job titles are listed");
    }

    @Override
    public Result add(String jobTitleName) {
        if(!isJobTitleValid(jobTitleName)) {
            return new ErrorResult("Job title is already in the system");
        }
        JobTitle jobTitle = new JobTitle(
                jobTitleName
        );
        jobTitleDAO.saveAndFlush(jobTitle);
        return new SuccessResult("Job title successfully added to the system");
    }

    private boolean isJobTitleValid(String jobTitleName) {
        if(jobTitleDAO.findByName(jobTitleName) != null) {
            return false;
        }
        return true;
    }

}
