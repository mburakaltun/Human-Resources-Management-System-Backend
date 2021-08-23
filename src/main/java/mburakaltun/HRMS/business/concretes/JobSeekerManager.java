package mburakaltun.HRMS.business.concretes;

import mburakaltun.HRMS.business.abstracts.JobSeekerService;
import mburakaltun.HRMS.dataAccess.abstracts.JobSeekerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDAO jobSeekerDAO;

    @Autowired
    public JobSeekerManager(JobSeekerDAO jobSeekerDAO) {
        this.jobSeekerDAO = jobSeekerDAO;
    }
}
