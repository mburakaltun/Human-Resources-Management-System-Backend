package mburakaltun.HRMS.api.controllers;

import mburakaltun.HRMS.business.abstracts.JobAdvertisementService;
import mburakaltun.HRMS.core.DataResult;
import mburakaltun.HRMS.core.SuccessDataResult;
import mburakaltun.HRMS.entities.DTOs.JobAdvertisementListDTO;
import mburakaltun.HRMS.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/jobAdvertisements")
@RestController
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getAllList")
    public DataResult<List<JobAdvertisementListDTO>> getAllList() {
        return jobAdvertisementService.getAllList();
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvertisement>> getAll() {
        return jobAdvertisementService.getAll();
    }

    @GetMapping("getAllByDesc")
    public DataResult<List<JobAdvertisementListDTO>> getAllByDesc() {
        return jobAdvertisementService.getAllByDesc();
    }
}
