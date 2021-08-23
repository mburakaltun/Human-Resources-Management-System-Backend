package mburakaltun.HRMS.business.concretes;

import mburakaltun.HRMS.business.abstracts.JobTitleService;
import mburakaltun.HRMS.dataAccess.abstracts.JobTitleDAO;
import mburakaltun.HRMS.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDAO jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDAO jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public List<JobTitle> getAll() {
        return jobTitleDao.findAll();
    }
}
