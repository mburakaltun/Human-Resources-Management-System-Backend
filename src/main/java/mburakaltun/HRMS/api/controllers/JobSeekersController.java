package mburakaltun.HRMS.api.controllers;

import mburakaltun.HRMS.business.abstracts.JobSeekerService;
import mburakaltun.HRMS.core.DataResult;
import mburakaltun.HRMS.core.Result;
import mburakaltun.HRMS.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {

    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll() {
        return jobSeekerService.getAll();
    }

    @PostMapping("/add")
    public Result add(JobSeeker jobSeeker) {
        return jobSeekerService.add(jobSeeker);
    }
}
