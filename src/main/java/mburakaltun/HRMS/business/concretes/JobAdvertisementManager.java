package mburakaltun.HRMS.business.concretes;

import mburakaltun.HRMS.business.abstracts.JobAdvertisementService;
import mburakaltun.HRMS.core.results.*;
import mburakaltun.HRMS.dataAccess.JobAdvertisementDAO;
import mburakaltun.HRMS.models.DTOs.JobAdvertisementListDTO;
import mburakaltun.HRMS.models.entities.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return new SuccessDataResult<>(jobAdvertisementDAO.findAll(), "Job Advertisements listed");
    }

    @Override
    public DataResult<List<JobAdvertisementListDTO>> getAllByDesc() {
        return new SuccessDataResult<>(jobAdvertisementDAO.getAllListByDesc(), "Job Advertisements listed by publishing date");
    }

    @Override
    public DataResult<List<JobAdvertisementListDTO>> getAllByEmployerId(int employerId) {
        return new SuccessDataResult<>(jobAdvertisementDAO.getByEmployerId(employerId), "Job Advertisements listed by company name");
    }

    @Override
    public Result deleteById(int id) {
        JobAdvertisement jobAdvertisement = jobAdvertisementDAO.findById(id);
        if(jobAdvertisement == null) {
            return new ErrorResult("No job advertisement found with id " + id);
        }
        jobAdvertisementDAO.deleteById(id);
        return new SuccessResult("Job advertisement with id " + id + " deleted");
    }
}
