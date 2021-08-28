package mburakaltun.HRMS.api.controllers;

import mburakaltun.HRMS.business.abstracts.EmployerService;
import mburakaltun.HRMS.core.DataResult;
import mburakaltun.HRMS.core.Result;
import mburakaltun.HRMS.entities.concretes.Employer;
import mburakaltun.HRMS.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll() {
        return employerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer) {
        return employerService.add(employer);
    }

    @PostMapping("/addJobAdvertisement")
    public Result addJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
        return employerService.addJobAdvertisement(jobAdvertisement);
    }
}
