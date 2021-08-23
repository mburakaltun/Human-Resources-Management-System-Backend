package mburakaltun.HRMS.api.controllers;

import mburakaltun.HRMS.business.abstracts.JobTitleService;
import mburakaltun.HRMS.core.DataResult;
import mburakaltun.HRMS.core.Result;
import mburakaltun.HRMS.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitlesController {

    private JobTitleService jobTitleService;

    @Autowired
    public JobTitlesController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobTitle>> getAll() {
        return jobTitleService.getAll();
    }

    @PostMapping("/add")
    public Result add(String jobTitleName) {
        return jobTitleService.add(jobTitleName);
    }
}
