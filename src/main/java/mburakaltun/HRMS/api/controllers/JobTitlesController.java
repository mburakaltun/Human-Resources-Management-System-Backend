package mburakaltun.HRMS.api.controllers;

import mburakaltun.HRMS.business.abstracts.JobTitleService;
import mburakaltun.HRMS.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<JobTitle> getAll() {
        return jobTitleService.getAll();
    }
}
