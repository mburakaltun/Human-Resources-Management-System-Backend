package mburakaltun.HRMS.business.abstracts;

import mburakaltun.HRMS.core.results.DataResult;
import mburakaltun.HRMS.core.results.Result;
import mburakaltun.HRMS.models.DTOs.JobAdvertisementListDTO;
import mburakaltun.HRMS.models.entities.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {

    Result add(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisementListDTO>> getAllList();
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisementListDTO>> getAllByDesc();
    DataResult<List<JobAdvertisementListDTO>> getAllByEmployerId(int employerId);
    Result deleteById(int id);
}
