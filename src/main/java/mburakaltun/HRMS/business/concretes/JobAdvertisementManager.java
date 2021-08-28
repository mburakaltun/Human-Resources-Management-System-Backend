package mburakaltun.HRMS.business.concretes;

import mburakaltun.HRMS.business.abstracts.JobAdvertisementService;
import mburakaltun.HRMS.core.DataResult;
import mburakaltun.HRMS.core.Result;
import mburakaltun.HRMS.core.SuccessDataResult;
import mburakaltun.HRMS.core.SuccessResult;
import mburakaltun.HRMS.dataAccess.abstracts.JobAdvertisementDAO;
import mburakaltun.HRMS.entities.DTOs.JobAdvertisementListDTO;
import mburakaltun.HRMS.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDAO jobAdvertisementDAO;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDAO jobAdvertisementDAO) {
        this.jobAdvertisementDAO = jobAdvertisementDAO;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        jobAdvertisementDAO.saveAndFlush(jobAdvertisement);
        return new SuccessResult("Job Advertisement added");
    }

    @Override
    public DataResult<List<JobAdvertisementListDTO>> getAllList() {
        return new SuccessDataResult<>(jobAdvertisementDAO.getAllList(),"Job Advertisement Listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<>(jobAdvertisementDAO.findAll(), "Job Advertisement Listed");
    }

    @Override
    public DataResult<List<JobAdvertisementListDTO>> getAllByDesc() {
        return new SuccessDataResult<>(jobAdvertisementDAO.getAllListByDesc(), "Job Advertisement Listed by publishing date");
    }
}
