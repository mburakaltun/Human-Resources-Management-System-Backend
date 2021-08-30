package mburakaltun.HRMS.api.controllers;

import mburakaltun.HRMS.business.abstracts.JobAdvertisementService;
import mburakaltun.HRMS.core.results.DataResult;
import mburakaltun.HRMS.core.results.Result;
import mburakaltun.HRMS.models.DTOs.JobAdvertisementListDTO;
import mburakaltun.HRMS.models.entities.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/getAllByEmployerId")
    public DataResult<List<JobAdvertisementListDTO>> getAllByEmployerId(int employerId) {
        return jobAdvertisementService.getAllByEmployerId(employerId);
    }

    @PostMapping("/deleteById")
    public Result deleteById(int id) {
        return jobAdvertisementService.deleteById(id);
    }

    @PostMapping("/add")
    public Result add(JobAdvertisement jobAdvertisement) {
        return jobAdvertisementService.add(jobAdvertisement);
    }
}
