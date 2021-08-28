package mburakaltun.HRMS.business.abstracts;

import mburakaltun.HRMS.core.DataResult;
import mburakaltun.HRMS.core.Result;
import mburakaltun.HRMS.entities.DTOs.JobAdvertisementListDTO;
import mburakaltun.HRMS.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {

    Result add(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisementListDTO>> getAllList();
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisementListDTO>> getAllByDesc();
}
